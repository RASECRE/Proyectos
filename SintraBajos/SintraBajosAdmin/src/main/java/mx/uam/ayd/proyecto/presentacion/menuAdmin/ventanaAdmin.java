
package mx.uam.ayd.proyecto.presentacion.menuAdmin;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.springframework.stereotype.Component;

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
public class ventanaAdmin extends JFrame {

  private JPanel contentPane;
  private ControlAdmin control;

  /**
   * Create the frame.
   */
  public ventanaAdmin() {
    setTitle("Menu Administrador");
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setBounds(100, 100, 600, 500);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(null);

    JPanel panelPrincipal = new JPanel();
    panelPrincipal.setBackground(new Color(0, 128, 128));
    panelPrincipal.setBounds(0, 0, 584, 461);
    contentPane.add(panelPrincipal);
    panelPrincipal.setLayout(null);

    JPanel panelPacientes = new JPanel();
    panelPacientes.setBackground(new Color(204, 0, 51));
    panelPacientes.setBounds(25, 35, 250, 197);
    panelPrincipal.add(panelPacientes);
    panelPacientes.setLayout(null);

    JLabel etiquetaCPacientes = new JLabel("Consultar Pacientes.");
    // ******* Escuchador de boton Consultar Pacienrte ******//
    etiquetaCPacientes.addMouseListener(new MouseAdapter() {
      // Se dio clic en el boton.
      @Override
      public void mouseClicked(MouseEvent arg0) {
         control.listarUsuarios(); //Se muuestra la HU-03
      }

      @Override
      // Se agrega el cursor de mano cuando al mouse esta sobre el JLabel.
      public void mouseEntered(MouseEvent e) {
        etiquetaCPacientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      }
    });
    etiquetaCPacientes.setHorizontalAlignment(SwingConstants.CENTER);
    etiquetaCPacientes.setForeground(new Color(255, 255, 255));
    etiquetaCPacientes.setFont(new Font("Microsoft Tai Le", Font.BOLD, 15));
    etiquetaCPacientes.setBounds(38, 146, 177, 40);
    panelPacientes.add(etiquetaCPacientes);

    JLabel etiquetaImg1 = new JLabel("");
    etiquetaImg1.setIcon(
        new ImageIcon(ventanaAdmin.class.getResource("/img/img1.png")));
    etiquetaImg1.setHorizontalAlignment(SwingConstants.CENTER);
    etiquetaImg1.setBounds(59, 45, 141, 90);
    panelPacientes.add(etiquetaImg1);

    JPanel panelCCitas = new JPanel();
    panelCCitas.setBackground(new Color(255, 102, 0));
    panelCCitas.setBounds(310, 35, 250, 197);
    panelPrincipal.add(panelCCitas);
    panelCCitas.setLayout(null);

    JLabel EtiquetaCCitas = new JLabel("Consultar Citas.");
    EtiquetaCCitas.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        control.listarCitas();
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        EtiquetaCCitas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      }
    });
    EtiquetaCCitas.setHorizontalAlignment(SwingConstants.CENTER);
    EtiquetaCCitas.setForeground(Color.WHITE);
    EtiquetaCCitas.setFont(new Font("Microsoft Tai Le", Font.BOLD, 15));
    EtiquetaCCitas.setBounds(44, 146, 177, 40);
    panelCCitas.add(EtiquetaCCitas);

    JLabel etiquetaImg1_1 = new JLabel("");
    etiquetaImg1_1.setIcon(
        new ImageIcon(ventanaAdmin.class.getResource("/img/img2.png")));
    etiquetaImg1_1.setHorizontalAlignment(SwingConstants.CENTER);
    etiquetaImg1_1.setBounds(62, 45, 141, 90);
    panelCCitas.add(etiquetaImg1_1);

    JPanel panelAgendarCitas = new JPanel();
    panelAgendarCitas.setBackground(new Color(0, 153, 51));
    panelAgendarCitas.setBounds(25, 243, 250, 197);
    panelPrincipal.add(panelAgendarCitas);
    panelAgendarCitas.setLayout(null);

    JLabel etiquetaACitas = new JLabel("Agendar Citas.");
    etiquetaACitas.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        etiquetaACitas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      }

      @Override
      public void mouseClicked(MouseEvent e) {
       // JOptionPane.showMessageDialog(null, "Se dio clic en Agendar citas.");
        control.agendarCita();
        
      }
    });
    etiquetaACitas.setHorizontalAlignment(SwingConstants.CENTER);
    etiquetaACitas.setForeground(Color.WHITE);
    etiquetaACitas.setFont(new Font("Microsoft Tai Le", Font.BOLD, 15));
    etiquetaACitas.setBounds(38, 146, 177, 40);
    panelAgendarCitas.add(etiquetaACitas);

    JLabel etiquetaImg1_2 = new JLabel("");
    etiquetaImg1_2.setIcon(
        new ImageIcon(ventanaAdmin.class.getResource("/img/img3.png")));
    etiquetaImg1_2.setHorizontalAlignment(SwingConstants.CENTER);
    etiquetaImg1_2.setBounds(57, 45, 141, 90);
    panelAgendarCitas.add(etiquetaImg1_2);

    JPanel panelEliminaCitas = new JPanel();
    panelEliminaCitas.setBackground(new Color(255, 153, 204));
    panelEliminaCitas.setBounds(310, 243, 250, 197);
    panelPrincipal.add(panelEliminaCitas);
    panelEliminaCitas.setLayout(null);

    JLabel etiquetaECitas = new JLabel("Eliminar Citas.");
    etiquetaECitas.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        etiquetaECitas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      }

      @Override
      public void mouseClicked(MouseEvent e) {
        control.eliminarCitas();
      }
    });
    etiquetaECitas.setHorizontalAlignment(SwingConstants.CENTER);
    etiquetaECitas.setForeground(Color.WHITE);
    etiquetaECitas.setFont(new Font("Microsoft Tai Le", Font.BOLD, 15));
    etiquetaECitas.setBounds(48, 146, 177, 40);
    panelEliminaCitas.add(etiquetaECitas);

    JLabel etiquetaImg1_3 = new JLabel("");
    etiquetaImg1_3.setIcon(
        new ImageIcon(ventanaAdmin.class.getResource("/img/img4.png")));
    etiquetaImg1_3.setHorizontalAlignment(SwingConstants.CENTER);
    etiquetaImg1_3.setBounds(66, 45, 141, 90);
    panelEliminaCitas.add(etiquetaImg1_3);

   
  }

  public void muestra(ControlAdmin control) {
    this.control = control;
    setVisible(true);
  }

}
