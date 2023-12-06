
package com.mycompany.parcial.laboratorio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leider Ceron
 */
import java.util.ArrayList;
import java.util.List;

public class Lector {
    public int numSocio;
    public String nombre, apellido, direccion;
    Multa multa;
    List<Copia> copias;

    public Lector(int numSocio, String nombre, String apellido, String direccion, List<Copia> copias) {
        this.numSocio = numSocio;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.copias = copias; 
    }

    public boolean comprebarMultasPendientes() {
       
        return false;
    }

    // Método para guardar 3 copias
    public void guardarTresCopias() {
                
    }
}



    