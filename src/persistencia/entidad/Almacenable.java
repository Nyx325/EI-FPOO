package persistencia.entidad;

public interface Almacenable {
    /** Getter del identificador único que debe tener un almacenable */
    public int getCodigo();
    /** Setter del identificador único que debe tener un almacenable */
    public void setCodigo(int codigo);
    
    public String toString();

    /**
     * Genera la separacion de los atributos de un objeto
     * separado por comas
     */
    public String toStrCsv();
    
    /**
     * Considerando que el objeto que implementa la 
     * interfaz ya tiene un contructor que no requiere
     * argumentos y ya se ya se ha instanciado un objeto,
     * esta clase recibiendo el strCsv guarda los datos
     * en los campos del objeto
     * @param strCsvSplit la cadena producida por toStrCsv
     * que es almacenada en el csv
     */
    public void fromStrCsv(String[] strCsvSplit);
    public boolean equals();
}
