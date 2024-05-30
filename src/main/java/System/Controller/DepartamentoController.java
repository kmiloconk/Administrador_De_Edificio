package System.Controller;
import System.Models.DepartamantoModel;
import System.Models.PersonaModel;
import System.Models.TablaModel;
import System.Models.VehiculoModel;

import java.util.*;

public class DepartamentoController {
    private List<DepartamantoModel> departamentoModels;
    public DepartamentoController(){
        this.departamentoModels = new ArrayList<>();
    }

    public void GenerarEjemplo(){
        PersonaModel persona1 = new PersonaModel("Juan", "Perez", 123456789, "Propietario");
        PersonaModel persona2 = new PersonaModel("María", "López", 987654321, "Arrendatario");
        PersonaModel persona3 = new PersonaModel("Pedro", "García", 456789123, "Propietario");
        PersonaModel persona4 = new PersonaModel("Ana", "Martínez", 789123456, "Arrendatario");
        PersonaModel persona5 = new PersonaModel("Luis", "Hernández", 321654987, "Propietario");
        PersonaModel persona6 = new PersonaModel("Laura", "González", 654987321, "Arrendatario");

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

        DepartamantoModel departamento1 = new DepartamantoModel();
        DepartamantoModel departamento2 = new DepartamantoModel();
        DepartamantoModel departamento3 = new DepartamantoModel();
        DepartamantoModel departamento4 = new DepartamantoModel();
        DepartamantoModel departamento5 = new DepartamantoModel();

        departamento1.setNumeroDepto(1);
        departamento2.setNumeroDepto(2);
        departamento3.setNumeroDepto(3);
        departamento4.setNumeroDepto(4);
        departamento5.setNumeroDepto(5);

        departamento1.getPersonaModels().add(persona1);
        departamento2.getPersonaModels().add(persona2);
        departamento3.getPersonaModels().add(persona3);
        departamento4.getPersonaModels().add(persona4);
        departamento5.getPersonaModels().add(persona5);
        departamento5.getPersonaModels().add(persona6);

        departamento1.getVehiculoModels().add(vehiculo1);
        departamento1.getVehiculoModels().add(vehiculo2);
        departamento2.getVehiculoModels().add(vehiculo3);
        departamento2.getVehiculoModels().add(vehiculo4);
        departamento3.getVehiculoModels().add(vehiculo5);
        departamento3.getVehiculoModels().add(vehiculo6);
        departamento4.getVehiculoModels().add(vehiculo7);
        departamento4.getVehiculoModels().add(vehiculo8);
        departamento5.getVehiculoModels().add(vehiculo9);
        departamento5.getVehiculoModels().add(vehiculo10);

        departamentoModels.add(departamento1);
        departamentoModels.add(departamento2);
        departamentoModels.add(departamento3);
        departamentoModels.add(departamento4);
        departamentoModels.add(departamento5);
    }

    public List<DepartamantoModel> getDepartamentoModels() {
        return departamentoModels;
    }

    public TablaModel tablaModelGenerator(List<DepartamantoModel> departamentos){
        TablaModel tablaModel = new TablaModel(departamentos);
        return tablaModel;
    }

    public void CreatePersona(String nombre, String apellido,Integer telefono,String descripcion, Integer numeroDepto){
        PersonaModel personaModel = new PersonaModel(nombre,apellido,telefono,descripcion);

        for (DepartamantoModel departamento : departamentoModels) {
            if (Objects.equals(departamento.getNumeroDepto(), numeroDepto)) {
                departamento.getPersonaModels().add(personaModel);
                break;
            }
        }
    }

    public  void  CreateVehiculo(Integer estacionamiento,String marca, String modelo, String color, Integer numero){
        VehiculoModel vehiculoModel = new VehiculoModel(estacionamiento,marca,modelo,color);

        for (DepartamantoModel departamento : departamentoModels) {
            if (Objects.equals(departamento.getNumeroDepto(), numero)) {
                departamento.getVehiculoModels().add(vehiculoModel);
                break;
            }
        }
    }



    public void CreateDepartamento(Integer numero){
        DepartamantoModel departamantoModel = new DepartamantoModel();
        departamantoModel.setNumeroDepto(numero);
        departamentoModels.add(departamantoModel);
    }


    public DepartamantoModel BuscarDepartamento(Integer numero){
        for (DepartamantoModel departamento : departamentoModels) {
            if (Objects.equals(departamento.getNumeroDepto(), numero)) {
                return departamento;
            }
        }
        return null;
    }

    public void UpdatePersona(List<PersonaModel> newPersonas,Integer numeroDepto) {
        for (DepartamantoModel departamento: departamentoModels){
            if (Objects.equals(departamento.getNumeroDepto(), numeroDepto)) {
                departamento.getPersonaModels().removeAll(departamento.getPersonaModels());
                departamento.getPersonaModels().addAll(newPersonas);
                break;
            }
        }
    }
    public void UpdateVehiculo(List<VehiculoModel> newVehiculos, Integer numeroDepto){
        for (DepartamantoModel departamento: departamentoModels){
            if (Objects.equals(departamento.getNumeroDepto(), numeroDepto)) {
                departamento.getVehiculoModels().removeAll(departamento.getVehiculoModels());
                departamento.getVehiculoModels().addAll(newVehiculos);
                break;
            }
        }
    }

    public void DeletePersona(Integer telefono,Integer numeroDepto){
        for (DepartamantoModel departamento: departamentoModels){
            if (Objects.equals(departamento.getNumeroDepto(), numeroDepto)) {
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
    public void DeleteVehiculo(Integer estacionamiento,Integer numeroDepto){
        for (DepartamantoModel departamento: departamentoModels){
            if (Objects.equals(departamento.getNumeroDepto(), numeroDepto)) {
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
    public void DeleteDepartamento(Integer numeroDepto){
        for (DepartamantoModel departamento: departamentoModels){
            if (Objects.equals(departamento.getNumeroDepto(), numeroDepto)){
                departamentoModels.remove(departamento);
                break;
            }
        }
    }

    public List<DepartamantoModel> BuscarDeptosString(String dato){
        List<DepartamantoModel> departamentoEncontrados = new ArrayList<>();
        for (DepartamantoModel departamento: departamentoModels){
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

}
