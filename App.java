import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Escuela escuela = new Escuela("16TIC", "Av. Tecnologuico #550", "Tecnologuico de Mexico");

    do {
      switch (mostrarMenu()) {
        case 0:
          return;
        /* ----------[ Listar ]---------- */
        case 11:
          escuela.mostrarCursos();
          break;
        case 21:
          escuela.mostrarAlumnos();
          break;
        case 31:
          escuela.mostrarPorefesores();
          break;
        case 41:
          escuela.mostrarAulas();
          break;
        case 51:
          escuela.mostrarMaterias();
          break;
        case 61:
          escuela.mostrarTutores();
          break;
        case 71:
          escuela.mostrarAlumnosPosgrado();
          break;
        /* ----------[ Capturar ]---------- */
        case 12:
          escuela.capturarCurso();
          break;
        case 22:
          escuela.capturarAlumno();
          break;
        case 32:
          escuela.capturarProfesor();
          break;
        case 42:
          escuela.capturarAula();
          break;
        case 52:
          escuela.capturarMateria();
          break;
        case 62:
          escuela.capturarTutor();
          break;
        case 72:
          escuela.capturarAlumnoPosgrado();
          break;
        /* ----------[ BUSCAR ]---------- */
        case 13:
          escuela.buscarCurso();
          break;
        case 23:
          escuela.buscarAlumno();
          break;
        case 33:
          escuela.buscarProfesor();
          break;
        case 43:
          escuela.buscarAula();
          break;
        case 53:
          escuela.buscarMateria();
          break;
        case 63:
          escuela.buscarTutor();
          break;
        case 73:
          escuela.buscarAlumnoPosgrado();
          break;
        /* ----------[ MODIFICAR ]---------- */
        case 14:
          escuela.modificarCurso();
          break;
        case 24:
          escuela.modificarAlumno();
          break;
        case 34:
          escuela.modificarProfesor();
          break;
        case 44:
          escuela.modificarAula();
          break;
        case 54:
          escuela.modificarMateria();
          break;
        case 64:
          escuela.modificarTutor();
          break;
        case 74:
          escuela.modificarAlumnoPosgrado();
          break;
        /* ----------[ ELIMINAR ]---------- */
        case 15:
          escuela.eliminarCurso();
          break;
        case 25:
          escuela.eliminarAlumno();
          break;
        case 35:
          escuela.eliminarProfesor();
          break;
        case 45:
          escuela.eliminarAula();
          break;
        case 55:
          escuela.eliminarMateria();
          break;
        case 65:
          escuela.eliminarTutor();
          break;
        case 75:
          escuela.eliminarAlumnoPosgrado();
          break;
        case 99:
          break;
        default:
          System.out.println("Opcion no valida");
          break;
      }
    } while (true);

  }

  public static int mostrarMenu() {
    Scanner sc = new Scanner(System.in);

    System.out.println("========================[ MENU ]========================");
    System.out.println("1) Cursos    2) Alumnos  3) Profesores        4) Aulas");
    System.out.println("5) Materias  6) Tutores  7) Alumnos Posgrado  0) Cancelar");
    System.out.print("Seleccione una Opcion : ");

    int accion = sc.nextInt();

    if (accion == 0)
      return 0;

    System.out.println("=======================[ SUBMENU ]======================");
    System.out.println("1) Mostrar   2) Agregar  3) Buscar");
    System.out.println("4) Modificar 5) Eliminar 0) Cancelar");
    System.out.print("Seleccione una Opcion : ");

    int accion2 = sc.nextInt();

    if (accion2 == 0)
      return 99;

    return accion * 10 + accion2;
  }
}
