package persistencia.entidad;

public interface Almacenable {
    public String toString();
    public String toStrCsv();
    public void fromStrCsv();
}