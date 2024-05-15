package System.Models;
import System.Models.PersonaModel;
import System.Models.VehiculoModel;

import java.util.ArrayList;
import java.util.List;

public class DepartamantoModel {
    private int numero;
    private List<Integer> estacionamiento;
    private List<PersonaModel> personaModels;
    private List<VehiculoModel> vehiculoModels;

    public DepartamantoModel(int numero){
        this.estacionamiento = new ArrayList<>();
        this.personaModels = new ArrayList<>();
        this.vehiculoModels = new ArrayList<>();
    }

    public void setNumero(int numero) {
        if (numero>0)
            this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public List<PersonaModel> getPersonaModels() {
        return personaModels;
    }

    public List<Integer> getEstacionamiento() {
        return estacionamiento;
    }

    public List<VehiculoModel> getVehiculoModels() {
        return vehiculoModels;
    }
}
