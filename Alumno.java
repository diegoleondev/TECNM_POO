import java.util.Scanner;

public class Alumno extends Persona {
  private String numeroControl;
  private String carrera;
  private int calificacion;
  private char genero;

  // Constructores
  public Alumno(String nombre, String numeroControl,
      String telefono, String correo, String carrera, char genero) {
    super(nombre, telefono, correo);
    this.numeroControl = numeroControl;
    this.carrera = carrera;
    this.genero = genero;

    System.out.println(numeroControl);
    inicialisaDatos();
  }

  public Alumno() {
    capturar();

    inicialisaDatos();
  }

  private void inicialisaDatos() {
    this.calificacion = 0;
  }

  public void mostrar() {
    String format = "%s-10: %s";

    System.out.println("\nDatos del Alumno: " + nombre);
    super.mostrar(format);
    System.out.printf(format, "  No. Control", numeroControl);
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
    return (this.numeroControl == numeroControl) ? true : false;
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