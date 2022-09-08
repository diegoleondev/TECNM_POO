public class Escuela {
  private String clave;
  private Curso  cursos[] = new Curso[500];
  private String domicilio;
  private String nombre;

  int cCursos;

  public Escuela (String clave, String domicilio, String nombre) {
    this.clave = clave;
    this.domicilio = domicilio;
    this.nombre = nombre;

    inicializarDatos();
  }

  private void inicializarDatos() {
    cCursos = 0;
  }

  // Loguica
  public void listarCursos() {
    String format = "%-6s %-20s %-13s %-8s %-10s\n";

    System.out.println("Cursos de la escuela: " + nombre);
    System.out.printf(format, "Clave", "Nombre", "Periodo", "Horario", "Modalidad");

    for (int i = 0; i< cCursos; i++) {
      Curso curso = cursos[i];

      System.out.printf(
        format, 
        curso.getClave(), 
        curso.getNombre(), 
        curso.getPeriodo(),
        curso.getHorario(),
        curso.isPresencial() ? "Presencial" : "Distancia"
      );
      
    }

    System.out.println("");
  }

  public void agregarCursos(Curso[] cursos) {
    for (int i = 0; i < cursos.length; i++) {
      this.cursos[cCursos] = cursos[i];
      cCursos++;
    }
  }

  // Encapsulamiento
  public String getClave () {
    return clave;
  }

  public Curso[] getCursos () { // FALTA EL SET (?)
    return cursos;
  }

  public String getDomicilio () {
    return domicilio;
  }

  public String getNombre () {
    return nombre;
  }

  public void setClave(String clave) {
    this.clave = clave;
  }

  public void setDomicilio (String domicilio) {
    this.domicilio = domicilio;
  }

  public void setNombre (String nombre) {
    this.nombre = nombre;
  }


}
