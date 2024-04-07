package persistencia.repositorio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import persistencia.entidad.Empleado;

public class RepoEmpleado extends Repositorio{
    public RepoEmpleado() throws IOException {
        this.pathArchivo = "Empleado.csv";
        this.lista = new ArrayList<>();

        try {
            File arch = new File(this.pathArchivo);
            List<String> regCsv = Files.readAllLines(arch.toPath());
            
            for (String r : regCsv) {
                var e = new Empleado();
                e.fromStrCsv(r.split(","));
                this.add(e);
            }
        } catch (IOException e) {
            this.save();
        }
    }
}