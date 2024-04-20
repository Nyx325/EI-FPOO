package vista;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import persistencia.entidad.Empleado;
import logica.LogicaEmpleado;

public class VistaEmpleado extends Vista<Empleado>{
    public VistaEmpleado() throws IOException {
        this.nombreTipo = "empleado";
        logica = new LogicaEmpleado();
        teclado = new Scanner(System.in);
    }

    @Override
    public void crear() throws IOException {
        var e = new Empleado();
        System.out.println("Ingresa el nombre");
        e.setNombre(teclado.nextLine());
        System.out.println("Ingresa el apellido paterno");
        e.setApellidoP(teclado.nextLine());
        System.out.println("Ingresa el apellido materno");
        e.setApellidoM(teclado.nextLine());
        System.out.println("Ingresa la dirección");
        e.setDireccion(teclado.nextLine());
        System.out.println("Ingresa el teléfono");
        e.setTelefono(teclado.nextLine());

        logica.add(e);
    }

    @Override
    public List<Empleado> buscar() {
        int opc, codigo;
        String entrada;
        List<Empleado> b = new ArrayList<>();
        System.out.println("Ingresa el método de busqueda");
        System.out.println("1) Buscar por id");
        System.out.println("2) Buscar por nombre");
        System.out.println("3) Buscar por telefono");
        opc = teclado.nextInt();
        teclado.nextLine();

        switch (opc) {
            case 0:
                return b;
            case 1:
                System.out.println("Ingresa el id a buscar");
                codigo = teclado.nextInt();
                teclado.nextLine();
                b = logica.buscar_por_id(codigo);
                break;
            case 2:
                System.out.println("Ingresa el nombre a buscar");
                entrada = teclado.nextLine();
                b = ((LogicaEmpleado)logica).buscar_por_nombre(entrada);
                break;
            case 3:
                System.out.println("Ingresa el telefono a buscar");
                entrada = teclado.nextLine();
                b = ((LogicaEmpleado)logica).buscar_por_telefono(entrada);
            default:
                break;
        }

        printBusqueda(b);
        return b;
    }

    @Override
    public void modificar() throws IOException{
        int opc;
        List<Empleado> b = buscar();

        printBusqueda(b);
        if(b.isEmpty()) return;
        System.out.println("0) Salir");

        do{
            opc = teclado.nextInt();
            if(opc<0 || opc>b.size())
                System.out.println("Ingrese un indice válido");
        }while(opc < 0 || opc>b.size());

        if(opc == 0) return;

        var e = (Empleado)b.get(opc-1);

        do{
            System.out.println("Ingrese el campo a modificar");
            System.out.println("1) Nombre");
            System.out.println("2) Apellido paterno");
            System.out.println("3) Apellido materno");
            System.out.println("4) Direccion");
            System.out.println("5) Teléfono");
            System.out.println("6) Guardar");
            System.out.println("7) Cancelar");
            opc = teclado.nextInt();
            teclado.nextLine();

            switch (opc) {
                case 1: 
                    System.out.println("Ingresa el nombre");
                    e.setNombre(teclado.nextLine());
                    break;
                case 2:
                    System.out.println("Ingresa el apellido paterno");
                    e.setApellidoP(teclado.nextLine());
                    break;
                case 3:
                    System.out.println("Ingresa el apellido materno");
                    e.setApellidoM(teclado.nextLine());
                    break;
                case 4:
                    System.out.println("Ingresa la dirección");
                    e.setDireccion(teclado.nextLine());
                    break;
                case 5:
                    System.out.println("Ingresa el teléfono");
                    e.setTelefono(teclado.nextLine());
                    break;
                case 6:
                    break;
                case 7:
                    return;
                default:
                    break;
            }
        }while(opc!=6);
        logica.getRepo().save();
    }

}
