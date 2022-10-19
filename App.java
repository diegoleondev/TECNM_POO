import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Escuela escuela = new Escuela("16TIC", "Av. Tecnologuico #550", "Tecnologuico de Mexico");

    boolean seguir = true;

    do {
      switch (mostrarMenu()) {
        case 0:
          seguir = false;
          break;
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
        case 61:
          escuela.listarTutores();
          break;
        case 71:
          escuela.listarAlumnosPosgrado();
          break;
        /*
         * case 72:
         * escuela.capturarAlumnoPosgrado();
         * break;
         */
        case 9999:
          System.out.println("-- Cancelado --");
          break;
        default:
          System.out.println("Opcion no valida");
          break;
      }
    } while (seguir);
  }

  public static int mostrarMenu() {
    Scanner sc = new Scanner(System.in);

    System.out.println("\nMenu");
    System.out
        .println("1) Cursos 2) Alumnos 3) Profesores 4) Aulas 5) Materias 6) Tutores 7)Alumnos Posgrado  0) Cancelar");
    System.out.print("Seleccione una opcion: ");
    int accion = sc.nextInt();

    if (accion == 0)
      return 0;

    if (accion < 1 && accion > 5)
      return 10000;

    System.out.println("\n1) Mostrar 2) Agregar 0) Cancelar");
    System.out.print("Seleccione una opcion: ");
    int accion2 = sc.nextInt();

    if (accion2 == 0)
      return 9999;

    if (accion < 1 && accion > 2)
      return 10000;

    return accion * 10 + accion2;
  }
}
