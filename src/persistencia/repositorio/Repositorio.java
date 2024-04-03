package persistencia.repositorio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import persistencia.entidad.Almacenable;

public abstract class Repositorio {
    protected List<Almacenable> lista;
    protected String pathArchivo;

    public List<Almacenable> getLista(){
        return lista;
    }

    public void mostrar(){
        for (Almacenable registro : lista) {
            System.out.println(registro);
        }
    }

    public void add(Almacenable registro){
        lista.add(registro);
    }

    public void remove(Almacenable registro){
        lista.remove(registro);
    }

    /**
     * ¿Por que hago guardar en el repo generico/clase abstracta?
     * Como la lista almacena objetos que implementen la interfaz
     * Almacenable, sabemos que tienen el metodo que devuelve la 
     * cadena que vamos a escrbir, y como la interfaz se dice que
     * es un "contrato", haces el contrado de que todo lo que quieras
     * almacenar si o si debe tener ese método
     * @throws IOException
     */
    public void save() throws IOException {
        File arch = new File(pathArchivo);
        FileWriter fWriter = new FileWriter(arch);
        PrintWriter pWriter = new PrintWriter(fWriter);

        for (Almacenable registro : lista) {
            String strCsv = registro.toStrCsv(); //lo separa por comas
            pWriter.append(strCsv);
        }

        pWriter.close();
        fWriter.close();
    }
}
