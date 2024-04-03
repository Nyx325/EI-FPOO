package persistencia.entidad;

import java.time.LocalDate;

public class Tarea implements Almacenable {
    protected String codigo;
    protected Empleado responsable;
    protected LocalDate fInicio;
    protected LocalDate fFin;

    @Override
    public String toString() {
        return codigo + " " + responsable.toString() + " " + fInicio + " " + fFin;
    }

    @Override
    public String toStrCsv() {
        return codigo + "," + responsable.toString() + "," + fInicio + "," + fFin + ",";
    }

    @Override
    public void fromStrCsv(String[] strCsvSplit) {
        
    }
}
