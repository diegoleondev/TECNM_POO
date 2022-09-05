import java.util.Scanner;

public class Materia {
  private String clave;
  private String nombre;
  private String unidades;
  private int    satca;

  // Constructores
  public Materia (String clave, String nombre, String unidades, int satca) {
    this.clave = clave;
    this.nombre = nombre;
    this.unidades = unidades;
    this.satca = satca;
  }

  public Materia () {
    this.clave = "";
    this.nombre = "";
    this.unidades = "";
    this.satca = 0;
  }

  // Logica de la clase
  public void  mostrar () {
    System.out.println("\nDatos de la \"Materia\"");
    System.out.printf("%-10s: %s\n", "Clave", clave);
    System.out.printf("%-10s: %s\n", "Nombre", nombre);
    System.out.printf("%-10s: %s\n", "Unidades", unidades);
    System.out.printf("%-10s: %s\n", "SATCA", satca);
  }

  public void capturar (){
    Scanner scanner = new Scanner(System.in);

    System.out.println("\nIngrese los datos de la \"Materia\"");
    System.out.printf("%-10s:","Clave"); clave =  scanner.nextLine();
    System.out.printf("%-10s:","Nombre"); nombre = scanner.nextLine();
    System.out.printf("%-10s:","Unidades"); unidades = scanner.nextLine();
    System.out.printf("%-10s:","SATCA"); satca = scanner.nextInt();
    
    scanner.close();
  }

  public boolean isEquals (String clave) {
    return (this.clave == clave) ? true : false; 
  }

  public String toString () {
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
