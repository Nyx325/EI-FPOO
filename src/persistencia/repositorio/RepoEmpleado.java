package persistencia.repositorio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import persistencia.entidad.Empleado;

public class RepoEmpleado extends Repositorio<Empleado>{
    private static RepoEmpleado instancia = null;

    private RepoEmpleado() throws IOException {
        super("./Empleado.csv");

        try {
            File arch = new File(this.pathArchivo);
            List<String> regCsv = Files.readAllLines(arch.toPath());
            
            for (String r : regCsv) {
                var e = new Empleado();
                e.fromStrCsv(r.split(this.separador));
                this.add(e);
            }
        } catch (IOException e) {
            this.save();
        }
    }

    public static RepoEmpleado getInstancia() throws IOException{
        if(instancia == null)
            instancia = new RepoEmpleado();
        return instancia;
    }
}
