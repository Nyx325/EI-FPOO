package logica;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import persistencia.entidad.Tarea;
import persistencia.repositorio.RepoTarea;

public class LogicaTarea extends Logica<Tarea> {
    public static RepoTarea repo;

    public LogicaTarea(String pathArchivo) throws IOException{
        repo = RepoTarea.getInstancia();
    }

    public List<Tarea> buscar_por_responsable(int responsable){
        long contador = 1;
        List<Tarea> busqueda = new ArrayList<>();
        for (Tarea tarea : repo.getLista()) {
            if(tarea.getResponsable() == responsable){
                busqueda.add(tarea);
                System.out.println(contador+") "+tarea);
                contador++;
            }
        }

        if(busqueda.isEmpty()) System.out.println("No se encontraron resultados");

        return busqueda;
    }

    /**
     * @param Fecha inicio de la tarea a buscar
     * @return si no se encuentran valores devuelve una lista
     * vacía */
    public List<Tarea> buscar_por_fInicio(LocalDate fInicio){
        long contador = 1;
        List<Tarea> b = new ArrayList<>();
        for(Tarea t:repo.getLista()){
            if(t.getfInicio().equals(fInicio)){
                b.add(t);
                System.out.println(contador+") "+t);
                contador++;
            }
        }

        if(b.isEmpty()) System.out.println("No se encontraron resultados");
        return b;
    }

    /**
     * @param Fecha fin de la tarea a buscar
     * @return si no se encuentran valores devuelve una lista
     * vacía */
    public List<Tarea> buscar_por_fFin(LocalDate fFin){
        long contador = 1;
        List<Tarea> b = new ArrayList<>();
        for(Tarea t:repo.getLista()){
            if(t.getfFin().equals(fFin)){
                b.add(t);
                System.out.println(contador+") "+t);
                contador++;
            }
        }

        if(b.isEmpty()) System.out.println("No se encontraron resultados");
        return b;
    }

    /**
     * @param objeto con algunos valores modificados, aquellos que no
     * desean sobreescribirse se mantienen o en -1 o null */ 
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
