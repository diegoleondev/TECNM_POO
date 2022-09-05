import java.util.Scanner;

public class Alumno {
  // Atributos
  private String numeroControl;
  private String nombre;
  private String telefono;
  private String carrera;
  private char   genero;

  // Constructores
  public Alumno (String numeroControl, String nombre, String telefono, String carrera, char genero) {
    this.numeroControl = numeroControl;
    this.nombre = nombre;
    this.telefono = telefono;
    this.carrera = carrera;
    this.genero = genero;
  }

  public Alumno () {
    this.numeroControl = "00000000";
    this.nombre = "Sin Nombre";
    this.telefono = "0000000000";
    this.carrera = "Sin Carrera";
    this.genero = 'M';
  }

  // Loguica de la la clase
  public void mostrar () {
    System.out.println("\nDatos del \"Alumno\"");
    System.out.printf("%-11s: %s\n", "No. Control", numeroControl);
    System.out.printf("%-11s: %s\n", "Nombre", nombre);
    System.out.printf("%-11s: %s\n", "Telefono", telefono);
    System.out.printf("%-11s: %s\n", "Carrera", carrera);
    System.out.printf("%-11s: %s\n", "Genero", genero);
  }

  public void capturar () {
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("\nIngrese los datos del \"Alumno\"");
    System.out.printf("%-11s: ", "No. Control"); numeroControl = scanner.nextLine();
    System.out.printf("%-11s: ", "Nombre"); nombre = scanner.nextLine();
    System.out.printf("%-11s: ", "Telefono"); telefono = scanner.nextLine();
    System.out.printf("%-11s: ", "Carrera"); carrera = scanner.nextLine();
    System.out.printf("%-11s: ", "Genero"); genero = scanner.nextLine().charAt(0);

    scanner.close();
  }

  public boolean isEquals (String numeroControl) {
    if(this.numeroControl == numeroControl) 
      return true; 
    return false;
  }

  public String toString () {
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
}