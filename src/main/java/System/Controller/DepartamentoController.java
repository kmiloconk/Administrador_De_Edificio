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
        for (int i =1; i<=50;i++){
            DepartamantoModel departamantoModel = new DepartamantoModel();
            departamantoModel.setLetra("A");
            if(i<=10){
                departamantoModel.setNumeroDepto(100+i);
                departamentoModels.add(departamantoModel);
            }else if (i<=20){
                departamantoModel.setNumeroDepto(200+i-10);
                departamentoModels.add(departamantoModel);
            }else if (i<=30){
                departamantoModel.setNumeroDepto(300+i-20);
                departamentoModels.add(departamantoModel);
            }else if (i<=40){
                departamantoModel.setNumeroDepto(400+i-30);
                departamentoModels.add(departamantoModel);
            }else if (i<=50){
                departamantoModel.setNumeroDepto(500+i-40);
                departamentoModels.add(departamantoModel);
            }
        }
        for (int i =1; i<=50;i++){
            DepartamantoModel departamantoModel = new DepartamantoModel();
            departamantoModel.setLetra("B");
            if(i<=10){
                departamantoModel.setNumeroDepto(100+i+10);
                departamentoModels.add(departamantoModel);
            }else if (i<=20){
                departamantoModel.setNumeroDepto(200+i);
                departamentoModels.add(departamantoModel);
            }else if (i<=30){
                departamantoModel.setNumeroDepto(300+i-10);
                departamentoModels.add(departamantoModel);
            }else if (i<=40){
                departamantoModel.setNumeroDepto(400+i-20);
                departamentoModels.add(departamantoModel);
            }else if (i<=50){
                departamantoModel.setNumeroDepto(500+i-30);
                departamentoModels.add(departamantoModel);
            }
        }

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

    public void Recet(){
        for (DepartamantoModel departamantoModel: departamentoModels){
            departamantoModel.getPersonaModels().clear();
            departamantoModel.getVehiculoModels().clear();
        }
    }

}
