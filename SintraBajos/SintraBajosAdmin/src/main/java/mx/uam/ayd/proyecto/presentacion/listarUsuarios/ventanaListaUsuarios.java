package mx.uam.ayd.proyecto.presentacion.listarUsuarios;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Usuario;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

@SuppressWarnings("serial")
@Component
public class ventanaListaUsuarios extends JFrame implements MouseListener {

  private JPanel contentPane;
  private JTable tablaUsuarios;
  //////////////////////////////////////////////
  // de ControlPrincipal a ControlListarUsuarios
  //////////////////////////////////////////////
  private ControlListarUsuarios control;
  private DefaultTableModel model;
  /**
   * Create the frame.
   */
  public ventanaListaUsuarios() {
    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setLocationRelativeTo(null);// Centramos la ventana
    setBounds(100, 100, 950, 600);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(null);

    JPanel panelRaiz = new JPanel();
    panelRaiz.setBackground(Color.LIGHT_GRAY);
    panelRaiz.setBounds(0, 0, 984, 561);
    contentPane.add(panelRaiz);
    panelRaiz.setLayout(null);

    JPanel panelLogo = new JPanel();
    panelLogo.setBounds(0, 0, 121, 88);
    panelRaiz.add(panelLogo);
    panelLogo.setLayout(null);
    
    JLabel lblNewLabel = new JLabel("");
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel.setIcon(new ImageIcon(ventanaListaUsuarios.class.getResource("/img/Logo3.png")));
    lblNewLabel.setBounds(0, 0, 121, 88);
    panelLogo.add(lblNewLabel);

    JPanel panelNombrePag = new JPanel();
    panelNombrePag.setLayout(null);
    panelNombrePag.setBackground(Color.LIGHT_GRAY);
    panelNombrePag.setBounds(121, 0, 863, 88);
    panelRaiz.add(panelNombrePag);

    JLabel lblListaDeClientes = new JLabel("Lista de Pacientes.");
    lblListaDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
    lblListaDeClientes.setFont(new Font("Leelawadee UI", Font.BOLD, 20));
    lblListaDeClientes.setBounds(254, 27, 229, 38);
    panelNombrePag.add(lblListaDeClientes);

    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(10, 99, 930, 451);
    panelRaiz.add(scrollPane);
    //Oculto la tabla de contrasena
    tablaUsuarios = new JTable() {
    public boolean isCellEditable(int rowIndex, int vColIndex) {
        return false;}};
    tablaUsuarios.getTableHeader().setReorderingAllowed(false);
    model = new DefaultTableModel();
    tablaUsuarios.setModel(model);
    tablaUsuarios.addMouseListener(this);
    // Agregamos los columnos
    model.addColumn("ID");
    model.addColumn("Nombre");
    model.addColumn("ApellidoP");
    model.addColumn("ApellidoM");
    model.addColumn("Diagnostico");
    model.addColumn("Correo"); 
    model.addColumn("Domicilio"); 
    model.addColumn("Fecha de nacimiento"); 
    model.addColumn("Password"); 
    model.addColumn("Sexo"); 
    model.addColumn("Telefono"); 
    model.addColumn("Boton");
    model.addColumn("Consultar");
    model.addColumn("Editar");
    // Agregamos el Scroll para la tabla.
    scrollPane.setViewportView(tablaUsuarios);
    /*Oculta la contrasena de la tabla.*/
    tablaUsuarios.getColumnModel().getColumn(8).setMaxWidth(0);
    tablaUsuarios.getColumnModel().getColumn(8).setMinWidth(0);
    tablaUsuarios.getTableHeader().getColumnModel().getColumn(8).setMaxWidth(0);
    tablaUsuarios.getTableHeader().getColumnModel().getColumn(8).setMinWidth(0);
    /*Oculta el ID de la tabla.*/
    tablaUsuarios.getColumnModel().getColumn(0).setMaxWidth(0);
    tablaUsuarios.getColumnModel().getColumn(0).setMinWidth(0);
    tablaUsuarios.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
    tablaUsuarios.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
  }

  //////////////////////////////////////////////
  // parametro de ControlPrincipal a ControlListarUsuarios
  //////////////////////////////////////////////
  public void muestra(ControlListarUsuarios control) {
    this.control = control;
    this.llenarTabla();
    setVisible(true);
  }

//Llena la tabla con los elementos que existen en la base de datos
  public void llenarTabla() {
	  Clear_Table1(); //Limpia la tabla antes de comenzar.
    List<Usuario> listaImprimir = control.obtenUsuarios();
    // Se asigna a la lista la persona.
    for (Usuario usuario : listaImprimir) {
      Object[] fila = new Object[14];
      fila[0] = usuario.getIdUsuario();
      fila[1] = usuario.getNombre();
      fila[2] = usuario.getApellido();
      fila[3] =usuario.getApellidomaterno();
      fila[4] = usuario.getDiagnostico();
      fila[5] =usuario.getCorreo();
      fila[6] =usuario.getDomicilio();
      fila[7] =usuario.getFechaNa();
      fila[8] =usuario.getPass();
      fila[9] =usuario.getSexo();
      fila[10] =usuario.getTelefono();
      fila[11] = "Ver diagnóstico";
      fila[12] = "Consultar";
      fila[13] = "Editar";
      model.addRow(fila); //Los elementos son agregados a la tabla. 
    }
  }

  // Muestra la nueva ventana.
  public void muestraNuevo() {
    this.llenarTabla();
    setVisible(true);
  }

  // Una vez terminan los primeros eventos deshabilita la ventana y limpia la
  // tabla.
  public void termina() {
    setVisible(false);
    Clear_Table1();
  }

  // Limpia los elementos de la tabla.
  private void Clear_Table1() {
    for (int i = 0; i < model.getRowCount(); i++) {
      model.removeRow(i);
      i -= 1;
    }
  }

  // Almacena el usuario que haya sido seleccionado en la lista para mandarselo al diagnostico.
  public Usuario validarSeleccionMouse(int fila) { // Metodo en el que se valida el usuario.
    Usuario usuario = new Usuario();
    usuario.setIdUsuario((long) tablaUsuarios.getValueAt(fila, 0));
    usuario.setNombre(tablaUsuarios.getValueAt(fila, 1).toString());
    usuario.setApellido(tablaUsuarios.getValueAt(fila, 2).toString());
    usuario.setApellidomaterno(tablaUsuarios.getValueAt(fila, 3).toString());
    usuario.setDiagnostico(tablaUsuarios.getValueAt(fila, 4).toString());
    usuario.setCorreo(tablaUsuarios.getValueAt(fila, 5).toString());
    usuario.setDomicilio(tablaUsuarios.getValueAt(fila, 6).toString());
    usuario.setFechaNa((Date) tablaUsuarios.getValueAt(fila, 7));
    usuario.setPass(tablaUsuarios.getValueAt(fila, 8).toString());
    usuario.setSexo(tablaUsuarios.getValueAt(fila, 9).toString());
    usuario.setTelefono((long) tablaUsuarios.getValueAt(fila, 10));

    return usuario; // Se almacenan los datos del paciente.
  }

  @Override
  //Cuando se da clic en el boton consultar toma al usuario y lo manda a la ventana diagnostico
  //con la ayuda de los metodos mencionados.
  public void mouseClicked(MouseEvent e) {
    // Este evento se activa cuando se da clic en un elemento.
    int fila = tablaUsuarios.rowAtPoint(e.getPoint()); // Con esto sabemos que fila esta ejecutando el evento.
    int columna = tablaUsuarios.columnAtPoint(e.getPoint());
    Usuario pac = new Usuario(); // Variable local que almacenara al usuario seleccionado.
    if (columna == 11) { // Columna 11 referente a la columna de consulta.
      pac = validarSeleccionMouse(fila); // Se obtienen el objeto usuario al cual se le realizara la consulta
      control.recuperaUsuario(pac); // Con este metodo se hace referencia al Usuario en turno
    }
    if (columna == 12) {
      pac = validarSeleccionMouse(fila); // Se obtienen el objeto usuario al cual se le realizara la consulta
      control.iniciaVentanaVerUsuario(pac);
    }
    if(columna == 13){
      pac = validarSeleccionMouse(fila);
      control.iniciaE(pac);
    }
  }

  @Override
  public void mousePressed(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub

  }
}