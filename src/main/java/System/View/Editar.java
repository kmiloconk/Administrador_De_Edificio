package System.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Editar extends JFrame{
    private JPanel Ventana;
    private JTextField numeroDeDeptoTextField;
    private JButton volverButton;
    private JTextField nombrePTF;
    private JTextField apellidoPTF;
    private JTextField telefonoPTF;
    private JTextField descripPTF;
    private JButton Guardar;
    private JTextField marcaVTF;
    private JTextField modeloVTF;
    private JTextField colorVTF;
    private JTextField numeroETF;
    private JButton buscarBotton;
    private JPanel personaPanel1;
    private JPanel personaPanel2;
    private JPanel personaPanel3;
    private JPanel personaPanel4;
    private JPanel personaPanel5;
    private JPanel personaPanel6;
    private JPanel personaPanel7;
    private JPanel personaPanel8;
    private JPanel personaPanel9;
    private JTextField nombrePTF1;
    private JTextField apellidoPTF1;
    private JTextField telefonoPTF1;
    private JTextField descripPTF1;
    private JTextField nombrePTF2;
    private JTextField apellidoPTF2;
    private JTextField telefonoPTF2;
    private JTextField descripPTF2;
    private JTextField nombrePTF3;
    private JTextField apellidoPTF3;
    private JTextField telefonoPTF3;
    private JTextField descripPTF3;
    private JTextField nombrePTF4;
    private JTextField apellidoPTF4;
    private JTextField telefonoPTF4;
    private JTextField descripPTF4;
    private JTextField nombrePTF5;
    private JTextField apellidoPTF5;
    private JTextField telefonoPTF5;
    private JTextField descripPTF5;
    private JTextField nombrePTF6;
    private JTextField apellidoPTF6;
    private JTextField telefonoPTF6;
    private JTextField descripPTF6;
    private JTextField nombrePTF7;
    private JTextField apellidoPTF7;
    private JTextField telefonoPTF7;
    private JTextField descripPTF7;
    private JTextField nombrePTF8;
    private JTextField apellidoPTF8;
    private JTextField telefonoPTF8;
    private JTextField descripPTF8;
    private JTextField nombrePTF9;
    private JTextField apellidoPTF9;
    private JTextField telefonoPTF9;
    private JTextField descripPTF9;
    private JPanel personaPanel;
    private JPanel vehiculoPanel;
    private JPanel estacioPanel;
    private JPanel vehiculoPanel1;
    private JPanel vehiculoPanel2;
    private JPanel vehiculoPanel3;
    private JPanel vehiculoPanel4;
    private JPanel vehiculoPanel5;
    private JPanel vehiculoPanel6;
    private JPanel vehiculoPanel7;
    private JPanel vehiculoPanel8;
    private JPanel vehiculoPanel9;
    private JTextField marcaVTF1;
    private JTextField modeloVTF1;
    private JTextField colorVTF1;
    private JTextField marcaVTF2;
    private JTextField modeloVTF2;
    private JTextField colorVTF2;
    private JTextField marcaVTF3;
    private JTextField modeloVTF3;
    private JTextField colorVTF3;
    private JTextField marcaVTF4;
    private JTextField modeloVTF4;
    private JTextField colorVTF4;
    private JTextField marcaVTF5;
    private JTextField modeloVTF5;
    private JTextField colorVTF5;
    private JTextField marcaVTF6;
    private JTextField modeloVTF6;
    private JTextField colorVTF6;
    private JTextField marcaVTF7;
    private JTextField modeloVTF7;
    private JTextField colorVTF7;
    private JTextField marcaVTF8;
    private JTextField modeloVTF8;
    private JTextField colorVTF8;
    private JTextField marcaVTF9;
    private JTextField modeloVTF9;
    private JTextField colorVTF9;
    private JPanel estacioPanel1;
    private JPanel estacioPanel2;
    private JPanel estacioPanel3;
    private JPanel estacioPanel4;
    private JPanel estacioPanel5;
    private JPanel estacioPanel6;
    private JPanel estacioPanel7;
    private JPanel estacioPanel8;
    private JPanel estacioPanel9;
    private JTextField numeroETF1;
    private JTextField numeroETF2;
    private JTextField numeroETF3;
    private JTextField numeroETF4;
    private JTextField numeroETF5;
    private JTextField numeroETF6;
    private JTextField numeroETF7;
    private JTextField numeroETF8;
    private JTextField numeroETF9;

    public Editar(){
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
        Guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        setVisible(false);
                        personaPanel1.setVisible(true);
                        setVisible(true);
                    }
                });
            }
        });

    }


}
