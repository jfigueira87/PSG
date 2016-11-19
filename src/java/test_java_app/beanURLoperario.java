package test_java_app;

public class beanURLoperario {
    private String IDusuario;
    private String url_imagen;

    public beanURLoperario(String IDusuario, String url_imagen) {
        this.IDusuario = IDusuario;
        this.url_imagen = url_imagen;
    }

    public String getIDusuario() {
        return IDusuario;
    }

    public void setIDusuario(String IDusuario) {
        this.IDusuario = IDusuario;
    }

    public String getUrl_imagen() {
        return url_imagen;
    }

    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }
    
    @Override
    public String toString(){
        return IDusuario+" "+url_imagen;
    }
    
}
