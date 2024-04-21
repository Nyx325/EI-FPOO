package persistencia.repositorio;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

import persistencia.entidad.Usuario;

public class RepoUsuario extends Repositorio<Usuario>{
    public RepoUsuario() throws IOException{
        super("./Usr.csv");

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

    public String toStrCsv(Usuario u){
        return u.getUsuario()+separador+u.getContrasenia()+separador+u.isAdmin()+"\n";
    }

    public Usuario fromStrCsv(String[] datos){
        return new Usuario(
            datos[0],
            datos[1],
            Boolean.parseBoolean(datos[2])
        );
    }
}
