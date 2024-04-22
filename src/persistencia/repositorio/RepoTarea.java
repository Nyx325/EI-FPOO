package persistencia.repositorio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.List;

import persistencia.entidad.Tarea;

public class RepoTarea extends Repositorio<Tarea> {
    private static RepoTarea instancia = null;

    private RepoTarea() throws IOException {
        super("./Tarea.csv");

        try {
            File arch = new File(this.pathArchivo);
            List<String> regCsv = Files.readAllLines(arch.toPath());

            for (String r : regCsv) {
                this.add(fromStrCsv(r.split(separador)));
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

    @Override
    public Tarea fromStrCsv(String[] datos) {
        return new Tarea(
                Integer.parseInt(datos[0]),
                Integer.parseInt(datos[1]),
                Integer.parseInt(datos[2]),
                LocalDate.parse(datos[3]),
                LocalDate.parse(datos[4])
        );
    }

    @Override
    public String toStrCsv(Tarea r) {
        return r.getCodigo()+separador+r.getResponsable()+separador+r.getProyecto()+separador+r.getfInicio()+separador+r.getfFin()+"\n";
    }
}
