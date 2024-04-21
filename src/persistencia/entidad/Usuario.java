package persistencia.entidad;

public class Usuario implements Almacenable{
    String usuario;
    String contrasenia;
    boolean admin;

    public Usuario(){}

    public Usuario(String usuario, String contrasenia, boolean admin){
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.admin = admin;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contraseña) {
        this.contrasenia = contraseña;
    }

    public boolean isAdmin(){
        return admin;
    }

    public void setAdmin(boolean admin){
        this.admin = admin;
    }

    @Override
    public void setCodigo(int codigo) {}

    @Override
    public int getCodigo() {return -1;}
}
