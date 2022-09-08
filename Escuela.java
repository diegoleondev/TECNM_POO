public class Escuela {
  private String clave;
  private Curso cursos[] = new Curso[500];
  private String domicilio;
  private String nombre;

  int cCursos;

  public Escuela(String clave, String domicilio, String nombre) {
    this.clave = clave;
    this.domicilio = domicilio;
    this.nombre = nombre;

    inicializarDatos();
  }

  private void inicializarDatos() {
    Curso[] cursos = {
        new Curso("B2L1A", "Programacion 2", true, "Ago-Dic 2022", "09:00"),
        new Curso("B2L2A", "Calculo Integral", false, "Ago-Dic 2022", "10:00"),
    };

    Alumno[] alumnosA = {
        new Alumno("22120601", "Antonio", "441 555 6666", "ISC", 'M'),
        new Alumno("22120602", "Juan", "441 555 6666", "ISC", 'M'),
        new Alumno("22120603", "Alexis", "441 555 6666", "ISC", 'M'),
        new Alumno("22120604", "Maria", "441 555 6666", "ISC", 'F'),
        new Alumno("22120605", "Pepe", "441 555 6666", "ISC", 'M'),
        new Alumno("22120606", "Diego", "441 555 6666", "ISC", 'M'),
        new Alumno("22120607", "Marco", "441 555 6666", "ISC", 'M'),
        new Alumno("22120608", "Polo", "441 555 6666", "ISC", 'M'),
        new Alumno("22120609", "Jose", "441 555 6666", "ISC", 'M'),
        new Alumno("22120610", "Mario", "441 555 6666", "ISC", 'M'),
    };

    Alumno[] alumnosB = {
        new Alumno("22120611", "Alfredo", "441 555 6666", "ISC", 'M'),
        new Alumno("22120612", "Ernesto", "441 555 6666", "ISC", 'M'),
        new Alumno("22120613", "Adolfo", "441 555 6666", "ISC", 'M'),
        new Alumno("22120614", "Jhosep", "441 555 6666", "ISC", 'M'),
    };

    this.cursos[0] = cursos[0];
    this.cursos[0].agregarAlumnos(alumnosA);
    this.cursos[1] = cursos[1];
    this.cursos[1].agregarAlumnos(alumnosB);

    cCursos = 2;
  }

  // Loguica
  public void listarCursos() {
    String format = "%-6s %-6s %-20s %-13s %-8s %-10s\n";

    System.out.println("Cursos de la escuela: " + nombre);
    System.out.printf(format, "Index", "Clave", "Nombre", "Periodo", "Horario", "Modalidad");

    for (int i = 0; i < cCursos; i++) {
      Curso curso = cursos[i];

      System.out.printf(
          format,
          i + 1 + "",
          curso.getClave(),
          curso.getNombre(),
          curso.getPeriodo(),
          curso.getHorario(),
          curso.isPresencial() ? "Presencial" : "Distancia");

    }

    System.out.println("");
  }

  // Encapsulamiento
  public String getClave() {
    return clave;
  }

  public Curso[] getCursos() { // FALTA EL SET (?): Si para establecer (editar) las props.
    return cursos;
  }

  public String getDomicilio() {
    return domicilio;
  }

  public String getNombre() {
    return nombre;
  }

  public void setClave(String clave) {
    this.clave = clave;
  }

  public void setDomicilio(String domicilio) {
    this.domicilio = domicilio;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

}
