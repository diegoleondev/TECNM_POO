import java.util.Scanner;

public class Cedula implements Acciones {
  private String fecha;
  private String institucion;
  private String titulo;
  private String numCedula;
  private boolean eliminada = false;

  public Cedula(String fecha, String institucion, String titulo, String numCedula) {
    this.fecha = fecha;
    this.institucion = institucion;
    this.titulo = titulo;
    this.numCedula = numCedula;
  }

  public Cedula() {
    capturar();
  }

  public void capturar() {
    Scanner sc = new Scanner(System.in);

    System.out.print("Fecha : ");
    fecha = sc.nextLine();

    System.out.print("Institucion : ");
    institucion = sc.nextLine();

    System.out.print("Titulo : ");
    titulo = sc.nextLine();

    System.out.print("NumCedula : ");
    numCedula = sc.nextLine();
  }

  public boolean isEliminada() {
    return eliminada;
  }

  public void eliminar() {
    eliminada = true;
  }

  public void modificar() {
  }

  public boolean buscar(String string) {
    return true;
  }

  public void mostrar() {
    System.out.println("Fecha : " + fecha);
    System.out.println("Institucion : " + institucion);
    System.out.println("Titulo : " + titulo);
    System.out.println("Num Cedula : " + numCedula);
  }

  public String getFecha() {
    return fecha;
  };

  public String getInstitucion() {
    return institucion;
  };

  public String getTitulo() {
    return titulo;
  };

  public String getNumCedula() {
    return numCedula;
  };
}
