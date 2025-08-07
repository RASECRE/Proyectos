package mx.uam.ayd.proyecto.presentacion.Notificacion;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

@Component
public class VentanaNotificacion extends JFrame {

  private JPanel contentPane;
  private ControlNotificacion control;
  private Usuario usuario;
  private List<JLabel> lista = new ArrayList<>();

  // main

  // public static void main(String[] args) {
  //   EventQueue.invokeLater(new Runnable() {
  //     public void run() {
  //       try {
  //         VentanaNotificacion frame = new VentanaNotificacion();
  //         frame.setVisible(true);
  //       } catch (Exception e) {
  //         e.printStackTrace();
  //       }
  //     }
  //   });
  // }

  public VentanaNotificacion() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 376, 547);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    // btn Regresar
    JButton btnRegresar = new JButton("Regresar");
    setContentPane(contentPane);
    btnRegresar.setBounds(10, 479, 100, 21);
    btnRegresar.setVerticalAlignment(SwingConstants.BOTTOM);

    // btn Eliminar
    JButton btnEliminar = new JButton("Eliminar");
    contentPane.setLayout(null);
    contentPane.add(btnRegresar);
    btnEliminar.setBounds(252, 479, 100, 21);
    contentPane.add(btnEliminar);

    JLabel Titulo = new JLabel("Notificaciones");
    Titulo.setFont(new Font("Consolas", Font.BOLD, 16));
    Titulo.setBounds(128, 10, 128, 21);
    contentPane.add(Titulo);

    // Listeners
    btnEliminar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < lista.size(); i++) {
          lista.get(i).setText(null);
        }
        control.deleteNotificacion(usuario.getCorreo());
      }
    });

    // regresar al menú
    btnRegresar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
      }
    });
  }

  public void muestra(ControlNotificacion control, Usuario usuario) {
    this.control = control;
    this.usuario = usuario;
    // Add user to recuperaNotificacion
    for (int i = 0; i < control.recuperaNotificacion(usuario.getCorreo()).size(); i++) {
      lista.add(new JLabel(control.recuperaNotificacion(usuario.getCorreo()).get(i).getMessage()));
      lista.get(i).setBounds(20, 30 + (20 * (i)), 342, 21);
      contentPane.add(lista.get(i));
    }

    dispose();
		setUndecorated(true);
    setVisible(true);
  }

  public void muestraDialogoConMensaje(String message) {
    JOptionPane.showMessageDialog(this, message);
  }
}