package mx.uam.ayd.proyecto.presentacion.agendarCita;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import com.toedter.calendar.JCalendar;

import mx.uam.ayd.proyecto.negocio.modelo.Precios;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

@Component
public class VentanaAgendarCita extends JFrame {
	private JPanel contentPane;
	private ControlAgendarCita control;
	private Usuario usuario;
	private JLabel lblHora;
	private JLabel lblAgendarCita;
	private JLabel lblFecha;
	private JLabel lblServicio;
	private JComboBox<String> comboBoxHoras;
	private JComboBox<String> comboBoxServicios;

	/**
	 * Create the frame.
	 */
	public VentanaAgendarCita() {
		setTitle("Agendar cita");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		setSize(600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblAgendarCita = new JLabel("Agendar Cita");
		lblAgendarCita.setBounds(5, 12, 437, 17);
		lblAgendarCita.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblAgendarCita);

		/*
		 * Componentes del área de fecha
		 */
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(25, 32, 60, 17);
		contentPane.add(lblFecha);

		// calendario
		JCalendar calendar = new JCalendar();
		calendar.setBounds(30, 50, 200, 200);
		contentPane.add(calendar);

		/*
		 * Componentes del área de hora
		 */
		lblHora = new JLabel("Hora");
		lblHora.setBounds(300, 32, 60, 17);
		contentPane.add(lblHora);

		comboBoxHoras = new JComboBox<>();
		comboBoxHoras.setBounds(300, 50, 100, 17);
		contentPane.add(comboBoxHoras);

		/*
		 * Componentes del área de servicios
		 */
		lblServicio = new JLabel("Servicio");
		lblServicio.setBounds(300, 100, 60, 17);
		contentPane.add(lblServicio);

		comboBoxServicios = new JComboBox<>();
		comboBoxServicios.setBounds(300, 120, 250, 17);
		contentPane.add(comboBoxServicios);

		// botón para agendar
		JButton btnAgendar = new JButton("Agendar");
		btnAgendar.setBounds(450, 300, 117, 29);
		contentPane.add(btnAgendar);

		// botón para regresar al menu
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(30, 300, 117, 29);
		contentPane.add(btnRegresar);

		// listeners
		btnAgendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// tomar la fecha del calendario
				LocalDate date = calendar.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				// establecer formato de la hora
				DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("H:mm");

				// agregar la cita
				control.agregarCita(date, LocalTime.parse((String) comboBoxHoras.getSelectedItem(), formatoHora),
						(String) comboBoxServicios.getSelectedItem(), usuario.getCorreo(),usuario.getNombre());
				control.comprobarCitasDia(date);
			}
		});

		// regresar al menú
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}

	// muestra
	public void muestra(ControlAgendarCita control, Usuario usuario) {
		this.control = control;
		this.usuario = usuario;
		DefaultComboBoxModel<String> comboBoxModelH = new DefaultComboBoxModel<>();
		DefaultComboBoxModel<String> comboBoxModelS = new DefaultComboBoxModel<>();
		DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("H:mm");
		LocalTime[] lapzos = new LocalTime[8];

		// establece las horas que van a mostrarse
		int i = 8;
		for (LocalTime lap : lapzos) {
			lap = LocalTime.parse(i + ":00", formatoHora);
			comboBoxModelH.addElement(lap.toString());
			i++;
		}

		comboBoxHoras.setModel(comboBoxModelH);

		// valores de los servicios
		/*String[] servicios = new String[7];
		servicios[0] = "Revisión general";
		servicios[1] = "Extracción de muelas";
		servicios[2] = "Colocación de amalgama";
		servicios[3] = "Limpieza";
		servicios[4] = "Blanqueamiento";
		servicios[5] = "Extracción de terceros molares inferiores";
		servicios[6] = "Extracción de terceros molares superiores";*/
		
		List<Precios> listaImprimir = control.listaPrecios();
		for (Precios Servicio : listaImprimir) {
			comboBoxModelS.addElement(Servicio.getServicio()); 
		    }
		/*for (String servicio : servicios) {
			comboBoxModelS.addElement(servicio);
		}*/

		comboBoxServicios.setModel(comboBoxModelS);

		dispose();
		setUndecorated(true);
		setVisible(true);
	}

	public void muestraDialogoConMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
