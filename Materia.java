import java.util.Scanner;

public class Materia {
  private String clave;
  private String nombre;
  private String unidades;
  private String satca;

  // Constructores
  public Materia(String clave, String nombre, String unidades, String satca) {
    this.clave = clave;
    this.nombre = nombre;
    this.unidades = unidades;
    this.satca = satca;
  }

  public Materia() {
    this.clave = "";
    this.nombre = "";
    this.unidades = "";
    this.satca = "0-0-0";
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
    satca = scanner.nextLine();
  }

  public boolean equals(String clave) {
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

  public String getSatca() {
    return satca;
  }

  public void setSatca(String satca) {
    this.satca = satca;
  }
}
