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

    public void save() throws IOException {
        File arch = new File(pathArchivo);
        FileWriter fWriter = new FileWriter(arch);
        PrintWriter pWriter = new PrintWriter(fWriter);

        for (Almacenable registro : lista) {
            pWriter.append(registro.toStrCsv());
        }

        pWriter.close();
        fWriter.close();
    }
}
