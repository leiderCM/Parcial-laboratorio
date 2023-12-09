
package taller.mavenproject4;


public class Multa {
    int id, fechaInicio, fechaFin;
    Lector lector;
    Prestamo prestamo;
     private double valorAPagar;
    

    public Multa(int id, int fechaInicio, int fechaFin, Lector lector, Prestamo prestamo) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.lector = lector;
        this.prestamo = prestamo;
       
    }

     

    public void setValorAPagar(double valorAPagar) {
        this.valorAPagar = valorAPagar;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(int fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(int fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    String getValorAPagar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
