package persistencia.repositorio;

import java.io.*;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.List;

import persistencia.entidad.*;

public class RepoProyecto extends Repositorio<Proyecto> {
    private static RepoProyecto instancia = null;

    public RepoProyecto() throws IOException {
        super("./Proyecto.csv");

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

    public static RepoProyecto getInstancia() throws IOException {
        if (instancia == null)
            instancia = new RepoProyecto();
        return instancia;
    }

    @Override
    public Proyecto fromStrCsv(String[] datos) {
        return new Proyecto(
                Integer.parseInt(datos[0]),
                datos[1],
                datos[2],
                LocalDate.parse(datos[3]),
                LocalDate.parse(datos[4]),
                Integer.parseInt(datos[5]));
    }

    public String toStrCsv(Proyecto r) {
        return r.getCodigo() + separador + r.getNombre() + separador + r.getDescipcion() + separador + r.getfInicio()
                + separador + r.getfFin() + separador + r.getJefe();
    }
}