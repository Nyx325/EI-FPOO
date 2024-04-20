package vista;

import java.util.List;
import java.util.Scanner;

import logica.Logica;
import persistencia.entidad.Almacenable;

public abstract class Vista<T extends Almacenable>{
    Scanner teclado;
    Logica<T> logica;
    String nombreTipo;

    public void menu(){
        System.out.println("Gestión de "+nombreTipo+"s");
        System.out.println("1) Crear "+nombreTipo);
        System.out.println("2) Modificar "+nombreTipo);
        System.out.println("3) Eliminar "+nombreTipo);
        System.out.println("4) Mostrar "+nombreTipo+"s");
        System.out.println("Elije una opcion:");

        switch (teclado.nextInt()) {
            case 1:
                this.crear();
                break;
            case 2:
                this.modificar();
                break;
            case 3:
                this.eliminar();
                break;
            case 4:
                this.modificar();
                break;
            default:
                System.out.println("Opcion no válida");
                break;
        }
    }

    public abstract void crear();
    public abstract void modificar();


    /**
     * Funcion que englobaá todas las posibles busquedas mediante un switch, y además podrá
     * retornar este resultado final independientemenete del método usado, deberá imprimir 
     * los resultados encontrados y mostrar una enumeracion para que el usuario sepa qué 
     * indice debe elegir o imprimir que no ha encontrado resultados
     * @return resultado de la búsqueda
     */ 
    public abstract List<T> buscar();

    /** 
     * Mediante la funcion buscar permite obtener un conjunto de resultados los cuales deba
     * elegir, tras elegir el indice de la busqueda seleccionada directamente elimina este
     * objeto
     */ 
    public void eliminar(){
        int eleccion;
        List<T> b = buscar();

        if (b.isEmpty()) return;

        System.out.println("0: Salir");
        eleccion = teclado.nextInt();

        if(eleccion == 0) return;
        
        logica.remove(b.get(eleccion-1));
    }
}
