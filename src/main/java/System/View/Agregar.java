package System.View;

import System.Controller.DepartamentoController;
import System.Models.DepartamantoModel;
import System.Models.VehiculoModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Agregar extends JFrame{
    private JPanel Ventana;
    private JTextField numeroDeDeptoTextField;
    private JTextField nombreTF;
    private JTextField apellidoTF;
    private JTextField telefonoTF;
    private JTextField emailTF;
    private JButton agregarPersonaButton;
    private JTextField marcaTF;
    private JTextField modeloTF;
    private JTextField colorTF;
    private JTextField estacioTF;
    private JButton agregarVehiculoButton;
    private JButton volverButton;
    private JComboBox comboBox1;
    private JTextField letraTF;

    public Agregar(DepartamentoController departamentoController){
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
                        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal(departamentoController);
                        pantallaPrincipal.setVisible(true);
                        pantallaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    }
                });
            }
        });

        agregarPersonaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreTF.getText();
                String apellido = apellidoTF.getText();
                String telefonoStr = telefonoTF.getText();
                String email = emailTF.getText();
                String descripcion = (String) comboBox1.getSelectedItem();
                String numeroDeptoStr = numeroDeDeptoTextField.getText();
                String letraDepto = letraTF.getText();


                if (nombre.isEmpty() || apellido.isEmpty() || telefonoStr.isEmpty() || numeroDeptoStr.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(Ventana, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(letraDepto.isEmpty()){
                    JOptionPane.showMessageDialog(Ventana, "El departamento debe tener una letra", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    Integer numeroDepto = Integer.parseInt(numeroDeptoStr);
                    DepartamantoModel departamento = departamentoController.BuscarDepartamento(letraDepto,numeroDepto);
                    if (departamento == null) {
                        JOptionPane.showMessageDialog(Ventana, "El departamento no existe", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if (departamento.getPersonaModels().size() >= 10) {
                        JOptionPane.showMessageDialog(Ventana, "El departamento ya tiene el máximo de 10 personas", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Ventana, "El número de departamento debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    Integer telefono = Integer.parseInt(telefonoStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Ventana, "El teléfono debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Integer telefono = Integer.parseInt(telefonoStr);
                Integer numeroDepto = Integer.parseInt(numeroDeptoStr);
                departamentoController.CreatePersona(nombre, apellido, telefono, email,descripcion,numeroDepto,letraDepto);
                JOptionPane.showMessageDialog(Ventana, "Persona agregada");

                nombreTF.setText("");
                apellidoTF.setText("");
                telefonoTF.setText("");
                emailTF.setText("");
                numeroDeDeptoTextField.setText("");
            }
        });

        agregarVehiculoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroDeptoSRT = numeroDeDeptoTextField.getText();
                String letra = letraTF.getText();

                if (letra.isEmpty()){
                    JOptionPane.showMessageDialog(Ventana, "El departamento debe tener una letra", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    Integer numeroDepto = Integer.parseInt(numeroDeptoSRT);
                    DepartamantoModel departamento = departamentoController.BuscarDepartamento(letra,numeroDepto);
                    if (departamento == null){
                        JOptionPane.showMessageDialog(Ventana, "El departamento no existe", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (departamento.getVehiculoModels().size() >= 10) {
                        JOptionPane.showMessageDialog(Ventana, "El departamento ya tiene el máximo de 10 vehículos", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String estacioStr = estacioTF.getText();
                    String marca = marcaTF.getText();
                    String modelo = modeloTF.getText();
                    String color = colorTF.getText();


                    try {
                        Integer estacionamiento = Integer.parseInt(estacioStr);

                        for (VehiculoModel vehiculo : departamento.getVehiculoModels()) {
                            if (vehiculo.getEstacionamiento().equals(estacionamiento)) {
                                JOptionPane.showMessageDialog(Ventana, "El número de estacionamiento ya está en uso", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }
                        }
                        departamentoController.CreateVehiculo(estacionamiento, marca, modelo, color, numeroDepto,letra);
                        JOptionPane.showMessageDialog(Ventana, "Vehículo agregado");

                        marcaTF.setText("");
                        modeloTF.setText("");
                        colorTF.setText("");
                        estacioTF.setText("");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(Ventana, "El estacionamiento debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Ventana, "El número de departamento debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });



    }
}
