package System.View;

import System.Controller.DepartamentoController;
import System.Controller.LoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame{
    private JPanel Ventana;
    private JPasswordField passwordField1;
    private JLabel Logo;
    private JButton entrarButton;

    public Login(DepartamentoController departamentoController, LoginController loginController){
        add(Ventana);
        setTitle("Login");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        ImageIcon imageIcon = new ImageIcon(Login.class.getResource("/images/Logo.jpg"));
        Image image = imageIcon.getImage();
        Image newImage=image.getScaledInstance(200, 180, Image.SCALE_SMOOTH);
        ImageIcon imageIcon1 = new ImageIcon(newImage);
        Logo.setIcon(imageIcon1);
        passwordField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    entrarButton.doClick();
                }
            }
        });
        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = passwordField1.getText();
                if (loginController.ValidatePassword(password)){
                    setVisible(false);
                    departamentoController.GenerarEjemplo();
                    departamentoController.CargarDeptos();
                    PantallaPrincipal pantalla = new PantallaPrincipal(departamentoController);
                    pantalla.setVisible(true);
                    pantalla.setExtendedState(JFrame.MAXIMIZED_BOTH);
                }else{
                    JOptionPane.showMessageDialog(Ventana, "Contraseña incorrecta intentelo de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
                    passwordField1.setText("");
                }
            }
        });
    }
}
