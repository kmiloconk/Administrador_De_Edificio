package System.Models;

import java.util.ArrayList;
import java.util.List;

public class DepartamantoModel {
    private Integer numeroDepto;
    private List<PersonaModel> personaModels;
    private List<VehiculoModel> vehiculoModels;

    public DepartamantoModel(){
        this.personaModels = new ArrayList<>();
        this.vehiculoModels = new ArrayList<>();
    }

    public void setNumeroDepto(Integer numeroDepto) {
        if (numeroDepto >0)
            this.numeroDepto = numeroDepto;
    }

    public int getNumeroDepto() {
        return numeroDepto;
    }

    public List<PersonaModel> getPersonaModels() {
        return personaModels;
    }


    public List<VehiculoModel> getVehiculoModels() {
        return vehiculoModels;
    }
}
