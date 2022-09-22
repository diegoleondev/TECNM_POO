import java.util.Scanner;

public class Alumno {
  private String numeroControl;
  private String nombre;
  private String telefono;
  private String carrera;
  private int calificacion;
  private char genero;

  // Constructores
  public Alumno(String numeroControl, String nombre, String telefono, String carrera, char genero) {
    this.numeroControl = numeroControl;
    this.nombre = nombre;
    this.telefono = telefono;
    this.carrera = carrera;
    this.genero = genero;
    this.calificacion = 0;

  }

  public Alumno(String numeroControl, String nombre, String telefono, String carrera, char genero, int calificacion) {
    this.numeroControl = numeroControl;
    this.nombre = nombre;
    this.telefono = telefono;
    this.carrera = carrera;
    this.genero = genero;
    this.calificacion = calificacion;
  }

  public Alumno() {
    this.numeroControl = "00000000";
    this.nombre = "Sin Nombre";
    this.telefono = "0000000000";
    this.carrera = "Sin Carrera";
    this.genero = 'D';
    this.calificacion = 0;
  }

  // Loguica de la la clase
  public void mostrar() {
    String format = "%s-10: %s";

    System.out.println("\nDatos del Alumno: " + nombre);
    System.out.printf(format, "  No. Control", numeroControl);
    System.out.printf(format, "  Nombre", nombre);
    System.out.printf(format, "  Telefono", telefono);
    System.out.printf(format, "  Carrera", carrera);
    System.out.printf(format, "  Genero", genero);
    System.out.printf(format, "  Genero", calificacion);
  }

  public void capturar() {
    Scanner sc = new Scanner(System.in);

    System.out.println("\nIngrese los datos del \"Alumno\"");

    System.out.print("No. Control: ");
    numeroControl = sc.nextLine();

    System.out.print("Nombre: ");
    nombre = sc.nextLine();

    System.out.print("Telefono: ");
    telefono = sc.nextLine();

    System.out.print("Carrera: ");
    carrera = sc.nextLine();

    System.out.print("Genero: ");
    genero = sc.nextLine().charAt(0);

    System.out.print("Genero: ");
    calificacion = sc.nextInt();

  }

  public boolean equals(String numeroControl) {
    if (this.numeroControl == numeroControl)
      return true;
    return false;
  }

  public String toString() {
    return nombre + "\n" + carrera;
  }

  // Encapsulamiento
  public String getNumeroControl() {
    return numeroControl;
  }

  public void setNumeroControl(String numeroControl) {
    this.numeroControl = numeroControl;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getCarrera() {
    return carrera;
  }

  public void setCarrera(String carrera) {
    this.carrera = carrera;
  }

  public char getGenero() {
    return genero;
  }

  public void setGenero(char genero) {
    this.genero = genero;
  }

  public void setCalificacion(int calificacion) {
    this.calificacion = calificacion;
  }

  public int getCalificacion() {
    return calificacion;
  }
}