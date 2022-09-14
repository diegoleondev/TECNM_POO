import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Escuela escuela = new Escuela("16TIC", "Av. Tecnologuico #550", "Tecnologuico de Mexico");

    escuela.listarCursos();

    System.out.print("Seleccione un curso (n): ");
    escuela.listarDetalles(sc.nextInt() - 1);

    sc.close();
  }
}
