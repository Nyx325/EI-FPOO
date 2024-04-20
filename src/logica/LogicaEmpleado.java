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

    public boolean add(Empleado obj) throws IOException{
        if(!buscar_por_telefono(obj.getTelefono()).isEmpty()){
            System.out.println("Ya existe un empleado con este teléfono");
            return false;
        }

        super.add(obj);
        return true;
    }

    public List<Empleado> buscar_por_nombre(String nombre){
        int contador = 1;
        List<Empleado> busqueda = new ArrayList<>();

        for(Empleado e:repo.getLista()){
            if(e.getNombre().equals(nombre))
            {
                busqueda.add(e);
                System.out.println(contador+") "+e);
                contador++;
            }
        }
        
        if(busqueda.isEmpty()) System.out.println("No se encontraron resultados");

        return busqueda;
    }

    public List<Empleado> buscar_por_telefono(String telefono){
        int contador = 1;
        List<Empleado> busqueda = new ArrayList<>();

        for(Empleado e:repo.getLista()){
            if(e.getTelefono().equals(telefono))
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
