package mx.uam.ayd.proyecto.presentacion.listarUsuarios;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;
import org.springframework.stereotype.Component;

/**
 * clase que muestra la GUI para ver los datos del usaurio
 * @author Axel Huerta Hernández
 * @version 1.0
 * @Date 10/06/2023
 */
@Component
public class VentanaVerUsaurio extends JFrame {

  // declaracion de variables
  private JPanel contentPane;
  private ControlVerUsuario control;
  private JLabel muestraPerfil;
  private JLabel muestraNombre;
  private JLabel muestraApellidoPaterno;
  private JLabel muestraApellidoMaterno;
  private JLabel muestraSexo;
  private JLabel muestraCorreo;
  private JLabel muestraFechaNacimiento;
  private JLabel muestraDomicilio;
  private JLabel muestraTelefono;
  private JLabel muestraDiagnostico;
  private Font textoNormal;
  private Font textoBold;

  /**
   * Create the frame.
   */
  public VentanaVerUsaurio() {
    // se establece el tipo de fuente
    textoNormal = new Font("Roboto Light", Font.PLAIN, 16);
    textoBold = new Font("Roboto Light", Font.BOLD, 16);

    setResizable(false);
    setLocationRelativeTo(null); // Centramos la ventana
    setBounds(100, 100, 900, 800);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(null);

    JPanel panelRaiz = new JPanel();
    panelRaiz.setBackground(Color.white);
    panelRaiz.setBounds(0, 0, 900, 800);
    contentPane.add(panelRaiz);
    panelRaiz.setLayout(null);

    // panel para el logo
    JPanel panelLogo = new JPanel();
    panelLogo.setBounds(0, 0, 121, 88);
    panelRaiz.add(panelLogo);
    panelLogo.setLayout(null);

    JLabel lblNewLabel = new JLabel("");
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel.setIcon(
      new ImageIcon(ventanaListaUsuarios.class.getResource("/img/Logo3.png"))
    );
    lblNewLabel.setBounds(0, 0, 121, 88);
    panelLogo.add(lblNewLabel);

    // panel de la cabecera
    JPanel panelNombrePag = new JPanel();
    panelNombrePag.setLayout(null);
    panelNombrePag.setBackground(Color.lightGray);
    panelNombrePag.setBounds(121, 0, 900, 88);
    panelRaiz.add(panelNombrePag);

    // titulo de la cabecera
    JLabel lblListaDeClientes = new JLabel("Perfil del paciente.");
    lblListaDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
    lblListaDeClientes.setFont(new Font("Leelawadee UI", Font.BOLD, 20));
    lblListaDeClientes.setBounds(254, 27, 200, 38);
    panelNombrePag.add(lblListaDeClientes);

    muestraPerfil = new JLabel();
    muestraPerfil.setFont(textoBold);
    muestraPerfil.setBounds(30, 100, 500, 50);
    panelRaiz.add(muestraPerfil);

    // titulo de la sección 'Datos generales'
    JLabel labelDatosGenerales = new JLabel("Datos generales");
    labelDatosGenerales.setFont(textoBold);
    labelDatosGenerales.setBounds(30, 130, 500, 50);
    panelRaiz.add(labelDatosGenerales);

    // datos generales del usuario
    muestraNombre = new JLabel();
    muestraNombre.setFont(textoNormal);
    muestraNombre.setBounds(30, 160, 500, 50);
    panelRaiz.add(muestraNombre);

    muestraApellidoPaterno = new JLabel();
    muestraApellidoPaterno.setFont(textoNormal);
    muestraApellidoPaterno.setBounds(30, 190, 500, 50);
    panelRaiz.add(muestraApellidoPaterno);

    muestraApellidoMaterno = new JLabel();
    muestraApellidoMaterno.setFont(textoNormal);
    muestraApellidoMaterno.setBounds(30, 220, 500, 50);
    panelRaiz.add(muestraApellidoMaterno);

    muestraFechaNacimiento = new JLabel();
    muestraFechaNacimiento.setFont(textoNormal);
    muestraFechaNacimiento.setBounds(400, 160, 500, 50);
    panelRaiz.add(muestraFechaNacimiento);

    muestraSexo = new JLabel();
    muestraSexo.setFont(textoNormal);
    muestraSexo.setBounds(400, 190, 500, 50);
    panelRaiz.add(muestraSexo);

    // titulo de la sección 'Datos de contacto'
    JLabel labelDatosContacto = new JLabel("Datos de contacto");
    labelDatosContacto.setFont(textoBold);
    labelDatosContacto.setBounds(30, 250, 500, 50);
    panelRaiz.add(labelDatosContacto);

    // datos de contacto del usuario
    muestraCorreo = new JLabel();
    muestraCorreo.setFont(textoNormal);
    muestraCorreo.setBounds(30, 280, 500, 50);
    panelRaiz.add(muestraCorreo);

    muestraTelefono = new JLabel();
    muestraTelefono.setFont(textoNormal);
    muestraTelefono.setBounds(30, 310, 500, 50);
    panelRaiz.add(muestraTelefono);

    muestraDomicilio = new JLabel();
    muestraDomicilio.setFont(textoNormal);
    muestraDomicilio.setBounds(400, 280, 500, 50);
    panelRaiz.add(muestraDomicilio);

    // titulo de la seccion 'Diagnóstico'
    JLabel labelDiagnostico = new JLabel("Diagnóstico:");
    labelDiagnostico.setFont(textoBold);
    labelDiagnostico.setBounds(30, 340, 500, 50);
    panelRaiz.add(labelDiagnostico);

    muestraDiagnostico = new JLabel();
    muestraDiagnostico.setFont(textoNormal);
    muestraDiagnostico.setBounds(30, 370, 800, 200);
    panelRaiz.add(muestraDiagnostico);

    // botón para regresar al menu
    JButton btnRegresar = new JButton("Regresar");
    btnRegresar.setBounds(30, 750, 117, 29);
    btnRegresar.setBackground(Color.gray);
    btnRegresar.setForeground(Color.white);
    contentPane.add(btnRegresar);

    btnRegresar.addActionListener(e -> control.termina());
  }

  /**
   *
   *  inicia la ventana para consultar los datos de usuario
   *  @param ControlVerUsuario
   *  @param Usuario
   * @return
   *
   */
  public void muestra(ControlVerUsuario control, Usuario usuario) {
    this.control = control;
    String diagnostico = "";
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // convierte la fecha de nacimiento de Date a LocalDate
    LocalDate fechaNacimiento = usuario
      .getFechaNa()
      .toInstant()
      .atZone(ZoneId.systemDefault())
      .toLocalDate();
    String fechaFormateada = fechaNacimiento.format(formato);

    // comporbar si existen diagnosticos para este usaurio
    if (usuario.getDiagnostico().compareTo("") == 0) {
      diagnostico = "Aún no hay diagnósticos";
    } else {
      diagnostico = usuario.getDiagnostico();
      String[] textoDiagnostico = diagnostico.split(" ");
      int cantPalabras = 10;
      int contadorPalabras = 0;
      StringBuilder texto = new StringBuilder();
      // Recorremos el arreglo de palabras
      for (String palabra : textoDiagnostico) {
        // Agregamos la palabra actual al texto formateado
        texto.append(palabra + " ");
        // Incrementamos el contador de palabras
        contadorPalabras++;
        // Verificamos si el contador de palabras alcanza la cantidad deseada por
        // renglón
        if (contadorPalabras == cantPalabras) {
          // Agregamos un salto de línea HTML al texto formateado
          texto.append("<br>");
          // Reiniciamos el contador de palabras a cero
          contadorPalabras = 0;
        }
      }
    }

    // agrega los datos del usario a la ventana
    muestraPerfil.setText(
      "Perfil del paciente: " +
      usuario.getNombre() +
      " " +
      usuario.getApellido() +
      " " +
      usuario.getApellidomaterno()
    );

    muestraNombre.setText("Nombre(s): " + usuario.getNombre());
    muestraApellidoPaterno.setText(
      "Apellido paterno: " + usuario.getApellido()
    );
    muestraApellidoMaterno.setText(
      "Apellido materno: " + usuario.getApellidomaterno()
    );
    muestraFechaNacimiento.setText("Fecha de nacimiento: " + fechaFormateada);
    muestraSexo.setText("Sexo: " + usuario.getSexo());
    setVisible(true);
    muestraCorreo.setText("Correo: " + usuario.getCorreo());
    muestraTelefono.setText("Teléfono: " + usuario.getTelefono());
    muestraDomicilio.setText("Domicilio: " + usuario.getDomicilio());
    // muestraDiagnostico.setText(diagnostico);
    muestraDiagnostico.setText("<html>" + diagnostico + "</html>");
  }
}
