import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Escuela escuela = new Escuela("16TIC", "Av. Tecnologuico #550", "Tecnologuico de Mexico");

    do {
      switch (mostrarMenu()) {
        case 11:
          escuela.listarCursos();
          break;
        case 12:
          escuela.capturarCurso();
          break;
        case 21:
          escuela.listarAlumnos();
          break;
        case 22:
          escuela.capturarAlumno();
          break;
        case 31:
          escuela.listarPorefesores();
          break;
        case 32:
          escuela.capturarProfesor();
          break;
        case 41:
          escuela.listarAulas();
          break;
        case 42:
          escuela.capturarAula();
          break;
        case 51:
          escuela.listarMaterias();
          break;
        case 52:
          escuela.capturarMateria();
          break;
        default:
          System.out.println("Opcion no valida");
          break;
      }
    } while (true);
  }

  public static int mostrarMenu() {
    Scanner sc = new Scanner(System.in);

    System.out.println("\nMenu");
    System.out.println("1) Cursos 2) Alumnos 3) Profesores 4) Aulas 5) Materias");
    System.out.print("Seleccione una opcion: ");
    int accion = sc.nextInt();

    if (accion == 0)
      return 0;

    System.out.println("\n1) Mostrar 2) Agregar 3) Canselar");
    System.out.print("Seleccione una opcion: ");
    accion = accion * 10 + sc.nextInt();

    System.out.println("\n");
    return accion;
  }
}
