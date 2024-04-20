package vista;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import logica.Logica;
import persistencia.entidad.Almacenable;

public abstract class Vista<T extends Almacenable>{
    int opc;
    Scanner teclado;
    Logica<T> logica;
    String nombreTipo;

    public void menu() throws IOException {
        while(true){
            System.out.println("Gestión de "+nombreTipo+"s");
            System.out.println("1) Agreagar "+nombreTipo);
            System.out.println("2) Modificar "+nombreTipo);
            System.out.println("3) Eliminar "+nombreTipo);
            System.out.println("4) Mostrar "+nombreTipo+"s");
            System.out.println("0) Menú anterior");
            System.out.println("Elije una opcion:");
            opc = teclado.nextInt();
            teclado.nextLine();
            switch (opc) {
                case 0:
                    return;
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
                    this.print();
                    break;
                default:
                    System.out.println("Opcion no válida");
                    break;
            }
        }
    }

    public abstract List<T> buscar();
    public abstract void crear() throws IOException;
    public abstract void modificar() throws IOException;

    public void print(){
        List<T> registros = logica.getRepo().getLista();
        if(registros.isEmpty()) System.out.println("No existen "+nombreTipo+"s");

        for (Almacenable r : registros) {
            System.out.println(r);
        }
        System.out.println("");
    }

    public void eliminar() throws IOException{
        int eleccion;
        List<T> b = buscar();

        if (b.isEmpty()) return;

        System.out.println("0: Salir");
        do{
            eleccion = teclado.nextInt();
            if(eleccion<0 || eleccion>b.size())
                System.out.println("Ingrese un indice válido");
        }while(eleccion<0 || eleccion>b.size());

        if(eleccion == 0) return;
        
        logica.remove(b.get(eleccion-1));
    }
}
