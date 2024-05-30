package System.View;

import System.Controller.DepartamentoController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaPrincipal extends JFrame {
    private JPanel Ventana;
    private JButton Buscar;
    private JTextField textField1;
    private JButton AgregarButton;
    private JButton EditarButton;
    private JButton EliminarButton;
    private JTable table1;
    private JLabel label;

    public PantallaPrincipal( DepartamentoController departamentoController){
        table1.setModel(departamentoController.tablaModelGenerator(departamentoController.getDepartamentoModels()));
        add(Ventana);
        setTitle("Principal");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        ImageIcon imageIcon = new ImageIcon("images/Logo.jpg");
        Image image = imageIcon.getImage();
        Image newImage=image.getScaledInstance(60, 50, Image.SCALE_SMOOTH);
        ImageIcon imageIcon1 = new ImageIcon(newImage);
        label.setIcon(imageIcon1);
        AgregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        Agregar agregar = new Agregar(departamentoController);
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
                        Editar editar = new Editar(departamentoController);
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
                        Eliminar eliminar = new Eliminar(departamentoController);
                        eliminar.setVisible(true);
                        eliminar.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    }
                });
            }
        });
        Buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String dato = textField1.getText();
                if(dato.isEmpty()){
                    table1.setModel(departamentoController.tablaModelGenerator(departamentoController.getDepartamentoModels()));
                }else {
                    try {
                        int number = Integer.parseInt(dato);
                        table1.setModel(departamentoController.tablaModelGenerator(departamentoController.BuscarDeptosInteger(number)));

                    } catch (NumberFormatException t) {
                        table1.setModel(departamentoController.tablaModelGenerator(departamentoController.BuscarDeptosString(dato)));
                    }
                }

            }
        });

    }


}
