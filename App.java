import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Escuela escuela = new Escuela("16TIC", "Av. Tecnologuico #500", "Tecnologuico de Morelia");

    escuela.listarCursos();

    System.out.println("Seleccione un curso: ");
    int index = sc.nextInt();

    escuela.getCursos()[index - 1].listarAlumnos();

  }
}
