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

  public Curso(String clave, boolean presencial, String periodo, String horario, Materia materia) {
    this.clave = clave;
    this.nombre = materia.getNombre();
    this.presencial = presencial;
    this.periodo = periodo;
    this.horario = horario;

    this.materia = new Materia(materia.getClave(), materia.getNombre(), materia.getUnidades(), materia.getSatca());

    inicializarDatos();
  }

  public Curso(Materia materia) {
    inicializarDatos();
    nombre = materia.getNombre();
    this.materia = new Materia(materia.getClave(), materia.getNombre(), materia.getUnidades(), materia.getSatca());
    capturar();
  }

  private void inicializarDatos() {
    cAlumnos = 0;
    cAulas = 0;

    profesor = new Profesor("P", "P", "P", "P", "P");

    /*
     * getCorreo()
     * getTelefono()
     * getRfc()
     * getNombre()
     */
  }

  // LOGICA DE LA CLASE
  public void asignarCalificacion(String numeroControl, int calificacion) {
    for (int i = 0; i < cAlumnos; i++) {
      Alumno alumno = alumnos[i];

      boolean isEquals = alumno.equals(numeroControl);

      if (isEquals) {
        alumno.setCalificacion(calificacion);
        break;
      }
    }
  }

  public void asignarCalificacion(int nAlumno, int calificacion) {
    alumnos[nAlumno].setCalificacion(calificacion);
  }

  public void agregarAlumno(String numeroControl, String nombre, String telefono, String correo, String carrera,
      char genero) {
    alumnos[cAlumnos++] = new Alumno(numeroControl, nombre, telefono, correo, carrera, genero);
  }

  public void agregarAlumno(Persona persona) {
    Alumno alumno = (Alumno) persona;
    alumnos[cAlumnos++] = new Alumno(
        alumno.getNombre(),
        alumno.getNumeroControl(),
        alumno.getTelefono(),
        alumno.getCorreo(),
        alumno.getCarrera(),
        alumno.getGenero());

  }

  public void asignarPrefesor(String correo, String especializacion, String nombre, String rfc, String telefono) {
    profesor = new Profesor(correo, especializacion, nombre, rfc, telefono);
  }

  public void asignarPrefesor(Persona persona) {
    Profesor profesor = (Profesor) persona;

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
    if (profesor == null) {
      System.out.println("No hay Profesor \n");
      return;
    }
    profesor.mostrar();
    System.out.println("");
  }

  public void mostrarMateria() {
    materia.mostrar();
    System.out.println("");
  }

  public void listarAlumnos() {
    if (cAlumnos == 0) {
      System.out.println("No hay alumnos registrados. \n");
      return;
    }

    int acomulador = 0;

    System.out.println("|----------------------------------- Alumnos ----------------------------------|");
    String format = "| %-1s | %-11s | %-51s | %-4s |\n";

    System.out.printf(format, "n", "No. Control", "Nombre", "Cali");

    for (int i = 0; i < cAlumnos; i++) {
      Alumno alumno = alumnos[i];

      acomulador += alumnos[i].getCalificacion();

      System.out.printf(
          format,
          i + 1 + "",
          alumno.getNumeroControl(),
          alumno.getNombre(),
          alumno.getCalificacion());
    }

    int promedio = acomulador / (cAlumnos - 1);

    System.out.println(
        "--------------------------------------------------------------------------------");
    System.out.printf("| %-18s: %-4s |\n", "Promedio del Grupo", promedio);
    System.out.println("----------------------------\n");
  }

  public void listarAulas() {
    String format = "| %-17s | %-17s | %-17s | %-16s |\n";

    System.out.println("|------------------------------------ Aulas -----------------------------------|");
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

    System.out.print("Periodo: ");
    periodo = sc.nextLine();

    System.out.print("Horario: ");
    horario = sc.nextLine();

    System.out.print("1) Precencial 2) Distancia : ");
    presencial = (sc.nextInt() == 1) ? true : false;
  }

  public boolean equals(String clave) {
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

  public Materia getMateria() {
    return materia;
  }

  public Profesor getProfesor() {
    return profesor;
  }

  public Aula[] getAulas() {
    return aulas;
  }

  public Alumno[] getAlumnos() {
    return alumnos;
  }

}
