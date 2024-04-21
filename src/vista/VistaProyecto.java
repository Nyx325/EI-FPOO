package vista;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import logica.LogicaProyecto;
import persistencia.entidad.Empleado;
import persistencia.entidad.Proyecto;

public class VistaProyecto extends Vista<Proyecto> {
    VistaEmpleado vEmp;

    public VistaProyecto() throws IOException {
        this.nombreTipo = "proyecto";
        logica = new LogicaProyecto();
        teclado = new Scanner(System.in);
        vEmp = new VistaEmpleado();
    }

    @Override
    public void crear() throws IOException {
        int opc, responsable;
        int[] fecha = new int[3];
        List<Empleado> b = new ArrayList<>();
        var p = new Proyecto();

        System.out.println("Ingresa el nombre");
        p.setNombre(teclado.nextLine());

        System.out.println("Ingresa la descipción");
        p.setDescipcion(teclado.nextLine());

        System.out.println("Ingresa la fecha de inicio");
        System.out.println("Ingresa el día de inicio");
        fecha[0] = teclado.nextInt();
        System.out.println("Ingresa el mes de inicio");
        fecha[1] = teclado.nextInt();
        System.out.println("Ingresa el año de inicio");
        fecha[2] = teclado.nextInt();
        p.setfInicio(LocalDate.of(fecha[2], fecha[1], fecha[0]));

        System.out.println("Ingresa la fecha de fin");
        System.out.println("Ingresa el día de inicio");
        fecha[0] = teclado.nextInt();
        System.out.println("Ingresa el mes de inicio");
        fecha[1] = teclado.nextInt();
        System.out.println("Ingresa el año de inicio");
        fecha[2] = teclado.nextInt();
        p.setfFin(LocalDate.of(fecha[2], fecha[1], fecha[0]));

        do {
            System.out.println("Selecciona un jefe de proyecto");
            System.out.println("1) Buscar jefe");
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
        }while (true);

        p.setJefe(responsable);

        logica.add(p);
    }

    @Override
    public List<Proyecto> buscar(){
        int codigo, opc;
        int[] fecha = new int[3];
        String entrada;
        List<Proyecto> b = new ArrayList<>();

        System.out.println("Ingresa el método de busqueda");
        System.out.println("1) Buscar por id");
        System.out.println("2) Buscar por nombre");
        System.out.println("3) Buscar por descipcion");
        System.out.println("4) Buscar por fecha de inicio");
        System.out.println("5) Buscar por fecha de fin");
        System.out.println("6) Buscar por jefe");
        System.out.println("0) Salir");
        opc = teclado.nextInt();
        teclado.nextLine();

        switch (opc) {
            case 0:
                return b;
            case 1:
                System.out.println("Ingresa el id del proyecto");
                codigo = teclado.nextInt();
                teclado.nextLine();
                b = logica.buscar_por_id(codigo);
                break;
            case 2:
                System.out.println("Ingresa el nombre del proyecto");
                entrada = teclado.nextLine();
                b = ((LogicaProyecto)logica).buscarPorNombre(entrada);
                break;
            case 3:
                System.out.println("Ingresa la descripcion del proyecto");
                entrada = teclado.nextLine();
                b = ((LogicaProyecto)logica).buscarPorDescripcion(entrada);
                break;
            case 4:
                System.out.println("Ingresa la fecha de inicio");
                System.out.println("Ingresa el dia de inicio");
                fecha[0] = teclado.nextInt();
                System.out.println("Ingresa el mes de inicio");
                fecha[1] = teclado.nextInt();
                System.out.println("Ingresa el año de inicio");
                fecha[2] = teclado.nextInt();
                teclado.nextLine();
                b = ((LogicaProyecto)logica).buscarPorfInicio(LocalDate.of(fecha[0], fecha[1], fecha[2]));
                break;
            case 5:
                System.out.println("Ingresa la fecha de fin");
                System.out.println("Ingresa el dia de fin");
                fecha[0] = teclado.nextInt();
                System.out.println("Ingresa el mes de fin");
                fecha[1] = teclado.nextInt();
                System.out.println("Ingresa el año de fin");
                fecha[2] = teclado.nextInt();
                teclado.nextLine();
                b = ((LogicaProyecto)logica).buscarPorfFin(LocalDate.of(fecha[0], fecha[1], fecha[2]));
                break;
            default:
                break;
        }
        
        printBusqueda(b);
        return b;
    }

    @Override
    public void modificar() throws IOException{
        int opc;
        List<Proyecto> b = buscar();
        
    }

    @Override
    public void print() {
        List<Proyecto> registros = logica.getRepo().getLista();
        Empleado responsable;
        if (registros.isEmpty())
            System.out.println("No existen " + nombreTipo + "s");

        for (Proyecto r : registros) {
            System.out.println(r);
            responsable = vEmp.logica.buscar_por_id(r.getJefe()).get(0);
            System.out.println("Jefe " + responsable.getNombre() + " " + responsable.getApellidoP() + " "
                    + responsable.getApellidoM());
        }
        System.out.println("");
    }
}