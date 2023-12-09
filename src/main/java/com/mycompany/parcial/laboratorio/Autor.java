

package taller.mavenproject4;

import java.util.LinkedList;


public class Autor {

    String nombre, nacionalidad, hbd;
    LinkedList<Libro> libros = new LinkedList<>();

    public Autor(String nombre, String nacionalidad, String hbd, LinkedList<Libro> libros) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.hbd = hbd;
        this.libros = libros;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getHbd() {
        return hbd;
    }

    public void setHbd(String hbd) {
        this.hbd = hbd;
    }
    
}
