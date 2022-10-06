public class Persona {
  protected String correo;
  protected String nombre;
  protected String telefono;

  public Persona(String nombre, String telefono, String correo) {
    this.nombre = nombre;
    this.telefono = nombre;
    this.correo = correo;
  }

  public Persona() {

  }

  protected void mostrar(String format) {
    System.out.printf(format, "Nombre", nombre);
    System.out.printf(format, "Telefono", telefono);
    System.out.printf(format, "correo", correo);
  }

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
