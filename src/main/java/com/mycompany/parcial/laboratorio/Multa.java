
package com.mycompany.parcial.laboratorio;

/**
 *
 * @author Leider Ceron
 */
public class Multa {
    public int fechaInicio,fechaFin;
    Prestamo prestamo;
    Lector lector;
    public Multa(int fechaInicio, int fechaFin,Lector lector,Prestamo prestamo) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.lector= lector;
        this.prestamo= prestamo;
    }
    public void calcularFechaFin(){
        
    }
}
