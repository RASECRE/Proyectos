package mx.uam.ayd.proyecto.presentacion.principal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.springframework.stereotype.Component;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;

@SuppressWarnings("serial")
@Component
public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	
	private ControlPrincipal control;
	private JTextField TCorreo;
	private JPasswordField TPass;

	
	public VentanaPrincipal() {   // Ventana de iniciar session
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 512);
		contentPane = new JPanel();
		setContentPane(contentPane);
		setLocationRelativeTo(null);
	    setResizable(false);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 596, 473);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel LogoU = new JLabel("");
		LogoU.setHorizontalAlignment(SwingConstants.CENTER);
		LogoU.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/iconUs.png")));
		LogoU.setBounds(232, 11, 141, 140);
		panel.add(LogoU);
		
		JLabel LAnun = new JLabel("\u00BFA\u00FAn no tienes una cuenta?");
		LAnun.setBackground(new Color(240, 255, 240));
		LAnun.setFont(new Font("Roboto Light", Font.PLAIN, 13));
		LAnun.setForeground(new Color(248, 248, 255));
		LAnun.setBounds(165, 173, 158, 14);
		panel.add(LAnun);
		
		JLabel LRegistrate = new JLabel("Registrate");
		LRegistrate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		LRegistrate.setForeground(new Color(248, 248, 255));
		LRegistrate.setFont(new Font("Roboto Light", Font.PLAIN, 13));
		LRegistrate.setBounds(346, 168, 65, 25);
		panel.add(LRegistrate);
		
		JLabel LCorreo = new JLabel("Correo");
		LCorreo.setForeground(new Color(240, 248, 255));
		LCorreo.setFont(new Font("Roboto Black", Font.BOLD, 16));
		LCorreo.setBounds(272, 225, 65, 14);
		panel.add(LCorreo);
		
		JLabel LContraseña = new JLabel("Contrase\u00F1a");
		LContraseña.setForeground(new Color(240, 248, 255));
		LContraseña.setFont(new Font("Roboto Black", Font.BOLD, 16));
		LContraseña.setBounds(256, 300, 111, 14);
		panel.add(LContraseña);
		
		TCorreo = new JTextField() {
			  @Override
	            protected void paintComponent(Graphics g) {
	                g.setColor(getBackground());
	                g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
	                super.paintComponent(g);
	            }

	            @Override
	            protected void paintBorder(Graphics g) {
	                g.setColor(Color.WHITE);
	                g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
	            }
		};
		TCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		TCorreo.setFont(new Font("Roboto", Font.BOLD, 12));
		TCorreo.setOpaque(false);
		TCorreo.setBackground(new Color(240, 248, 255));
		TCorreo.setBounds(145, 255, 314, 27);
		panel.add(TCorreo);
		TCorreo.setColumns(10);
		TCorreo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		TPass = new JPasswordField()
		{
			  @Override
	            protected void paintComponent(Graphics g) {
	                g.setColor(getBackground());
	                g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
	                super.paintComponent(g);
	            }

	            @Override
	            protected void paintBorder(Graphics g) {
	                g.setColor(Color.WHITE);
	                g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
	            }
		};
		TPass.setHorizontalAlignment(SwingConstants.CENTER);
		TPass.setFont(new Font("Roboto", Font.BOLD, 12));
		TPass.setOpaque(false);
		TPass.setBounds(145, 333, 314, 27);
		panel.add(TPass);
		
		JLabel LIniciarS = new JLabel("Iniciar Sesi\u00F3n"){
			  @Override
	            protected void paintComponent(Graphics g) {
	                g.setColor(getBackground());
	                g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
	                super.paintComponent(g);
	            }

	            @Override
	            protected void paintBorder(Graphics g) {
	                g.setColor(Color.WHITE);
	                g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
	            }
		};
		LIniciarS.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		LIniciarS.setHorizontalTextPosition(SwingConstants.CENTER);
		LIniciarS.setHorizontalAlignment(SwingConstants.CENTER);
		LIniciarS.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		LIniciarS.setBackground(new Color(30, 144, 255));
		LIniciarS.setFont(new Font("Roboto Black", Font.BOLD, 17));
		LIniciarS.setForeground(new Color(240, 248, 255));
		LIniciarS.setBounds(215, 389, 176, 37);
		panel.add(LIniciarS);
		
		JLabel Fondo = new JLabel("");
		Fondo.setForeground(new Color(0, 191, 255));
		Fondo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Fondo2.1.jpg")));
		Fondo.setBounds(0, 0, 596, 473);
		panel.add(Fondo);
		
		// ******* Listeners  *******
		
		LRegistrate.addMouseListener(new MouseAdapter() {  //Este listener llama a la ventana agregar ususario		
			@Override                                      // para registrarse
			public void mousePressed(MouseEvent e) {       
				
				control.agregarUsuario();   // Contro de Registro o agregar usuario
				dispose();                  // Cierra la ventana principal "Inicio de sesion"
			}
		});
		
		
		LIniciarS.addMouseListener(new MouseAdapter() {  // Listener de iniciar sesion
			@Override
			public void mousePressed(MouseEvent e) { 
				 
				if (control.validaUsuario(TCorreo.getText(),String.valueOf(TPass.getPassword())) !=null) {
					control.VentanaUsuario(control.validaUsuario(TCorreo.getText(),String.valueOf(TPass.getPassword())));
					dispose(); 
				}
				//Este listener debe recibir un control
			}                                           
		});                                            
		

	}
	
	public void muestra(ControlPrincipal control) {
		
		this.control = control;
		
		setVisible(true);
	}
}
