import java.util.Scanner;

public abstract class Persona implements Acciones {
  protected String correo;
  protected String nombre;
  protected String telefono;
  protected boolean eliminada;

  public Persona(String nombre, String telefono, String correo) {
    this.nombre = nombre;
    this.telefono = telefono;
    this.correo = correo;

    inicializarDatos();
  }

  public Persona() {
    capturar();

    inicializarDatos();
  }

  private void inicializarDatos() {
    eliminada = false;
  }

  public void mostrar() {
    String format = "%-15s: %s\n";
    System.out.printf(format, "Nombre", nombre);
    System.out.printf(format, "Telefono", telefono);
    System.out.printf(format, "correo", correo);
  }

  public void capturar() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Nombre : ");
    nombre = scanner.nextLine();

    System.out.print("Correo : ");
    correo = scanner.next();

    System.out.print("Telefono : ");
    telefono = scanner.next();
  }

  public void eliminar() {
    eliminada = true;
  }

  protected boolean isEliminada() {
    return eliminada;
  }

  protected abstract String quienSoy();

  protected abstract boolean equals(String clave);

  protected String getCorreo() {
    return correo;
  }

  protected void setCorreo(String correo) {
    this.correo = correo;
  }

  protected String getNombre() {
    return nombre;
  }

  protected void setNombre(String nombre) {
    this.nombre = nombre;
  }

  protected String getTelefono() {
    return telefono;
  }

  protected void setTelefono(String telefono) {
    this.telefono = telefono;
  }
}
