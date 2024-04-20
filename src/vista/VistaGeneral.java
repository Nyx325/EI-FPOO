package vista;

import java.io.IOException;
import java.util.Scanner;

public class VistaGeneral {
    Scanner teclado;
    VistaEmpleado vEmp;
    VistaTarea vTar;
    //VistaProyecto vPro;
    
    public VistaGeneral() throws IOException {
        teclado = new Scanner(System.in);
        vEmp = new VistaEmpleado();
        vTar = new VistaTarea();
        //vPro = new VistaProyecto();
    }

    public void menu() throws IOException{
        int opc;
        while(true){
            System.out.println("Bievenidos");
            System.out.println("1) Gestión empleados");
            System.out.println("2) Gestión proyectos");
            System.out.println("3) Gestión tareas");
            System.out.println("0) Salir");
            opc = teclado.nextInt();

            switch (opc) {
                case 0:
                    return;
                case 1:
                    vEmp.menu();
                    break;
                case 2:
                    break;
                case 3:
                    vTar.menu();
                    break;
                default:
                    break;
            }
        }
    }
}
