package System.View;

import System.Controller.DepartamentoController;
import System.Models.DepartamantoModel;
import System.Models.PersonaModel;
import System.Models.VehiculoModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private JTextField numeroETF1;
    private JTextField numeroETF2;
    private JTextField numeroETF3;
    private JTextField numeroETF4;
    private JTextField numeroETF5;
    private JTextField numeroETF6;
    private JTextField numeroETF7;
    private JTextField numeroETF8;
    private JTextField numeroETF9;
    private JTextField letraTF;

    List<JPanel> personaPanels = Arrays.asList(personaPanel, personaPanel1, personaPanel2, personaPanel3, personaPanel4, personaPanel5, personaPanel6, personaPanel7, personaPanel8, personaPanel9);
    List<JTextField> nombrePTFs = Arrays.asList(nombrePTF, nombrePTF1, nombrePTF2, nombrePTF3, nombrePTF4, nombrePTF5, nombrePTF6, nombrePTF7, nombrePTF8, nombrePTF9);
    List<JTextField> apellidoPTFs = Arrays.asList(apellidoPTF, apellidoPTF1, apellidoPTF2, apellidoPTF3, apellidoPTF4, apellidoPTF5, apellidoPTF6, apellidoPTF7, apellidoPTF8, apellidoPTF9);
    List<JTextField> telefonoPTFs = Arrays.asList(telefonoPTF, telefonoPTF1, telefonoPTF2, telefonoPTF3, telefonoPTF4, telefonoPTF5, telefonoPTF6, telefonoPTF7, telefonoPTF8, telefonoPTF9);
    List<JTextField> descripPTFs = Arrays.asList(descripPTF, descripPTF1, descripPTF2, descripPTF3, descripPTF4, descripPTF5, descripPTF6, descripPTF7, descripPTF8, descripPTF9);
    List<JPanel> vehiculoPanels = Arrays.asList(vehiculoPanel, vehiculoPanel1, vehiculoPanel2, vehiculoPanel3, vehiculoPanel4, vehiculoPanel5, vehiculoPanel6, vehiculoPanel7, vehiculoPanel8, vehiculoPanel9);

    List<JTextField> marcaVTFs = Arrays.asList(marcaVTF, marcaVTF1, marcaVTF2, marcaVTF3, marcaVTF4, marcaVTF5, marcaVTF6, marcaVTF7, marcaVTF8, marcaVTF9);

    List<JTextField> modeloVTFs = Arrays.asList(modeloVTF, modeloVTF1, modeloVTF2, modeloVTF3, modeloVTF4, modeloVTF5, modeloVTF6, modeloVTF7, modeloVTF8, modeloVTF9);

    List<JTextField> colorVTFs = Arrays.asList(colorVTF, colorVTF1, colorVTF2, colorVTF3, colorVTF4, colorVTF5, colorVTF6, colorVTF7, colorVTF8, colorVTF9);

    List<JTextField> numeroETFs = Arrays.asList(numeroETF, numeroETF1, numeroETF2, numeroETF3, numeroETF4, numeroETF5, numeroETF6, numeroETF7, numeroETF8, numeroETF9);
    Integer personaCant=0,vehiculoCant =0;
    public Editar(DepartamentoController departamentoController){
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
                        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal(departamentoController);
                        pantallaPrincipal.setVisible(true);
                        pantallaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    }
                });
            }
        });
        Guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String numeroDeptoStr = numeroDeDeptoTextField.getText();
                    String letra = letraTF.getText();
                    if (letra.isEmpty()){
                        JOptionPane.showMessageDialog(Ventana, "El departamento debe tener una letra", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (numeroDeptoStr.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Por favor, ingrese un número de departamento", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    Integer numero;
                    try {
                        numero = Integer.parseInt(numeroDeptoStr);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "El número de departamento debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    DepartamantoModel departamento = departamentoController.BuscarDepartamento(letra,numero);
                    if (departamento == null) {
                        JOptionPane.showMessageDialog(null, "El departamento no existe", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }


                    String nombre, apellido, descripcion, marca, modelo, color;
                    Integer telefono, estacionamiento;
                    List<PersonaModel> newPersonas = new ArrayList<>();

                    for (int i = 0; i <= personaCant - 1; i++) {
                        nombre = nombrePTFs.get(i).getText();
                        apellido = apellidoPTFs.get(i).getText();
                        String telefonoStr = telefonoPTFs.get(i).getText();
                        descripcion = descripPTFs.get(i).getText();



                        if (!telefonoStr.matches("\\d+")) {
                            JOptionPane.showMessageDialog(null, "El teléfono debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        telefono = Integer.parseInt(telefonoStr);
                        PersonaModel persona = new PersonaModel(nombre, apellido, telefono, descripcion,"Arrendatario");
                        newPersonas.add(persona);
                    }
                    departamentoController.UpdatePersona(newPersonas, numero,letra);

                    List<VehiculoModel> newvehiculos = new ArrayList<>();

                    for (int i = 0; i <= vehiculoCant - 1; i++) {
                        String estacionamientoStr = numeroETFs.get(i).getText();
                        marca = marcaVTFs.get(i).getText();
                        modelo = modeloVTFs.get(i).getText();
                        color = colorVTFs.get(i).getText();


                        if (!estacionamientoStr.matches("\\d+")) {
                            JOptionPane.showMessageDialog(null, "El estacionamiento debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        estacionamiento = Integer.parseInt(estacionamientoStr);
                        VehiculoModel vehiculoModel = new VehiculoModel(estacionamiento, marca, modelo, color);
                        newvehiculos.add(vehiculoModel);
                    }
                    departamentoController.UpdateVehiculo(newvehiculos, numero,letra);
                    JOptionPane.showMessageDialog(Ventana, "Los cambios han sido guardados");

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        buscarBotton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroDeptoStr = numeroDeDeptoTextField.getText();
                String letra = letraTF.getText();

                if (numeroDeptoStr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un número de departamento", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Integer numero;
                try {
                    numero = Integer.parseInt(numeroDeptoStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El número de departamento debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                DepartamantoModel departamento = departamentoController.BuscarDepartamento(letra,numero);
                if (departamento == null) {
                    JOptionPane.showMessageDialog(null, "El departamento no existe", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                personaCant = 0;
                vehiculoCant = 0;
                for (JPanel panel : personaPanels){
                    if(panel.isVisible()){
                        panel.setVisible(false);
                    }
                }
                for (JPanel panel : vehiculoPanels){
                    if(panel.isVisible()){
                        panel.setVisible(false);
                    }
                }

                for (PersonaModel persona : departamento.getPersonaModels()) {
                    if (personaCant < personaPanels.size()) {
                        personaPanels.get(personaCant).setVisible(true);
                        nombrePTFs.get(personaCant).setText(persona.getNombre());
                        apellidoPTFs.get(personaCant).setText(persona.getApellido());
                        telefonoPTFs.get(personaCant).setText(persona.getTelefono().toString());
                        descripPTFs.get(personaCant).setText(persona.getEmail());
                    }
                    personaCant++;
                }

                for (VehiculoModel vehiculo : departamento.getVehiculoModels()) {
                    if (vehiculoCant < vehiculoPanels.size()) {
                        vehiculoPanels.get(vehiculoCant).setVisible(true);
                        numeroETFs.get(vehiculoCant).setText(vehiculo.getEstacionamiento().toString());
                        marcaVTFs.get(vehiculoCant).setText(vehiculo.getMarca());
                        modeloVTFs.get(vehiculoCant).setText(vehiculo.getModelo());
                        colorVTFs.get(vehiculoCant).setText(vehiculo.getColor());
                    }
                    vehiculoCant++;
                }

            }

        });

    }


}
