package logica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import persistencia.entidad.Tarea;
import persistencia.repositorio.RepoTarea;

public class LogicaTarea extends Logica<Tarea> {
    public LogicaTarea(String pathArchivo) throws IOException{
        repo = new RepoTarea(pathArchivo);
    }

    /**
     * @param responsable id del responsable a buscar
     * @return resultado de busqueda, si no se encuentra la lista
     * se queda vacía
     */
    public List<Tarea> buscar_por_responsable(int responsable){
        List<Tarea> busqueda = new ArrayList<>();
        for (Tarea tarea : repo.getLista()) {
            if(tarea.getResponsable() == responsable){
                busqueda.add(tarea);
            }
        }

        busqueda.getLast();

        return busqueda;
    }
}
