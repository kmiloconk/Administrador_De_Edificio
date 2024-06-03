package System.Controller;
import System.Models.DepartamantoModel;
import System.Models.PersonaModel;
import System.Models.TablaModel;
import System.Models.VehiculoModel;
import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DepartamentoController {
    private List<DepartamantoModel> departamentoModels;
    public DepartamentoController(){
        this.departamentoModels = new ArrayList<>();
    }

    public void GenerarEjemplo(){
       /* PersonaModel persona1 = new PersonaModel("Juan", "Perez", 123456789,"email@ejemplo.com", "Propietario");
        PersonaModel persona2 = new PersonaModel("María", "López", 987654321,"email@ejemplo.com", "Arrendatario");
        PersonaModel persona3 = new PersonaModel("Pedro", "García", 456789123,"email@ejemplo.com", "Propietario");
        PersonaModel persona4 = new PersonaModel("Ana", "Martínez", 789123456,"email@ejemplo.com", "Arrendatario");
        PersonaModel persona5 = new PersonaModel("Luis", "Hernández", 321654987,"email@ejemplo.com", "Propietario");
        PersonaModel persona6 = new PersonaModel("Laura", "González", 654987321,"email@ejemplo.com", "Arrendatario");

        VehiculoModel vehiculo1 = new VehiculoModel(1,"Toyota", "Corolla", "Blanco");
        VehiculoModel vehiculo2 = new VehiculoModel(2,"Ford", "Fiesta", "Azul");
        VehiculoModel vehiculo3 = new VehiculoModel(3,"Honda", "Civic", "Rojo");
        VehiculoModel vehiculo4 = new VehiculoModel(4,"Chevrolet", "Spark", "Gris");
        VehiculoModel vehiculo5 = new VehiculoModel(5,"Nissan", "Sentra", "Blanco");
        VehiculoModel vehiculo6 = new VehiculoModel(6,"Volkswagen", "Jetta", "Negro");
        VehiculoModel vehiculo7 = new VehiculoModel(7,"Hyundai", "Accent", "Verde");
        VehiculoModel vehiculo8 = new VehiculoModel(8,"Mazda", "3", "Amarillo");
        VehiculoModel vehiculo9 = new VehiculoModel(9,"Kia", "Rio", "Marrón");
        VehiculoModel vehiculo10 = new VehiculoModel(10,"BMW", "Serie 3", "Blanco");
        departamento1.getPersonaModels().add(persona1);
        departamento2.getPersonaModels().add(persona2);
        departamento3.getPersonaModels().add(persona6);
        departamento4.getPersonaModels().add(persona4);
        departamento5.getPersonaModels().add(persona5);
        departamento5.getPersonaModels().add(persona3);

        departamento1.getVehiculoModels().add(vehiculo1);
        departamento1.getVehiculoModels().add(vehiculo2);
        departamento2.getVehiculoModels().add(vehiculo3);
        departamento2.getVehiculoModels().add(vehiculo4);
        departamento3.getVehiculoModels().add(vehiculo5);
        departamento3.getVehiculoModels().add(vehiculo6);
        departamento4.getVehiculoModels().add(vehiculo7);
        departamento4.getVehiculoModels().add(vehiculo8);
        departamento5.getVehiculoModels().add(vehiculo9);
        departamento5.getVehiculoModels().add(vehiculo10);*/

        DepartamantoModel departamento1 = new DepartamantoModel();
        DepartamantoModel departamento2 = new DepartamantoModel();
        DepartamantoModel departamento3 = new DepartamantoModel();
        DepartamantoModel departamento4 = new DepartamantoModel();
        DepartamantoModel departamento5 = new DepartamantoModel();
        DepartamantoModel departamantoModel = new DepartamantoModel();
        departamantoModel.setNumeroDepto(6);
        departamantoModel.setLetra("A");
        departamento1.setNumeroDepto(1);
        departamento2.setNumeroDepto(2);
        departamento3.setNumeroDepto(3);
        departamento4.setNumeroDepto(4);
        departamento5.setNumeroDepto(5);
        departamento1.setLetra("A");
        departamento2.setLetra("A");
        departamento3.setLetra("A");
        departamento4.setLetra("A");
        departamento5.setLetra("B");

        departamentoModels.add(departamento1);
        departamentoModels.add(departamento2);
        departamentoModels.add(departamento3);
        departamentoModels.add(departamento4);
        departamentoModels.add(departamento5);
        departamentoModels.add(departamantoModel);
    }

    public List<DepartamantoModel> getDepartamentoModels() {
        return departamentoModels;
    }

    public TablaModel tablaModelGenerator(List<DepartamantoModel> departamentos){
        TablaModel tablaModel = new TablaModel(departamentos);
        return tablaModel;
    }

    public void CreatePersona(String nombre, String apellido,Integer telefono,String email,String descripcion, Integer numeroDepto,String letra){
        PersonaModel personaModel = new PersonaModel(nombre,apellido,telefono,email,descripcion);

        for (DepartamantoModel departamento : departamentoModels) {
            if (Objects.equals(departamento.getNumeroDepto(), numeroDepto) && Objects.equals(departamento.getLetra(), letra)) {
                departamento.getPersonaModels().add(personaModel);
                break;
            }
        }
    }

    public  void  CreateVehiculo(Integer estacionamiento,String marca, String modelo, String color, Integer numero,String letra){
        VehiculoModel vehiculoModel = new VehiculoModel(estacionamiento,marca,modelo,color);

        for (DepartamantoModel departamento : departamentoModels) {
            if (Objects.equals(departamento.getNumeroDepto(), numero) && Objects.equals(departamento.getLetra(), letra)) {
                departamento.getVehiculoModels().add(vehiculoModel);
                break;
            }
        }
    }



    public void CreateDepartamento(String letra,Integer numero){
        DepartamantoModel departamantoModel = new DepartamantoModel();
        departamantoModel.setNumeroDepto(numero);
        departamantoModel.setLetra(letra);
        departamentoModels.add(departamantoModel);
    }


    public DepartamantoModel BuscarDepartamento(String letra,Integer numero){
        for (DepartamantoModel departamento : departamentoModels) {
            if (Objects.equals(departamento.getNumeroDepto(), numero) && Objects.equals(departamento.getLetra(), letra)) {
                return departamento;
            }
        }
        return null;
    }

    public void UpdatePersona(List<PersonaModel> newPersonas,Integer numeroDepto,String letra) {
        for (DepartamantoModel departamento: departamentoModels){
            if (Objects.equals(departamento.getNumeroDepto(), numeroDepto) && Objects.equals(departamento.getLetra(), letra)) {
                departamento.getPersonaModels().removeAll(departamento.getPersonaModels());
                departamento.getPersonaModels().addAll(newPersonas);
                break;
            }
        }
    }
    public void UpdateVehiculo(List<VehiculoModel> newVehiculos, Integer numeroDepto, String letra){
        for (DepartamantoModel departamento: departamentoModels){
            if (Objects.equals(departamento.getNumeroDepto(), numeroDepto) && Objects.equals(departamento.getLetra(), letra)) {
                departamento.getVehiculoModels().removeAll(departamento.getVehiculoModels());
                departamento.getVehiculoModels().addAll(newVehiculos);
                break;
            }
        }
    }

    public void DeletePersona(Integer telefono,Integer numeroDepto,String letra){
        for (DepartamantoModel departamento: departamentoModels){
            if (Objects.equals(departamento.getNumeroDepto(), numeroDepto) && Objects.equals(departamento.getLetra(), letra)) {
                for (PersonaModel persona: departamento.getPersonaModels()){
                    if (Objects.equals(persona.getTelefono(), telefono)){
                        departamento.getPersonaModels().remove(persona);
                        break;
                    }
                }
                break;
            }
        }
    }
    public void DeleteVehiculo(Integer estacionamiento,Integer numeroDepto, String letra){
        for (DepartamantoModel departamento: departamentoModels){
            if (Objects.equals(departamento.getNumeroDepto(), numeroDepto) && Objects.equals(departamento.getLetra(), letra)) {
                for (VehiculoModel vehiculoModel: departamento.getVehiculoModels()){
                    if (Objects.equals(vehiculoModel.getEstacionamiento(), estacionamiento)){
                        departamento.getVehiculoModels().remove(vehiculoModel);
                        break;
                    }
                }
                break;
            }
        }
    }
    public void DeleteDepartamento(Integer numeroDepto,String letra){
        for (DepartamantoModel departamento: departamentoModels){
            if (Objects.equals(departamento.getNumeroDepto(), numeroDepto) && Objects.equals(departamento.getLetra(), letra)){
                departamentoModels.remove(departamento);
                break;
            }
        }
    }

    public List<DepartamantoModel> BuscarDeptosString(String dato){
        List<DepartamantoModel> departamentoEncontrados = new ArrayList<>();
        for (DepartamantoModel departamento: departamentoModels){
            if (Objects.equals(departamento.getLetra(), dato)){
                departamentoEncontrados.add(departamento);
            }
            for (PersonaModel persona: departamento.getPersonaModels()){
                if (Objects.equals(persona.getNombre(), dato) || Objects.equals(persona.getApellido(), dato) || Objects.equals(persona.getDescripcion(), dato)){
                    departamentoEncontrados.add(departamento);
                }
            }
            for (VehiculoModel vehiculoModel: departamento.getVehiculoModels()){
                if (Objects.equals(vehiculoModel.getMarca(), dato)||Objects.equals(vehiculoModel.getModelo(), dato) || Objects.equals(vehiculoModel.getColor(), dato)){
                    departamentoEncontrados.add(departamento);
                }
            }
        }
        return departamentoEncontrados;
    }
    public List<DepartamantoModel> BuscarDeptosInteger(Integer dato){
        List<DepartamantoModel> departamentoEncontrados = new ArrayList<>();
        for (DepartamantoModel departamento: departamentoModels){
            if (Objects.equals(departamento.getNumeroDepto(), dato)){
                departamentoEncontrados.add(departamento);
            }
            for (PersonaModel persona: departamento.getPersonaModels()){
                if (Objects.equals(persona.getTelefono(), dato)){
                    departamentoEncontrados.add(departamento);
                }
            }
            for (VehiculoModel vehiculoModel: departamento.getVehiculoModels()){
                if (Objects.equals(vehiculoModel.getEstacionamiento(), dato)){
                    departamentoEncontrados.add(departamento);
                }
            }
        }
        return departamentoEncontrados;
    }

    public void GuardarDeptos(){
        String csvFilePath = "files/personas.csv";
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {

            for (DepartamantoModel departamantoModel:departamentoModels){
                for (PersonaModel personaModel:departamantoModel.getPersonaModels()){
                    String[] record1 = {departamantoModel.getLetra(),departamantoModel.getNumeroDepto().toString(),personaModel.getNombre(),personaModel.getApellido(),personaModel.getTelefono().toString(),personaModel.getEmail(),personaModel.getDescripcion()};
                    writer.writeNext(record1);
                }
            }

        } catch (IOException e) {
            System.err.println("Error al escribir el archivo CSV: " + e.getMessage());
        }
        String csvFilePath2 = "files/vehiculos.csv";
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath2))) {

            for (DepartamantoModel departamantoModel:departamentoModels){
                for (VehiculoModel vehiculoModel:departamantoModel.getVehiculoModels()){
                    String[] record1 = {departamantoModel.getLetra(),departamantoModel.getNumeroDepto().toString(),vehiculoModel.getMarca(),vehiculoModel.getModelo(),vehiculoModel.getColor(),vehiculoModel.getEstacionamiento().toString()};
                    writer.writeNext(record1);
                }
            }

        } catch (IOException e) {
            System.err.println("Error al escribir el archivo CSV: " + e.getMessage());
        }
    }

    public void CargarDeptos(){
        String csvFile = "Files/personas.csv";
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {


                String[] datos = line.split(csvSplitBy);

                // Extraer los datos necesarios
                String letra = datos[0].replace("\"", "");
                Integer numeroDepto = Integer.parseInt(datos[1].replace("\"", ""));
                String nombre = datos[2].replace("\"", "");
                String apellido = datos[3].replace("\"", "");
                Integer telefono = Integer.parseInt(datos[4].replace("\"", ""));
                String email = datos[5].replace("\"", "");
                String descripcion = datos[6].replace("\"", "");

                // Crear la persona y añadirla al departamento correspondiente
                CreatePersona(nombre, apellido, telefono, email, descripcion, numeroDepto, letra);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        String csvFile2 = "Files/vehiculos.csv";
        String line2;
        String csvSplitBy2 = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile2))) {

            while ((line2 = br.readLine()) != null) {


                String[] datos2 = line2.split(csvSplitBy2);

                // Extraer los datos necesarios
                String letra = datos2[0].replace("\"", "");
                Integer numeroDepto = Integer.parseInt(datos2[1].replace("\"", ""));
                String marca = datos2[2].replace("\"", "");
                String modelo = datos2[3].replace("\"", "");
                String color = datos2[4].replace("\"", "");
                Integer estacionamiento = Integer.parseInt(datos2[5].replace("\"", ""));

                // Crear la persona y añadirla al departamento correspondiente
                CreateVehiculo(estacionamiento,marca,modelo,color, numeroDepto, letra);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
