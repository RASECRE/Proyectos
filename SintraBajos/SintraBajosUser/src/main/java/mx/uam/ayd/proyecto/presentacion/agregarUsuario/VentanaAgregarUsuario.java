package mx.uam.ayd.proyecto.presentacion.agregarUsuario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


import org.springframework.stereotype.Component;
import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;




@SuppressWarnings("serial")
@Component
public class VentanaAgregarUsuario extends JFrame {

	private JPanel contentPane;
	private ControlAgregarUsuario control;
	private JTextField TNombre;
	private JTextField TAP;
	private JTextField TAM;
	private JTextField TSexo;
	private JTextField TDom;
	private JTextField TTel;
	private JTextField TCorreo;
	private JPasswordField TPass;
	private JDateChooser TCalendario;
	private String Diagnostico = "";
	private long Tel2;
	private boolean band = false;

	/**
	 * Launch the application.
	 *
    */
	
	public VentanaAgregarUsuario() {
		
		
		setTitle("Registrate");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 645); 
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		JPanel panel = new JPanel();                       // Creación del panel
        panel.setBackground(new Color(30, 144, 255));
        panel.setLayout(null); 
        panel.setPreferredSize(new Dimension(380, 850)); 
        
        JScrollPane scrollPane = new JScrollPane(panel);    // Creación del JScrollPane y agregación del panel
        scrollPane.setBounds(0, 0, 484, 610);
        contentPane.add(scrollPane);	
        
        JLabel TRegistro = new JLabel("Registrate");
        TRegistro.setHorizontalAlignment(SwingConstants.CENTER);
        TRegistro.setForeground(new Color(240, 255, 240));
        TRegistro.setFont(new Font("Roboto Black", Font.BOLD, 24));
        TRegistro.setBounds(163, 25, 132, 32);
        panel.add(TRegistro);
		   
	    JLabel Logo = new JLabel("");                       //Se crea el Logo
        Logo.setIcon(new ImageIcon(VentanaAgregarUsuario.class.getResource("/img/Logo3.png")));
        Logo.setBounds(30, 11, 72, 73);
        panel.add(Logo);
        
        JLabel LCuenta = new JLabel("\u00BFYa tienes una cuenta?");
        LCuenta.setHorizontalAlignment(SwingConstants.CENTER);
        LCuenta.setForeground(new Color(240, 255, 240));
        LCuenta.setFont(new Font("Roboto", Font.BOLD, 12));
        LCuenta.setBounds(119, 87, 132, 42);
        panel.add(LCuenta);
        
        JLabel InicioSesion = new JLabel("Inicia Sesi\u00F3n");
        InicioSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        InicioSesion.setForeground(SystemColor.textHighlightText);
        InicioSesion.setFont(new Font("Roboto", Font.BOLD, 12));
        InicioSesion.setBounds(255, 97, 78, 22);
        panel.add(InicioSesion);
        
        
        
        JLabel LNombre = new JLabel("Nombre (s)");
        LNombre.setHorizontalAlignment(SwingConstants.CENTER);
        LNombre.setForeground(new Color(240, 255, 240));
        LNombre.setFont(new Font("Roboto Light", Font.BOLD, 14));
        LNombre.setBounds(30, 140, 92, 42);
        panel.add(LNombre);
        
        TNombre = new JTextField();
        TNombre.setVerifyInputWhenFocusTarget(false);
        TNombre.setOpaque(false);
        TNombre.setForeground(Color.WHITE);
        TNombre.setFont(new Font("Roboto Light", Font.BOLD, 14));
        TNombre.setColumns(10);
        TNombre.setBorder(null);
        TNombre.setBackground(Color.WHITE);
        TNombre.setBounds(45, 185, 356, 18);
        panel.add(TNombre);
        
        JSeparator separator = new JSeparator();
        separator.setIgnoreRepaint(true);
        separator.setForeground(SystemColor.text);
        separator.setDoubleBuffered(true);
        separator.setBackground(Color.WHITE);
        separator.setBounds(45, 202, 356, 5);
        panel.add(separator);
        
        JLabel LAp = new JLabel("Apellido Paterno");
        LAp.setForeground(new Color(240, 255, 240));
        LAp.setFont(new Font("Roboto Light", Font.BOLD, 14));
        LAp.setBounds(45, 218, 124, 42);
        panel.add(LAp);
        
        TAP = new JTextField();
        TAP.setVerifyInputWhenFocusTarget(false);
        TAP.setOpaque(false);
        TAP.setForeground(Color.WHITE);
        TAP.setFont(new Font("Roboto Light", Font.BOLD, 14));
        TAP.setColumns(10);
        TAP.setBorder(null);
        TAP.setBackground(Color.WHITE);
        TAP.setBounds(45, 259, 356, 18);
        panel.add(TAP);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setIgnoreRepaint(true);
        separator_1.setForeground(SystemColor.text);
        separator_1.setDoubleBuffered(true);
        separator_1.setBackground(Color.WHITE);
        separator_1.setBounds(45, 278, 356, 5);
        panel.add(separator_1);
        
        JLabel LAm = new JLabel("Apellido Materno");
        LAm.setForeground(new Color(240, 255, 240));
        LAm.setFont(new Font("Roboto Light", Font.BOLD, 14));
        LAm.setBounds(45, 287, 124, 42);
        panel.add(LAm);
        
        TAM = new JTextField();
        TAM.setVerifyInputWhenFocusTarget(false);
        TAM.setOpaque(false);
        TAM.setForeground(Color.WHITE);
        TAM.setFont(new Font("Roboto Light", Font.BOLD, 14));
        TAM.setColumns(10);
        TAM.setBorder(null);
        TAM.setBackground(Color.WHITE);
        TAM.setBounds(45, 328, 356, 18);
        panel.add(TAM);
        
        JSeparator separator_1_1 = new JSeparator();
        separator_1_1.setIgnoreRepaint(true);
        separator_1_1.setForeground(SystemColor.text);
        separator_1_1.setDoubleBuffered(true);
        separator_1_1.setBackground(Color.WHITE);
        separator_1_1.setBounds(45, 345, 356, 5);
        panel.add(separator_1_1);
        
        JLabel LS = new JLabel("Sexo");
        LS.setHorizontalAlignment(SwingConstants.LEFT);
        LS.setForeground(new Color(240, 255, 240));
        LS.setFont(new Font("Roboto Light", Font.BOLD, 14));
        LS.setBounds(45, 360, 50, 42);
        panel.add(LS);
        
        JLabel LFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
        LFechaDeNacimiento.setHorizontalAlignment(SwingConstants.LEFT);
        LFechaDeNacimiento.setForeground(new Color(240, 255, 240));
        LFechaDeNacimiento.setFont(new Font("Roboto Light", Font.BOLD, 14));
        LFechaDeNacimiento.setBounds(263, 360, 167, 42);
        panel.add(LFechaDeNacimiento);
        
        JCheckBox OPH = new JCheckBox("Hombre");
        OPH.setFont(new Font("Roboto Light", Font.BOLD, 14));
        OPH.setForeground(new Color(240, 248, 255));
        OPH.setOpaque(false);
        OPH.setBounds(40, 417, 97, 23);
        panel.add(OPH);
        
        JCheckBox OPM = new JCheckBox("Mujer");
        OPM.setOpaque(false);
        OPM.setForeground(new Color(240, 248, 255));
        OPM.setFont(new Font("Roboto Light", Font.BOLD, 14));
        OPM.setBounds(154, 417, 97, 23);
        panel.add(OPM);
        
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(OPH);
        grupo.add(OPM);
        
        TSexo  = new JTextField();
              
        
        TCalendario = new JDateChooser();
        TCalendario.setBounds(272, 417, 124, 23);
        panel.add(TCalendario);
        
        JLabel LDomicilio = new JLabel("Domicilio");
        LDomicilio.setHorizontalAlignment(SwingConstants.LEFT);
        LDomicilio.setForeground(new Color(240, 255, 240));
        LDomicilio.setFont(new Font("Roboto Light", Font.BOLD, 14));
        LDomicilio.setBounds(45, 466, 103, 42);
        panel.add(LDomicilio);
        
        TDom = new JTextField();
        TDom.setVerifyInputWhenFocusTarget(false);
        TDom.setOpaque(false);
        TDom.setForeground(Color.WHITE);
        TDom.setFont(new Font("Roboto Light", Font.BOLD, 14));
        TDom.setColumns(10);
        TDom.setBorder(null);
        TDom.setBackground(Color.WHITE);
        TDom.setBounds(45, 508, 356, 18);
        panel.add(TDom);
        
        JSeparator separator_1_1_1 = new JSeparator();
        separator_1_1_1.setIgnoreRepaint(true);
        separator_1_1_1.setForeground(Color.BLACK);
        separator_1_1_1.setDoubleBuffered(true);
        separator_1_1_1.setBackground(Color.WHITE);
        separator_1_1_1.setBounds(45, 527, 356, 5);
        panel.add(separator_1_1_1);
        
        JLabel LTlefono = new JLabel("T\u00E9lefono");
        LTlefono.setHorizontalAlignment(SwingConstants.LEFT);
        LTlefono.setForeground(new Color(240, 255, 240));
        LTlefono.setFont(new Font("Roboto Light", Font.BOLD, 14));
        LTlefono.setBounds(45, 543, 103, 42);
        panel.add(LTlefono);
        
        TTel = new JTextField();
        TTel.setVerifyInputWhenFocusTarget(false);
        TTel.setOpaque(false);
        TTel.setForeground(Color.WHITE);
        TTel.setFont(new Font("Roboto Light", Font.BOLD, 14));
        TTel.setColumns(10);
        TTel.setBorder(null);
        TTel.setBackground(Color.WHITE);
        TTel.setBounds(45, 583, 356, 18);
        panel.add(TTel);
        
        JSeparator separator_1_1_1_1 = new JSeparator();
        separator_1_1_1_1.setIgnoreRepaint(true);
        separator_1_1_1_1.setForeground(Color.BLACK);
        separator_1_1_1_1.setDoubleBuffered(true);
        separator_1_1_1_1.setBackground(Color.WHITE);
        separator_1_1_1_1.setBounds(45, 602, 356, 5);
        panel.add(separator_1_1_1_1);
        
        JLabel LCorreo = new JLabel("Correo");
        LCorreo.setHorizontalAlignment(SwingConstants.LEFT);
        LCorreo.setForeground(new Color(240, 255, 240));
        LCorreo.setFont(new Font("Roboto Light", Font.BOLD, 14));
        LCorreo.setBounds(45, 623, 103, 42);
        panel.add(LCorreo);
        
        TCorreo = new JTextField();
        TCorreo.setVerifyInputWhenFocusTarget(false);
        TCorreo.setText("example@gmail.com");
        TCorreo.setOpaque(false);
        TCorreo.setForeground(new Color(211, 211, 211));
        TCorreo.setFont(new Font("Roboto Light", Font.BOLD, 14));
        TCorreo.setColumns(10);
        TCorreo.setBorder(null);
        TCorreo.setBackground(Color.WHITE);
        TCorreo.setBounds(45, 668, 356, 18);
        panel.add(TCorreo);
                
        JSeparator separator_1_1_1_1_1 = new JSeparator();
        separator_1_1_1_1_1.setIgnoreRepaint(true);
        separator_1_1_1_1_1.setForeground(Color.BLACK);
        separator_1_1_1_1_1.setDoubleBuffered(true);
        separator_1_1_1_1_1.setBackground(Color.WHITE);
        separator_1_1_1_1_1.setBounds(45, 689, 356, 5);
        panel.add(separator_1_1_1_1_1);
        
        JLabel LPass = new JLabel("Contrase\u00F1a");
        LPass.setHorizontalAlignment(SwingConstants.LEFT);
        LPass.setForeground(new Color(240, 255, 240));
        LPass.setFont(new Font("Roboto Light", Font.BOLD, 14));
        LPass.setBounds(45, 707, 103, 42);
        panel.add(LPass);
        
        
        TPass = new JPasswordField();
        TPass.setToolTipText("");
        TPass.setOpaque(false);
        TPass.setForeground(Color.WHITE);
        TPass.setBorder(null);
        TPass.setBounds(45, 744, 356, 18);
        panel.add(TPass);
        
           
        JSeparator separator_1_1_1_1_1_1 = new JSeparator();
        separator_1_1_1_1_1_1.setIgnoreRepaint(true);
        separator_1_1_1_1_1_1.setForeground(Color.BLACK);
        separator_1_1_1_1_1_1.setDoubleBuffered(true);
        separator_1_1_1_1_1_1.setBackground(Color.WHITE);
        separator_1_1_1_1_1_1.setBounds(45, 762, 356, 5);
        panel.add(separator_1_1_1_1_1_1);
        
        JLabel BRegistrarse = new JLabel("Registrarse");       
        BRegistrarse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        BRegistrarse.setHorizontalAlignment(SwingConstants.CENTER);
        BRegistrarse.setForeground(Color.WHITE);
        BRegistrarse.setFont(new Font("Roboto Light", Font.BOLD, 14));
        BRegistrarse.setBorder(new LineBorder(new Color(255, 255, 255)));
        BRegistrarse.setBackground(new Color(30, 144, 255));
        BRegistrarse.setBounds(118, 794, 209, 32);
        panel.add(BRegistrarse);


		
		// Listeners
		
    	    	
    	 InicioSesion.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mousePressed(MouseEvent e) {
	        		
	        		//control.regresa();           //AQUI SE TIENE QUE REGRESAR A LA VISTA PRINCIPAL (BUSCAR SOLUCION)
	        		//dispose();                      //Funcion que cierra ventana
	        	}
	        });
    	 
			BRegistrarse.addMouseListener(new MouseAdapter() {
				@Override
				

				public void mousePressed(MouseEvent e) {
					
					if (OPH.isSelected()) {
						TSexo.setText("Hombre");
					}
					if (OPM.isSelected()) {
						TSexo.setText("Mujer");
					}
					
                       
					// Falta Validar el telefono
					if (TNombre.getText().equals("") || TAP.getText().equals("") || TAM.getText().equals("")
							|| TDom.getText().equals("") || TTel.getText().equals("") || TSexo.getText().equals("")
							|| TCorreo.getText().equals("") || TPass.getPassword().equals("")||TPass.getPassword().length<=0) {
						muestraDialogoConMensaje("Los campos no deben estar vacios");
					}
							          	          			

					else if (TCalendario.getDate() == null) {

						muestraDialogoConMensaje("Ingresa una fecha valida");
					}
					
					else if (TTel.getText().length()<10 || !TTel.getText().matches("\\d{10}")) {        
						muestraDialogoConMensaje("Verifica el número de télefono ingresado");
                     } 
					
					else if ((!TCorreo.getText().contains(".com") && !TCorreo.getText().contains(".mx"))
							|| !TCorreo.getText().contains("@")) {
						muestraDialogoConMensaje("Verifica que el correo sea valido");
					}
					else if (TPass.getPassword().length<=7) {
						muestraDialogoConMensaje("Ingresa una contraseña de minimo 8 caracteres");
					}
					else {
						control.agregaUsuario(TNombre.getText(), TAP.getText(), TAM.getText(), TSexo.getText(),
								TCalendario.getDate(), TDom.getText(),Long.valueOf(TTel.getText()),TCorreo.getText(),
								String.valueOf(TPass.getPassword()), Diagnostico);

					}
				}
			});

		}
	
	public void muestra(ControlAgregarUsuario control) {
		
		this.control = control;
		
		TNombre.setText("");
		TAP.setText("");
		TAM.setText("");
		TSexo.setText("");
		TCalendario.setDate(null);
		TTel.setText("");
		TDom.setText(""); 
		TCorreo.setText("");
		TPass.setText("");
			
		setVisible(true);

	}
	
	public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}
}
