package System;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CSVFileWriter {
    public static void main(String[] args) {
        String csvFilePath = "datos.csv"; // Ruta donde se guardará el archivo CSV

        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {

            // Escribir encabezados
            String[] headers = {"Nombre", "Edad", "Email"};
            writer.writeNext(headers);

            // Escribir registros
            String[] record1 = {"Juan", "30", "juan@example.com"};
            String[] record2 = {"María", "25", "maria@example.com"};

            writer.writeNext(record1);
            writer.writeNext(record2);

            System.out.println("Archivo CSV creado exitosamente.");

        } catch (IOException e) {
            System.err.println("Error al escribir el archivo CSV: " + e.getMessage());
        }
    }
}
