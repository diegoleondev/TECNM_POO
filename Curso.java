import java.util.Scanner;

public class Curso {
  // Atributos
  private String clave;
  private boolean presencial;
  private String periodo;
  private String nombre;
  private String horario;

  Alumno alumnos[] = new Alumno[500];
  int cAlumnos;

  // Constructores
  public Curso (String clave, String nombre, boolean presencial, String periodo, String horario) {
    this.clave = clave;
    this.nombre = nombre;
    this.presencial = presencial;
    this.periodo = periodo;
    this.horario = horario;
    inicializarDatos();
  }
  
  public Curso () {
    this.clave = "";
    this.nombre = "";
    this.presencial = false;
    this.periodo = "";
    this.horario = "";    

    inicializarDatos();
  }

  private void inicializarDatos () {
    cAlumnos = 0;
  }

  // Loguica de la la clase

  public void agregarAlumnos (Alumno[] alumnos) {
    for (int i = 0; i < alumnos.length; i++) {
      this.alumnos[cAlumnos] = alumnos[i];
      cAlumnos++;
    }
  }

  public void listarAlumnos () {
    String format = "%-6s %-20s %-12s %-8s %-7s %-11s\n";

    System.out.println("Alumnos del curso: " + nombre);
    System.out.printf(format,"Index", "Nombre", "No. Control", "Carrera", "Genero", "Telefono");
    
    for (int i = 0; i < cAlumnos; i++) {
      Alumno alumno = alumnos[i];

      System.out.printf(
        format,
        i + 1 + "", 
        alumno.getNombre(), 
        alumno.getNumeroControl(), 
        alumno.getCarrera(),
        alumno.getGenero(),
        alumno.getTelefono()
      );
    }

    System.out.println("");
  }

  public void  mostrar () {
    System.out.println("\nDatos del Curso: " + nombre);
    System.out.printf("%-10s: %s\n", "Clave", clave);
    System.out.printf("%-10s: %s\n", "Clase", nombre);
    System.out.printf("%-10s: %s\n", "Periodo", periodo);
    System.out.printf("%-10s: %s\n", "Horario", horario);
    System.out.printf("%-10s: %s\n", "Modalidad", presencial ? "Presencial" : "Distancia");
  }

  public void capturar (){
    Scanner sc = new Scanner(System.in);

    System.out.println("\nIngrese los datos del Curso");
    
    System.out.print("Clave: "); 
    clave =  sc.nextLine();

    System.out.print("Nombre: ");
    nombre = sc.nextLine();

    System.out.print("Periodo: "); 
    periodo = sc.nextLine();

    System.out.print("Horario: ");
    horario = sc.nextLine();

    System.out.print("a) Precencial b) Distancia : ");
    presencial = (sc.next() == "a") ? true : false;
  }

  public boolean isEquals (String clave) {
    return (this.clave == clave) ? true : false;
  }

  public String toString () {
    return nombre + "\n" + periodo;
  }

  // Encapsulamiento  
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
