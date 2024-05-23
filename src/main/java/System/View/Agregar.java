package System.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Agregar extends JFrame{
    private JPanel Ventana;
    private JTextField numeroDeDeptoTextField;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton Agregar1;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JButton agregar2;
    private JTextField textField8;
    private JButton agregar3;
    private JButton volverButton;
    public Agregar(){
        add(Ventana);
        setTitle("Agregar");
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
