package mx.uam.ayd.proyecto.presentacion.EliminarCitas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;
import com.toedter.calendar.JDateChooser;

import mx.uam.ayd.proyecto.negocio.modelo.Cita;

/**
 * Ventana para eliminar citas.
 * @author César Ramírez Echeverría
 * @version 1.0
 * @Date 09/06/2023
 */

@Component
public class VentanaEliminarCitas extends JFrame {

	private JPanel contentPane;
	private JTable tablaDCitas;
    private ControlEliminarCita controlE;

	/**
	 * Crea la ventana de eliminar citas.
	 */

	public VentanaEliminarCitas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 688, 610);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//se crea el apartado para poder poner el logo
		JPanel  panelLogo = new JPanel();
		panelLogo.setBounds(0, 0, 110, 97);
		panelLogo.setBackground(new Color(255,255,255));
		contentPane.add( panelLogo);
		panelLogo.setLayout(null);
		
		//se coloca el logo en su lugar correspondiente 
		JLabel lblILogo = new JLabel("");
		lblILogo.setIcon(new ImageIcon(VentanaEliminarCitas.class.getResource("/img/Logo3.png")));
		lblILogo.setBounds(10, 10, 90, 77);
		lblILogo.setHorizontalAlignment(SwingConstants.CENTER);
		panelLogo.add(lblILogo);
		
		//se crea el apartado para poner el titulo de lo que se visualiza en la ventana
		JPanel  panelDatos = new JPanel();
		panelDatos.setBounds(109, 0, 563, 97);
		panelDatos.setBackground(Color.LIGHT_GRAY);
		contentPane.add( panelDatos);
		panelDatos.setLayout(null);
		
		//se crea el titulo con sus respectivos puntos
		JLabel lblNewLabel = new JLabel("Eliminar Citas");
		lblNewLabel.setFont(new Font("Leelawadee UI", Font.BOLD, 20));
		lblNewLabel.setBounds(216, 35, 133, 27);
		panelDatos.add(lblNewLabel);
		
		//creo una nota para que alado se ponga un apartado para seleccionar el dia de la cita
		JLabel lblNcita = new JLabel("Citas ");
		lblNcita.setBounds(37, 107, 73, 30);
		lblNcita.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		contentPane.add(lblNcita);

		//se crea la tabla con las columnas necesarias para arrojar los datos que quiero visualizar de cada cita
        JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 162, 594, 282);
		contentPane.add(scrollPane);
		tablaDCitas = new JTable();
		tablaDCitas.getTableHeader().setReorderingAllowed(false);
		DefaultTableModel model = new DefaultTableModel();
		tablaDCitas.setModel(model);
		 
		model.addColumn("Nombre");
		model.addColumn("Fecha");
		model.addColumn("Hora");
		model.addColumn("Servicio");
		 
		scrollPane.setViewportView(tablaDCitas);

		//es para poner el dia de la cita
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(109, 107, 123, 30);
		contentPane.add(dateChooser);

		//se crean botones
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setBackground(Color.RED);
		btnEliminar.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		btnEliminar.setBounds(508, 487, 123, 46);
		contentPane.add(btnEliminar);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setForeground(new Color(255, 255, 255));
		btnRegresar.setBackground(Color.GRAY);
		btnRegresar.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		btnRegresar.setBounds(37, 487, 123, 46);
		contentPane.add(btnRegresar);
        
        // LISTENERS 
        btnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				mostrarMensaje("Regresó al menú principal");
                controlE.termina();
            }
        });

		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Verificar si hay una fila seleccionada
				int filaSeleccionada = tablaDCitas.getSelectedRow();
				if (filaSeleccionada == -1) {
					mostrarMensaje("Seleccione una cita para eliminar.");
					return;
				}
				
				// Obtener los datos de la fila seleccionada
        		String nombre = (String) tablaDCitas.getValueAt(filaSeleccionada, 0);
        		LocalDate fecha = (LocalDate) tablaDCitas.getValueAt(filaSeleccionada, 1);
        		LocalTime hora = (LocalTime) tablaDCitas.getValueAt(filaSeleccionada, 2);
				String servicio = (String) tablaDCitas.getValueAt(filaSeleccionada, 3);

				// Verificar si la fecha de la cita es estrictamente anterior a la fecha actual
				LocalDate fechaActual = LocalDate.now();
				
				if (fecha.isEqual(fechaActual) || fecha.isAfter(fechaActual)) {
					mostrarMensaje("No se puede eliminar una cita del día de hoy o futura.");
					return;
				}

        		// Mostrar un mensaje de confirmación
        		int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar la cita seleccionada?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        		if (opcion == JOptionPane.YES_OPTION) {
					
					// Llamar al método en el controlador para eliminar la cita
           			controlE.eliminarCita(nombre, fecha, hora,servicio);

            		// Eliminar la fila de la tabla
            		DefaultTableModel model = (DefaultTableModel) tablaDCitas.getModel();
            		model.removeRow(filaSeleccionada);

            		mostrarMensaje("Cita eliminada correctamente.");
					
        		}
    		}
		});

		// Agregar PropertyChangeListener al JDateChooser
		dateChooser.addPropertyChangeListener("date", new PropertyChangeListener() {
		    public void propertyChange(PropertyChangeEvent e) {
		        try {
		            Date selectedDate = dateChooser.getDate();
					LocalDate localDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					LocalDate fecha = localDate; // Declarar la variable fecha
					List<Cita> citas = controlE.obtenerCitasPorFecha(fecha);
					actualizarTabla(citas);
				} catch (Exception ex) {
					ex.printStackTrace();
					mostrarMensaje("Error al seleccionar la fecha de la cita.");
				}
			}
		});
    }

	/**
     * Muestra la ventana de eliminar citas.
     * 
     * @param controlE Objeto ControlEliminarCita asociado
     */

    public void muestraE(ControlEliminarCita controlE){
        this.controlE = controlE;
		this.controlE.obtenerCitasPorFecha(LocalDate.now()); 

		setVisible(true);
    }

	/**
     * Muestra un mensaje en un cuadro de diálogo.
     * 
     * @param mensaje El mensaje a mostrar
     */

	public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

	 /**
     * Actualiza la tabla con las citas proporcionadas.
     * 
     * @param citas La lista de citas para mostrar en la tabla
     */

	 private void actualizarTabla(List<Cita> citas) {
		DefaultTableModel model = (DefaultTableModel) tablaDCitas.getModel();
		model.setRowCount(0); // Limpiar la tabla antes de actualizar los datos
		
		for (Cita cita : citas) {
        Object[] row = { cita.getNombre(), cita.getFecha(), cita.getHora(), cita.getServicio() };
        model.addRow(row);
		}
	}
}