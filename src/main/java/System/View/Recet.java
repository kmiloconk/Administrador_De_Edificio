package System.View;

import System.Controller.DepartamentoController;
import System.Controller.LoginController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Recet extends JFrame {
    private JPasswordField passwordField1;
    private JPanel Ventana;
    private JButton okButton;
    public Recet(DepartamentoController departamentoController){
        LoginController loginController = new LoginController();
        add(Ventana);
        setTitle("Receteo de tabla");
        setSize(300, 150);
        setLocationRelativeTo(null);
        passwordField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    okButton.doClick();
                }
            }
        });
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = passwordField1.getText();
                if(loginController.ValidatePassword(password)){
                    departamentoController.Recet();
                    JOptionPane.showMessageDialog(Ventana, "Sea receteado la tabla con exito");
                    setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(Ventana, "Contraseña incorrecta intentelo de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
                    passwordField1.setText("");
                }
            }
        });
    }
}
