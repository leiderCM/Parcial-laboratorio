

package taller.mavenproject4;


public class Prestamo {
 
    //NO PARECE PERO EN TEORIA EL ID DEBE ESTAR PARA ESTO TIPO DE CASOS
    int id, fechaInicio, fechaFin;
    Copia copia;
    Lector lector;

    public Prestamo(int id, int fechaInicio, int fechaFin, Copia copia, Lector lector) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.copia = copia;
        this.lector = lector;
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

    public Copia getCopia() {
        return copia;
    }

    public void setCopia(Copia copia) {
        this.copia = copia;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }
    
    
    
    
}
