import java.util.Scanner;

public class Profesor {
  //Atributos
  private String correo;
  private String especializacion;
  private String nombre;
  private String rfc;
  private String telefono;

  //Constructores
  public Profesor (String correo, String especializacion, String nombre, String rfc, String telefono) {
    this.correo = correo;
    this.especializacion = especializacion;
    this.nombre = nombre;
    this.rfc = rfc;
    this.telefono = telefono;
  }

  public Profesor () {
    this.correo = "";
    this.especializacion = "";
    this.nombre = "";
    this.rfc = "";
    this.telefono = "";
  }

  //Logica de la clase
  public void mostrar () {
    System.out.println("\nDatos del \"Profesor\"");
    System.out.printf("%-15s: %s\n", "Correo", correo);
    System.out.printf("%-15s: %s\n", "Especializacion", especializacion);
    System.out.printf("%-15s: %s\n", "Nombre", nombre);
    System.out.printf("%-15s: %s\n", "RFC", rfc);
    System.out.printf("%-15s: %s\n", "Telefono", telefono);
  }

  public void capturar (){
    Scanner scanner = new Scanner(System.in);

    System.out.println("\nIngrese los datos del \"Profesor\"");
    System.out.printf("%-15s:","Correo"); correo =  scanner.nextLine();
    System.out.printf("%-15s:","Especializacion"); especializacion = scanner.nextLine();
    System.out.printf("%-15s:","Nombre"); nombre = scanner.nextLine();
    System.out.printf("%-15s:","RFC"); rfc = scanner.nextLine();
    System.out.printf("%-15s:","Telefono"); telefono = scanner.nextLine();
    
    scanner.close();
  }

  public boolean isEquals (String rfc) {
    return (this.rfc == rfc) ? true : false; 
  }

  public String toString () {
    return rfc + "\n" + nombre;
  }
  
  // Encapsulamiento
  public String getCorreo() {
    return correo;
  }
  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public String getEspecializacion() {
    return especializacion;
  }
  public void setEspecializacion(String especializacion) {
    this.especializacion = especializacion;
  }

  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getRfc() {
    return rfc;
  }
  public void setRfc(String rfc) {
    this.rfc = rfc;
  }

  public String getTelefono() {
    return telefono;
  }
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }
}
