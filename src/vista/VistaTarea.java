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
        int opc, codigo;
        int[] fecha = new int[3];
        List<Tarea> b = new ArrayList<>();
        List<Empleado> lE = new ArrayList<>();

        System.out.println("Ingresa el método de busqueda");
        System.out.println("1) Buscar por id");
        System.out.println("2) Buscar por responsable");
        System.out.println("3) Buscar por fecha de inicio");
        System.out.println("4) Buscar por fecha de fin");
        opc = teclado.nextInt();
        teclado.nextLine();

        switch (opc) {
            case 1:
                System.out.println("Ingrese el id de la tarea");
                codigo = teclado.nextInt();
                teclado.nextLine();
                b = logica.buscar_por_id(codigo);
                break;
            case 2:
                lE = vEmp.buscar();
                if(lE.isEmpty()) break;

                do {
                    opc = teclado.nextInt();
                    if (opc < 1 || opc > b.size()) {
                        System.out.println("Ingrese un indice válido");
                        vEmp.printBusqueda(lE);
                    }
                } while (opc < 1 || opc > b.size());

                int e = lE.get(opc - 1).getCodigo();

                b = ((LogicaTarea)logica).buscar_por_responsable(e);
                break;
            case 3:
                System.out.println("Ingresa la fecha de inicio");
                System.out.println("Ingresa el día de inicio");
                fecha[0] = teclado.nextInt();
                System.out.println("Ingresa el mes de inicio");
                fecha[1] = teclado.nextInt();
                System.out.println("Ingresa el año de inicio");
                fecha[2] = teclado.nextInt();
                b = ((LogicaTarea)logica).buscar_por_fInicio(LocalDate.of(fecha[2], fecha[1], fecha[0]));
                break;
            case 4:
                System.out.println("Ingresa el día de fin");
                fecha[0] = teclado.nextInt();
                System.out.println("Ingresa el mes de fin");
                fecha[1] = teclado.nextInt();
                System.out.println("Ingresa el año de fin");
                fecha[2] = teclado.nextInt();
                b = ((LogicaTarea)logica).buscar_por_fFin(LocalDate.of(fecha[2], fecha[1], fecha[0]));
                break;
            default:
                break;
        }
        
        printBusqueda(b);
        return b;
    }

    @Override
    public void modificar() throws IOException{
        int[] fecha = new int[3];
        int opc;
        List<Tarea> b = buscar();
        List<Empleado> lE = new ArrayList<>();
        List<Proyecto> lP = new ArrayList<>();

        if(b.isEmpty()) return;
        System.out.println("0) Salir");
        do {
            opc = teclado.nextInt();
            if (opc < 0 || opc > b.size())
                System.out.println("Ingrese un índice válido");
        } while (opc < 0 || opc > b.size());

        if (opc == 0)
            return;
        var t = (Tarea) b.get(opc - 1);
        
        do{
            System.out.println("Ingresa el campo a modificar");
            System.out.println("1) Responsable");
            System.out.println("2) proyecto");
            System.out.println("3) Fecha de inicio");
            System.out.println("4) Fecha de fin");
            System.out.println("5) Guardar");
            System.out.println("6) Cancelar");
            opc = teclado.nextInt();
            teclado.nextLine();

            switch (opc) {
                case 1:
                    System.out.println("Ingrese el nuevo responsable");
                    lE = vEmp.buscar();
                    if(lE.isEmpty()) break;

                    do {
                        opc = teclado.nextInt();
                        if (opc < 1 || opc > lE.size()) {
                            System.out.println("Ingrese un indice válido");
                            vEmp.printBusqueda(lE);
                        }
                    } while (opc < 1 || opc > lE.size());

                    int r = lE.get(opc - 1).getCodigo();

                    t.setResponsable(r);
                    break;
                case 2:
                    System.out.println("Ingrese el nuevo proyecto");
                    lP = vPro.buscar();
                    if(lP.isEmpty()) break;

                    do {
                        opc = teclado.nextInt();
                        if (opc < 1 || opc > lP.size()) {
                            System.out.println("Ingrese un indice válido");
                            vPro.printBusqueda(lP);
                        }
                    } while (opc < 1 || opc > lP.size());

                    int p = lP.get(opc - 1).getCodigo();

                    t.setProyecto(p);
                    break;
                case 3:
                    System.out.println("Ingresa la nueva fecha de inicio");
                    System.out.println("Ingresa el dia de inicio");
                    fecha[0] = teclado.nextInt();
                    System.out.println("Ingresa el mes de inicio");
                    fecha[1] = teclado.nextInt();
                    System.out.println("Ingresa el año de inicio");
                    fecha[2] = teclado.nextInt();
                    t.setfInicio(LocalDate.of(fecha[2], fecha[1], fecha[0]));
                    break;
                case 4:
                    System.out.println("Ingresa la nueva fecha de fin");
                    System.out.println("Ingresa el dia de fin");
                    fecha[0] = teclado.nextInt();
                    System.out.println("Ingresa el mes de fin");
                    fecha[1] = teclado.nextInt();
                    System.out.println("Ingresa el año de fin");
                    fecha[2] = teclado.nextInt();
                    t.setfFin(LocalDate.of(fecha[2], fecha[1], fecha[0]));
                    break;
                case 5:
                    break;
                case 6:
                    return;
                default:
                    break;
            }
        }while(opc!=5);
        logica.getRepo().save();
    }
}
