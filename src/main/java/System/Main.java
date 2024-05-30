package System;
import System.Controller.DepartamentoController;
import System.View.PantallaPrincipal;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        DepartamentoController departamentoController =new DepartamentoController();
        departamentoController.GenerarEjemplo();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PantallaPrincipal pantalla = new PantallaPrincipal(departamentoController);
                pantalla.setVisible(true);
                pantalla.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });


    }

}
