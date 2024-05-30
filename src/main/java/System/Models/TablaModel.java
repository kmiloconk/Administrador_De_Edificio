package System.Models;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TablaModel extends AbstractTableModel {
    private final List<RowData> rowDataList = new ArrayList<>();
    private final String[] columnNames = {"Número Departamento", "Nombre", "Apellido", "Teléfono", "Descripción", "Vehículo Marca", "Vehículo Modelo", "Vehículo Color", "Número estacionamiento"};
    private int currentDepartmentNumber = -1;

    public TablaModel(List<DepartamantoModel> departamentos) {
        Collections.sort(departamentos, new Comparator<DepartamantoModel>() {
            @Override
            public int compare(DepartamantoModel d1, DepartamantoModel d2) {
                return Integer.compare(d1.getNumeroDepto(), d2.getNumeroDepto());
            }
        });
        for (DepartamantoModel departamento : departamentos) {
            List<PersonaModel> personas = departamento.getPersonaModels();
            List<VehiculoModel> vehiculos = departamento.getVehiculoModels();
            int numPersonas = personas.size();
            int numVehiculos = vehiculos.size();
            int max = Math.max(numPersonas, numVehiculos);

            for (int i = 0; i < max; i++) {
                PersonaModel persona = i < numPersonas ? personas.get(i) : null;
                VehiculoModel vehiculo = i < numVehiculos ? vehiculos.get(i) : null;

                // Añadir el número de departamento solo para la primera fila de cada departamento
                if (currentDepartmentNumber != departamento.getNumeroDepto()) {
                    rowDataList.add(new RowData(departamento, persona, vehiculo));
                    currentDepartmentNumber = departamento.getNumeroDepto();
                } else {
                    rowDataList.add(new RowData(null, persona, vehiculo)); // Si no es la primera fila, agregar nulo
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
                return rowData.departamento != null ? rowData.departamento.getNumeroDepto() : ""; // Mostrar número de departamento solo en la primera fila
            case 1:
                return rowData.persona != null ? rowData.persona.getNombre() : "";
            case 2:
                return rowData.persona != null ? rowData.persona.getApellido() : "";
            case 3:
                return rowData.persona != null ? rowData.persona.getTelefono() : "";
            case 4:
                return rowData.persona != null ? rowData.persona.getDescripcion() : "";
            case 5:
                return rowData.vehiculo != null ? rowData.vehiculo.getMarca() : "";
            case 6:
                return rowData.vehiculo != null ? rowData.vehiculo.getModelo() : "";
            case 7:
                return rowData.vehiculo != null ? rowData.vehiculo.getColor() : "";
            case 8:
                return rowData.vehiculo != null ? rowData.vehiculo.getEstacionamiento() : "";
            default:
                throw new IndexOutOfBoundsException("Columna no válida");
        }
    }

    private static class RowData {
        private final DepartamantoModel departamento;
        private final PersonaModel persona;
        private final VehiculoModel vehiculo;

        public RowData(DepartamantoModel departamento, PersonaModel persona, VehiculoModel vehiculo) {
            this.departamento = departamento;
            this.persona = persona;
            this.vehiculo = vehiculo;
        }
    }
}
