package logica;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

import persistencia.entidad.Proyecto;
import persistencia.repositorio.RepoProyecto;

public class LogicaProyecto extends Logica<Proyecto> {
    public LogicaProyecto() throws IOException{
        repo = RepoProyecto.getInstancia();
    }

    public List<Proyecto> buscarPorNombre(String nombre){
        List<Proyecto> busqueda = new ArrayList<>();

        for(Proyecto p : repo.getLista()){
            if(p.getNombre().equals(nombre)){
                busqueda.add(p);
            }
        }

        return busqueda;
    }

    public List<Proyecto> buscarPorDescripcion(String descripcion){
        List<Proyecto> b = new ArrayList<>();

        for(Proyecto p : repo.getLista()){
            if(p.getDescipcion().equals(descripcion)){
                b.add(p);
            }
        }

        return b;
    }

    public List<Proyecto> buscarPorfInicio(LocalDate fInicio){
        List<Proyecto> b = new ArrayList<>();

        for(Proyecto p : repo.getLista()){
            if(p.getfInicio().equals(fInicio)){
                b.add(p);
            }
        }

        return b;
    }

    public List<Proyecto> buscarPorfFin(LocalDate fFin){
        List<Proyecto> b = new ArrayList<>();

        for(Proyecto p : repo.getLista()){
            if(p.getfFin().equals(fFin)){
                b.add(p);
            }
        }

        return b;
    }

    public List<Proyecto> buscarPorJefe(int jefe){
        List<Proyecto> b = new ArrayList<>();

        for(Proyecto p : repo.getLista()){
            if(p.getJefe()== jefe){
                b.add(p);
            }
        }

        return b;
    }
}
