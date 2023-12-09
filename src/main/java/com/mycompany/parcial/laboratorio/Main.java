


package taller.mavenproject4;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import spark.Spark;
import static spark.Spark.port;


public class Mavenproject4 {

   public static void main(String[] args) {
        port(8081);
       Gson gson = new Gson();
        LinkedList<Libro> libros = new LinkedList<>();
        LinkedList<Autor> autoresLibro1 = new LinkedList<>();
        LinkedList<Autor> autoresGenericos = new LinkedList<>();
        LinkedList<Copia> copias = new LinkedList<>();
        LinkedList<Lector> lectores = new LinkedList<>();
        LinkedList<Prestamo> prestamos = new LinkedList<>();
        LinkedList<Multa> multas = new LinkedList<>();

        LocalDate fechaActual = LocalDate.now();
        int mesActual = fechaActual.getMonthValue();

        autoresLibro1.add(addAutor("Gabriel", "Colombia", "1900", null));
        autoresGenericos.add(addAutor("Pepe", "Colombia", "1910", null));
        autoresGenericos.add(addAutor("Fabiola", "Chile", "2000", null));

        libros.add(addLibro("Lbro1", "tipo 1", "economica", 2013, autoresLibro1));
        libros.add(addLibro("Lbro2", "tipo 2", "top", 2005, autoresGenericos));
        libros.add(addLibro("Lbro3", "tipo 3", "economica", 1995, autoresGenericos));
        libros.add(addLibro("Lbro4", "tipo 4", "basica", 2015, autoresGenericos));
        libros.add(addLibro("Lbro5", "tipo 5", "costosa", 2020, autoresGenericos));

        int indiceCopia = 1;
        for (Libro libroCopiar : libros) {
            copias.add(addCopia(
                    indiceCopia,
                    "DISPONIBLE",
                    libroCopiar.nombre,
                    libroCopiar.tipo,
                    libroCopiar.editorial,
                    libroCopiar.anio,
                    libroCopiar.autores
            ));
            indiceCopia++;

            copias.add(addCopia(
                    indiceCopia,
                    "DISPONIBLE",
                    libroCopiar.nombre,
                    libroCopiar.tipo,
                    libroCopiar.editorial,
                    libroCopiar.anio,
                    libroCopiar.autores
            ));
            indiceCopia++;
        }

        lectores.add(addLector(32434, "Alvaro", "Rubie", "Uberrimo"));
        lectores.add(addLector(66666, "Gustavo", "Petro", "Casa Nariño"));

        Lector lectorPrestar = null;
        for (Lector lector : lectores) {
            if (lector.getIdentificador() == 32434) {
                lectorPrestar = lector;
            }
        }

        Copia copiaPrestar = null;
        for (Copia copia : copias) {
            if (copia.getId() == 2) {
                copiaPrestar = copia;
                copiaPrestar.setEstado("PRESTADO");
            }
        }

        if (copiaPrestar != null && lectorPrestar != null) {
            prestamos.add(
                    nuevoPrestamo(101, 82023, 92023, copiaPrestar, lectorPrestar)
            );
        }

        int idPrestamo = 101;

        for (Prestamo prestamo : prestamos) {
            if (prestamo.getId() == idPrestamo) {
                int fechaInicioMulta = prestamo.getFechaFin();
                int fechaFinMulta = mesActual;

                Lector lectorMulta = prestamo.getLector();
                Prestamo prestamoMulta = prestamo;

                Multa multaGenerada = nuevaMulta(
                        idPrestamo,
                        fechaInicioMulta,
                        fechaFinMulta,
                        lectorMulta,
                        prestamoMulta
                );

                multas.add(multaGenerada);
                calcularMulta(prestamo, multas);
            }
        }
         lectores.add(addLector(12345, "Juan", "Pérez", "Calle Principal"));
        
        Prestamo prestamoVencido = nuevoPrestamo(201, 82023, 92023, copias.get(0), lectores.get(lectores.size() - 1));
prestamos.add(prestamoVencido);

calcularMulta(prestamoVencido, multas);

// Añadir multa al lector con el ID 12345
Lector lectorConMulta = obtenerLectorPorId(12345, lectores);

if (lectorConMulta != null) {
    Multa multaEjemplo = nuevaMulta(
            generarIdMulta(),
            prestamoVencido.getFechaFin(),
            mesActual, // Para simular una multa actual
            lectorConMulta,
            prestamoVencido
    );

    multas.add(multaEjemplo);

    
    lectorConMulta.setMulta(multaEjemplo);
}
        Spark.get("/lectores", (req, res) -> {
            res.type("application/json");
            return gson.toJson(lectores);
        });
        

        Spark.get("/libros", (req, res) -> {
            res.type("application/json");
            return gson.toJson(libros);
        });

        Spark.get("/copias", (req, res) -> {
            res.type("application/json");
            return gson.toJson(copias);
        });

        Spark.get("/lectores", (req, res) -> {
            res.type("application/json");
            return gson.toJson(lectores);
        });

        Spark.get("/prestamos", (req, res) -> {
            res.type("application/json");
            return gson.toJson(prestamos);
        });

        Spark.post("/nuevoprestamo", (req, res) -> {
            res.type("application/json");

            Prestamo prestamoRequest = gson.fromJson(req.body(), Prestamo.class);

            Copia copiaPrestamo = obtenerCopiaPorId(prestamoRequest.getId(), copias);
            Lector lectorPrestamo = obtenerLectorPorId(prestamoRequest.getId(), lectores);

            if (copiaPrestamo != null && lectorPrestamo != null) {
                cambiarEstadoCopia(copiaPrestamo, "PRESTADO");

                Prestamo nuevoPrestamo = nuevoPrestamo(
                        generarIdPrestamo(),
                        prestamoRequest.getFechaInicio(),
                        prestamoRequest.getFechaFin(),
                        copiaPrestamo,
                        lectorPrestamo
                );

                prestamos.add(nuevoPrestamo);

                
                calcularMulta(nuevoPrestamo, multas);
            }

            return gson.toJson("Préstamo añadido exitosamente");
        });
        
        Spark.get("/multa/:idLector", (req, res) -> {
    res.type("application/json");

    try {
        int idLector = Integer.parseInt(req.params(":idLector"));

        int valor=5000;
        Lector lectorSeleccionado = obtenerLectorPorId(idLector, lectores);

        if (lectorSeleccionado != null) {
            
            List<Multa> multasLector = obtenerMultasPorLectorId(idLector, multas);

            
            JsonObject lectorConMultaJson = new JsonObject();
            lectorConMultaJson.addProperty("identificador", lectorSeleccionado.getIdentificador());
            lectorConMultaJson.addProperty("nombre", lectorSeleccionado.getNombre());
            lectorConMultaJson.addProperty("apellido", lectorSeleccionado.getApellido());
            lectorConMultaJson.addProperty("dir", lectorSeleccionado.getDir());

            
            JsonArray multasJson = new JsonArray();
            
            if (multasLector.isEmpty()) {
                
                lectorConMultaJson.addProperty("mensaje", "No hay multas para el ID registrado.");
            } else {
               
                lectorConMultaJson.addProperty("mensaje", "Tiene multas ,debe:."+valor);

                for (Multa multa : multasLector) {
                    JsonObject multaJson = new JsonObject();
                    multaJson.addProperty("id", multa.getId());
                    multaJson.addProperty("fechaInicio", multa.getFechaInicio());
                    multaJson.addProperty("fechaFin", multa.getFechaFin());
                    
                   

                    multasJson.add(multaJson);
                    valor=valor*2;
                }
            }

            lectorConMultaJson.add("multas", multasJson);

            return gson.toJson(lectorConMultaJson);
        } else {
            res.status(404);
            return gson.toJson("Lector no encontrado para el ID especificado.");
        }
    } catch (NumberFormatException e) {
        res.status(400);
        return gson.toJson("ID de lector no válido. Debe ser un número entero.");
    }
});

    }

    public static Libro addLibro(String nombre, String tipo, String editorial, int anio, LinkedList<Autor> autores) {
        return new Libro(nombre, tipo, editorial, anio, autores);
    }

    public static Autor addAutor(String nombre, String nacionalidad, String hbd, LinkedList<Libro> libros) {
        return new Autor(nombre, nacionalidad, hbd, libros);
    }

    public static Copia addCopia(int id, String estado, String nombre, String tipo, String editorial, int anio, LinkedList<Autor> autores) {
        return new Copia(id, estado, nombre, tipo, editorial, anio, autores);
    }

    public static Lector addLector(int id, String nombre, String apellido, String dir) {
        return new Lector(id, nombre, apellido, dir, null);
    }

    public static Prestamo nuevoPrestamo(int id, int fechaInicio, int fechaFin, Copia copia, Lector lector) {
        return new Prestamo(id, fechaInicio, fechaFin, copia, lector);
    }

    public static Multa nuevaMulta(int id, int fechaInicio, int fechaFin, Lector lector, Prestamo prestamo) {
        return new Multa(id, fechaInicio, fechaFin, lector, prestamo);
    }
     private static void cambiarEstadoCopia(Copia copia, String nuevoEstado) {
        copia.setEstado(nuevoEstado);
    }
     private static int generarIdPrestamo() {
        return contadorPrestamo.getAndIncrement();
    }

   private static String calcularMulta(Prestamo prestamo, List<Multa> multas) {
        LocalDate fechaActual = LocalDate.now();
        int mesActual = fechaActual.getMonthValue();

        if (prestamo.getFechaFin() < mesActual) {
            int mesesDeRetraso = mesActual - prestamo.getFechaFin();
            Lector lectorMulta = prestamo.getLector();
            Prestamo prestamoMulta = prestamo;
            LocalDate fechaInicioMulta = obtenerFechaActual();
            LocalDate fechaFinMulta = obtenerFechaFinMulta(fechaInicioMulta, mesesDeRetraso);

            // Crear la nueva multa
            Multa multaGenerada = nuevaMulta(
                    generarIdMulta(),
                    fechaInicioMulta.getDayOfMonth(),
                    fechaFinMulta.getDayOfMonth(),
                    lectorMulta,
                    prestamoMulta
            );

            // Calcular el valor a pagar
            double valorPorMesDeRetraso = 5.0; // Puedes ajustar este valor según tus necesidades
            double valorAPagar = valorPorMesDeRetraso * mesesDeRetraso;

            // Establecer el valor a pagar usando el método setter
            multaGenerada.setValorAPagar(valorAPagar);

            multas.add(multaGenerada);

            // Crear un objeto JSON para representar la nueva multa
            JsonObject nuevaMultaJson = new JsonObject();
            nuevaMultaJson.addProperty("id", multaGenerada.getId());
            nuevaMultaJson.addProperty("fechaInicio", multaGenerada.getFechaInicio());
            nuevaMultaJson.addProperty("fechaFin", multaGenerada.getFechaFin());
            nuevaMultaJson.addProperty("valorAPagar", multaGenerada.getValorAPagar());

            // Convertir el objeto JSON a una cadena y devolverla
            return gson.toJson(nuevaMultaJson);
        }

        return ""; // Devolver una cadena vacía si no se genera la multa
    }


    private static LocalDate obtenerFechaActual() {
        return LocalDate.now();
    }
    public static List<Multa> obtenerMultasPorLectorId(int idLector, List<Multa> multas) {
    List<Multa> multasLector = new ArrayList<>();
    for (Multa multa : multas) {
        if (multa.getLector().getIdentificador() == idLector) {
            multasLector.add(multa);
        }
    }
    return multasLector;
}
  
   
   

    private static LocalDate obtenerFechaFinMulta(LocalDate fechaInicio, int meses) {
        return fechaInicio.plus(meses, ChronoUnit.MONTHS);
    }
 private static final AtomicInteger contadorPrestamo = new AtomicInteger(1);
    private static final AtomicInteger contadorMulta = new AtomicInteger(1);

    private static int generarIdMulta() {
        return contadorMulta.getAndIncrement();
    }
   public static Copia obtenerCopiaPorId(int idCopia, List<Copia> copias) {
        for (Copia copia : copias) {
            if (copia.getId() == idCopia) {
                return copia;
            }
        }
        return null; // Retorna null si no se encuentra la copia con el ID especificado
    }
    public static Lector obtenerLectorPorId(int idLector, List<Lector> lectores) {
    for (Lector lector : lectores) {
        if (lector.getIdentificador() == idLector) {
            return lector;
        }
    }
    return null; // Retorna null si no se encuentra el lector con el ID especificado
}
     public static Multa obtenerMultaPorIdPrestamo(int idPrestamo, List<Multa> multas) {
    for (Multa multa : multas) {
        if (multa.getPrestamo().getId() == idPrestamo) {
            return multa;
        }
    }
    return null; 
}
}
