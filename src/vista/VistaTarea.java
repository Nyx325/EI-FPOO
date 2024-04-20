package vista;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import logica.LogicaTarea;
import persistencia.entidad.Tarea;

public class VistaTarea extends Vista<Tarea>{
    public VistaTarea(String pathArchivo) throws IOException {
        this.teclado = new Scanner(System.in);
        this.logica = new LogicaTarea(pathArchivo);
    }

    @Override
    public void crear(){
        int anio, mes, dia, responsable;
        LocalDate fInicio, fFin;
        System.out.println("Ingresa la fecha de inicio");
        System.out.println("Ingresa el dia");
        dia = teclado.nextInt();
        System.out.println("Ingresa el mes");
        mes = teclado.nextInt();
        System.out.println("Ingresa el año");
        anio = teclado.nextInt();
        fInicio = LocalDate.of(anio, mes, dia);
        
        System.out.println("Ingresa la fecha de fin");
        System.out.println("Ingresa el dia");
        dia = teclado.nextInt();
        System.out.println("Ingresa el mes");
        mes = teclado.nextInt();
        System.out.println("Ingresa el año");
        anio = teclado.nextInt();
        fFin = LocalDate.of(anio, mes, dia);

        // TODO impl metodo de busqueda de empleados
        System.out.println("Ingresa el responsable");
        responsable = teclado.nextInt();

        var t = new Tarea(responsable, fInicio, fFin);
        logica.add(t);
    }

    @Override
    public void eliminar() {
        // TODO 
        
    }

    @Override
    public void modificar() {
        // TODO 
        
    }

    public List<Tarea> buscar(){
        List<Tarea> b = new ArrayList<>();



        return b;
    }
}
