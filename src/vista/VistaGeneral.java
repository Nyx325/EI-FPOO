package vista;

import java.io.IOException;
import java.util.Scanner;

import persistencia.entidad.Usuario;
import persistencia.repositorio.RepoUsuario;

public class VistaGeneral {
    Usuario usr;
    Scanner teclado;
    VistaEmpleado vEmp;
    VistaTarea vTar;
    VistaProyecto vPro;
    RepoUsuario rUsr;
    
    public VistaGeneral() throws IOException {
        teclado = new Scanner(System.in);
        vEmp = new VistaEmpleado();
        vTar = new VistaTarea();
        vPro = new VistaProyecto();
        rUsr = new RepoUsuario();
    }

    public void menu() throws IOException{
        String usr, pwd;
        int opc;

        if(!rUsr.getLista().isEmpty()){
            do{
                System.out.println("Inicio de sesion");
                System.out.println("Ingresa el usuario");
                usr = teclado.nextLine();
                System.out.println("Ingresa la contraseña");
                pwd = teclado.nextLine();
                this.usr = inicioSesion(usr, pwd);
            }while(this.usr == null);
        }

        while(true){
            System.out.println("Bievenidos");
            System.out.println("1) Gestión empleados");
            System.out.println("2) Gestión proyectos");
            System.out.println("3) Gestión tareas");
            System.out.println("4) Agregar usuario");
            System.out.println("0) Salir");
            opc = teclado.nextInt();
            teclado.nextLine();

            switch (opc) {
                case 0:
                    return;
                case 1:
                    vEmp.menu();
                    break;
                case 2:
                    if(this.usr.isAdmin())
                        vPro.menu();
                    else
                        System.out.println("No se tienen los permisos");
                    break;
                case 3:
                    vTar.menu();
                    break;
                case 4:
                    this.agregarUsuario();
                    break;
                default:
                    break;
            }
        }
    }

    Usuario inicioSesion(String usr, String pwd){
        for(Usuario u : rUsr.getLista()){
            if(
                u.getUsuario().equals(usr) &&
                u.getContrasenia().equals(pwd)
            ){
                return u;
            }
        }

        System.out.println("Usuario o contraseña incorrectos");
        return null;
    }

    public void agregarUsuario() throws IOException{
        boolean admin = false;
        int opc;
        String usr, pwd;
        System.out.println("Ingrese el usuario");
        usr = teclado.nextLine();
        System.out.println("Ingrese la contraseña");
        pwd = teclado.nextLine();

        //Caso existe usuario y es admin
        if(this.usr != null && this.usr.isAdmin()){
            System.out.println("¿Dar privilegios de administrador?");
            System.out.println("0) No");
            System.out.println("1) Sí");
            opc = teclado.nextInt();
            if(opc == 0) admin = false;
            else admin = true;
        }

        // Caso no existen usuarios
        if(rUsr.getLista().isEmpty()) admin = true;

        // Caso el usuario no es admin
        if(this.usr != null && !this.usr.isAdmin()) admin = false;
        
        
        var u = new Usuario(usr, pwd, admin);
        rUsr.add(u);
        rUsr.save();
        if(this.usr == null)
            this.usr = u;
    }
}
