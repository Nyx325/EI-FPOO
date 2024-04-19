package persistencia.repositorio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import persistencia.entidad.Tarea;

public class RepoTarea extends Repositorio<Tarea> {
    private static RepoTarea instancia;

    private RepoTarea() throws IOException {
        super("./Tarea.csv");

        try {
            File arch = new File(this.pathArchivo);
            List<String> regCsv = Files.readAllLines(arch.toPath());
            
            for (String r : regCsv) {
                var t = new Tarea();
                t.fromStrCsv(r.split(this.separador));
                this.add(t);
            }
        } catch (IOException e) {
            this.save();
        }

    }

    public static RepoTarea getInstancia() throws IOException{
        if(instancia == null)
            instancia = new RepoTarea();
        return instancia;
    }
}
