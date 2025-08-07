package mx.uam.ayd.proyecto.presentacion.consultarDiagnostico;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;
import javax.swing.ImageIcon;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import java.util.Date;

@SuppressWarnings("serial")
@Component
/**
 * Descripción de la clase VentanaDiagnosticoUsuario. Se especifican los
 * elementos de la ventana.
 * 
 * @author Ricardo Antonio Ponce Garcia
 * @version 2.0
 * @Date 07/06/2023
 */
public class VentanaDiagnosticoUsuario extends JFrame {

	/*
	 * Se declaran algunos elementos como variables globales para tener acceso a
	 * ellos.
	 */
	private JPanel contentPane;
	private JLabel muestraNombre;
	private JLabel muestraApellidoP;
	private JLabel muestraFechaNa;
	private JLabel muestraApellidoM;
	private SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd"); // Varible necesaria que pasa de Date a
																				// String.
	private JLabel muestraDiag;
	private transient Usuario usuario; // Se agrega transient para quitar el mal olor del codigo. Cuidado 56 y 57.
	@SuppressWarnings("unused")
	private transient ControlDiagnosticoUsuario control;
	private Font letraTexto = new Font("Roboto Light", Font.PLAIN, 16);
	private String letraPDF = "Tahoma";

	/**
	 * Constructor de la ventana.
	 */
	public VentanaDiagnosticoUsuario() {
		setResizable(false);
		setLocationRelativeTo(null);
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
		lblNewLabel.setIcon(new ImageIcon(VentanaDiagnosticoUsuario.class.getResource("/img/Logo3.png")));

		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 113, 66);
		panelLogo.add(lblNewLabel);

		JPanel panelNombre = new JPanel();
		panelNombre.setBackground(Color.LIGHT_GRAY);
		panelNombre.setBounds(111, 0, 473, 66);
		panel.add(panelNombre);
		panelNombre.setLayout(null);

		JLabel etiquetaTitulo = new JLabel("Consultar Diagnóstico.");
		etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaTitulo.setFont(new Font("Leelawadee UI", Font.BOLD, 20));
		etiquetaTitulo.setBounds(77, 11, 298, 44);
		panelNombre.add(etiquetaTitulo);

		JLabel etiquetaNombre = new JLabel("Nombre del usuario: ");
		etiquetaNombre.setFont(letraTexto);
		etiquetaNombre.setBounds(10, 71, 159, 34);
		panel.add(etiquetaNombre);

		JLabel apellidos = new JLabel("Apellidos:");
		apellidos.setFont(letraTexto);
		apellidos.setBounds(10, 104, 80, 34);
		panel.add(apellidos);

		JLabel etiquetaServicio = new JLabel("Fecha de Nacimiento: ");
		etiquetaServicio.setFont(letraTexto);
		etiquetaServicio.setBounds(10, 135, 173, 34);
		panel.add(etiquetaServicio);

		muestraNombre = new JLabel();
		muestraNombre.setFont(letraTexto);
		muestraNombre.setBounds(153, 71, 159, 34);
		panel.add(muestraNombre);

		muestraApellidoP = new JLabel();
		muestraApellidoP.setFont(letraTexto);
		muestraApellidoP.setBounds(85, 104, 87, 34);
		panel.add(muestraApellidoP);

		muestraFechaNa = new JLabel("");
		muestraFechaNa.setFont(letraTexto);
		muestraFechaNa.setBounds(193, 135, 99, 34);
		panel.add(muestraFechaNa);

		JLabel etiquetaTitulo1 = new JLabel("Diagnóstico."); /* Corregir */
		etiquetaTitulo1.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaTitulo1.setFont(letraTexto);
		etiquetaTitulo1.setBounds(218, 168, 155, 27);
		panel.add(etiquetaTitulo1);

		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.LIGHT_GRAY);
		panel1.setBounds(10, 206, 564, 202);
		panel.add(panel1);
		panel1.setLayout(null);

		muestraDiag = new JLabel();
		muestraDiag.setFont(letraTexto);
		muestraDiag.setBounds(0, 0, 564, 202);
		panel1.add(muestraDiag);

		JButton btnAgregar = new JButton("Cerrar");
		// Accion que se lleva a cabo al dar clic en el boton Cerrar
		btnAgregar.addMouseListener(new MouseAdapter() { // Cambiar esto a Lamda
			// Cuando se selecciona el boton cerrar, la ventana envia al usuario al menu.
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Regresando al menú principal"); // Se muestra un mensaje
				setVisible(false);
			}
		});
		btnAgregar.setForeground(new Color(255, 250, 250));
		btnAgregar.setBackground(new Color(100, 149, 237));
		btnAgregar.setBounds(455, 415, 119, 34);
		panel.add(btnAgregar);

		muestraApellidoM = new JLabel();
		muestraApellidoM.setFont(new Font("Dialog", Font.PLAIN, 16));
		muestraApellidoM.setBounds(163, 104, 99, 34);
		panel.add(muestraApellidoM);
		// Boton para imprimir //
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(e -> imprime()); // Cambio por lamda
		btnImprimir.setForeground(new Color(255, 250, 250));
		btnImprimir.setBackground(new Color(100, 149, 237));
		btnImprimir.setBounds(218, 415, 119, 34);
		panel.add(btnImprimir);
	}

	/**
	 * Metodo usado para mostrar la ventana una vez sea creado.
	 * 
	 * @param control Objeto usado para la inyeccion de dependencias.
	 * @param usuario Objeto que nos permite acceder a los atributos del usuario.
	 */
	public void muestra(ControlDiagnosticoUsuario control, Usuario usuario) {
		// Definimos el texto completo que se mostrará en el JLabel
		String textoCompleto = usuario.getDiagnostico();
		// Dividimos el texto en palabras utilizando el espacio como separador y lo
		// almacenamos en un arreglo
		String[] palabras = textoCompleto.split(" ");
		// Definimos la cantidad de palabras por renglón que deseamos mostrar
		int cantidadPalabrasPorRenglon = 10;
		// Inicializamos el contador de palabras y la variable para almacenar el texto
		// formateado
		int contadorPalabras = 0;
		StringBuilder texto = new StringBuilder();
		// Recorremos el arreglo de palabras
		for (String palabra : palabras) {
			// Agregamos la palabra actual al texto formateado
			texto.append(palabra + " ");
			// Incrementamos el contador de palabras
			contadorPalabras++;
			// Verificamos si el contador de palabras alcanza la cantidad deseada por
			// renglón
			if (contadorPalabras == cantidadPalabrasPorRenglon) {
				// Agregamos un salto de línea HTML al texto formateado
				texto.append("<br>");
				// Reiniciamos el contador de palabras a cero
				contadorPalabras = 0;
			}
		}
		// Se cambia la fecha a String
		String fecha = formatoFecha.format(usuario.getFechaNa());
		this.control = control;
		this.usuario = usuario;
		// Muestra los datos del usuario en la Interfaz.
		muestraNombre.setText(usuario.getNombre());
		muestraApellidoP.setText(usuario.getApellido());
		muestraApellidoM.setText(usuario.getApellidomaterno());
		muestraFechaNa.setText(fecha);
		// Establecemos el texto formateado en el JLabel utilizando etiquetas HTML
		muestraDiag.setText("<html>" + texto + "</html>");
		setVisible(true); // La ventana se muestra
	}

	/* Metodo para la impresion del archivo */
	public void imprime() {
		// Obtener la fecha actual
		Date fechaActual = new Date();
		// Convertir la fecha a String utilizando un formato específico
		String fechaString = formatoFecha.format(fechaActual);

		// Generamos un documento
		Document documento = new Document();
		try {
			// Damos la ruta de almacenamiento
			PdfWriter.getInstance(documento, new FileOutputStream(
					"../Diagnostico_Paciente" + usuario.getNombre() + usuario.getApellido() + ".pdf"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al generar el archivo PDF."); // Se muestra un mensaje de error.
		}
		/*
		 * A continuacion se hace algo similar a lo anterior, se agrega la informacion
		 * del usuario Y se le da formato al texto.
		 */
		try {
			Image cabecera = Image.getInstance("src/main/java/img/Header.jpg"); // Ruta de la imagen de cabecera.
			cabecera.scaleToFit(300, 800);
			cabecera.setAlignment(Element.ALIGN_CENTER);
			// Le damos formato al texto con la clase Paragraph
			Paragraph formato = new Paragraph();
			Paragraph formato2 = new Paragraph();
			Paragraph formato3 = new Paragraph();
			// Alineamos texto al centro
			formato.setAlignment(Element.ALIGN_RIGHT);
			formato.setFont(FontFactory.getFont(letraPDF, 12, Font.BOLD, BaseColor.DARK_GRAY)); // Tipo de lettra
			formato.add("Fecha: " + fechaString + " \n"); // Se agrega la fecha en la esquina superior izquierda.
			formato2.setAlignment(Element.ALIGN_CENTER);
			formato2.setFont(FontFactory.getFont(letraPDF, 18, Font.BOLD, BaseColor.DARK_GRAY)); // Tipo de lettra
			formato2.add("Clinica dental. \n\n");
			formato3.setAlignment(Element.ALIGN_CENTER);
			formato3.setFont(FontFactory.getFont(letraPDF, 18, Font.BOLD, BaseColor.DARK_GRAY)); // Tipo de lettra
			formato3.add("Datos del Paciente: \n\n");
			documento.open(); // Se abre el documento
			// Se agregan los elementos al documento PDF.
			documento.add(formato);
			documento.add(formato2); // Se agrega el texto
			documento.add(cabecera); // Se agrega la cabecera.
			documento.add(formato3); // Se agrega el texto

			// Se crea un objeto tabla donde se guardara la informacion.
			Paragraph formato4 = new Paragraph();
			String fecha = formatoFecha.format(usuario.getFechaNa());
			formato4.setAlignment(Element.ALIGN_LEFT);
			formato4.setFont(FontFactory.getFont("Lato", 14, Font.ITALIC, BaseColor.BLACK)); // Se define el tamano y
																								// tipo de letra
			formato4.add("Nombre completo: " + usuario.getNombre() + " " + usuario.getApellido() + " "
					+ usuario.getApellidomaterno() + ". \n");
			formato4.add("\nFecha de nacimiento: " + fecha + ". \n");
			formato4.add("\nGenero: " + usuario.getSexo() + ". \n");
			formato4.add("\nCorreo: " + usuario.getCorreo() + ". \n");
			formato4.add("\nTelefono: " + usuario.getTelefono() + ". \n");
			formato4.add("\nDomicilio: " + usuario.getDomicilio() + ". \n");
			documento.add(formato4);
			Paragraph formato5 = new Paragraph();
			formato5.setAlignment(Element.ALIGN_CENTER);
			formato5.setFont(FontFactory.getFont(letraPDF, 18, Font.BOLD, BaseColor.DARK_GRAY)); // Se define el tamano
																									// y tipo de letra
			formato5.add("\nDiagnostico: \n\n");
			documento.add(formato5);
			Paragraph formato6 = new Paragraph();
			formato6.setAlignment(Element.ALIGN_LEFT);
			formato6.setFont(FontFactory.getFont("Open Sans", 15, Font.ITALIC, BaseColor.BLACK)); // Se define el tamano
																									// y tipo de letra
			formato6.add(usuario.getDiagnostico());
			documento.add(formato6); // Se agregan elementos al archivo PDF.
			documento.close(); // Se cierra el documento

		} catch (Exception f) {
			// Se muestra un mensaje en la consola si hay algun error.
			JOptionPane.showMessageDialog(null, "Error, el reporte no fue creado exitosamente");
		}
		JOptionPane.showMessageDialog(null, "Reporte creado exitosamente"); // Si no hay ningun error
		/* Muestra mensaje indicando que el archivo a sido creado exitosamente. */
	}
}
