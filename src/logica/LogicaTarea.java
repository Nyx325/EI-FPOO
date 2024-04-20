package logica;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import persistencia.entidad.Tarea;
import persistencia.repositorio.RepoTarea;

public class LogicaTarea extends Logica<Tarea> {
    public static RepoTarea repo;

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

    public void modificar(Tarea t, Tarea tModificado) throws IOException {
        if (tModificado.getCodigo() != -1)
            t.setCodigo(tModificado.getCodigo());

        if (tModificado.getResponsable() != -1)
            t.setResponsable(tModificado.getResponsable());

        if(tModificado.getfInicio() != null)
            t.setfInicio(tModificado.getfInicio());

        if(tModificado.getfFin() != null)
            t.setfFin(tModificado.getfFin());

        repo.save();
    }
}
