package System;

import System.Models.DepartamantoModel;
import System.Models.PersonaModel;
import System.Models.VehiculoModel;

public class EjemploInicializacion {
    public static void main(String[] args) {
        // Crear instancias de personas y vehículos
        PersonaModel persona1 = new PersonaModel("Juan", "Perez", 123456789, "Empleado");
        PersonaModel persona2 = new PersonaModel("María", "López", 987654321, "Gerente");

        VehiculoModel vehiculo1 = new VehiculoModel("Toyota", "Corolla", "Blanco");
        VehiculoModel vehiculo2 = new VehiculoModel("Ford", "Fiesta", "Azul");

        // Crear instancia de DepartamentoModel
        DepartamantoModel departamento = new DepartamantoModel(1);

        // Agregar personas y vehículos al departamento
        departamento.getPersonaModels().add(persona1);
        departamento.getPersonaModels().add(persona2);

        departamento.getVehiculoModels().add(vehiculo1);
        departamento.getVehiculoModels().add(vehiculo2);

        departamento.getEstacionamiento().add(2);
        departamento.getEstacionamiento().add(1);


        // Mostrar el número del departamento
        System.out.println("Número de departamento: " + departamento.getNumero());

        // Mostrar la lista de personas y vehículos del departamento
        System.out.println("Personas en el departamento:");
        for (PersonaModel persona : departamento.getPersonaModels()) {
            System.out.println(persona.getNombre() + " " + persona.getApellido());
        }

        System.out.println("Vehículos en el departamento:");
        for (VehiculoModel vehiculo : departamento.getVehiculoModels()) {
            System.out.println(vehiculo.getMarca() + " " + vehiculo.getModelo() + " - " + vehiculo.getColor());
        }
        System.out.println("Estacionamientos del departamento: ");
        for (Integer estacionamiento : departamento.getEstacionamiento()) {
            System.out.println(estacionamiento +",");
        }
    }
}
