package persistencia.entidad;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Proyecto implements Almacenable {
    private int codigo;
    private String nombre;
    private String descipcion;
    private LocalDate fInicio;
    private LocalDate fFin;
    private int jefe;
    private List<Tarea> tareas;

    public Proyecto(){}

    public Proyecto(int codigo, String nombre, String descipcion, LocalDate fInicio, LocalDate fFin, int jefe) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descipcion = descipcion;
        this.fInicio = fInicio;
        this.fFin = fFin;
        this.jefe = jefe;
        this.tareas = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescipcion() {
        return descipcion;
    }
    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
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
    public int getJefe() {
        return jefe;
    }
    public void setJefe(int jefe) {
        this.jefe = jefe;
    }

    @Override
    public String toString() {
        // TODO buscar jefe o algo asi para imprimirlo
        return codigo+" "+nombre+" "+descipcion+" "+fInicio+" "+fFin;
    }
    @Override
    public void fromStrCsv(String[] strCsvSplit) {
        this.codigo = Integer.parseInt(strCsvSplit[0]);
        this.nombre = strCsvSplit[1];
        this.descipcion = strCsvSplit[2];
        this.fInicio = LocalDate.parse(strCsvSplit[3]);
        this.fFin = LocalDate.parse(strCsvSplit[4]);
        this.jefe = Integer.parseInt(strCsvSplit[5]);
    }
    @Override
    public String toStrCsv() {
        return codigo+","+nombre+","+descipcion+","+fInicio+","+fFin+","+jefe;
    }
    
    
}
