package mx.uam.ayd.proyecto.presentacion.precios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.Notificacion.ControlNotificacion;
import mx.uam.ayd.proyecto.negocio.modelo.Precios;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;

@SuppressWarnings("serial")
@Component
public class VentanaPrecios extends JFrame {

	private JPanel contentPane;
	  private JTable tabla;
	  private ControlPrecios control;
	  private DefaultTableModel model; 

	
	public VentanaPrecios() {   // Ventana de Precios
		
		setResizable(false);
	    setLocationRelativeTo(null);// Centramos la ventana
	    setBounds(100, 100, 633, 561);
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	    setContentPane(contentPane);
	    contentPane.setLayout(null);

	    JPanel panelRaiz = new JPanel();
	    panelRaiz.setBackground(Color.WHITE);
	    panelRaiz.setBounds(0, 0, 633, 561);
	    contentPane.add(panelRaiz);
	    panelRaiz.setLayout(null);
	    
	    JLabel Logo = new JLabel("");
	    Logo.setIcon(new ImageIcon(VentanaPrecios.class.getResource("/img/Logo3.png")));
	    Logo.setBounds(30, 11, 72, 73);
	    panelRaiz.add(Logo);

	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(10, 95, 600, 355);
	    panelRaiz.add(scrollPane);

	    tabla = new JTable() {
	    public boolean isCellEditable(int rowIndex, int vColIndex) {
	        return false;}};
	    tabla.getTableHeader().setReorderingAllowed(false);
	    model = new DefaultTableModel();
	    tabla.setModel(model);
	    // Agregamos los columnos
	    //model.addColumn("id");
	    model.addColumn("Servicio");
	    model.addColumn("Precio");
	    Object[] fila = {"valor2", 1554};
	    model.addRow(fila);
	    
	    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	    centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
	    
	    // Establecer el renderizador centrado para la columna deseada
	    tabla.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
	 
	    // Agregamos el Scroll para la tabla.
	    scrollPane.setViewportView(tabla);
	    
	    JLabel LTitulo = new JLabel("Lista de Servicios");
	    LTitulo.setFont(new Font("Roboto Black", Font.BOLD, 24));
	    LTitulo.setHorizontalAlignment(SwingConstants.CENTER);
	    LTitulo.setBounds(191, 26, 222, 29);
	    panelRaiz.add(LTitulo);
	    
	    JLabel Nota = new JLabel("Nota: Estos precios estan sujetos a cambios, estos dependen de la complejidad del servicio y el estado del paciente.");
	    Nota.setFont(new Font("Roboto Black", Font.PLAIN, 11));
	    Nota.setBounds(10, 479, 588, 37);
	    panelRaiz.add(Nota);

		
	

	}
	public void llenarTabla() {
	    List<Precios> listaImprimir = control.listaPrecios();
	    // Se asigna a la lista la persona.
	    for (Precios Servicio : listaImprimir) {
	      Object[] fila = new Object[2];
	      fila[0] = Servicio.getServicio();
	      fila[1] = Servicio.getPrecio();
	      model.addRow(fila); //Los elementos son agregados a la tabla. 
	    }
	  }

	
	
	
	public void muestra(ControlPrecios control) {
	     	
	    //Vacia la fila de las columnas para que no se repitan
		for (int i = 0; i < model.getRowCount(); i++) {
		      model.removeRow(i);
		      i -= 1;
		}
		this.control = control;
		this.llenarTabla();
		
		setVisible(true);
	}
}
