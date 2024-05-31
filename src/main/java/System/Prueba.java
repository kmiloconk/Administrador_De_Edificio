package System;
import javax.swing.*;
import java.awt.*;

public class Prueba {

    public static void main(String[] args) {
        // Crear el marco principal
        JFrame frame = new JFrame("Lista de Botones");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Crear un panel con BoxLayout en el eje Y (vertical)
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Crear y añadir botones al panel
        for (int i = 1; i <= 10; i++) {
            JButton button = new JButton("Botón " + i);
            panel.add(button);
        }

        // Añadir el panel al marco
        frame.add(panel);

        // Hacer visible el marco
        frame.setVisible(true);
    }
}