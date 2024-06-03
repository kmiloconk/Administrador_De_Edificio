package System;
import System.Controller.DepartamentoController;
import System.Controller.LoginController;
import System.Models.PasswordModel;
import System.View.Login;
import System.View.PantallaPrincipal;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        DepartamentoController departamentoController =new DepartamentoController();
        PasswordModel passwordModel = new PasswordModel("user123");
        LoginController loginController = new LoginController(passwordModel);
        departamentoController.GenerarEjemplo();
        departamentoController.CargarDeptos();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Login login = new Login(departamentoController,loginController);
                login.setVisible(true);
                login.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });


    }

}
