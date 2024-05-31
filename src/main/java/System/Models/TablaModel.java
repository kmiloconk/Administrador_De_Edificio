package System.Models;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TablaModel extends AbstractTableModel {
    private final List<RowData> rowDataList = new ArrayList<>();
    private final String[] columnNames = {"Departamento", "Propietario", "Arrendatario", "Vehículo", "Estacionamiento"};
    private int currentDepartmentNumber = -1;

    public TablaModel(List<DepartamantoModel> departamentos) {
        // Sort departments by department number
        Collections.sort(departamentos, Comparator.comparingInt(DepartamantoModel::getNumeroDepto));

        // Populate row data list
        for (DepartamantoModel departamento : departamentos) {
            List<PersonaModel> personas = departamento.getPersonaModels();
            List<VehiculoModel> vehiculos = departamento.getVehiculoModels();

            List<String> propietarios = new ArrayList<>();
            List<String> arrendatarios = new ArrayList<>();
            for (PersonaModel persona : personas) {
                if ("Propietario".equalsIgnoreCase(persona.getDescripcion())) {
                    propietarios.add(persona.getNombre() + " " + persona.getApellido() + " | " + persona.getTelefono() + " | " + persona.getEmail());
                } else if ("Arrendatario".equalsIgnoreCase(persona.getDescripcion())) {
                    arrendatarios.add(persona.getNombre() + " " + persona.getApellido() + " | " + persona.getTelefono() + " | " + persona.getEmail());
                }
            }

            int numPropietarios = propietarios.size();
            int numArrendatarios = arrendatarios.size();
            int numVehiculos = vehiculos.size();
            int max1 = Math.max(numPropietarios, numVehiculos);
            int max2 = Math.max(max1,numArrendatarios);


            if (vehiculos.isEmpty()) {
                for (int i = 0; i < max2; i++){
                    String propietario = i < numPropietarios ? propietarios.get(i) : null;
                    String arrendatario = i< numArrendatarios? arrendatarios.get(i):null;
                    String numerDepto = departamento.getNumeroDepto().toString();
                    if (currentDepartmentNumber != departamento.getNumeroDepto()) {
                        rowDataList.add(new RowData(numerDepto,propietario, arrendatario, "", ""));
                        currentDepartmentNumber = departamento.getNumeroDepto();
                    } else {
                        rowDataList.add(new RowData(null, propietario, arrendatario, "", ""));
                    }
                }
            }else {
                for (int i = 0; i < max2; i++){
                    String propietario = i < numPropietarios ? propietarios.get(i) : null;
                    String arrendatario = i< numArrendatarios? arrendatarios.get(i):null;
                    VehiculoModel vehiculo = i < numVehiculos ? vehiculos.get(i) : null;
                    String numerDepto = departamento.getNumeroDepto().toString();
                    if (vehiculo==null){
                        if (currentDepartmentNumber != departamento.getNumeroDepto()) {
                            rowDataList.add(new RowData(numerDepto,propietario, arrendatario, "", ""));
                            currentDepartmentNumber = departamento.getNumeroDepto();
                        } else {
                            rowDataList.add(new RowData(null, propietario, arrendatario, "", ""));
                        }
                    }else {
                        String vehiculoInfo = vehiculo.getMarca() + " | " + vehiculo.getModelo() + " | " + vehiculo.getColor();
                        String estacionamiento = vehiculo.getEstacionamiento().toString();

                        if (currentDepartmentNumber != departamento.getNumeroDepto()) {
                            rowDataList.add(new RowData(numerDepto, propietario, arrendatario, vehiculoInfo, estacionamiento));
                            currentDepartmentNumber = departamento.getNumeroDepto();
                        } else {
                            rowDataList.add(new RowData(null, propietario, arrendatario, vehiculoInfo, estacionamiento));
                        }
                    }
                }
            }


        }
    }

    @Override
    public int getRowCount() {
        return rowDataList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RowData rowData = rowDataList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowData.numeroDepartamento!= null ? rowData.numeroDepartamento : "";
            case 1:
                return rowData.propietario!= null ? rowData.propietario : "";
            case 2:
                return rowData.arrendatario!= null ? rowData.arrendatario : "";
            case 3:
                return rowData.vehiculo!= null ? rowData.vehiculo : "";
            case 4:
                return rowData.estacionamiento;
            default:
                throw new IndexOutOfBoundsException("Columna no válida");
        }
    }

    private static class RowData {
        private final String numeroDepartamento;
        private final String propietario;
        private final String arrendatario;
        private final String vehiculo;
        private final String estacionamiento;

        public RowData(String numeroDepartamento, String propietario, String arrendatario, String vehiculo, String estacionamiento) {
            this.numeroDepartamento = numeroDepartamento;
            this.propietario = propietario;
            this.arrendatario = arrendatario;
            this.vehiculo = vehiculo;
            this.estacionamiento = estacionamiento;
        }
    }
}
