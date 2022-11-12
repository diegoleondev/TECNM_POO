import java.util.Scanner;

public class Tutor extends Profesor {
  private String otrosCursos;
  private boolean tomoDiplomado;
  private String fechaDiploma;
  private String moduloDiplomado;

  public Tutor(Persona persona, String otrosCursos, Boolean tomoDiplomado, String fechaDiploma,
      String moduloDiplomado) {
    super(persona);
    this.otrosCursos = otrosCursos;
    this.tomoDiplomado = tomoDiplomado;
    this.fechaDiploma = fechaDiploma;
    this.moduloDiplomado = moduloDiplomado;
  }

  public Tutor(Tutor tutor) {
    super(tutor.getCorreo(), tutor.getEspecializacion(), tutor.getNombre(), tutor.getRfc(),
        tutor.getTelefono());
    this.otrosCursos = tutor.getOtrosCursos();
    this.tomoDiplomado = tutor.getTomoDiplomado();
    this.fechaDiploma = tutor.getFechaDiploma();
    this.moduloDiplomado = tutor.getModuloDiplomado();
  }

  public Tutor() {
  }

  @Override
  public void capturar() {
    Scanner scanner = new Scanner(System.in);

    super.capturar();

    System.out.print("Otros Cursos : ");
    otrosCursos = scanner.nextLine();

    System.out.print("Tomo Diplomado \n 1. Si 2. No : ");
    tomoDiplomado = scanner.nextInt() == 1 ? true : false;

    System.out.print("Fecha Diploma : ");
    scanner.nextLine();
    fechaDiploma = scanner.nextLine();

    System.out.print("Modulo Diplomado : ");
    moduloDiplomado = scanner.nextLine();
  }

  @Override
  public void mostrar() {
    String format = "%-15s: %s\n";

    super.mostrar();
    System.out.printf(format, "Otros Cursos", otrosCursos);
    System.out.printf(format, "Tomo Diplomado", tomoDiplomado ? "Si" : "No");
    System.out.printf(format, "Fecha Diploma", fechaDiploma);
    System.out.printf(format, "Modulo Diploma", moduloDiplomado);
  }

  @Override
  public String quienSoy() {
    return "Tutor";
  }

  @Override
  public boolean buscar(String string) {
    String contenido = otrosCursos + tomoDiplomado + fechaDiploma + moduloDiplomado + correo + nombre + telefono
        + eliminada + especializacion + rfc;

    return contenido.indexOf(string) >= 0 ? true : false;
  }

  public String getOtrosCursos() {
    return otrosCursos;
  }

  public boolean getTomoDiplomado() {
    return tomoDiplomado;
  }

  public String getFechaDiploma() {
    return fechaDiploma;
  }

  public String getModuloDiplomado() {
    return moduloDiplomado;
  }

}
