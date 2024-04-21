package vista;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import logica.LogicaTarea;
import persistencia.entidad.Empleado;
import persistencia.entidad.Proyecto;
import persistencia.entidad.Tarea;

public class VistaTarea extends Vista<Tarea> {
    VistaEmpleado vEmp;
    VistaProyecto vPro;

    public VistaTarea() throws IOException {
        this.nombreTipo = "tarea";
        this.teclado = new Scanner(System.in);
        this.logica = new LogicaTarea();
        this.vEmp = new VistaEmpleado();
        this.vPro = new VistaProyecto();
    }

    @Override
    public void menu() throws IOException {
        while(true){
            System.out.println("Gestión de "+nombreTipo+"s");
            System.out.println("1) Agreagar "+nombreTipo);
            System.out.println("2) Modificar "+nombreTipo);
            System.out.println("3) Eliminar "+nombreTipo);
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
                default:
                    System.out.println("Opcion no válida");
                    break;
            }
        }
    }

    @Override
    public void crear() throws IOException {
        List<Empleado> b1 = new ArrayList<>();
        List<Proyecto> b2 = new ArrayList<>();
        var t = new Tarea();
        int anio, mes, dia, responsable, proyecto, opc;
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

        while (true) {
            System.out.println("Seleccion del responsable");
            System.out.println("1) Buscar responsable");
            System.out.println("2) Cancelar agregado");
            opc = teclado.nextInt();
            teclado.nextLine();

            switch (opc) {
                case 1:
                    b1 = vEmp.buscar();
                    break;
                case 2:
                    return;
                default:
                    break;
            }

            if (opc > 2 || opc < 1 || b1.isEmpty())
                continue;

            do {
                opc = teclado.nextInt();
                if (opc < 1 || opc > b1.size()) {
                    System.out.println("Ingrese un indice válido");
                    vEmp.printBusqueda(b1);
                }
            } while (opc < 1 || opc > b1.size());

            responsable = b1.get(opc - 1).getCodigo();
            break;
        }

        while (true) {
            System.out.println("Seleccion del proyecto");
            System.out.println("1) Buscar proyecto");
            System.out.println("2) Cancelar agregado");
            opc = teclado.nextInt();
            teclado.nextLine();

            switch (opc) {
                case 1:
                    b2 = vPro.buscar();
                    break;
                case 2:
                    return;
                default:
                    break;
            }

            if (opc > 2 || opc < 1 || b2.isEmpty())
                continue;

            do {
                opc = teclado.nextInt();
                if (opc < 1 || opc > b2.size()) {
                    System.out.println("Ingrese un indice válido");
                    vPro.printBusqueda(b2);
                }
            } while (opc < 1 || opc > b2.size());

            proyecto = b2.get(opc - 1).getCodigo();
            break;
        }

        t.setResponsable(responsable);
        t.setProyecto(proyecto);
        t.setfInicio(fInicio);
        t.setfFin(fFin);

        logica.add(t);
    }

    @Override
    public List<Tarea> buscar() {
        List<Tarea> b = new ArrayList<>();

        return b;
    }

    @Override
    public void modificar(){

    }
}
