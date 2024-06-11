package System;
import System.Controller.DepartamentoController;
import System.Controller.LoginController;
import System.Models.PasswordModel;
import System.View.Login;
import System.View.PantallaPrincipal;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Login login = new Login(new DepartamentoController(),new LoginController());
                login.setVisible(true);
                login.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });


    }

}
