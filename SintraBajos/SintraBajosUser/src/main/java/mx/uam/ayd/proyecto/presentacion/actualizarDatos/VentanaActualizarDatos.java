package mx.uam.ayd.proyecto.presentacion.actualizarDatos;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.springframework.stereotype.Component;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
@SuppressWarnings("serial")
@Component
public class VentanaActualizarDatos extends JFrame {
	private Usuario usuario;
	private ControlActualizarDatos control;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textCorreo;
	private JTextField textTelefono;
	private JTextField textDomicilio;
	private JDateChooser TCalendario = new JDateChooser(); 
	
	
	public VentanaActualizarDatos() {
		setResizable(false);
		setTitle("Actualizar Datos Personales.");
		setLocationRelativeTo(null);
		setBounds(100, 100,580, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(291, 10, 1, 1);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 204, 204));
		panel_1.setBounds(0, 0, 564, 501);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(153, 204, 204));
		panel_2.setBounds(0, 0, 564, 81);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Datos personales.");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(167, 11, 259, 71);
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(211, 211, 211));
		panel_3.setBounds(0, 85, 564, 70);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre completo:");
		lblNewLabel_1.setBounds(10, 11, 187, 41);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		panel_3.add(lblNewLabel_1);
		
		textNombre = new JTextField();
		textNombre.setBounds(207, 12, 101, 41);
		panel_3.add(textNombre);
		textNombre.setFont(new Font("Dialog", Font.PLAIN, 14));
		textNombre.setColumns(10);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(211, 211, 211));
		panel_3_1.setBounds(0, 155, 564, 63);
		panel_1.add(panel_3_1);
		panel_3_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fecha de Nacimiento:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(0, 12, 197, 41);
		panel_3_1.add(lblNewLabel_1_1);
		
		
		TCalendario.setBounds(207, 29, 124, 23);
		panel_3_1.add(TCalendario);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBackground(new Color(211, 211, 211));
		panel_3_2.setBounds(0, 218, 564, 63);
		panel_1.add(panel_3_2);
		panel_3_2.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("Correo:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(0, 11, 104, 41);
		panel_3_2.add(lblNewLabel_1_2);
		
		textCorreo = new JTextField();
		textCorreo.setFont(new Font("Dialog", Font.PLAIN, 14));
		textCorreo.setColumns(10);
		textCorreo.setBounds(207, 7, 224, 41);
		panel_3_2.add(textCorreo);
		
		JPanel panel_3_3 = new JPanel();
		panel_3_3.setBackground(new Color(211, 211, 211));
		panel_3_3.setBounds(0, 280, 564, 63);
		panel_1.add(panel_3_3);
		panel_3_3.setLayout(null);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Teléfono:");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lblNewLabel_1_2_1.setBounds(0, 9, 114, 41);
		panel_3_3.add(lblNewLabel_1_2_1);
		
		textTelefono = new JTextField();
		textTelefono.setFont(new Font("Dialog", Font.PLAIN, 14));
		textTelefono.setColumns(10);
		textTelefono.setBounds(207, 11, 224, 41);
		panel_3_3.add(textTelefono);
		
		JPanel panel_3_3_1 = new JPanel();
		panel_3_3_1.setBackground(new Color(211, 211, 211));
		panel_3_3_1.setBounds(0, 343, 564, 70);
		panel_1.add(panel_3_3_1);
		panel_3_3_1.setLayout(null);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Domicilio:");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lblNewLabel_1_2_2.setBounds(0, 7, 114, 41);
		panel_3_3_1.add(lblNewLabel_1_2_2);
		
		textDomicilio = new JTextField();
		textDomicilio.setFont(new Font("Dialog", Font.PLAIN, 14));
		textDomicilio.setColumns(10);
		textDomicilio.setBounds(207, 7, 224, 41);
		panel_3_3_1.add(textDomicilio);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setForeground(new Color(255, 250, 250));
		btnActualizar.setBackground(new Color(0, 0, 204));
		btnActualizar.setBounds(80, 437, 119, 34);
		panel_1.add(btnActualizar);
		
		btnActualizar.addMouseListener(new MouseAdapter() {
		      @Override
		      //Cuando se selecciona el boton guardar, se obtiene el texto del campo de diagnostico
		      // Y esta nueva informacion es almacenada en el Paciente en turno. 
		      public void mouseClicked(MouseEvent e) {
		    	 /*Agregar parte actualizar fecha usuario*/
		    	// Se valida que los campos no esten vacios
					if (textNombre.getText().equals("") ||  textDomicilio.getText().equals("") || textTelefono.getText().equals("") || 
							textCorreo.getText().equals("")) {
						muestraDialogoConMensaje("Los campos no deben estar vacios");
					}
							          	          			
					/*Se revisa que la fecha no quede vacia */
					else if (TCalendario.getDate() == null) {

						muestraDialogoConMensaje("Ingresa una fecha valida");
					}
					/*Se verifica que el telefono recibido sea correctamente escrito */
					else if (textTelefono.getText().length()<10 || !textTelefono.getText().matches("\\d{10}")) {        
						muestraDialogoConMensaje("Verifica el número de télefono ingresado");
                   } 
					/*Se verifica el correo */
					else if ((!textCorreo.getText().contains(".com") && !textCorreo.getText().contains(".mx"))
							|| !textCorreo.getText().contains("@")) {
						muestraDialogoConMensaje("Verifica que el correo sea valido");
					}

					else {
						/*Se han pasado todas las verificaciones, se almacena el usuario*/
						/*Se asignan los nuevos datos del usuario al objeto Usuario para que se pueda actualizar.*/
						usuario.setFechaNa(TCalendario.getDate()); 
				    	usuario.setNombre(textNombre.getText()); 
				        usuario.setCorreo(textCorreo.getText());
				        usuario.setDomicilio(textDomicilio.getText());
				        usuario.setTelefono(Long.parseLong(textTelefono.getText()));
				        control.UsuarioAct(usuario); //Se envian los datos nuevos del usuario para que el cambio 
				        // Se vea reflejado en la BD.
					}
		      }
		    });
		
		JButton btnCancelar = new JButton("Cancelar"); //Boton para cancelar la operacion 
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mensajeCancela(); //Si se da clic en cancelar, nos envia al metodo de cancelacion
			}
		});
		btnCancelar.setForeground(new Color(255, 250, 250));
		btnCancelar.setBackground(new Color(255, 0, 51));
		btnCancelar.setBounds(360, 437, 119, 34);
		panel_1.add(btnCancelar);
	}
	

	/*Metodo con la que se muestra al usuario*/
	public void muestra(ControlActualizarDatos control, Usuario usuario) {
		/*Los controles son asignados*/
		this.control = control;
		this.usuario = usuario;
		//A continuacion, se escribe la informacion del usuario
		//En el cuadro de texto correspondiente.
		textNombre.setText(usuario.getNombre());
		TCalendario.setDate(usuario.getFechaNa());
		textCorreo.setText(usuario.getCorreo());
		textDomicilio.setText(usuario.getDomicilio());
		textTelefono.setText(String.valueOf(usuario.getTelefono()));
		setVisible(true); //Se indica que la ventana debe ser mostrada 
	}
	
	//Metodo que nos confirma que la informacion fue almacenada correctamente
	public void mensajeConfir() {
		JOptionPane.showMessageDialog(null, "La informacion fue actualizada correctamente.");
		cierra(); //Cierra la ventana
	}
	// Si se da clic en cancelar, se activa este evento y se cierra la ventana sin cambiar los datos del usuario de la BD.
	public void mensajeCancela() {
		JOptionPane.showMessageDialog(null, "Cancelando, la actualizacion no fue realizada");
		setVisible(false); //La ventana se cierra, sin detener la ejecucion de la ventana principal
	}
	
	//Cierra la ventana
	  public void cierra() { // Cierra la ventana despues de guardar
	    setVisible(false); //La ventana se cierra, sin detener la ejecucion de la ventana principal
	  }
	  
	  //Se muestra el mensaje en funcion de 
	  public void muestraDialogoConMensaje(String mensaje ) {
			JOptionPane.showMessageDialog(this , mensaje);
		}
}
