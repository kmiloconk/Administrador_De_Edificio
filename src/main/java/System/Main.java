package System;
import System.View.PantallaPrincipal;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PantallaPrincipal pantalla = new PantallaPrincipal();
                pantalla.setVisible(true);
                pantalla.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });

    }

}
