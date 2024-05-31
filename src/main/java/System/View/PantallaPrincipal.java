package System.View;

import System.Controller.DepartamentoController;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PantallaPrincipal extends JFrame {
    private JPanel Ventana;
    private JButton Buscar;
    private JTextField textField1;
    private JButton AgregarButton;
    private JButton EditarButton;
    private JButton EliminarButton;
    private JTable table1;
    private JLabel label;
    private JButton Exportarbutton;
    private JButton UsiarioButton;
    private JButton OpcionesButton;
    private JPanel OptionPanel;
    private JButton resetButton;

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
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Verifica si la tecla presionada es Enter
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Simula el clic en el botón de búsqueda
                    Buscar.doClick();
                }
            }
        });
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
                adjustColumnWidths(table1);
                centerTableText(table1);

            }
        });

        OpcionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(OptionPanel.isVisible()){
                    OptionPanel.setVisible(false);
                }else{
                    OptionPanel.setVisible(true);
                }

            }
        });
        adjustColumnWidths(table1);
        centerTableText(table1);


    }


    private void adjustColumnWidths(JTable table) {
        for (int column = 0; column < table.getColumnCount(); column++) {
            TableColumn tableColumn = table.getColumnModel().getColumn(column);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();

            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
                Component c = table.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width);

                if (preferredWidth >= maxWidth) {
                    preferredWidth = maxWidth;
                    break;
                }
            }

            tableColumn.setPreferredWidth(preferredWidth);
        }
    }
    private void centerTableText(JTable table) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int column = 0; column < table.getColumnCount(); column++) {
            table.getColumnModel().getColumn(column).setCellRenderer(centerRenderer);
        }
    }


}

