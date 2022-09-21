import java.util.Scanner;

public class Curso {
  // Atributos
  private String clave;
  private boolean presencial;
  private String periodo;
  private String nombre;
  private String horario;

  private Alumno alumnos[] = new Alumno[40];
  private Aula aulas[] = new Aula[5];
  private Profesor profesor;
  private Materia materia;

  private int cAlumnos;
  private int cAulas;

  // CONSTRUCTORES
  public Curso(String clave, String nombre, boolean presencial, String periodo, String horario, String claveMateria,
      String unidades, String satca) {
    this.clave = clave;
    this.nombre = nombre;
    this.presencial = presencial;
    this.periodo = periodo;
    this.horario = horario;

    materia = new Materia(claveMateria, nombre, unidades, satca);

    inicializarDatos();
  }

  public Curso(String clave, String nombre, boolean presencial, String periodo, String horario, Materia materia) {
    this.clave = clave;
    this.nombre = nombre;
    this.presencial = presencial;
    this.periodo = periodo;
    this.horario = horario;

    materia = new Materia(materia.getClave(), materia.getNombre(), materia.getUnidades(), materia.getClave());
  }

  public Curso() {
    this.clave = "";
    this.nombre = "";
    this.presencial = false;
    this.periodo = "";
    this.horario = "";

    inicializarDatos();
  }

  private void inicializarDatos() {
    cAlumnos = 0;
    cAulas = 0;
  }

  // LOGICA DE LA CLASE

  public void asignarCalificacion(int nAlumno, int calificacion) {
    alumnos[nAlumno].setCalificacion(calificacion);
  }

  public void agregarAlumno(String numeroControl, String nombre, String telefono, String carrera, char genero) {
    alumnos[cAlumnos++] = new Alumno(numeroControl, nombre, telefono, carrera, genero);
  }

  public void agregarAlumno(Alumno alumno) {
    alumnos[cAlumnos++] = new Alumno(alumno.getNumeroControl(), alumno.getNombre(), alumno.getTelefono(),
        alumno.getCarrera(), alumno.getGenero());

  }

  public void asignarPrefesor(String correo, String especializacion, String nombre, String rfc, String telefono) {
    profesor = new Profesor(correo, especializacion, nombre, rfc, telefono);
  }

  public void asignarPrefesor(Profesor profesor) {
    this.profesor = new Profesor(profesor.getCorreo(), profesor.getEspecializacion(), profesor.getNombre(),
        profesor.getRfc(), profesor.getTelefono());
  }

  public void agregarAula(boolean aula, int capacidad, String edificio, String nombre) {
    aulas[cAulas++] = new Aula(aula, capacidad, edificio, nombre);
  }

  public void agregarAula(Aula aula) {
    aulas[cAulas++] = new Aula(aula.isAula(), aula.getCapacidad(), aula.getEdificio(), aula.getNombre());
  }

  public void mostrarProfesor() {
    profesor.mostrar();
    System.out.println("");
  }

  public void mostrarMateria() {
    materia.mostrar();
    System.out.println("");
  }

  public void listarAlumnos() {
    String format = "%-2s %-20s %-13s %-8s %-7s %-11s %-12s\n";

    System.out.println("Alumnos:");
    System.out.printf(format, "n", "Nombre", "No. Control", "Carrera", "Genero", "Telefono", "calificacion");

    for (int i = 0; i < cAlumnos; i++) {
      Alumno alumno = alumnos[i];

      System.out.printf(
          format,
          i + 1 + "",
          alumno.getNombre(),
          alumno.getNumeroControl(),
          alumno.getCarrera(),
          alumno.getGenero(),
          alumno.getTelefono(),
          alumno.getCalificacion());
    }
    System.out.println("");
  }

  public void listarAulas() {
    String format = "%-2s %-7s %-9s %-10s %-13s \n";

    System.out.println("Aulas:");
    System.out.printf(format, "n", "Nombre", "Edificio", "Capacidad", "Tipo");

    for (int i = 0; i < cAulas; i++) {
      Aula aula = aulas[i];

      System.out.printf(
          format,
          i + 1 + "",
          aula.getNombre(),
          aula.getEdificio(),
          aula.getCapacidad(),
          aula.isAula() ? "Laboratorio" : "Aula");
    }
    System.out.println("");
  }

  public void mostrar() {
    String format = "%-10s: %s\n";

    System.out.println("\nDatos del Curso: " + nombre);
    System.out.printf(format, "  Clave", clave);
    System.out.printf(format, "  Clase", nombre);
    System.out.printf(format, "  Periodo", periodo);
    System.out.printf(format, "  Horario", horario);
    System.out.printf(format, "  Modalidad", presencial ? "Presencial" : "Distancia");
    System.out.println("");
  }

  public void capturar() {
    Scanner sc = new Scanner(System.in);

    System.out.println("\nIngrese los datos del Curso");

    System.out.print("Clave: ");
    clave = sc.nextLine();

    System.out.print("Nombre: ");
    nombre = sc.nextLine();

    System.out.print("Periodo: ");
    periodo = sc.nextLine();

    System.out.print("Horario: ");
    horario = sc.nextLine();

    System.out.print("a) Precencial b) Distancia : ");
    presencial = (sc.next() == "a") ? true : false;
  }

  public boolean isEquals(String clave) {
    return (this.clave == clave) ? true : false;
  }

  public String toString() {
    return nombre + "\n" + periodo;
  }

  // ENCAPSULAMIENTO
  public String getClave() {
    return clave;
  }

  public void setClave(String clave) {
    this.clave = clave;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Boolean isPresencial() {
    return presencial;
  }

  public void setPresencial(Boolean presencial) {
    this.presencial = presencial;
  }

  public String getPeriodo() {
    return periodo;
  }

  public void setPeriodo(String periodo) {
    this.periodo = periodo;
  }

  public String getHorario() {
    return horario;
  }

  public void setHorario(String horario) {
    this.horario = horario;
  }
}
