import java.util.Scanner;

public class Aula {
  private boolean aula;
  private int capacidad;
  private String edificio;
  private String nombre;

  // Constructores
  public Aula(boolean aula, int capacidad, String edificio, String nombre) {
    this.aula = aula;
    this.capacidad = capacidad;
    this.edificio = edificio;
    this.nombre = nombre;
  }

  public Aula() {
    this.aula = false;
    this.capacidad = 0;
    this.edificio = "";
    this.nombre = "";
  }

  // Logica de la clase
  public void mostrar() {
    String format = "%-10s: %s\n";

    System.out.println("\nDatos del Aula");
    System.out.printf(format, "  Edificio", edificio);
    System.out.printf(format, "  Nombre", nombre);
    System.out.printf(format, "  Capasidad", capacidad);
    System.out.printf(format, "  Tipo", aula ? "Aula" : "Laboratorio");
  }

  public void capturar() {
    Scanner sc = new Scanner(System.in);

    System.out.println("\nIngrese los datos del Aula");

    System.out.print("Edificio: ");
    edificio = sc.nextLine();

    System.out.print("Nombre: ");
    nombre = sc.nextLine();

    System.out.print("Capasidad: ");
    capacidad = sc.nextInt();

    System.out.print("a) Aula  b) Laboratorio: ");
    aula = (sc.next().charAt(0) == 'a') ? true : false;
  }

  public boolean equals(String nombre, String edificio) {
    return (this.nombre == nombre && this.edificio == edificio) ? true : false;
  }

  public String toString() {
    return nombre + "\n" + edificio;
  }

  // Encapsulamiento
  public boolean isAula() {
    return aula;
  }

  public void setAula(boolean isAula) {
    this.aula = isAula;
  }

  public int getCapacidad() {
    return capacidad;
  }

  public void setCapacidad(int capacidad) {
    this.capacidad = capacidad;
  }

  public String getEdificio() {
    return edificio;
  }

  public void setEdificio(String edificio) {
    this.edificio = edificio;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
}
