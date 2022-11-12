
import java.util.Scanner;

public class Materia implements Acciones {
  private String clave;
  private String nombre;
  private String unidades;
  private String satca;
  private boolean eliminada;

  // Constructores
  public Materia(String clave, String nombre, String unidades, String satca) {
    this.clave = clave;
    this.nombre = nombre;
    this.unidades = unidades;
    this.satca = satca;
    eliminada = false;
  }

  public Materia() {
    capturar();
    eliminada = false;
  }

  // LOGICA DE LA CLASE
  public void mostrar() {
    String format = "%-15s: %s\n";

    System.out.printf(format, "Clave", clave);
    System.out.printf(format, "Nombre", nombre);
    System.out.printf(format, "Unidades", unidades);
    System.out.printf(format, "SATCA", satca);
  }

  public void capturar() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Clave: ");
    clave = scanner.nextLine();

    System.out.print("Nombre: ");
    nombre = scanner.nextLine();

    System.out.print("Unidades: ");
    unidades = scanner.nextLine();

    System.out.print("SATCA: ");
    satca = scanner.nextLine();
  }

  public boolean isEliminada() {
    return eliminada;
  }

  public boolean equals(String clave) {
    return this.clave.equals(clave);
  }

  public String toString() {
    return clave + " " + nombre;
  }

  public boolean buscar(String string) {
    String contenido = clave + nombre + unidades + satca;

    return contenido.indexOf(string) >= 0 ? true : false;
  }

  public void eliminar() {
    eliminada = true;
  }

  public void modificar() {
    if (eliminada)
      return;
    Scanner sc = new Scanner(System.in);

    do {
      System.out.println("1) Nombre 2) Unidades 3) SATCA 0) Cancelar");
      System.out.print("Seleccione un valor a Modificar : ");

      switch (sc.nextInt()) {
        case 1:
          System.out.print("\nIngrese el nuevo Nombre : ");
          sc.nextLine();
          nombre = sc.nextLine();
          break;
        case 2:
          System.out.print("\nIngrese las Nuevas Unidades : ");
          sc.nextLine();
          unidades = sc.nextLine();
          break;
        case 3:
          System.out.print("\nIngrese el nuevo SATCA : ");
          sc.nextLine();
          satca = sc.nextLine();
          break;
        default:
          return;
      }

      System.out.println("");
    } while (true);
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

  public String getUnidades() {
    return unidades;
  }

  public void setUnidades(String unidades) {
    this.unidades = unidades;
  }

  public String getSatca() {
    return satca;
  }

  public void setSatca(String satca) {
    this.satca = satca;
  }
}
