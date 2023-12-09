


package taller.mavenproject4;


public class Lector {
    
    int identificador; // numSocio
    String nombre, apellido, dir;
    Multa multa;

    public Lector(int identificador, String nombre, String apellido, String dir, Multa multa) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dir = dir;
        this.multa = multa;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public Multa getMulta() {
        return multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }

    

    
    
}