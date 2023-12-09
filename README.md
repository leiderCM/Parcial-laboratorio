Parcial final de laboratorio- jordarn

paso 1: en este link se muestras los lectores 👉 http://localhost:8081/lectores

paso 2: en este link se muestra las copias (todas sus caracteristicas) 👉 http://localhost:8081/copias

paso 3: en este link se muestra en los libros 👉 http://localhost:8081/libros

paso 4: en este link se muestra los prestamos  👉 http://localhost:8081/prestamos

paso 5: en este link para los nuevos prestamos 👉 http://localhost:8081/nuevoprestamo 
 ya que es un metodo post requiere un cuerpo formato json asi:
{
  "id": 102,
  "fechaInicio": 82023,
  "fechaFin": 92023,
  "copia": {
    "id": 3,
    "estado": "DISPONIBLE",
    "nombre": "Lbro3",
    "tipo": "tipo 3",
    "editorial": "economica",
    "anio": 1995,
    "autores": [
{
"nombre": "Pepe",
"nacionalidad": "Colombia",
"hbd": "1910"
},
{
"nombre": "Fabiola",
"nacionalidad": "Chile",
"hbd": "2000"
}
]
  },
  "lector": {
    "id": 32434,
    "nombre": "Alvaro",
    "apellido": "Rubie",
    "dir": "Uberrimo"
  }
}


paso 6: en este link se muestran las multas 👉 http://localhost:8081/multa/idusuario


// Rubrica de calificación
punto 1: diagrama de proceso

link del diagrama del proceso 👉 https://github.com/leiderCM/Parcial-laboratorio/files/13624957/Blank.diagram.pdf

punto 2:

para aquellos que no estan familiarizados con la programacion pueden tener conflictos con el diagrama UML debido a varias razones como pueden ser. 
1. Simbolos y notaciones: especificas dado que los simbolos y notaciones en uml no tienen una interfaz intuitiva para el usuario primerizo debido a que cuanta con diferentes tipos de flechas cajas y lineas y relaciones especificas en la programacion

2. Complejidad de relaciones: en sistemas conplejos en sistemas uml pueden representar relaciones e interacciones entre clases y objeto, comprender como estas entidades interactuan puede ser complejo sin un conocimiento previo

3. Niveles de detalle: dependiendo del proposito del diagrama puede incluir detalles especificos de implementacion que pueden ser facilmente comprensibles  como lo son metodos atribotos encapsulamiento y otros elementos de codigo
 en conclusion la diagramacion UML es necesaria para aquellos que se dedican a la programaciion ya que mediante este metodo se logra una abstraccion del lenguaje natural a codigo mas legible para el desarrollador, y ahorra tiempo al mismo en el sentido que no debe pensar nombres de variables, encapsulamiento,nombres de metodos, herencias etc... ya que viene o tendria que ser dado por el propio diagrama, sin embargo para aquellos que no estan familiarizados con la codificacion o con la misma sintaxis o simbolismos utilizados en UML este esquema no facilitara su comprension de ninguna manera, al contrario  confuncira mas al mismo

