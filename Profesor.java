import java.util.Scanner;

public class Profesor extends Persona {
  protected String especializacion;
  protected String rfc;

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

  }

  // Logica de la clase
  @Override
  public boolean buscar(String string) {
    String contenido = correo + nombre + telefono + eliminada + especializacion + rfc;

    return contenido.indexOf(string) >= 0 ? true : false;
  }

  @Override
  public void modificar() {
    if (eliminada)
      return;
    Scanner sc = new Scanner(System.in);

    do {
      System.out.println("1) Nombre 2) Correo 3) Telefono");
      System.out.println("4) Especializacion 0) Cancelar");
      System.out.print("Seleccione un parametro a Modificar : ");

      switch (sc.nextInt()) {
        case 1:
          System.out.print("\nIngrese el nuevo Nombre : ");
          sc.nextLine();
          nombre = sc.nextLine();
          break;
        case 2:
          System.out.print("\nIngrese las Nuevas Correo : ");
          sc.nextLine();
          correo = sc.nextLine();
          break;
        case 3:
          System.out.print("\nIngrese el nuevo Telefono : ");
          sc.nextLine();
          telefono = sc.nextLine();
          break;
        case 4:
          System.out.print("\nIngrese el nuevo Especializacion : ");
          sc.nextLine();
          especializacion = sc.nextLine();
          break;
        default:
          return;
      }

      System.out.println("");
    } while (true);
  }

  @Override
  public void mostrar() {
    String format = "%-15s: %s\n";
    super.mostrar();
    System.out.printf(format, "RFC", rfc);
    System.out.printf(format, "Telefono", telefono);
  }

  @Override
  public void capturar() {
    Scanner scanner = new Scanner(System.in);

    super.capturar();

    System.out.print("Especializacion: ");
    especializacion = scanner.nextLine();

    System.out.print("RFC: ");
    rfc = scanner.nextLine();

  }

  @Override
  public String quienSoy() {
    return "Profesor";
  }

  @Override
  public boolean equals(String clave) {
    return (this.rfc.equals(clave));
  }

  @Override
  public String toString() {
    return rfc + " " + nombre;
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
