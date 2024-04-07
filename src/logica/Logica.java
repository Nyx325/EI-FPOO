package logica;

import persistencia.entidad.Almacenable;
import persistencia.repositorio.Repositorio;

public class Logica<T extends Almacenable> {
    protected Repositorio<T> repo;

    public Repositorio<T> getRepo(){
        return repo;
    }

    /** 
     * "Validacion" de el agregado de una tarea al repositorio
     * @param r Un objeto tarea el cual ya debe tener los datos 
     * necesarios pero sin el codigo asignado (-1)
     */
    public void add(T r){
        // Incrementar el valor de la lista según las anterores
        if(repo.getLista().isEmpty()){
            // En caso de no haber tareas, se toma como la primer tarea
            r.setCodigo(1);
        }
        else{
            //En caso contrario se asigna el numero de tarea incrementando
            //el num de la ultima tarea
            r.setCodigo(repo.getLista().getLast().getCodigo()+1);
        }

        repo.add(r);
    }

    
    /**
     * Eliminacion producto de una previa busqueda del elemento que
     * se quiere eliminar
     * @param r referencia al registro a eliminar
     */
    public void remove(T r){
        repo.remove(r);
    }

    
    /**
     * Busqueda por código de un registro
     * @param codigo el código a buscar
     * @return retorna la referencia al registro en cuestion
     * de lo contrario retorna null
     */
    public T buscar(int codigo){
        for(T r:repo.getLista()){
            if(r.getCodigo() == codigo){
                return r;
            }
        }

        return null;
    }
}
