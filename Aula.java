import java.io.Serializable;
import java.util.Scanner;

public class Aula implements Acciones, Serializable {
  private boolean aula;
  private int capacidad;
  private String edificio;
  private String nombre;
  private boolean eliminada = false;

  // Constructores
  public Aula(boolean aula, int capacidad, String edificio, String nombre) {
    this.aula = aula;
    this.capacidad = capacidad;
    this.edificio = edificio;
    this.nombre = nombre;
  }

  public Aula() {
    capturar();
  }

  /* ==============================[ LOGUICA ]============================= */
  public void modificar() {
    if (eliminada)
      return;
    Scanner sc = new Scanner(System.in);

    do {
      System.out.println(" 1) Nombre 2) Edificio 3) Aula 4) Capacidad 0) Cancelar");
      System.out.print("Seleccione un valor a Modificar : ");

      switch (sc.nextInt()) {
        case 0:
          return;
        case 1:
          System.out.print("Introduzca el nuevo nombre : ");
          nombre = sc.next();
          break;
        case 2:
          System.out.print("Introduzca el nuevo edificio : ");
          edificio = sc.next();
          break;
        case 3:
          System.out.print("1 ) Aula 2) Laboratorio : ");
          aula = sc.nextInt() == 1;
          break;
        case 4:
          System.out.print("Introduzca la nueva capacidad : ");
          capacidad = sc.nextInt();
          break;
        default:
          System.out.println("Opccion no valida. ");
          break;
      }

      System.out.println("");
    } while (true);
  }

  public void mostrar() {
    String format = "%-15s: %s\n";

    System.out.printf(format, "Edificio", edificio);
    System.out.printf(format, "Nombre", nombre);
    System.out.printf(format, "Capasidad", capacidad);
    System.out.printf(format, "Tipo", aula ? "Aula" : "Laboratorio");
  }

  public void capturar() {
    Scanner sc = new Scanner(System.in);

    System.out.print("Edificio: ");
    edificio = sc.nextLine();

    System.out.print("Nombre: ");
    nombre = sc.nextLine();

    System.out.print("Capasidad: ");
    capacidad = sc.nextInt();

    System.out.print("1) Aula  2) Laboratorio: ");
    aula = (sc.nextInt() == 1) ? true : false;
  }

  public boolean equals(String clave) {
    return (edificio + nombre).equals(clave);
  }

  public boolean buscar(String string) {
    String cadena = (aula ? "Aula" : "Laboratorio") + capacidad + edificio + nombre;

    return cadena.indexOf(string) >= 0 ? true : false;
  }

  public void eliminar() {
    eliminada = true;
  }

  public boolean isEliminada() {
    return eliminada;
  }

  public String toString() {
    return edificio + nombre;
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
