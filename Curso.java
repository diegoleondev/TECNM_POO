import java.util.Scanner;

public class Curso implements Acciones {
  // Atributos
  private String clave;
  private boolean presencial;
  private String periodo;
  private String nombre;
  private String horario;
  private boolean eliminada;

  private Alumno alumnos[] = new Alumno[100];
  private Aula aulas[] = new Aula[100];
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
    nombre = materia.getNombre();
    this.materia = new Materia(
        materia.getClave(),
        materia.getNombre(),
        materia.getUnidades(),
        materia.getSatca());
    capturar();
    inicializarDatos();
  }

  private void inicializarDatos() {
    cAlumnos = 0;
    cAulas = 0;

    eliminada = false;
  }

  /* ==============================[ LOGUICA ]============================= */

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

  public void eliminarAlumno(String clave) {
    for (Alumno alumno : alumnos) {
      if (alumno == null) {
        System.out.println("* No se encontraron coincidencias. ");
        return;
      }
      if (alumno.isEliminada())
        continue;
      if (!alumno.equals(clave))
        continue;

      alumno.eliminar();
      System.out.println("+ Alumno eliminado. ");

      return;
    }

  }

  public void eliminarAula(String clave) {
    for (Aula aula : aulas) {
      if (aula == null) {
        System.out.println("* No se encontraron coincidencias. ");
        return;
      }
      if (aula.isEliminada())
        continue;
      if (!aula.equals(clave))
        continue;

      aula.eliminar();
      System.out.println("+ Aula eliminada. ");
      return;
    }

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
    if (presencial)
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

    for (Alumno alumno : alumnos) {
      if (alumno == null)
        continue;
      if (alumno.isEliminada())
        continue;

      System.out.println("  > " + alumno);
    }
    /*
     * acomulador += alumnos[i].getCalificacion();
     * int promedio = acomulador / (cAlumnos - 1);
     * 
     * System.out.println(
     * "--------------------------------------------------------------------------------"
     * );
     * System.out.printf("| %-18s: %-4s |\n", "Promedio del Grupo", promedio);
     * System.out.println("----------------------------\n");
     */
  }

  public void listarAulas() {
    for (Aula aula : aulas) {
      if (aula == null)
        return;
      if (aula.isEliminada())
        continue;

      System.out.println("  > " + aula);
    }
  }

  public void mostrar() {

    String format = "%-10s: %s\n";

    System.out.printf(format, "Clave", clave);
    System.out.printf(format, "Clase", nombre);
    System.out.printf(format, "Periodo", periodo);
    System.out.printf(format, "Horario", horario);
    System.out.printf(format, "Modalidad", presencial ? "Presencial" : "Distancia");

    if (materia != null)
      System.out.printf(format, "\nMateria", materia);

    if (profesor != null)
      System.out.printf(format, "\nProfesor", profesor);

    for (Alumno alumno : alumnos) {
      if (alumno == null)
        break;
      if (alumno.isEliminada())
        continue;

      System.out.printf(format, "\nAlumnos del Curso", "");
      listarAlumnos();

      break;
    }

    for (Aula aula : aulas) {
      if (aula == null)
        break;
      if (aula.isEliminada())
        continue;

      System.out.printf(format, "\nAulas", "");
      listarAulas();

      break;
    }
  }

  public void capturar() {
    Scanner sc = new Scanner(System.in);

    System.out.print("Clave: ");
    clave = sc.nextLine();

    System.out.print("Periodo: ");
    periodo = sc.nextLine();

    System.out.print("Horario: ");
    horario = sc.nextLine();

    System.out.print("1.- Precencial 2.- Distancia : ");
    presencial = (sc.nextInt() == 1) ? true : false;
  }

  public boolean buscar(String string) {

    if (eliminada)
      return false;

    String cadena = clave + presencial + periodo + nombre + horario;

    if (cadena.indexOf(string) != -1)
      return true;

    for (Alumno alumno : alumnos) {
      if (alumno == null)
        break;

      if (alumno.buscar(string))
        return true;
    }

    for (Aula aula : aulas) {
      if (aula == null)
        break;

      if (aula.buscar(string))
        return true;
    }

    if (profesor.buscar(string))
      return true;

    if (materia.buscar(string))
      return true;

    return false;
  }

  public void modificar() {
  }

  public boolean poseeProfesor(String rfc) {
    if (profesor == null)
      return false;

    return profesor.equals(rfc);
  }

  public boolean poseeAula(String clave) {
    for (Aula aula : aulas) {
      if (aula == null)
        return false;
      if (aula.equals(clave))
        return true;
    }

    return false;
  }

  public boolean poseeAlumno(String numeroControl) {
    for (Alumno alumno : alumnos) {
      if (alumno == null)
        return false;
      if (alumno.equals(numeroControl))
        return true;
    }

    return false;
  }

  public Aula encontrarAula(String numeroControl) {
    for (Aula aula : aulas) {
      if (aula == null)
        return null;
      if (aula.isEliminada())
        continue;
      if (!aula.equals(clave))
        continue;

      return aula;
    }

    System.out.println("El Numero de Control no coincide con ningun Alumno.");

    return null;
  }

  public Alumno encontrarAlumno(String numeroControl) {
    for (Alumno alumno : alumnos) {
      if (alumno == null)
        return null;
      if (alumno.isEliminada())
        continue;
      if (!alumno.equals(numeroControl))
        continue;

      return alumno;
    }

    System.out.println("El Numero de Control no coincide con ningun Alumno.");

    return null;
  }

  public boolean equals(String clave) {
    return this.clave.equals(clave);
  }

  public String toString() {
    return clave + " " + nombre;
  }

  public void eliminar() {
    eliminada = true;
  }

  public boolean isEliminada() {
    return eliminada;
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

  public void setPresencial(boolean presencial) {
    this.presencial = presencial;
  }

  public void setProfesor(Profesor profesor) {
    this.profesor = profesor;
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

  public boolean getPresencial() {
    return presencial;
  }

  public Profesor getProfesor() {
    return profesor;
  }

  public Aula[] getAulas() {
    return aulas;
  }

  public void setAulas(Aula[] aulas) {
    this.aulas = aulas;
  }

  public Alumno[] getAlumnos() {
    return alumnos;
  }

  private int capturarOpcionNumerica(int opciones) {
    Scanner sc = new Scanner(System.in);

    do {
      int opcion = sc.nextInt();
      boolean range = (opcion >= 0 && opcion <= opciones);

      if (range)
        return opcion;

      System.out.print("Opcion no valida, vuelva a seleccionar : ");

    } while (true);
  }

  private boolean capturarOpcionBooleana() {
    Scanner sc = new Scanner(System.in);

    do {
      int opcion = sc.nextInt();

      boolean isValid = opcion == 1 || opcion == 2;

      if (isValid)
        return opcion == 1 ? true : false;

      System.out.print("Opcion no valida, ¿1.-Si o 2.-No?: ");

    } while (true);
  }
}
