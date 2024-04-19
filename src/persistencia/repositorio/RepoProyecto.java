package persistencia.repositorio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import persistencia.entidad.Proyecto;

public class RepoProyecto extends Repositorio<Proyecto>{
    private static RepoProyecto instancia = null;

    private RepoProyecto() throws IOException{
        super("./Proyecto.csv");

        try {
            File arch = new File(this.pathArchivo);
            List<String> regCsv = Files.readAllLines(arch.toPath());
            
            for (String r : regCsv) {
                var e = new Proyecto();
                e.fromStrCsv(r.split(this.separador));
                this.add(e);
            }
        } catch (IOException e) {
            this.save();
        }
    }

    @Override
    public RepoProyecto getInstancia() throws IOException {
        if(instancia == null)
            instancia = new RepoProyecto();
        return instancia;
    }
    
}
