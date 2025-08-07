package mx.uam.ayd.proyecto.presentacion.listarUsuarios;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ventanaEditar extends JFrame {

  private JPanel contentPane;
  private JTextField textField;
  private JTextField textField_1;
  private JTextField textField_2;
  private JTextField textField_3;
  private JTextField textField_4;
  private JTextField textField_5;

  private ControlListarUsuarios controlE;
  private Usuario usuario;

  @Autowired
  private ventanaListaUsuarios ventana2;

  public ventanaEditar() {
    setTitle("Datos del Usuario");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 790, 551);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(null);

    JPanel panelLogo = new JPanel();
		panelLogo.setBounds(0, 0, 173, 104);
		contentPane.add(panelLogo);
		panelLogo.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ventanaEditar.class.getResource("/img/Logo3.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(37, 10, 98, 84);
		panelLogo.add(lblNewLabel_1);
    
    JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(172, 0, 604, 104);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Datos del Usuario");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 30));
		lblNewLabel.setBounds(183, 30, 223, 38);
		panel.add(lblNewLabel);

    JLabel DUsuario = new JLabel("");
		DUsuario.setIcon(new ImageIcon(ventanaEditar.class.getResource("/img/Usuario.png")));
		DUsuario.setBounds(56, 138, 225, 237);
		contentPane.add(DUsuario);
		
		JPanel panelI = new JPanel();
		panelI.setBackground(Color.LIGHT_GRAY);
		panelI.setBounds(172, 0, 604, 104);
		contentPane.add(panelI);
		panelI.setLayout(null);

    JLabel lblNombre = new JLabel("Nombre:");
    lblNombre.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblNombre.setBounds(368, 138, 98, 29);
    contentPane.add(lblNombre);

    textField = new JTextField();
    textField.setBounds(464, 138, 280, 26);
    contentPane.add(textField);
    textField.setColumns(10);

    JLabel lblApellidoP = new JLabel("Apellido P:");
    lblApellidoP.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblApellidoP.setBounds(364, 177, 98, 29);
    contentPane.add(lblApellidoP);

    textField_1 = new JTextField();
    textField_1.setColumns(10);
    textField_1.setBounds(464, 177, 280, 26);
    contentPane.add(textField_1);

    JLabel lblApellido = new JLabel("Apellido M:");
    lblApellido.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblApellido.setBounds(364, 216, 98, 29);
    contentPane.add(lblApellido);

    textField_2 = new JTextField();
    textField_2.setColumns(10);
    textField_2.setBounds(464, 216, 280, 26);
    contentPane.add(textField_2);

    JLabel lblTelfono = new JLabel("Teléfono:");
    lblTelfono.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblTelfono.setBounds(364, 255, 98, 29);
    contentPane.add(lblTelfono);

    textField_3 = new JTextField();
    textField_3.setColumns(10);
    textField_3.setBounds(464, 255, 280, 26);
    contentPane.add(textField_3);

    JLabel lblCorreo = new JLabel("Correo:");
    lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblCorreo.setBounds(364, 294, 98, 29);
    contentPane.add(lblCorreo);

    textField_4 = new JTextField();
    textField_4.setColumns(10);
    textField_4.setBounds(464, 294, 280, 26);
    contentPane.add(textField_4);

    JLabel lblDireccin = new JLabel("Domicilio:");
    lblDireccin.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblDireccin.setBounds(364, 333, 98, 29);
    contentPane.add(lblDireccin);

    textField_5 = new JTextField();
    textField_5.setColumns(10);
    textField_5.setBounds(464, 325, 280, 50);
    contentPane.add(textField_5);

    JButton btnActualizar = new JButton("Guardar");
    JButton btnRegresar = new JButton("Regresar");

    btnRegresar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
      }
    });

    btnRegresar.setFont(new Font("Arial", Font.BOLD, 15));
    btnRegresar.setBounds(10, 444, 143, 38);
    contentPane.add(btnRegresar);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    btnActualizar.addMouseListener(new MouseAdapter() {
      @Override

      public void mouseClicked(MouseEvent e) {
    	  if(textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") 
        || textField_3.getText().equals("") || textField_4.getText().equals("") || textField_5.getText().equals("")){ 
    	  muestraDialogoConMensaje("Rellena Todos Los Campos");
    	  }else if(textField_3.getText().length()<10 || !textField_3.getText().matches("\\d{10}")){
    		  muestraDialogoConMensaje("Verifica el Número de Télefono ingresado");
    	  }else if ((!textField_4.getText().contains(".com") && !textField_4.getText().contains(".mx"))
        || !textField_4.getText().contains("@")) {
          muestraDialogoConMensaje("Verifica que el correo sea valido");
        }else{
          usuario.setNombre(textField.getText());
        	usuario.setApellido(textField_1.getText());
        	usuario.setApellidomaterno(textField_2.getText());
        	usuario.setTelefono(Long.parseLong(textField_3.getText()));
        	usuario.setCorreo(textField_4.getText());
        	usuario.setDomicilio(textField_5.getText());
        	controlE.recuperaNuevo(usuario);

          ventana2.termina();
          setVisible(false);
        }
      }});
    
    btnActualizar.setFont(new Font("Arial", Font.BOLD, 15));
    btnActualizar.setBounds(601, 444, 143, 38);
    contentPane.add(btnActualizar);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void muestraE(ControlListarUsuarios control, Usuario usuario) {
    this.controlE = control;
    this.usuario = usuario;
   
    textField.setText(usuario.getNombre());
    textField_1.setText(usuario.getApellido());
    textField_2.setText(usuario.getApellidomaterno());
    textField_3.setText(String.valueOf(usuario.getTelefono()));
    textField_4.setText(usuario.getCorreo());
    textField_5.setText(usuario.getDomicilio());
    setVisible(true);
  }

  public void cierra() {
    setVisible(false);
  }

  public void muestraMensaje() {
    JOptionPane.showMessageDialog(null,"La informacion fue actualizada correctamente.");
    cierra();
  }
  
  public void muestraDialogoConMensaje(String mensaje){
    JOptionPane.showMessageDialog(this,mensaje);
    }
   
}