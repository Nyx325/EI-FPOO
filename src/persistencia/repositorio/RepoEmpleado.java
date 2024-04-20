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
                this.add(fromStrCsv(r.split(separador)));
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

    public String toStrCsv(Empleado e) {
        return e.getCodigo()+separador+e.getNombre()+separador+e.getApellidoP()+separador+e.getApellidoM()+separador+e.getDireccion()+separador+e.getTelefono()+"\n";
    }

    public Empleado fromStrCsv(String[] datos){
        return new Empleado(
                Integer.parseInt(datos[0]),
                datos[1],
                datos[2],
                datos[3],
                datos[4],
                datos[5]
        );
    }
}
