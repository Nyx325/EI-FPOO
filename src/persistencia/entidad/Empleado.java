package persistencia.entidad;

public class Empleado implements Almacenable{
    private int codigo = -1;
    private String nombre = null;
    private String apellidoP = null;
    private String apellidoM = null;
    private String direccion = null;
    private String telefono = null;

    public Empleado(){}

    public Empleado(int codigo, String nombre, String apellidoP, String apellidoM, String direccion, String telefono){
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.direccion = direccion;
        this.telefono = telefono;
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

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    @Override
    public String toString() {
        return codigo+" "+nombre+" "+apellidoP+" "+apellidoM+" "+direccion+" "+telefono;
    }

    @Override
    public String toStrCsv() {
        return codigo+","+nombre+","+apellidoP+","+apellidoM+","+direccion+","+telefono+"\n";
    }

    @Override
    public void fromStrCsv(String[] strCsvSplit) {
        this.codigo = Integer.parseInt(strCsvSplit[0]);
        this.nombre = strCsvSplit[1];
        this.apellidoP = strCsvSplit[2];
        this.apellidoM = strCsvSplit[3];
        this.direccion = strCsvSplit[4];
        this.telefono = strCsvSplit[5];
    }
}
