package logica;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import persistencia.entidad.Tarea;
import persistencia.repositorio.RepoTarea;

public class LogicaTarea extends Logica<Tarea> {
    public LogicaTarea() throws IOException{
        repo = RepoTarea.getInstancia();
    }

    public List<Tarea> buscar_por_responsable(int responsable){
        List<Tarea> busqueda = new ArrayList<>();
        for (Tarea tarea : repo.getLista()) {
            if(tarea.getResponsable() == responsable){
                busqueda.add(tarea);
            }
        }

        return busqueda;
    }

    public List<Tarea> buscar_por_fInicio(LocalDate fInicio){
        List<Tarea> b = new ArrayList<>();
        for(Tarea t:repo.getLista()){
            if(t.getfInicio().equals(fInicio)){
                b.add(t);
            }
        }

        return b;
    }

    public List<Tarea> buscar_por_fFin(LocalDate fFin){
        List<Tarea> b = new ArrayList<>();
        for(Tarea t:repo.getLista()){
            if(t.getfFin().equals(fFin)){
                b.add(t);
            }
        }

        return b;
    }

    public void dropPorProyecto(int idPro) throws IOException{
        List<Tarea> borrados = new ArrayList<>();
        System.out.println("Id pro: "+idPro);
        System.out.println(repo.getLista().size());
        for(Tarea t : repo.getLista()){
            System.out.println("Id tar: "+t.getProyecto());
            if(t.getProyecto() == idPro){
                System.out.println("Borrao");
                borrados.add(t);
            }
        }

        for(Tarea t : borrados){
            repo.remove(t);
        }

        repo.save();
    }
}
