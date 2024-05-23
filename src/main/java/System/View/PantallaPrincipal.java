package System.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaPrincipal extends JFrame {
    private JPanel Ventana;
    private JButton Buscar;
    private JTextField textField1;
    private JButton AgregarButton;
    private JButton EditarButton;
    private JButton EliminarButton;

    public PantallaPrincipal(){
        add(Ventana);
        setTitle("Principal");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        AgregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        Agregar agregar = new Agregar();
                        agregar.setVisible(true);
                        agregar.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    }
                });
            }
        });
        EditarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        Editar editar = new Editar();
                        editar.setVisible(true);
                        editar.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    }
                });
            }
        });
        EliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        Eliminar eliminar = new Eliminar();
                        eliminar.setVisible(true);
                        eliminar.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    }
                });
            }
        });
    }

}
