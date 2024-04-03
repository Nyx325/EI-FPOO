package persistencia.repositorio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import persistencia.entidad.Tarea;

public class RepoTarea extends Repositorio {
    public RepoTarea() throws IOException {
        this.pathArchivo = "Tarea.csv";
        this.lista = new ArrayList<>();

        try {
            File arch = new File(this.pathArchivo);
            List<String> regCsv = Files.readAllLines(arch.toPath());
            
            for (String r : regCsv) {
                var t = new Tarea();
                t.fromStrCsv(r.split(","));
                this.add(t);
            }
        } catch (IOException e) {
            this.save();
        }

    }
}
