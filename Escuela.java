public class Escuela {
  private String nombre;
  private String clave;
  private String domicilio;

  private Curso cursos[] = new Curso[500];
  private int cCursos;

  public Escuela(String clave, String domicilio, String nombre) {
    this.clave = clave;
    this.domicilio = domicilio;
    this.nombre = nombre;

    inicializarDatos();
  }

  private void inicializarDatos() {

    cursos[0] = new Curso("B2L1A", "POO", true, "Ago-Dic 2022", "09:00", "TECP2", "Programacion", "5", 5);
    cursos[0].asignarPrefesor("martin@tecnm.com", "Desarollo Web", "Martin", "MART2000301", "443 111 5555");
    cursos[0].agregarAulas(true, 30, "AG", "LC1");
    cursos[0].agregarAulas(true, 25, "AG", "LC2");
    cursos[0].agregarAlumno("22120601", "Antonio Gomez", "441 555 6666", "ISC", 'M');
    cursos[0].agregarAlumno("22120602", "Juan Diaz", "441 555 6666", "ISC", 'M');
    cursos[0].agregarAlumno("22120603", "Alexis Lora", "441 555 6666", "ISC", 'M');

    cursos[1] = new Curso("B2L2A", "Calculo Integral", false, "Ago-Dic 2022", "10:00", "TECC2", "Programacion", "3", 5);
    cursos[1].asignarPrefesor("omar@tecnm.com", "Matematicas", "Omar", "OMAR2300311", "443 555 222");
    cursos[1].agregarAulas(false, 40, "F", "3");
    cursos[1].agregarAlumno("22120604", "Alfredo Perez", "441 555 6666", "ISC", 'M');
    cursos[1].agregarAlumno("22120605", "Ernesto Zedillo", "441 555 6666", "ISC", 'M');
    cursos[1].agregarAlumno("22120606", "Adolfo Lopez", "441 555 6666", "ISC", 'M');
    cursos[1].agregarAlumno("22120607", "Maria Nuñes", "441 555 6666", "ISC", 'F');

    cCursos = 2;
  }

  // LOGICA DE LA CLASE

  public void listarCursos() {
    String format = "%-2s %-6s %-20s %-13s %-8s %-10s\n";

    System.out.println("Cursos de " + nombre);
    System.out.printf(format, "n", "Clave", "Nombre", "Periodo", "Horario", "Modalidad");

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

  public void listarDetalles(int curso) {
    System.out.println("");
    System.out.println("Detalles del curso: " + cursos[curso].getNombre());
    System.out.println("");
    cursos[curso].mostrarMateria();
    cursos[curso].mostrarProfesor();
    cursos[curso].listarAlumnos();
    cursos[curso].listarAulas();
  }

  public void mostrar() {
    String format = "%s-10: %s\n";

    System.out.println("Esculea:");
    System.out.printf(format, "  Nombre ", nombre);
    System.out.printf(format, "  Clave ", clave);
    System.out.printf(format, "  Domicilio ", domicilio);
  }
  // ENCAPSULAMIENTO

  public String getNombre() {
    return nombre;
  }

  public String getClave() {
    return clave;
  }

  public String getDomicilio() {
    return domicilio;
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
