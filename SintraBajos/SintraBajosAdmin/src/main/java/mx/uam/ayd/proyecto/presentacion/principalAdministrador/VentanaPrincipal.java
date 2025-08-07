package mx.uam.ayd.proyecto.presentacion.principalAdministrador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.springframework.stereotype.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		
		
		JLabel LIniciar = new JLabel("BIENVENIDO DE NUEVO"){
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
		LIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				control.MenuAdmin();
				dispose();
			}
		});
		LIniciar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		LIniciar.setHorizontalTextPosition(SwingConstants.CENTER);
		LIniciar.setHorizontalAlignment(SwingConstants.CENTER);
		LIniciar.setBorder(new LineBorder(new Color(0, 0, 0)));
		LIniciar.setBackground(new Color(128, 0, 128, 128));
		LIniciar.setFont(new Font("Roboto Black", Font.BOLD, 17));
		LIniciar.setForeground(Color.WHITE);
		LIniciar.setBounds(180, 218, 229, 37);
		panel.add(LIniciar);
		
		JLabel Fondo = new JLabel("");
		Fondo.setForeground(Color.WHITE);
		Fondo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Triangulos.jpg")));
		Fondo.setBounds(0, 0, 596, 473);
		panel.add(Fondo);
	}
	
	public void muestra(ControlPrincipal control) {
		
		this.control = control;
		
		setVisible(true);
	}
}
