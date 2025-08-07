package mx.uam.ayd.proyecto.presentacion.verCitas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import mx.uam.ayd.proyecto.negocio.modelo.Cita;
import org.springframework.stereotype.Component;

@Component
public class VentanaDetallesCita extends JFrame {

  private ControlVerCitas control;
  private JPanel contentPane;
  private Cita cita;
  private JLabel muestraNombre;
  private JLabel muestraCorreo;
  private JLabel muestraetiquetaFecha;
  private JLabel muestraetiquetaHora;

  public VentanaDetallesCita() {
    setResizable(false);
    setLocationRelativeTo(null); // Centramos la ventana
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 600, 500);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(null);

    // panel de la cabecera
    JPanel panel = new JPanel();
    panel.setBackground(Color.WHITE);
    panel.setBounds(0, 0, 584, 461);
    contentPane.add(panel);
    panel.setLayout(null);

    // logo del panel
    JPanel panelLogo = new JPanel();
    panelLogo.setBounds(0, 0, 113, 66);
    panel.add(panelLogo);
    panelLogo.setLayout(null);

    JLabel lblNewLabel = new JLabel("");
    lblNewLabel.setIcon(
      new ImageIcon(VentanaDetallesCita.class.getResource("/img/Logo3.png"))
    );
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel.setBounds(0, 0, 113, 66);
    panelLogo.add(lblNewLabel);

    // titulo de la cabecera
    JLabel etiquetaTitulo = new JLabel("Detalles de la cita.");
    etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
    etiquetaTitulo.setFont(new Font("Leelawadee UI", Font.BOLD, 15));
    etiquetaTitulo.setBounds(107, 11, 229, 38);
    panel.add(etiquetaTitulo);

    // fondo de la cabecera
    JPanel panelNombre = new JPanel();
    panelNombre.setBackground(Color.LIGHT_GRAY);
    panelNombre.setBounds(111, 0, 473, 66);
    panel.add(panelNombre);
    panelNombre.setLayout(null);

    // etiqueta: usuario
    JLabel etiquetaUsuario = new JLabel("Usuario: ");
    etiquetaUsuario.setFont(new Font("Roboto Light", Font.PLAIN, 16));
    etiquetaUsuario.setBounds(10, 71, 159, 34);
    panel.add(etiquetaUsuario);

    // etiqueta: correo
    JLabel etiquetaCorreo = new JLabel("Correo: ");
    etiquetaCorreo.setFont(new Font("Roboto Light", Font.PLAIN, 16));
    etiquetaCorreo.setBounds(10, 104, 159, 34);
    panel.add(etiquetaCorreo);

    // etiqueta: fecha
    JLabel etiquetaFecha = new JLabel("Fecha: ");
    etiquetaFecha.setFont(new Font("Roboto Light", Font.PLAIN, 16));
    etiquetaFecha.setBounds(10, 137, 80, 34);
    panel.add(etiquetaFecha);

    // etiqueta: hora
    JLabel etiquetaHora = new JLabel("Hora: ");
    etiquetaHora.setFont(new Font("Roboto Light", Font.PLAIN, 16));
    etiquetaHora.setBounds(10, 170, 80, 34);
    panel.add(etiquetaHora);

    // etiqueta: servicio
    JLabel etiquetaServicio = new JLabel("Tipo de servicio:");
    etiquetaServicio.setFont(new Font("Roboto Light", Font.PLAIN, 16));
    etiquetaServicio.setBounds(10, 203, 150, 34);
    panel.add(etiquetaServicio);

    // muesta el nombre del usuario
    muestraNombre = new JLabel();
    muestraNombre.setFont(new Font("Roboto Light", Font.PLAIN, 16));
    muestraNombre.setBounds(80, 71, 159, 34);
    panel.add(muestraNombre);

    // muesta el correo del usuario
    muestraCorreo = new JLabel();
    muestraCorreo.setFont(new Font("Roboto Light", Font.PLAIN, 16));
    muestraCorreo.setBounds(70, 104, 159, 34);
    panel.add(muestraCorreo);

    // muesta la fecha de la cita
    muestraetiquetaFecha = new JLabel();
    muestraetiquetaFecha.setFont(new Font("Roboto Light", Font.PLAIN, 16));
    muestraetiquetaFecha.setBounds(70, 137, 100, 34);
    panel.add(muestraetiquetaFecha);

    // muesta la hora de la cita
    muestraetiquetaHora = new JLabel();
    muestraetiquetaHora.setFont(new Font("Roboto Light", Font.PLAIN, 16));
    muestraetiquetaHora.setBounds(60, 170, 100, 34);
    panel.add(muestraetiquetaHora);

    // muesta el tipo de servicio de la cita
    JLabel muestraServicio = new JLabel("Consulta Medica.");
    muestraServicio.setFont(new Font("Roboto Light", Font.PLAIN, 16));
    muestraServicio.setBounds(139, 203, 203, 34);
    panel.add(muestraServicio);

    // botón para regresar al menu
    JButton btnRegresar = new JButton("Regresar");
    btnRegresar.setBounds(30, 400, 117, 29);
    contentPane.add(btnRegresar);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Con esto cerramos la ventana

    btnRegresar.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          control.terminaDetalles();
        }
      }
    );
  }

  //Muestra los datos del paciente que fue seleccionado desde la lista de usuarios.
  public void muestra(ControlVerCitas control, Cita cita) {
    this.control = control;
    this.cita = cita;
    muestraNombre.setText(cita.getNombre());
    muestraCorreo.setText(cita.getCorreo());
    muestraetiquetaFecha.setText(cita.getFecha().toString());
    muestraetiquetaHora.setText(cita.getHora().toString());
    setVisible(true);
  }

  //Cierra la ventana
  public void cierra() { // Cierra la ventana despues de guardar
    setVisible(false);
  }
}
