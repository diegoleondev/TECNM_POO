import java.util.Scanner;

public class Profesor extends Persona {
  // Atributos
  private String especializacion;
  private String rfc;

  // Constructores
  public Profesor(String correo, String especializacion, String nombre, String rfc, String telefono) {
    super(nombre, telefono, correo);
    this.especializacion = especializacion;
    this.rfc = rfc;
  }

  public Profesor(Persona persona) {
    super(persona.getNombre(), persona.getTelefono(), persona.getCorreo());

    Profesor profesor = (Profesor) persona;
    this.especializacion = profesor.getEspecializacion();
    this.rfc = profesor.getRfc();
  }

  public Profesor() {
    capturar();
  }

  // Logica de la clase
  // @Override
  public void mostrar() {
    String format = "%-16s: %20s\n";
    System.out.println("---- Profesor ----");
    super.mostrar(format);
    System.out.printf(format, "  RFC", rfc);
    System.out.printf(format, "  Telefono", telefono);
  }

  public String quienSoy() {
    return "Profesor";
  }

  public void capturar() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("\nIngrese los datos del \"Profesor\"");

    System.out.print("Correo: ");
    correo = scanner.nextLine();

    System.out.print("Especializacion: ");
    especializacion = scanner.nextLine();

    System.out.print("Nombre: ");
    nombre = scanner.nextLine();

    System.out.print("RFC: ");
    rfc = scanner.nextLine();

    System.out.print("Telefono: ");
    telefono = scanner.nextLine();
  }

  public boolean equals(String rfc) {
    return (this.rfc == rfc) ? true : false;
  }

  public String toString() {
    return rfc + "\n" + nombre;
  }

  // Encapsulamiento
  public String getEspecializacion() {
    return especializacion;
  }

  public void setEspecializacion(String especializacion) {
    this.especializacion = especializacion;
  }

  public String getRfc() {
    return rfc;
  }

  public void setRfc(String rfc) {
    this.rfc = rfc;
  }

}
