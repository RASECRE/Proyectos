package mx.uam.ayd.proyecto.presentacion.menuUsuario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
@Component
public class VentanaUsuario extends JFrame {

	private JPanel contentPane;
	private ControlUsuario control;
	private Usuario usuario;

	/**
	 * Create the frame.
	 */
	public VentanaUsuario() {
		setTitle("Ventana Paciente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		setLocationRelativeTo(null);// Centramos la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBackground(new Color(255, 228, 225));
		panelPrincipal.setBounds(0, 0, 584, 461);
		contentPane.add(panelPrincipal);
		panelPrincipal.setLayout(null);

		JPanel panelCitas = new JPanel();
		panelCitas.setLayout(null);
		panelCitas.setBackground(new Color(0, 102, 102));
		panelCitas.setBounds(10, 26, 169, 172);
		panelPrincipal.add(panelCitas);

		JLabel etiquetaACitas = new JLabel("Agendar Citas.");
		etiquetaACitas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// JOptionPane.showMessageDialog(null, "Se dio clic en Agendar citas.");
				control.agendarCitas(usuario);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				etiquetaACitas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		etiquetaACitas.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaACitas.setForeground(Color.WHITE);
		etiquetaACitas.setFont(new Font("Microsoft Tai Le", Font.BOLD, 13));
		etiquetaACitas.setBounds(23, 121, 126, 40);
		panelCitas.add(etiquetaACitas);

		JLabel etiquetaImg1 = new JLabel("");
		etiquetaImg1.setIcon(new ImageIcon(VentanaUsuario.class.getResource("/img/p1.png")));
		etiquetaImg1.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaImg1.setBounds(11, 29, 138, 84);
		panelCitas.add(etiquetaImg1);

		JPanel panelCitas_1 = new JPanel();
		panelCitas_1.setLayout(null);
		panelCitas_1.setBackground(new Color(189, 183, 107));
		panelCitas_1.setBounds(385, 26, 189, 172);
		panelPrincipal.add(panelCitas_1);

		JLabel lblNotificaciones = new JLabel("Notificaciones.");
		lblNotificaciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// JOptionPane.showMessageDialog(null, "Se dio clic en Notificaciones.");
				control.verNitificaciones(usuario);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblNotificaciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblNotificaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotificaciones.setForeground(Color.WHITE);
		lblNotificaciones.setFont(new Font("Microsoft Tai Le", Font.BOLD, 13));
		lblNotificaciones.setBounds(10, 121, 169, 40);
		panelCitas_1.add(lblNotificaciones);

		JLabel etiquetaImg1_1 = new JLabel("");
		etiquetaImg1_1.setIcon(new ImageIcon(VentanaUsuario.class.getResource("/img/p2.png")));
		etiquetaImg1_1.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaImg1_1.setBounds(22, 24, 144, 99);
		panelCitas_1.add(etiquetaImg1_1);

		JPanel panelCitas_2 = new JPanel();
		panelCitas_2.setLayout(null);
		panelCitas_2.setBackground(new Color(250, 128, 114));
		panelCitas_2.setBounds(10, 247, 169, 172);
		panelPrincipal.add(panelCitas_2);

		JLabel lblActualizarDatos = new JLabel("Actualizar Datos.");
		lblActualizarDatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					control.actualizaDatos(usuario);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblActualizarDatos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblActualizarDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblActualizarDatos.setForeground(Color.WHITE);
		lblActualizarDatos.setFont(new Font("Microsoft Tai Le", Font.BOLD, 13));
		lblActualizarDatos.setBounds(20, 121, 139, 40);
		panelCitas_2.add(lblActualizarDatos);

		JLabel etiquetaImg1_2 = new JLabel("");
		etiquetaImg1_2.setIcon(new ImageIcon(VentanaUsuario.class.getResource("/img/p3.png")));
		etiquetaImg1_2.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaImg1_2.setBounds(10, 22, 144, 99);
		panelCitas_2.add(etiquetaImg1_2);

		JPanel panelCitas_1_1 = new JPanel();
		panelCitas_1_1.setLayout(null);
		panelCitas_1_1.setBackground(new Color(60, 179, 113));
		panelCitas_1_1.setBounds(186, 247, 189, 172);
		panelPrincipal.add(panelCitas_1_1);

		JLabel lblPrecios = new JLabel("Precios.");
		lblPrecios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//JOptionPane.showMessageDialog(null, "Se dio clic en Precios.");
				control.precios();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblPrecios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblPrecios.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecios.setForeground(Color.WHITE);
		lblPrecios.setFont(new Font("Microsoft Tai Le", Font.BOLD, 13));
		lblPrecios.setBounds(10, 121, 169, 40);
		panelCitas_1_1.add(lblPrecios);

		JLabel etiquetaImg1_1_1 = new JLabel("");
		etiquetaImg1_1_1.setIcon(new ImageIcon(VentanaUsuario.class.getResource("/img/p4.png")));
		etiquetaImg1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaImg1_1_1.setBounds(22, 24, 144, 99);
		panelCitas_1_1.add(etiquetaImg1_1_1);

		JPanel panelCitas_1_2 = new JPanel();
		panelCitas_1_2.setLayout(null);
		panelCitas_1_2.setBackground(new Color(102, 51, 51));
		panelCitas_1_2.setBounds(385, 247, 189, 172);
		panelPrincipal.add(panelCitas_1_2);

		JLabel lblConsultarInformacion = new JLabel("Consultar Informacion");
		lblConsultarInformacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				control.consultaDiagnostico(usuario);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblConsultarInformacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblConsultarInformacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultarInformacion.setForeground(Color.WHITE);
		lblConsultarInformacion.setFont(new Font("Microsoft Tai Le", Font.BOLD, 13));
		lblConsultarInformacion.setBounds(10, 121, 169, 40);
		panelCitas_1_2.add(lblConsultarInformacion);

		JLabel etiquetaImg1_1_2 = new JLabel("");
		etiquetaImg1_1_2.setIcon(new ImageIcon(VentanaUsuario.class.getResource("/img/p5.png")));
		etiquetaImg1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaImg1_1_2.setBounds(22, 24, 144, 99);
		panelCitas_1_2.add(etiquetaImg1_1_2);

		JPanel panelCitas_3 = new JPanel();
		panelCitas_3.setLayout(null);
		panelCitas_3.setBackground(new Color(0, 102, 102));
		panelCitas_3.setBounds(201, 26, 169, 172);
		panelPrincipal.add(panelCitas_3);

		// reagendar cita
		JLabel lblReagendarCitas = new JLabel("Reagendar Citas.");
		lblReagendarCitas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// JOptionPane.showMessageDialog(null, "Se dio clic en Reagendar Citas.");
				control.reagendarCita(usuario);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblConsultarInformacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblReagendarCitas.setHorizontalAlignment(SwingConstants.CENTER);
		lblReagendarCitas.setForeground(Color.WHITE);
		lblReagendarCitas.setFont(new Font("Microsoft Tai Le", Font.BOLD, 13));
		lblReagendarCitas.setBounds(23, 121, 126, 40);
		panelCitas_3.add(lblReagendarCitas);

		JLabel etiquetaImg1_3 = new JLabel("");
		etiquetaImg1_3.setIcon(new ImageIcon(VentanaUsuario.class.getResource("/img/p6.png")));
		etiquetaImg1_3.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaImg1_3.setBounds(11, 29, 138, 84);
		panelCitas_3.add(etiquetaImg1_3);
	}

	public void muestra(ControlUsuario control, Usuario UsuarioR) {
		this.control = control;
		this.usuario = UsuarioR;
		setVisible(true);
	}
}