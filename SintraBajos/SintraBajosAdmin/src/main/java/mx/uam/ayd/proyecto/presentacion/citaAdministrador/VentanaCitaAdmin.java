
package mx.uam.ayd.proyecto.presentacion.citaAdministrador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import org.springframework.stereotype.Component;
import com.toedter.calendar.JCalendar;

import mx.uam.ayd.proyecto.negocio.modelo.Cita;
import mx.uam.ayd.proyecto.negocio.modelo.Precios;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("serial")
@Component
public class VentanaCitaAdmin extends JFrame {

  private JPanel contentPane;
  private static final String FONT_TEXTO = "Roboto Light";
  private static final String FONT_CALENDAR = "Roboto Light";
  private JComboBox<String> comboBoxHoras;
  private DefaultComboBoxModel<String> comboBoxModelH = new DefaultComboBoxModel<>();	
  private DefaultComboBoxModel<String> comboBoxModelU = new DefaultComboBoxModel<>();	
  private JComboBox<String> comboBoxPaciente;
  private JComboBox<String> comboBoxServicios;
  private ControlCitaAdmin control;
  private List<Usuario> listaUsuario;
  private JTextField tcorreo;
  private Usuario usuariorecuperado;

 
  /**
   * Descripción de la clase VentanaCitaAdmin. Se especifican los
   * elementos de la ventana.
   * 
   * @author Octavio Silva Zamora
   * @version 1.0
   * @Date 09/06/2023
   */
  
  public VentanaCitaAdmin() {
	  setTitle("Cita para Paciente");
		setResizable(false);
	    setLocationRelativeTo(null);// Centramos la ventana
	    setBounds(100, 100, 632, 730);
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	    setContentPane(contentPane);
	    contentPane.setLayout(null);  
		
		
		 JPanel panelRaiz = new JPanel();
		 panelRaiz.setFont(new Font(FONT_TEXTO, Font.PLAIN, 16));
		    panelRaiz.setBackground(Color.WHITE);
		    panelRaiz.setBounds(0, 0, 615, 721);
		    contentPane.add(panelRaiz);
		    panelRaiz.setLayout(null);
		    
	     JPanel encabezado = new JPanel();
		    encabezado.setBackground(Color.LIGHT_GRAY);
		    encabezado.setBounds(0, 0, 617, 91);
		    panelRaiz.add(encabezado);
		    encabezado.setLayout(null);   
		    
		 JLabel logo = new JLabel("");
		    logo.setIcon(new ImageIcon(VentanaCitaAdmin.class.getResource("/img/Logo3.png")));
		    logo.setBounds(10, 11, 72, 73); 
		    encabezado.add(logo);
		    
		 JLabel titulo = new JLabel("Agendar Cita para Paciente");
		    titulo.setFont(new Font("Leelawadee UI", Font.BOLD, 20));
		    titulo.setBounds(183, 25, 262, 42);
		    encabezado.add(titulo);
		    
		 JCalendar calendar = new JCalendar();
		    calendar.getMonthChooser().setFont(new Font(FONT_CALENDAR, Font.PLAIN, 14));
		    calendar.getMonthChooser().getSpinner().setFont(new Font(FONT_CALENDAR, Font.PLAIN, 14));
		    calendar.getMonthChooser().getComboBox().setBackground(Color.WHITE);
		    calendar.getMonthChooser().getComboBox().setFont(new Font(FONT_CALENDAR, Font.PLAIN, 15));
		    calendar.getYearChooser().setFont(new Font(FONT_CALENDAR, Font.PLAIN, 14));
		    calendar.getMonthChooser().setBackground(Color.WHITE);
		    calendar.getDayChooser().getDayPanel().setBackground(Color.WHITE);
		    calendar.getDayChooser().setBackground(Color.WHITE);
			calendar.setBounds(120, 120, 380, 220);
			panelRaiz.add(calendar);
			
		JLabel hora = new JLabel("Hora");
		hora.setFont(new Font(FONT_TEXTO, Font.PLAIN, 16));
			hora.setBounds(141, 357, 46, 17);
			panelRaiz.add(hora);

			comboBoxHoras = new JComboBox<>();
			comboBoxHoras.setFont(new Font(FONT_TEXTO, Font.PLAIN, 14));
			comboBoxHoras.setBounds(197, 358, 290, 17);
			panelRaiz.add(comboBoxHoras);
			
			DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("H:mm");			
			LocalTime[] lapzos = new LocalTime[8];

			// Establece las horas que van a mostrarse con el formato de hora
			int i = 8;
			for (LocalTime lap : lapzos) {
				LocalTime horario = LocalTime.parse(i + ":00", formatoHora);
				comboBoxModelH.addElement(horario.toString());
				i++;
			}
			comboBoxHoras.setModel(comboBoxModelH);
			
			//Alinea las horas a la derecha
			((JLabel)comboBoxHoras.getRenderer()).setHorizontalAlignment(SwingConstants.RIGHT); 
			
			JLabel lpaciente = new JLabel("Nombre del Paciente");
			lpaciente.setFont(new Font(FONT_TEXTO, Font.PLAIN, 16));
			lpaciente.setBounds(33, 415, 162, 23);
			panelRaiz.add(lpaciente);
			
						
			JLabel lcorreo = new JLabel("Correo del Paciente");
			lcorreo.setFont(new Font(FONT_TEXTO, Font.PLAIN, 16));
			lcorreo.setBounds(33, 459, 155, 14);
			panelRaiz.add(lcorreo);
			
			JLabel ltipoCita = new JLabel("Tipo de Cita");
			ltipoCita.setFont(new Font(FONT_TEXTO, Font.PLAIN, 16));
			ltipoCita.setBounds(33, 509, 105, 14);
			panelRaiz.add(ltipoCita);
			
			comboBoxServicios = new JComboBox<String>();
			comboBoxServicios.setFont(new Font(FONT_TEXTO, Font.PLAIN, 14));
			comboBoxServicios.setBounds(197, 507, 187, 17);
			panelRaiz.add(comboBoxServicios);
			
			JLabel lhistorial = new JLabel("Historial Clinico");
			lhistorial.setFont(new Font(FONT_TEXTO, Font.PLAIN, 16));
			lhistorial.setBounds(33, 561, 120, 14);
			panelRaiz.add(lhistorial);
			
			JCheckBox chckbxUrgente = new JCheckBox("Urgente");
			chckbxUrgente.setOpaque(false);
			chckbxUrgente.setForeground(Color.BLACK);
			chckbxUrgente.setFont(new Font(FONT_TEXTO, Font.PLAIN, 16));
			chckbxUrgente.setBounds(403, 505, 97, 23);
			panelRaiz.add(chckbxUrgente);
			
			JButton bconsultar = new JButton("Consultar");
			bconsultar.setForeground(new Color(255, 255, 255));
			bconsultar.setFont(new Font(FONT_TEXTO, Font.PLAIN, 16));
			bconsultar.setBackground(new Color(30, 144, 255));
			bconsultar.setBounds(209, 558, 105, 23);
			panelRaiz.add(bconsultar);
			
			JButton bregistrar = new JButton("Registrar Cita");
			bregistrar.setForeground(new Color(255, 255, 255));
			bregistrar.setFont(new Font(FONT_TEXTO, Font.PLAIN, 16));
			bregistrar.setBackground(new Color(30, 144, 255));
			bregistrar.setBounds(33, 631, 198, 29);
			panelRaiz.add(bregistrar);
			
			JButton bcancelar = new JButton("Cancelar");
			bcancelar.setForeground(Color.WHITE);
			bcancelar.setFont(new Font(FONT_TEXTO, Font.PLAIN, 16));
			bcancelar.setBackground(new Color(255, 0, 0));
			bcancelar.setBounds(369, 631, 198, 29);
			panelRaiz.add(bcancelar);
			
			tcorreo = new JTextField();
			tcorreo.setEditable(false);
			tcorreo.setFont(new Font(FONT_TEXTO, Font.PLAIN, 14));
			tcorreo.setBounds(197, 458, 290, 20);
			tcorreo.setHorizontalAlignment(SwingConstants.RIGHT);
			panelRaiz.add(tcorreo);
			
			
			comboBoxPaciente = new JComboBox<>();
			comboBoxPaciente.setFont(new Font(FONT_TEXTO, Font.PLAIN, 14));
			comboBoxPaciente.setBounds(197, 417, 290, 17);
			panelRaiz.add(comboBoxPaciente);
			
			 //Alinea el nombre del paciente a la derecha 
			((JLabel)comboBoxPaciente.getRenderer()).setHorizontalAlignment(SwingConstants.RIGHT);
					
			
			
			
			//LISTENERS
			
			comboBoxPaciente.addItemListener(e -> {            //Listener que ejecuta el evento al seleccionar un nombre de usuario
			    if (e.getStateChange() == ItemEvent.SELECTED) {
			        String nombre = (String) comboBoxPaciente.getSelectedItem();
			        asignarusuario(nombre);
			    }
			});
			
			bconsultar.addMouseListener(new MouseAdapter() {    // Listener de consulta para el cotrol que llama a la ventana diagnostico
				@Override
				public void mouseClicked(MouseEvent e) {
					if (usuariorecuperado != null) {
						control.consultar(usuariorecuperado);
					}
					else {
						muestramensaje("Selecciona un Paciente");
					}
					
				}
			});
			
			
			bregistrar.addMouseListener(new MouseAdapter() {          //Listener de Registrar
				@Override
				public void mouseClicked(MouseEvent e) { 
					if(calendar.getDate()==null|| comboBoxHoras.getSelectedItem().equals("") || comboBoxServicios.getSelectedItem().equals("") || usuariorecuperado == null) {
						muestramensaje("Verifique que no haya campos vacios o sin seleccionar");
					}
					else {
					 LocalDate date = calendar.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("H:mm");
					
					control.agregarcita(date,  LocalTime.parse((String) comboBoxHoras.getSelectedItem(), formatoHora) , (String)comboBoxServicios.getSelectedItem(), usuariorecuperado.getCorreo(), usuariorecuperado.getNombre());
					
					// Deseleccionar el chckbxUrgente 
		            chckbxUrgente.setSelected(false);
					}
				}
			});
		   
			
			bcancelar.addMouseListener(new MouseAdapter() {         // Listener de Cancelar
				@Override
				public void mouseClicked(MouseEvent e) {   
					int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de Cancelar?", "Confirmación", JOptionPane.YES_NO_OPTION);

			        if (opcion == JOptionPane.YES_OPTION) {
			        	dispose();  // Metodo que cierra la ventana
			        }
				}
			});
			
			
			
			chckbxUrgente.addMouseListener(new MouseAdapter() {   // Listener de Cita Urgente
			    @Override
			    public void mouseClicked(MouseEvent e) {
			        if (chckbxUrgente.contains(e.getPoint())) {
			            if (chckbxUrgente.isSelected()) {
			            	Optional<Cita> citaCercana = control.findProximaCitaDisponible();
				            
				            if (citaCercana.isPresent()) {
				                Cita cita = citaCercana.get();
				                
				                // Establezca los parámetros de fecha y hora con los valores de la cita más cercana
			                    calendar.setDate(Date.from(cita.getFecha().atStartOfDay(ZoneId.systemDefault()).toInstant()));
			                    comboBoxHoras.setSelectedItem(cita.getHora().toString());
			                    comboBoxServicios.setSelectedItem(""); 

				                String mensaje = "Cita más cercana:\nFecha: " + cita.getFecha() + "\nHora: " + cita.getHora();
				                JOptionPane.showMessageDialog(null, mensaje, "Cita más cercana", JOptionPane.INFORMATION_MESSAGE);
				            
				            
				        } 
			            }
			        }
			    }
			});
			
  }
  
  /**
   * Llena el ComboBox de usuarios con 
   * la lista de usuarios obtenida del controlador.
   * Elimina todos los elementos existentes en el 
   * ComboBox y agrega los nombres completos de los usuarios.
   */
  
  public void llenaUsuarios() {
	    comboBoxPaciente.removeAllItems(); // Elimina todos los elementos existentes en el ComboBox
	    listaUsuario = control.listausuarios(); // Obtiene la lista de usuarios del controlador

	    // Agrega los nombres completos de los usuarios al ComboBox
	    for (Usuario Usuarios : listaUsuario) {
	        comboBoxModelU.addElement(Usuarios.getNombre() + " " + Usuarios.getApellido() + " " + Usuarios.getApellidomaterno());
	    }

	    comboBoxPaciente.setModel(comboBoxModelU); // Establece el modelo del ComboBox con los nuevos elementos
	}
  
  /**
   * Metodo que asigna un usuario en
   * función del nombre proporcionado.
   * 
   * @param nombre. El nombre completo del usuario a asignar.
   */
  
  public void asignarusuario(String nombre) {
      String[] palabras = nombre.split(" "); // Divide el nombre en palabras utilizando un espacio como delimitador

      // Busca un usuario que coincida con el nombre completo
      for (Usuario usuario : listaUsuario) {
          if (usuario.getNombre().equals(palabras[0]) && usuario.getApellido().equals(palabras[1]) && usuario.getApellidomaterno().equals(palabras[2])) {
              usuariorecuperado = usuario; // Asigna el usuario encontrado a la variable "usuariorecuperado"
              tcorreo.setText(usuario.getCorreo()); // Establece el correo del usuario en un campo de texto
              break; // Se encontró el usuario, se termina el bucle
          }
      }
  }
  
  
  /**
   * Actualiza el ComboBox de servicios con
   * la lista de precios obtenida del controlador.
   * 
   * agrega los nombres de los servicios disponibles
   * al ComboBox principal de los servicios
   */
  public void servicios() {
      DefaultComboBoxModel<String> comboBoxModelS = new DefaultComboBoxModel<>(); // Crea un nuevo modelo de ComboBox

      List<Precios> listaImprimir = control.listaPrecios(); // Obtiene la lista de precios del controlador

      // Agrega los nombres de los servicios disponibles al ComboBox
      for (Precios Servicio : listaImprimir) {
          comboBoxModelS.addElement(Servicio.getServicio());
      }
      comboBoxServicios.setModel(comboBoxModelS); // Establece el modelo del ComboBox con los nuevos elementos
  }
  
  /**
   * Muestra un mensaje en una ventana de diálogo.
   *
   * @param mensaje El mensaje a mostrar en la ventana de diálogo.
   */
  public void muestramensaje(String mensaje) {
      JOptionPane.showMessageDialog(this, mensaje); 
  }

  public void muestra(ControlCitaAdmin control) {
	this.control = control;
	listaUsuario = null;
	llenaUsuarios();
	asignarusuario( (String) comboBoxPaciente.getSelectedItem());
	servicios();    
    setVisible(true);
  }

}
