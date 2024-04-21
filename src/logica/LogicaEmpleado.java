package logica;

import java.io.IOException;
import java.util.*;

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
        List<Empleado> busqueda = new ArrayList<>();

        for(Empleado e:repo.getLista()){
            if(e.getNombre().equals(nombre)){
                busqueda.add(e);
            }
        }

        return busqueda;
    }

    public List<Empleado> buscar_por_telefono(String telefono){
        List<Empleado> busqueda = new ArrayList<>();

        for(Empleado e:repo.getLista()){
            if(e.getTelefono().equals(telefono)){
                busqueda.add(e);
            }
        }

        return busqueda;
    }
}
