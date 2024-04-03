package persistencia.entidad;

public interface Almacenable {
    public String toString();
    public String toStrCsv();
    /**
     * Considerando que el objeto que implementa la 
     * interfaz ya tiene un contructor que no requiere
     * argumentos y ya se ya se ha instanciado un objeto,
     * esta clase recibiendo el strCsv guarda los datos
     * en los campos del objeto
     */
    public void fromStrCsv(String[] strCsvSplit);
}