package mx.uam.ayd.proyecto.presentacion.verCitas;
import javax.swing.JButton;
import javax.swing.JFrame;

import org.springframework.stereotype.Component;

import com.toedter.calendar.JCalendar;

import mx.uam.ayd.proyecto.negocio.modelo.Cita;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;




@Component
public class VentanaVerCitas extends JFrame implements MouseListener {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ControlVerCitas control;
	private JLabel lblAgendarCita;
	private JTable proximasCitas;
	public	String idUsuario;
	private LocalDate fecha;

	
	/**
	 * Create the frame.
	 */
	public VentanaVerCitas() {
		setTitle("Citas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		setSize(800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblAgendarCita = new JLabel("Citas");
		lblAgendarCita.setBounds(350, 12, 500, 17);
		contentPane.add(lblAgendarCita);

	
		 
		// PROXIMA CITA
		proximasCitas = new JTable();
		
		proximasCitas.setBounds(30, 250, 700, 225);
		proximasCitas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		DefaultTableModel modelo = new DefaultTableModel();
		
		
		
		modelo.addColumn("Hora");
		modelo.addColumn("Paciente");
		modelo.addColumn("Servicio");
		
		
		
		
		proximasCitas.setModel(modelo);
		proximasCitas.addMouseListener(this);
		JScrollPane scrollPane = new JScrollPane(proximasCitas);
		scrollPane.setBounds(30, 250, 700, 225);
		contentPane.add(scrollPane);
		//contentPane.add(proximasCitas);
				
			
		// botón para regresar al menu
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(30, 500, 117, 29);
		contentPane.add(btnRegresar);
		

		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(250, 30, 250, 250);
		contentPane.add(calendar);
		
		calendar.addPropertyChangeListener("calendar", new PropertyChangeListener() {
		    public void propertyChange(PropertyChangeEvent e) {
		        Date selectedDate = calendar.getDate();
		        LocalDate localDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				fecha = localDate;
		        List<Cita> citas = control.ProximasCitas(localDate);
		        actualizarTabla(citas);
		        
		    }
		    public void actualizarTabla(List<Cita> citas) {
			    // Obtener el modelo de la tabla
			    DefaultTableModel modelo = (DefaultTableModel) proximasCitas.getModel();
			    
			    // Eliminar todas las filas existentes
			    modelo.setRowCount(0);
			    
			    // Agregar las filas correspondientes a las citas encontradas
			    for (Cita cita : citas) {
			        Object[] fila = {cita.getHora(), cita.getNombre(),cita.getServicio()};
			        modelo.addRow(fila);
			    }
			}
	
		});
		
		
		// LISTENERS 
		
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.termina();
			}
		});
		
	}

	public void muestra(ControlVerCitas control) {
		this.control = control;
		setVisible(true);
		
		
	}
	
  public Cita validarSeleccionMouse(int fila) { // Metodo en el que se valida el usuario.
    Cita cita = new Cita();
	cita.setFecha(fecha);
	cita.setHora((LocalTime) proximasCitas.getValueAt(fila, 0));
	cita.setNombre(proximasCitas.getValueAt(fila, 1).toString());
	cita.setServicio(proximasCitas.getValueAt(fila, 2).toString());
    return cita; // Se almacenan los datos del paciente.
  }	

  public void mouseClicked(MouseEvent e) {
    // Este evento se activa cuando se da clic en un elemento.
    int fila = proximasCitas.rowAtPoint(e.getPoint()); // Con esto sabemos que fila esta ejecutando el evento.
    Cita cita = new Cita(); // Variable local que almacenara al usuario seleccionado.
    cita = validarSeleccionMouse(fila); // Se obtienen el objeto usuario al cual se le realizara la consulta
    control.recuperarCita(cita); // Con este metodo se hace referencia al Usuario en turno
  }
	
	public void muestraDialogoConMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
