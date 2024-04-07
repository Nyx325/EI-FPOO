package persistencia.repositorio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import persistencia.entidad.Almacenable;

public abstract class Repositorio<T extends Almacenable> {
    protected List<T> lista;
    protected String pathArchivo;

    public List<T> getLista(){
        return lista;
    }

    public void mostrar(){
        for (T registro : lista) {
            System.out.println(registro);
        }
    }

    public void add(T registro){
        lista.add(registro);
    }

    public void remove(T registro){
        lista.remove(registro);
    }

    public void save() throws IOException {
        File arch = new File(pathArchivo);
        FileWriter fWriter = new FileWriter(arch);
        PrintWriter pWriter = new PrintWriter(fWriter);

        for (T registro : lista) {
            pWriter.append(registro.toStrCsv());
        }

        pWriter.close();
        fWriter.close();
    }
}
