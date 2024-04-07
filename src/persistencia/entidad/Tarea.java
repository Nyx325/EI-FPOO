package persistencia.entidad;

import java.time.LocalDate;


public class Tarea implements Almacenable {
    protected String codigo;
    protected int responsable;
    protected LocalDate fInicio;
    protected LocalDate fFin;

    public Tarea() {
    }

    public Tarea(String codigo, int responsable, LocalDate fInicio, LocalDate fFin) {
        this.codigo = codigo;
        this.responsable = responsable;
        this.fInicio = fInicio;
        this.fFin = fFin;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getResponsable() {
        return responsable;
    }

    public void setResponsable(int responsable) {
        this.responsable = responsable;
    }

    public LocalDate getfInicio() {
        return fInicio;
    }

    public void setfInicio(LocalDate fInicio) {
        this.fInicio = fInicio;
    }

    public LocalDate getfFin() {
        return fFin;
    }

    public void setfFin(LocalDate fFin) {
        this.fFin = fFin;
    }

    @Override
    public String toString() {
        return codigo + " " + responsable + " " + fInicio + " " + fFin;
    }

    @Override
    public String toStrCsv() {
        return codigo + "," + responsable + "," + fInicio + "," + fFin + ",";
    }

    @Override
    public void fromStrCsv(String[] strCsvSplit) {
        this.codigo = strCsvSplit[0];
        this.responsable = Integer.parseInt(strCsvSplit[0]);
        this.fInicio = LocalDate.parse(strCsvSplit[2]);
        this.fFin = LocalDate.parse(strCsvSplit[3]);
    }    
}
