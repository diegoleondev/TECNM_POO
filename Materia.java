import java.util.Scanner;

public class Materia {
  private String clave;
  private String nombre;
  private String unidades;
  private int satca;

  // Constructores
  public Materia(String clave, String nombre, String unidades, int satca) {
    this.clave = clave;
    this.nombre = nombre;
    this.unidades = unidades;
    this.satca = satca;
  }

  public Materia() {
    this.clave = "";
    this.nombre = "";
    this.unidades = "";
    this.satca = 0;
  }

  // LOGICA DE LA CLASE
  public void mostrar() {
    String format = "%-16s: %s\n";

    System.out.println("Materia:");
    System.out.printf(format, "  Clave", clave);
    System.out.printf(format, "  Nombre", nombre);
    System.out.printf(format, "  Unidades", unidades);
    System.out.printf(format, "  SATCA", satca);
  }

  public void capturar() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("\nIngrese los datos de la Materia");

    System.out.print("Clave: ");
    clave = scanner.nextLine();

    System.out.print("Nombre: ");
    nombre = scanner.nextLine();

    System.out.print("Unidades: ");
    unidades = scanner.nextLine();

    System.out.print("SATCA: ");
    satca = scanner.nextInt();
  }

  public boolean isEquals(String clave) {
    return (this.clave == clave) ? true : false;
  }

  public String toString() {
    return clave + "\n" + nombre;
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

  public int getSatca() {
    return satca;
  }

  public void setSatca(int satca) {
    this.satca = satca;
  }
}
