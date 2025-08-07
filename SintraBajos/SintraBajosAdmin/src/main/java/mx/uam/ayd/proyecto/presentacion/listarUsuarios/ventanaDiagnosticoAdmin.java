package mx.uam.ayd.proyecto.presentacion.listarUsuarios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.ComponentOrientation;

@Component
public class ventanaDiagnosticoAdmin extends JFrame {

  private ControlListarUsuarios controlU;
  private JPanel contentPane;
  private JTextField campoTexto;
  private Usuario usuario;
  private JLabel muestraNombre;
  private JLabel muestraApellido;
  
  @Autowired
  private ventanaListaUsuarios ventana2;

  public ventanaDiagnosticoAdmin() {
    setResizable(false);
    setLocationRelativeTo(null);// Centramos la ventana
    setBounds(100, 100, 600, 500);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(null);

    JPanel panel = new JPanel();
    panel.setBackground(Color.WHITE);
    panel.setBounds(0, 0, 584, 461);
    contentPane.add(panel);
    panel.setLayout(null);

    JPanel panelLogo = new JPanel();
    panelLogo.setBounds(0, 0, 113, 66);
    panel.add(panelLogo);
    panelLogo.setLayout(null);
    
    JLabel lblNewLabel = new JLabel("");
    lblNewLabel.setIcon(new ImageIcon(ventanaDiagnosticoAdmin.class.getResource("/img/Logo3.png")));
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel.setBounds(0, 0, 113, 66);
    panelLogo.add(lblNewLabel);

    JPanel panelNombre = new JPanel();
    panelNombre.setBackground(Color.LIGHT_GRAY);
    panelNombre.setBounds(111, 0, 473, 66);
    panel.add(panelNombre);
    panelNombre.setLayout(null);

    JLabel etiquetaTitulo = new JLabel("Informaci\u00F3n y diagn\u00F3stico.");
    etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
    etiquetaTitulo.setFont(new Font("Leelawadee UI", Font.BOLD, 15));
    etiquetaTitulo.setBounds(107, 11, 229, 38);
    panelNombre.add(etiquetaTitulo);

    JLabel etiquetaNombre = new JLabel("Nombre del usuario: ");
    etiquetaNombre.setFont(new Font("Roboto Light", Font.PLAIN, 16));
    etiquetaNombre.setBounds(10, 71, 159, 34);
    panel.add(etiquetaNombre);

    JLabel Apellido = new JLabel("Apellido");
    Apellido.setFont(new Font("Roboto Light", Font.PLAIN, 16));
    Apellido.setBounds(10, 104, 80, 34);
    panel.add(Apellido);

    JLabel etiquetaServicio = new JLabel("Tipo de servicio:");
    etiquetaServicio.setFont(new Font("Roboto Light", Font.PLAIN, 16));
    etiquetaServicio.setBounds(10, 135, 119, 34);
    panel.add(etiquetaServicio);

    muestraNombre = new JLabel();
    muestraNombre.setFont(new Font("Roboto Light", Font.PLAIN, 16));
    muestraNombre.setBounds(179, 71, 159, 34);
    panel.add(muestraNombre);

    muestraApellido = new JLabel();
    muestraApellido.setFont(new Font("Roboto Light", Font.PLAIN, 16));
    muestraApellido.setBounds(89, 104, 80, 34);
    panel.add(muestraApellido);

    JLabel muestraServicio = new JLabel("Consulta Medica.");
    muestraServicio.setFont(new Font("Roboto Light", Font.PLAIN, 16));
    muestraServicio.setBounds(139, 135, 133, 34);
    panel.add(muestraServicio);

    JLabel etiquetaTitulo_1 = new JLabel("Diagnóstico.");
    etiquetaTitulo_1.setHorizontalAlignment(SwingConstants.CENTER);
    etiquetaTitulo_1.setFont(new Font("Roboto Light", Font.BOLD, 16));
    etiquetaTitulo_1.setBounds(218, 168, 155, 27);
    panel.add(etiquetaTitulo_1);

    JPanel panel_1 = new JPanel();
    panel_1.setBackground(Color.LIGHT_GRAY);
    panel_1.setBounds(10, 206, 564, 202);
    panel.add(panel_1);
    panel_1.setLayout(null);

    campoTexto = new JTextField();
    campoTexto.setBounds(10, 11, 544, 180);
    campoTexto.setFont(new Font("Roboto Light", Font.PLAIN, 14));
    panel_1.add(campoTexto);
    campoTexto.setColumns(10);

    JButton btnAgregar = new JButton("Guardar");

    // Accion que se lleva a cabo al dar clic en el bpton gaurdar
    btnAgregar.addMouseListener(new MouseAdapter() {
      @Override
      //Cuando se selecciona el boton guardar, se obtiene el texto del campo de diagnostico
      // Y esta nueva informacion es almacenada en el Paciente en turno. 
      public void mouseClicked(MouseEvent e) {
        usuario.setDiagnostico(campoTexto.getText()); //Se almacena en el usuario el nuevo diagnostico.
        controlU.recuperaNuevo(usuario);
        ventana2.termina();
      }
    });
    btnAgregar.setForeground(new Color(255, 250, 250));
    btnAgregar.setBackground(new Color(100, 149, 237));
    btnAgregar.setBounds(455, 415, 119, 34);
    panel.add(btnAgregar);
    
  }

  //Muestra los datos del paciente que fue seleccionado desde la lista de usuarios. 
  public void muestra(ControlListarUsuarios control, Usuario p) {
    this.controlU = control;
    this.usuario = p;
    muestraNombre.setText(usuario.getNombre());
    muestraApellido.setText(usuario.getApellido());
    campoTexto.setText(usuario.getDiagnostico());
    setVisible(true);
  }

  //Cierra la ventana
  public void cierra() { // Cierra la ventana despues de guardar
    setVisible(false);
  }

  //Muestra el mensaje de que la informacion ha sido almacenada.
  public void muestraMensaje() {
    JOptionPane.showMessageDialog(null, "La informacion fue actualizada correctamente.");
    cierra();
  }
}