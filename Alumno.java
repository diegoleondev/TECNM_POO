import java.util.Scanner;

public class Alumno extends Persona {
  protected String numeroControl;
  protected String carrera;
  protected int calificacion;
  protected char genero;
  protected Tutor tutor;

  // Constructores
  public Alumno(String nombre, String numeroControl,
      String telefono, String correo, String carrera, char genero) {
    super(nombre, telefono, correo);
    this.numeroControl = numeroControl;
    this.carrera = carrera;
    this.genero = genero;

    inicialisaDatos();
  }

  public Alumno(Alumno alumno) {
    super(alumno.getNombre(), alumno.getTelefono(), alumno.getCorreo());

    numeroControl = alumno.getNumeroControl();
    genero = alumno.getGenero();
    carrera = alumno.getCarrera();

    inicialisaDatos();
  }

  public Alumno(Persona persona) {
    super(persona.getNombre(), persona.getTelefono(), persona.getCorreo());
    Alumno alumno = (Alumno) persona;
    this.numeroControl = alumno.getNumeroControl();
    this.carrera = alumno.getCarrera();
    this.genero = alumno.getGenero();
  }

  public Alumno() {
    inicialisaDatos();
  }

  private void inicialisaDatos() {
    this.calificacion = 0;
  }

  /* ==============================[ LOGUICA ]============================= */
  @Override
  public void modificar() {
    if (eliminada)
      return;

    Scanner sc = new Scanner(System.in);

    do {
      System.out.println("1) Nombre 2) Correo 3) Telefono 4) Carrera");
      System.out.println("5) Calificacion 6) Genero 7) Tutor 0) Cancelar");
      System.out.print("Seleccione un parametro a Modificar : ");

      switch (sc.nextInt()) {
        case 0:
          return;
        case 1:
          System.out.print("\nIntroduzca el nuevo nombre : ");
          sc.nextLine();
          nombre = sc.nextLine();
          break;
        case 2:
          System.out.print("\nIntroduzca las nuevo correo : ");
          sc.nextLine();
          correo = sc.nextLine();
          break;
        case 3:
          System.out.print("\nIntroduzca el nuevo telefono : ");
          sc.nextLine();
          telefono = sc.nextLine();
          break;
        case 4:
          System.out.print("\nIntroduzca el nuevo carrera : ");
          sc.nextLine();
          carrera = sc.nextLine();
          break;
        case 5:
          System.out.print("\nIntroduzca el nuevo calificacion : ");
          sc.nextLine();
          calificacion = sc.nextInt();
          break;
        case 6:
          System.out.print("\nIntroduzca el nuevo genero : ");
          sc.nextLine();
          genero = sc.next().charAt(0);
          break;
        case 7:
          System.out.print("\nIntroduzca el nuevo Tutor : ( -- PENDIENTE -- ) ");
          sc.nextLine();
          break;
        default:
          System.out.println("Opccion no valida. ");
          break;
      }

      System.out.println("");
    } while (true);
  }

  @Override
  public void capturar() {
    Scanner sc = new Scanner(System.in);

    super.capturar();

    System.out.print("No. Control: ");
    numeroControl = sc.nextLine();

    System.out.print("Carrera: ");
    carrera = sc.nextLine();

    System.out.print("Genero (m/f): ");
    genero = sc.next().charAt(0);
  }

  @Override
  public void mostrar() {
    String format = "%-15s: %s\n";

    super.mostrar();
    System.out.printf(format, "No. Control", numeroControl);
    System.out.printf(format, "Carrera", carrera);
    System.out.printf(format, "Genero", genero);
    if (calificacion != 0)
      System.out.printf(format, "Calificacion", calificacion);

    if (tutor != null) {
      System.out.println("Tutor");
      tutor.mostrar();
    }
  }

  @Override
  public String quienSoy() {
    return "Alumno";
  }

  @Override
  public boolean equals(String numeroControl) {
    return (this.numeroControl.equals(numeroControl));
  }

  @Override
  public boolean buscar(String string) {
    String contenido = correo + nombre + telefono + eliminada + numeroControl + carrera + calificacion + genero + tutor;

    return contenido.indexOf(string) >= 0 ? true : false;
  }

  public String toString() {
    return numeroControl + " " + nombre;
  }

  public void asignarTutor(Persona persona) {
    Tutor tutor = (Tutor) persona;
    this.tutor = new Tutor(tutor);
  }

  public boolean hasTutor(String rfc) {
    return tutor.getRfc() == rfc;
  }

  // Encapsulamiento
  public String getNumeroControl() {
    return numeroControl;
  }

  public void setNumeroControl(String numeroControl) {
    this.numeroControl = numeroControl;
  }

  public String getCarrera() {
    return carrera;
  }

  public void setCarrera(String carrera) {
    this.carrera = carrera;
  }

  public char getGenero() {
    return genero;
  }

  public void setGenero(char genero) {
    this.genero = genero;
  }

  public void setCalificacion(int calificacion) {
    this.calificacion = calificacion;
  }

  public int getCalificacion() {
    return calificacion;
  }

  public Tutor getTutor() {
    return tutor;
  }

}