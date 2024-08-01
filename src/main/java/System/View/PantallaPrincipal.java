package System.View;

import System.Controller.DepartamentoController;
import System.Controller.LoginController;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

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
    private JButton salirButton;
    private JButton guardarButton;

    public PantallaPrincipal( DepartamentoController departamentoController){
        table1.setModel(departamentoController.tablaModelGenerator(departamentoController.getDepartamentoModels()));
        add(Ventana);
        setTitle("Principal");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        ImageIcon imageIcon = new ImageIcon(PantallaPrincipal.class.getResource("/images/Logo.jpg"));
        Image image = imageIcon.getImage();
        Image newImage=image.getScaledInstance(60, 50, Image.SCALE_SMOOTH);
        ImageIcon imageIcon1 = new ImageIcon(newImage);
        label.setIcon(imageIcon1);
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
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
        Exportarbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null,"¿Desea Exportar esta tabla a su Escritorio en formato .PDF?","Adevertencia",JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);

                if (option == JOptionPane.OK_OPTION) {
                    try {
                        exportToPDF();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

            }
        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                departamentoController.GuardarDeptos();
                JOptionPane.showMessageDialog(null,"Sean guardado todos los datos");
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null,"¿Seguro que desea recetear la tabla? se eliminaran todos los datos","Adevertencia",JOptionPane.OK_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);

                if (option == JOptionPane.OK_OPTION) {
                    Recet recet = new Recet(departamentoController);
                    recet.setVisible(true);
                }

            }
        });
        UsiarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contraseña contraseña = new Contraseña();
                contraseña.setVisible(true);
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null,"¿Desea guardar los cambios realizados antes de salir? ","Adevertencia",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);

                if (option == JOptionPane.YES_OPTION) {
                    guardarButton.doClick();
                    Login login = new Login(new DepartamentoController(),new LoginController());
                    login.setVisible(true);
                    login.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    setVisible(false);
                }else if (option == JOptionPane.NO_OPTION){
                    Login login = new Login(new DepartamentoController(),new LoginController());
                    login.setVisible(true);
                    login.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    setVisible(false);
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
    private void exportToPDF() throws Exception {
        File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();
        File pdfFile = new File(desktopDir, "tabla.PDF");

        Document document = new Document(PageSize.LEGAL.rotate());
        PdfWriter.getInstance(document, new java.io.FileOutputStream(pdfFile));
        document.open();

        PdfPTable pdfTable = new PdfPTable(table1.getColumnCount());
        pdfTable.setWidthPercentage(100);

        for (int i = 0; i < table1.getColumnCount(); i++) {
            pdfTable.addCell(table1.getColumnName(i));
        }

        for (int rows = 0; rows < table1.getRowCount(); rows++) {
            for (int cols = 0; cols < table1.getColumnCount(); cols++) {
                PdfPCell cell = new PdfPCell(new Phrase(table1.getModel().getValueAt(rows, cols).toString()));
                cell.setPadding(5);
                pdfTable.addCell(cell);
            }
        }


        document.add(pdfTable);
        document.close();

        JOptionPane.showMessageDialog(this, "PDF exportado exitosamente al escritorio!");
    }



}

