package logica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import persistencia.entidad.Empleado;
import persistencia.repositorio.RepoEmpleado;

public class LogicaEmpleado extends Logica<Empleado>{
    public LogicaEmpleado() throws IOException {
        repo = RepoEmpleado.getInstancia();
    }

    public List<Empleado> buscar_por_nombre(Empleado obj){
        int contador = 1;
        List<Empleado> busqueda = new ArrayList<>();

        for(Empleado e:repo.getLista()){
            if
            (
                e.getNombre().equals(obj.getNombre()) &&
                e.getApellidoP().equals(obj.getApellidoP()) &&
                e.getApellidoM().equals(obj.getApellidoM())
            )
            {
                busqueda.add(e);
                System.out.println(contador+") "+e);
                contador++;
            }
        }
        
        if(busqueda.isEmpty()) System.out.println("No se encontraron resultados");

        return busqueda;
    }
}
