package vista;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import logica.LogicaTarea;
import persistencia.entidad.Empleado;
import persistencia.entidad.Tarea;

public class VistaTarea extends Vista<Tarea> {
    VistaEmpleado vEmp;

    public VistaTarea() throws IOException {
        this.nombreTipo = "tarea";
        this.teclado = new Scanner(System.in);
        this.logica = new LogicaTarea();
        this.vEmp = new VistaEmpleado();
    }

    @Override
    public void crear() throws IOException {
        List<Empleado> b = new ArrayList<>();
        var t = new Tarea();
        int anio, mes, dia, responsable, opc;
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
                    b = vEmp.buscar();
                    break;
                case 2:
                    return;
                default:
                    break;
            }

            if (opc > 2 || opc < 1 || b.isEmpty())
                continue;

            do {
                opc = teclado.nextInt();
                if (opc < 1 || opc > b.size()) {
                    System.out.println("Ingrese un indice válido");
                    vEmp.printBusqueda(b);
                }
            } while (opc < 1 || opc > b.size());

            responsable = b.get(opc - 1).getCodigo();
            break;
        }

        t.setResponsable(responsable);
        t.setfInicio(fInicio);
        t.setfFin(fFin);

        logica.add(t);
    }

    @Override
    public void print() {
        List<Tarea> registros = logica.getRepo().getLista();
        Empleado responsable;
        if (registros.isEmpty())
            System.out.println("No existen " + nombreTipo + "s");

        for (Tarea r : registros) {
            System.out.println(r);
            responsable = vEmp.logica.buscar_por_id(r.getResponsable()).get(0);
            System.out.println("Responsable " + responsable.getNombre() + " " + responsable.getApellidoP() + " "
                    + responsable.getApellidoM());
        }
        System.out.println("");
    }

    @Override
    public void eliminar() {
        // TODO

    }

    @Override
    public void modificar() {
        // TODO

    }

    public List<Tarea> buscar() {
        List<Tarea> b = new ArrayList<>();

        return b;
    }
}
