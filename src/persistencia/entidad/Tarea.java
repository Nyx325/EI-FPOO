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
        this.codigo = strCsvSplit[0];
        //this.responsable = strCsvSplit[0];
        this.fInicio = LocalDate.parse(strCsvSplit[2]);
        this.fFin = LocalDate.parse(strCsvSplit[3]);
    }
}
