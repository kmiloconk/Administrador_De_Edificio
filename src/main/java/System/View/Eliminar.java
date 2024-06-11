package System.View;

import System.Controller.DepartamentoController;
import System.Models.DepartamantoModel;
import System.Models.PersonaModel;
import System.Models.VehiculoModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;

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
    private JButton eliminarTodoButton;
    private JTextField letraTF;
    Integer telefono,telefono1,telefono2,telefono3,telefono4,telefono5,telefono6,telefono7,telefono8,telefono9;
    Integer estacinamiento,estacinamiento1,estacinamiento2,estacinamiento3,estacinamiento4,estacinamiento5,estacinamiento6,estacinamiento7,estacinamiento8,estacinamiento9;
    List<JPanel> personaPanels = Arrays.asList(personaPanel, personaPanel1, personaPanel2, personaPanel3, personaPanel4, personaPanel5, personaPanel6, personaPanel7, personaPanel8, personaPanel9);
    List<JTextField> nombrePTFs = Arrays.asList(nombrePTF, nombrePTF1, nombrePTF2, nombrePTF3, nombrePTF4, nombrePTF5, nombrePTF6, nombrePTF7, nombrePTF8, nombrePTF9);
    List<JPanel> vehiculoPanels = Arrays.asList(vehiculoPanel, vehiculoPanel1, vehiculoPanel2, vehiculoPanel3, vehiculoPanel4, vehiculoPanel5, vehiculoPanel6, vehiculoPanel7, vehiculoPanel8, vehiculoPanel9);
    List<JTextField> marcaVTFs = Arrays.asList(marcaVTF, marcaVTF1, marcaVTF2, marcaVTF3, marcaVTF4, marcaVTF5, marcaVTF6, marcaVTF7, marcaVTF8, marcaVTF9);
    List<Integer> telefonos= Arrays.asList(telefono,telefono1,telefono2,telefono3,telefono4,telefono5,telefono6,telefono7,telefono8,telefono9);
    List<Integer> estacionamientos= Arrays.asList(estacinamiento,estacinamiento1,estacinamiento2,estacinamiento3,estacinamiento4,estacinamiento5,estacinamiento6,estacinamiento7,estacinamiento8,estacinamiento9);
    Integer personaCant=0,vehiculoCant =0;

    public Eliminar(DepartamentoController departamentoController){
        add(Ventana);
        setTitle("Editar");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        numeroDeDeptoTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    buscarBotton.doClick();
                }
            }
        });
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

        buscarBotton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                Integer numero = Integer.parseInt(numeroDeDeptoTextField.getText());
                String letra = letraTF.getText();
                DepartamantoModel departamento = departamentoController.BuscarDepartamento(letra,numero);

                if (departamento == null) {
                    JOptionPane.showMessageDialog(null, "El departamento no existe", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    for (PersonaModel persona : departamento.getPersonaModels()) {
                        if (personaCant < personaPanels.size()) {
                            personaPanels.get(personaCant).setVisible(true);
                            telefonos.set(personaCant, persona.getTelefono());

                            nombrePTFs.get(personaCant).setText(persona.getNombre() + "," + persona.getApellido() + "," + persona.getTelefono().toString() +","+persona.getEmail() +"," + persona.getDescripcion());
                        }
                        personaCant++;
                    }
                    for (VehiculoModel vehiculo : departamento.getVehiculoModels()) {
                        if (vehiculoCant < vehiculoPanels.size()) {
                            vehiculoPanels.get(vehiculoCant).setVisible(true);
                            estacionamientos.set(vehiculoCant, vehiculo.getEstacionamiento());
                            marcaVTFs.get(vehiculoCant).setText(vehiculo.getMarca() + "," + vehiculo.getModelo() + "," + vehiculo.getColor() + "," + vehiculo.getEstacionamiento());
                        }
                        vehiculoCant++;
                    }
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer numeroDepto = Integer.parseInt(numeroDeDeptoTextField.getText());
                String letra = letraTF.getText();
                telefono = telefonos.get(0);
                departamentoController.DeletePersona(telefono, numeroDepto,letra);
                personaPanels.get(0).setVisible(false);
                JOptionPane.showMessageDialog(Ventana,"Persona Eliminada");
            }
        });
        eliminarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer numeroDepto = Integer.parseInt(numeroDeDeptoTextField.getText());
                String letra = letraTF.getText();
                telefono1 = telefonos.get(1);
                departamentoController.DeletePersona(telefono1, numeroDepto,letra);
                personaPanels.get(1).setVisible(false);
                JOptionPane.showMessageDialog(Ventana,"Persona Eliminada");
            }
        });
        eliminarButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer numeroDepto = Integer.parseInt(numeroDeDeptoTextField.getText());
                String letra = letraTF.getText();
                telefono2 = telefonos.get(2);
                departamentoController.DeletePersona(telefono2, numeroDepto,letra);
                personaPanels.get(2).setVisible(false);
                JOptionPane.showMessageDialog(Ventana,"Persona Eliminada");
            }
        });
        eliminarButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer numeroDepto = Integer.parseInt(numeroDeDeptoTextField.getText());
                String letra = letraTF.getText();
                telefono3 = telefonos.get(3);
                departamentoController.DeletePersona(telefono3, numeroDepto,letra);
                personaPanels.get(3).setVisible(false);
                JOptionPane.showMessageDialog(Ventana,"Persona Eliminada");
            }
        });
        eliminarButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer numeroDepto = Integer.parseInt(numeroDeDeptoTextField.getText());
                String letra = letraTF.getText();
                telefono4 = telefonos.get(4);
                departamentoController.DeletePersona(telefono4, numeroDepto,letra);
                personaPanels.get(4).setVisible(false);
                JOptionPane.showMessageDialog(Ventana,"Persona Eliminada");
            }
        });
        eliminarButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer numeroDepto = Integer.parseInt(numeroDeDeptoTextField.getText());
                String letra = letraTF.getText();
                telefono5 = telefonos.get(5);
                departamentoController.DeletePersona(telefono5, numeroDepto,letra);
                personaPanels.get(5).setVisible(false);
                JOptionPane.showMessageDialog(Ventana,"Persona Eliminada");
            }
        });
        eliminarButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer numeroDepto = Integer.parseInt(numeroDeDeptoTextField.getText());
                String letra = letraTF.getText();
                telefono6 = telefonos.get(6);
                departamentoController.DeletePersona(telefono6, numeroDepto,letra);
                personaPanels.get(6).setVisible(false);
                JOptionPane.showMessageDialog(Ventana,"Persona Eliminada");
            }
        });
        eliminarButton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer numeroDepto = Integer.parseInt(numeroDeDeptoTextField.getText());
                String letra = letraTF.getText();
                telefono7 = telefonos.get(7);
                departamentoController.DeletePersona(telefono7, numeroDepto,letra);
                personaPanels.get(7).setVisible(false);
                JOptionPane.showMessageDialog(Ventana,"Persona Eliminada");
            }
        });
        eliminarButton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer numeroDepto = Integer.parseInt(numeroDeDeptoTextField.getText());
                String letra = letraTF.getText();
                telefono8 = telefonos.get(8);
                departamentoController.DeletePersona(telefono8, numeroDepto,letra);
                personaPanels.get(8).setVisible(false);
                JOptionPane.showMessageDialog(Ventana,"Persona Eliminada");
            }
        });
        eliminarButton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer numeroDepto = Integer.parseInt(numeroDeDeptoTextField.getText());
                String letra = letraTF.getText();
                telefono9 = telefonos.get(9);
                departamentoController.DeletePersona(telefono9, numeroDepto,letra);
                personaPanels.get(9).setVisible(false);
                JOptionPane.showMessageDialog(Ventana,"Persona Eliminada");
            }
        });
        eliminarButton10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer numeroDepto = Integer.parseInt(numeroDeDeptoTextField.getText());
                String letra = letraTF.getText();
                estacinamiento = estacionamientos.get(0);
                departamentoController.DeleteVehiculo(estacinamiento, numeroDepto,letra);
                JOptionPane.showMessageDialog(Ventana,"Vehiculo Eliminado");
                vehiculoPanels.get(0).setVisible(false);
                System.out.println(estacinamiento);
            }
        });
        eliminarButton11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer numeroDepto = Integer.parseInt(numeroDeDeptoTextField.getText());
                String letra = letraTF.getText();
                estacinamiento1 = estacionamientos.get(1);
                departamentoController.DeleteVehiculo(estacinamiento1, numeroDepto,letra);
                vehiculoPanels.get(1).setVisible(false);
                JOptionPane.showMessageDialog(Ventana,"Vehiculo Eliminado");
            }
        });
        eliminarButton12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer numeroDepto = Integer.parseInt(numeroDeDeptoTextField.getText());
                String letra = letraTF.getText();
                estacinamiento2 = estacionamientos.get(2);
                departamentoController.DeleteVehiculo(estacinamiento2, numeroDepto,letra);
                vehiculoPanels.get(2).setVisible(false);
                JOptionPane.showMessageDialog(Ventana,"Vehiculo Eliminado");
            }
        });
        eliminarButton13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer numeroDepto = Integer.parseInt(numeroDeDeptoTextField.getText());
                String letra = letraTF.getText();
                estacinamiento3 = estacionamientos.get(3);
                departamentoController.DeleteVehiculo(estacinamiento3, numeroDepto,letra);
                vehiculoPanels.get(3).setVisible(false);
                JOptionPane.showMessageDialog(Ventana,"Vehiculo Eliminado");
            }
        });
        eliminarButton14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer numeroDepto = Integer.parseInt(numeroDeDeptoTextField.getText());
                String letra = letraTF.getText();
                estacinamiento4 = estacionamientos.get(4);
                departamentoController.DeleteVehiculo(estacinamiento4, numeroDepto,letra);
                vehiculoPanels.get(4).setVisible(false);
                JOptionPane.showMessageDialog(Ventana,"Vehiculo Eliminado");
            }
        });
        eliminarButton15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer numeroDepto = Integer.parseInt(numeroDeDeptoTextField.getText());
                String letra = letraTF.getText();
                estacinamiento5 = estacionamientos.get(5);
                departamentoController.DeleteVehiculo(estacinamiento5, numeroDepto,letra);
                vehiculoPanels.get(5).setVisible(false);
                JOptionPane.showMessageDialog(Ventana,"Vehiculo Eliminado");
            }
        });
        eliminarButton16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer numeroDepto = Integer.parseInt(numeroDeDeptoTextField.getText());
                String letra = letraTF.getText();
                estacinamiento6 = estacionamientos.get(6);
                departamentoController.DeleteVehiculo(estacinamiento6, numeroDepto,letra);
                vehiculoPanels.get(6).setVisible(false);
                JOptionPane.showMessageDialog(Ventana,"Vehiculo Eliminado");
            }
        });
        eliminarButton17.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer numeroDepto = Integer.parseInt(numeroDeDeptoTextField.getText());
                String letra = letraTF.getText();
                estacinamiento7 = estacionamientos.get(7);
                departamentoController.DeleteVehiculo(estacinamiento7, numeroDepto,letra);
                vehiculoPanels.get(7).setVisible(false);
                JOptionPane.showMessageDialog(Ventana,"Vehiculo Eliminado");
            }
        });
        eliminarButton18.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer numeroDepto = Integer.parseInt(numeroDeDeptoTextField.getText());
                String letra = letraTF.getText();
                estacinamiento8 = estacionamientos.get(8);
                departamentoController.DeleteVehiculo(estacinamiento8, numeroDepto,letra);
                vehiculoPanels.get(8).setVisible(false);
                JOptionPane.showMessageDialog(Ventana,"Vehiculo Eliminado");
            }
        });
        eliminarButton19.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer numeroDepto = Integer.parseInt(numeroDeDeptoTextField.getText());
                String letra = letraTF.getText();
                estacinamiento9 = estacionamientos.get(9);
                departamentoController.DeleteVehiculo(estacinamiento9, numeroDepto,letra);
                vehiculoPanels.get(9).setVisible(false);
                JOptionPane.showMessageDialog(Ventana,"Vehiculo Eliminado");
            }
        });
        eliminarTodoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null,"¿Seguro que desea eliminar todo el departamento?","Adevertencia",JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.WARNING_MESSAGE);

                if (option == JOptionPane.OK_OPTION) {
                    Integer numeroDepto = Integer.parseInt(numeroDeDeptoTextField.getText());
                    String letra = letraTF.getText();
                    departamentoController.DeleteDepartamento(numeroDepto,letra);
                    JOptionPane.showMessageDialog(Ventana,"Departamento Eliminado");
                    setVisible(false);
                    PantallaPrincipal pantallaPrincipal = new PantallaPrincipal(departamentoController);
                    pantallaPrincipal.setVisible(true);
                    pantallaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
                }

            }
        });
    }
}
