package System.View;

import System.Controller.LoginController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Contraseña extends JFrame{
    private JPasswordField passwordField1;
    private JPanel Ventana;
    private JPasswordField passwordField2;
    private JPasswordField passwordField3;
    private JButton okButton;
    public Contraseña(){
        LoginController loginController = new LoginController();
        add(Ventana);
        setTitle("Actualizar Contraseña");
        setSize(500, 300);
        setLocationRelativeTo(null);
        passwordField3.addKeyListener(new KeyAdapter() {
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
                String passwordNEW = passwordField2.getText();
                String passwordNEW2 = passwordField3.getText();
                if(loginController.UpdatePassword(password,passwordNEW,passwordNEW2)){
                    JOptionPane.showMessageDialog(Ventana, "Contraseña actualizada con exito");
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(Ventana, "Contraseña incorrecta o las contraceñas no coinciden intentelo de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
                    passwordField1.setText("");
                    passwordField2.setText("");
                    passwordField3.setText("");
                }
            }
        });
    }
}
