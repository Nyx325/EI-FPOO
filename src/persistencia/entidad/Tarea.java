package persistencia.entidad;

import java.time.LocalDate;


public class Tarea implements Almacenable {
    protected int codigo = -1;
    protected int responsable = -1;
    protected LocalDate fInicio = null;
    protected LocalDate fFin = null;

    public Tarea() {
        this.codigo = -1;
        this.responsable = -1;
        this.fInicio = null;
        this.fFin = null;
    }

    public Tarea(int responsable, LocalDate fInicio, LocalDate fFin) {
        this.codigo = -1;
        this.responsable = responsable;
        this.fInicio = fInicio;
        this.fFin = fFin;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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
        this.codigo = Integer.parseInt(strCsvSplit[0]);
        this.responsable = Integer.parseInt(strCsvSplit[1]);
        this.fInicio = LocalDate.parse(strCsvSplit[2]);
        this.fFin = LocalDate.parse(strCsvSplit[3]);
    }    

    public boolean equals(Tarea t){
        return this.responsable == t.responsable && this.fInicio == t.fInicio && this.fFin == t.fFin;
    }
}
