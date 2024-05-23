package System.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eliminar extends JFrame{
    private JTextField numeroDeDeptoTextField;
    private JButton buscarBotton;
    private JButton volverButton;
    private JPanel personaPanel;
    private JTextField nombrePTF;
    private JPanel personaPanel1;
    private JTextField nombrePTF1;
    private JPanel personaPanel2;
    private JTextField nombrePTF2;
    private JPanel personaPanel3;
    private JTextField nombrePTF3;
    private JPanel personaPanel4;
    private JTextField nombrePTF4;
    private JPanel personaPanel5;
    private JTextField nombrePTF5;
    private JPanel personaPanel6;
    private JTextField nombrePTF6;
    private JPanel personaPanel7;
    private JTextField nombrePTF7;
    private JPanel personaPanel8;
    private JTextField nombrePTF8;
    private JPanel personaPanel9;
    private JTextField nombrePTF9;
    private JPanel vehiculoPanel;
    private JTextField marcaVTF;
    private JPanel vehiculoPanel1;
    private JTextField marcaVTF1;
    private JPanel vehiculoPanel2;
    private JTextField marcaVTF2;
    private JPanel vehiculoPanel3;
    private JTextField marcaVTF3;
    private JPanel vehiculoPanel4;
    private JTextField marcaVTF4;
    private JPanel vehiculoPanel5;
    private JTextField marcaVTF5;
    private JPanel vehiculoPanel6;
    private JTextField marcaVTF6;
    private JPanel vehiculoPanel7;
    private JTextField marcaVTF7;
    private JPanel vehiculoPanel8;
    private JTextField marcaVTF8;
    private JPanel vehiculoPanel9;
    private JTextField marcaVTF9;
    private JPanel estacioPanel;
    private JTextField numeroETF;
    private JPanel estacioPanel1;
    private JPanel estacioPanel2;
    private JPanel estacioPanel3;
    private JPanel estacioPanel4;
    private JPanel estacioPanel5;
    private JPanel estacioPanel6;
    private JPanel estacioPanel7;
    private JPanel estacioPanel8;
    private JPanel estacioPanel9;
    private JPanel Ventana;
    private JButton eliminarButton;
    private JButton eliminarButton1;
    private JButton eliminarButton4;
    private JButton eliminarButton2;
    private JButton eliminarButton3;
    private JButton eliminarButton5;
    private JButton eliminarButton6;
    private JButton eliminarButton7;
    private JButton eliminarButton8;
    private JButton eliminarButton9;
    private JButton eliminarButton10;
    private JButton eliminarButton11;
    private JButton eliminarButton12;
    private JButton eliminarButton13;
    private JButton eliminarButton14;
    private JButton eliminarButton15;
    private JButton eliminarButton16;
    private JButton eliminarButton17;
    private JButton eliminarButton18;
    private JButton eliminarButton19;
    private JButton eliminarButton20;
    private JButton eliminarButton21;
    private JButton eliminarButton22;
    private JButton eliminarButton23;
    private JButton eliminarButton24;
    private JButton eliminarButton25;
    private JButton eliminarButton26;
    private JButton eliminarButton27;
    private JButton eliminarButton28;
    private JButton eliminarButton29;
    public Eliminar(){
        add(Ventana);
        setTitle("Editar");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal();
                        pantallaPrincipal.setVisible(true);
                        pantallaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    }
                });
            }
        });
    }
}
