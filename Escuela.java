import java.util.Scanner;

public class Escuela {
  private String nombre;
  private String numeroControl;
  private String domicilio;

  private Curso cursos[] = new Curso[500];
  private int cCursos;

  private Aula aulas[] = new Aula[500];
  private int cAulas;

  private Materia materias[] = new Materia[500];
  private int cMaterias;

  private Persona personas[] = new Persona[100];
  private int cPersonas;

  public Escuela(String clave, String domicilio, String nombre) {
    this.numeroControl = clave;
    this.domicilio = domicilio;
    this.nombre = nombre;

    inicializarDatos();
  }

  // Sobrecarga

  private void inicializarDatos() {
    // DB - Materias
    materias[0] = new Materia("AED-1287", "Programacion Orientada a Objetos", "5", "3-2-5");
    materias[1] = new Materia("AED-1246", "Calculo Integral", "5", "1-2-3");
    materias[2] = new Materia("AED-1275", "Algebra Lineal", "4", "3-2-5");

    cMaterias = 3;

    // DB - Cursos
    cursos[0] = new Curso("B2L1A", true, "ago-dic 2022", "09:00", materias[0]);
    cursos[1] = new Curso("B2L2A", true, "ago-dic 2022", "08:00", materias[1]);
    cursos[2] = new Curso("B2L3A", false, "ago-dic 2022", "10:00", materias[2]);

    cCursos = 3;

    // DB - Profesores
    personas[0] = new Alumno("Antonio Gomez", "22120601", "441 555 6666", "antonio@email.com", "ISC", 'M');
    personas[1] = new Alumno("Juan Diaz", "22120602", "441 555 6666", "juan@email.com", "ISC", 'M');
    personas[2] = new Alumno("Alexis Salgado", "22120603", "441 555 6666", "alexis@email.com", "ISC", 'M');
    personas[3] = new Alumno("Samuel Rodrigez", "22120604", "441 555 6666", "alexis@email.com", "ISC", 'M');
    personas[4] = new Alumno("Paco Aguilar", "22120605", "441 555 6456", "paco@email.com", "ISC", 'M');
    personas[5] = new Profesor("martin@tecnm.com", "TICS", "Martin Martinez", "MART20003", "443 111 5555");
    personas[6] = new Profesor("omar@tecnm.com", "Matematicas", "Omar Calderon", "OMAR23003", "443 555 222");
    personas[7] = new Profesor("paco@tecnm.com", "Matematicas", "Gerardo Diaz", "PACO23003", "442 465 752");
    personas[8] = new Tutor(personas[5], "mate - quimica", true, "02/02/2010", "modulo 1");
    personas[9] = new Tutor(personas[6], "fisica - quimica", true, "08/02/205", "modulo 5");
    personas[10] = new AlumnoPosgrado(personas[0], "Chiles Maria", "Gerente", "Chiles", "Soltero", "08/10/2025",
        "tecmorelia", "Ing. Sistemas", "XXX-XXX-CEDULA");
    personas[11] = new AlumnoPosgrado(personas[1], "Tacos Jose", "Gerente", "Tacos", "Soltero", "04/04/2025",
        "tecmorelia", "Ing. Sistemas", "XXX-XXX-CEDULA");

    cPersonas = 12;
    Alumno a1 = (Alumno) personas[0],
        a2 = (Alumno) personas[1],
        a3 = (Alumno) personas[2],
        a4 = (Alumno) personas[3],
        a5 = (Alumno) personas[4];

    a1.asignarTutor(personas[8]);
    a2.asignarTutor(personas[8]);
    a3.asignarTutor(personas[9]);
    a4.asignarTutor(personas[9]);
    a5.asignarTutor(personas[9]);

    // DB - Aulas
    aulas[0] = new Aula(true, 30, "AG", "LC1");
    aulas[1] = new Aula(true, 25, "AG", "LC2");
    aulas[2] = new Aula(false, 40, "F", "3");
    aulas[3] = new Aula(false, 32, "K", "8");

    cAulas = 4;

    // Asignaciones

    cursos[0].asignarPrefesor(personas[5]);
    cursos[1].asignarPrefesor(personas[6]);
    cursos[2].asignarPrefesor(personas[7]);

    cursos[0].agregarAula(aulas[0]);
    cursos[0].agregarAula(aulas[1]);
    cursos[1].agregarAula(aulas[2]);

    cursos[0].agregarAlumno(personas[0]);
    cursos[0].agregarAlumno(personas[1]);
    cursos[0].agregarAlumno(personas[2]);
    cursos[1].agregarAlumno(personas[0]);
    cursos[1].agregarAlumno(personas[1]);
    cursos[1].agregarAlumno(personas[2]);
    cursos[2].agregarAlumno(personas[0]);
    cursos[2].agregarAlumno(personas[1]);
    cursos[2].agregarAlumno(personas[2]);

    /* Calificaciones */
    cursos[0].asignarCalificacion(0, 60);
    cursos[0].asignarCalificacion(1, 65);
    cursos[0].asignarCalificacion(2, 70);
    cursos[1].asignarCalificacion("22120601", 80);
    cursos[1].asignarCalificacion("22120602", 85);
    cursos[1].asignarCalificacion("22120603", 90);
    cursos[2].asignarCalificacion("22120601", 90);
    cursos[2].asignarCalificacion("22120602", 95);
    cursos[2].asignarCalificacion("22120603", 100);

  }

  // LOGICA DE LA CLASE
  /* ============================[ Listar ]============================ */
  public void listarCurso() {
    for (Curso curso : cursos) {
      if (curso == null)
        return;
      if (curso.isEliminada())
        continue;

      System.out.println("  > " + curso);
    }
  }

  public void listarAulas() {
    for (Aula aula : aulas) {
      if (aula == null)
        return;
      if (aula.isEliminada())
        continue;

      System.out.println("  > " + aula);
    }
  }

  public void listarMaterias() {
    for (Materia materia : materias) {
      if (materia == null)
        return;

      if (materia.isEliminada())
        continue;

      System.out.println("  > " + materia);
    }
  }

  public void listarAlumnos() {
    listarPersonas("Alumno");
  }

  public void listarAlumnosPosgrado() {
    listarPersonas("AlumnoPosgrado");
  }

  public void listarProfesores() {
    listarPersonas("Profesor");
  }

  public void listarTutores() {
    listarPersonas("Tutor");
  }

  private void listarPersonas(String filter) {
    for (Persona persona : personas) {
      if (persona == null)
        return;
      if (persona.isEliminada())
        continue;
      if (!persona.quienSoy().equals(filter))
        continue;

      System.out.println("  > " + persona);

    }
  }

  /* ============================[ Mostrar ]============================ */
  public void mostrarCursos() {
    for (Curso curso : cursos) {
      if (curso == null)
        return;
      if (curso.isEliminada())
        continue;

      separador(2);
      curso.mostrar();
    }
  }

  public void mostrarAulas() {
    for (Aula aula : aulas) {
      if (aula == null)
        return;
      if (aula.isEliminada())
        continue;

      separador(2);
      aula.mostrar();
    }
  }

  public void mostrarMaterias() {
    for (Materia materia : materias) {
      if (materia == null)
        return;
      if (materia.isEliminada())
        continue;

      separador(2);
      materia.mostrar();
    }
  }

  public void mostrarAlumnos() {
    mostrarPersonas("Alumno");
  }

  public void mostrarPorefesores() {
    mostrarPersonas("Profesor");
  }

  public void mostrarTutores() {
    for (Persona persona : personas) {
      if (persona == null)
        return;
      if (!persona.quienSoy().equals("Tutor"))
        continue;

      Tutor tutor = (Tutor) persona;

      separador(2);
      tutor.mostrar();

      System.out.println("\nTutora a ");
      for (Persona persona2 : personas) {
        if (persona2 == null)
          break;
        if (!persona2.quienSoy().equals("Alumno"))
          continue;

        Alumno alumno = (Alumno) persona2;

        if (alumno.hasTutor(tutor.getRfc())) {
          System.out.println("  > " + alumno);
        }

      }
    }
  }

  public void mostrarAlumnosPosgrado() {
    mostrarPersonas("AlumnoPosgrado");
  }

  private void mostrarPersonas(String filter) {
    for (Persona persona : personas) {
      if (persona == null)
        return;
      if (persona.isEliminada())
        continue;
      if (!persona.quienSoy().equals(filter))
        continue;

      separador(2);
      persona.mostrar();
    }
  }

  /* ============================[ CAPTURAR ]============================ */

  public void capturarCurso() {
    Scanner sc = new Scanner(System.in);

    Curso curso;

    int numeroControl, contador = 0, acomulador = 0;

    System.out.println("====================[ Agregar Curso ]===================");

    for (int i = 0; i < cMaterias; i++)
      System.out.println(1 + i + ".- " + materias[i]);
    System.out.println("0.- Cancelar");
    System.out.print("Asigne una materia al curso por INDICE : ");
    numeroControl = capturarOpcionNumerica(cMaterias);

    if (numeroControl == 0)
      return;

    System.out.println("");
    do {
      boolean isValid = true;
      curso = new Curso(materias[numeroControl - 1]);

      for (Curso c : cursos) {
        if (c == null)
          break;
        if (c.equals(curso.getClave())) {
          System.err.println("Ya existe un curso con esa Clave");
          isValid = false;
          break;
        }
      }

      if (isValid)
        break;
    } while (true);
    System.out.print("\nQuieres asignar un profesor? 1.- Si 2.- No : ");
    if (capturarOpcionBooleana()) {
      for (int i = 0; i < cPersonas; i++)
        if (personas[i].quienSoy().equals("Profesor"))
          System.out.println((1 + contador++) + ".- " + personas[i]);
      System.out.print("Seleccione un Profesor por indice : ");
      numeroControl = capturarOpcionNumerica(contador);

      for (Persona persona : personas) {
        if (persona == null)
          break;
        if (!persona.quienSoy().equals("Profesor"))
          continue;
        if (numeroControl - 1 == acomulador) {
          curso.asignarPrefesor(persona);
          break;
        }

        acomulador++;
      }
    }

    if (!curso.isPresencial()) {
      System.out.println("\nDebido a la modalidad del curso no se pueden asignar aulas.");
    } else {
      System.out.print("\nQuieres asignar aulas? 1.- Si 2.- No : ");
      if (capturarOpcionBooleana()) {
        for (int i = 0; i < cAulas; i++)
          System.out.println(1 + i + ".- " + aulas[i]);
        System.out.println("0.- Cancelar / Parar");

        do {
          System.out.print("Seleccione un Aula por indice : ");
          numeroControl = capturarOpcionNumerica(cAulas);

          if (numeroControl == 0)
            break;

          Aula aula = aulas[numeroControl - 1];

          if (curso.poseeAula(aula.getEdificio() + aula.getNombre())) {
            System.err.println("Ya existe el Aula en el Curso");
            continue;
          }

          curso.agregarAula(aula);
        } while (true);
      }
    }

    System.out.print("\nQuieres asignar alumnos? 1.- Si 2.- No : ");
    if (capturarOpcionBooleana()) {
      for (Persona persona : personas) {
        if (persona == null)
          break;
        if (persona.isEliminada())
          continue;
        if (!persona.quienSoy().equals("Alumno"))
          continue;

        Alumno alumno = (Alumno) persona;
        if (curso.poseeAlumno(alumno.getNumeroControl()))
          continue;

        System.out.println("  > " + alumno);
      }

      System.out.println("0.- Cancelar / Parar");

      do {

        Alumno alumno = encontrarAlumno();

        if (alumno == null)
          break;

        if (curso.poseeAlumno(alumno.getNumeroControl())) {
          System.out.println("* Alumno existente en curso.");
          continue;
        }

        curso.agregarAlumno(alumno);
        System.out.println("+ Alumno Agregado");
      } while (true);
    }

    cursos[cCursos++] = curso;
  }

  public void capturarAlumno() {
    Alumno alumno = new Alumno();

    listarTutores();
    System.out.println("0.- Cancelar");

    Tutor tutor = encontrarTutor();

    if (tutor == null)
      return;

    alumno.asignarTutor(tutor);

    personas[cPersonas++] = alumno;

  }

  public void capturarProfesor() {
    personas[cPersonas++] = new Profesor();
  }

  public void capturarAula() {
    aulas[cAulas++] = new Aula();
  }

  public void capturarMateria() {
    materias[cMaterias++] = new Materia();
  }

  public void capturarTutor() {
    personas[cPersonas++] = new Tutor();
  }

  public void capturarAlumnoPosgrado() {
    personas[cPersonas++] = new AlumnoPosgrado();
  }

  /* ==============================[ ELIMINAR ]=============================== */
  public void eliminarCurso() {
    System.out.println("===================[ Eliminar Curso ]===================");
    listarCurso();
    System.out.println("0.- Cancelar");

    Curso curso = encontrarCurso();

    if (curso == null)
      return;

    curso.eliminar();
    System.out.println("+ Curso eliminado.");
  }

  public void eliminarAlumno() {
    System.out.println("===================[ Eliminar Alumno ]===================");
    listarAlumnos();
    System.out.println("0.- Cancelar");

    Alumno alumno = encontrarAlumno();

    if (alumno == null)
      return;

    alumno.eliminar();
    System.out.println("+ Alumno eliminado.");
  }

  public void eliminarProfesor() {
    System.out.println("===================[ Eliminar Profesor ]===================");
    listarProfesores();
    System.out.println("0.- Cancelar");

    Profesor profesor = encontrarProfesor();

    if (profesor == null)
      return;

    profesor.eliminar();
    System.out.println("+ Profesor eliminado.");
  }

  public void eliminarAlumnoPosgrado() {
    System.out.println("==============[ Eliminar Alumno de Posgrado ]==============");
    listarAlumnosPosgrado();
    System.out.println("0.- Cancelar");

    AlumnoPosgrado alumnoPosgrado = encontrarAlumnoPosgrado();

    if (alumnoPosgrado == null)
      return;

    alumnoPosgrado.eliminar();
    System.out.println("+ Alumno de Posgrado eliminado.");
  }

  public void eliminarTutor() {
    System.out.println("===================[ Eliminar Tutor ]===================");
    listarTutores();
    System.out.println("0.- Cancelar");

    Tutor tutor = encontrarTutor();

    if (tutor == null)
      return;

    tutor.eliminar();
    System.out.println("+ Tutor eliminado.");
  }

  public void eliminarMateria() {
    System.out.println("===================[ Eliminar Materia ]===================");
    listarMaterias();
    System.out.println("0.- Cancelar");

    Materia materia = encontrarMateria();

    if (materia == null)
      return;

    materia.eliminar();
    System.out.println("+ Materia eliminado.");
  }

  public void eliminarAula() {
    System.out.println("===================[ Eliminar Aula ]===================");
    listarAulas();
    System.out.println("0.- Cancelar");

    Aula aula = encontrarAula();

    if (aula == null)
      return;

    aula.eliminar();

    System.out.println("+ Aula eliminado.");
  }

  /* ==============================[ MODIFICAR ]============================= */
  public void modificarCurso() {
    Scanner sc = new Scanner(System.in);

    System.out.println("===================[ Modificar Curso ]===================");

    Curso curso = null;
    System.out.println("Cursos en escuela : ");
    for (Curso iCurso : cursos) {
      if (iCurso == null)
        break;
      if (iCurso.isEliminada())
        continue;
      System.out.println("  > " + iCurso);
    }
    System.out.println("0.- Cancelar");

    do {
      System.out.print("Introduzca la clave del curso : ");
      String clave = sc.nextLine();

      if (clave.equals("0"))
        return;

      for (Curso iCurso : cursos) {
        if (iCurso == null)
          break;
        if (iCurso.isEliminada())
          continue;
        if (!iCurso.equals(clave))
          continue;

        curso = iCurso;
        break;
      }

      if (curso != null)
        break;

      System.out.println("* No se encontraron coincidencias.");
    } while (true);

    do {
      separador(2);
      System.out.println("1) Modalidad 2) Periodo  3) Nombre   4) Horario");
      System.out.println("5) Alumnos   6) Aulas    7) Profesor 0) Cancelar");
      System.out.print("Seleccione un parametro a Modificar : ");
      int opcion = sc.nextInt();

      separador(2);

      switch (opcion) {
        case 0:
          return;
        case 1:
          System.out.print("Ingrese el nuevo valor de Modalidad 1. Precencial o 2. Linea : ");
          sc.nextLine();
          Boolean valor = sc.nextInt() == 1 ? true : false;

          curso.setPresencial(valor);

          if (!valor)
            curso.setAulas(new Aula[5]);

          break;
        case 2:
          System.out.print("Ingrese el nuevo valor de Periodo : ");
          sc.nextLine();
          curso.setPeriodo(sc.nextLine());

          break;
        case 3:
          System.out.print("Ingrese el nuevo valor de Nombre : ");
          sc.nextLine();
          curso.setNombre(sc.nextLine());

          break;
        case 4:
          System.out.print("Ingrese el nuevo valor de Horario : ");
          sc.nextLine();
          curso.setHorario(sc.nextLine());

          break;
        case 5:
          System.out.print("1.- Dar de Alta / 2.- Dar de Baja : ");
          sc.nextLine();

          if (capturarOpcionBooleana()) {

            System.out.println("Alumnos que no estan en el curso : ");
            for (Persona persona : personas) {
              if (persona == null)
                break;
              if (persona.isEliminada())
                continue;
              if (!persona.quienSoy().equals("Alumno"))
                continue;

              Alumno alumno = (Alumno) persona;

              if (curso.poseeAlumno(alumno.getNumeroControl()))
                continue;

              System.out.println("  > " + persona);
            }

            System.out.println("0.- Cancelar / Parar");

            // Seleccionar Alumno
            do {
              Alumno alumno = encontrarAlumno();

              if (alumno == null)
                return;

              if (curso.poseeAlumno(alumno.getNumeroControl())) {
                System.out.println("Alumno existente en curso.");
                continue;
              }

              curso.agregarAlumno(alumno);
              System.out.println("+ Alumno agregado. ");

            } while (true);

          } else {
            // Dar de Baja Alumno
            System.out.println("Alumnos del Curso: ");
            curso.listarAlumnos();
            System.out.println("0.- Cancelar / Parar");

            do {
              System.out.print("Ingrese el numero de control del alumno : ");
              String clave = sc.next();

              if (clave.equals("0"))
                break;

              curso.eliminarAlumno(clave);
            } while (true);
          }
          break;
        case 6: /* <-----------------AULA---------------------------------- */
          if (!curso.getPresencial()) {
            System.out.println("* No puede agregar o eliminar aulas a de un curso en modalidad a Distancia. ");
            break;
          }
          System.out.print("1.- Agregar Aula / 2.- Eliminar Aula : ");

          if (capturarOpcionBooleana()) {

            System.out.println("Aulas que no estan en el Curso : ");
            for (Aula aula : aulas) {
              if (aula == null)
                break;
              if (aula.isEliminada())
                continue;
              if (curso.poseeAula(aula.getEdificio() + aula.getNombre()))
                continue;

              System.out.println("  > " + aula);
            }
            System.out.println("0.- Cancelar / Parar");

            do {
              System.out.print("Ingrese el aula a agregar : ");
              String clave = sc.next();

              if (clave.equals("0"))
                break;

              for (Aula aula : aulas) {
                if (aula == null) {
                  System.err.println("* No se encontraron coincidencias");
                  break;
                }
                if (aula.isEliminada())
                  continue;

                if (!aula.equals(clave))
                  continue;

                if (curso.poseeAula(aula.getEdificio() + aula.getNombre())) {
                  System.err.println("* El curso ya tiene el Aula. ");
                  break;
                }

                curso.agregarAula(aula);
                System.out.println("+ Aula agregada. ");
                break;
              }
            } while (true);

          } else {
            System.out.println("Aulas en el Curso: ");
            curso.listarAulas();
            System.out.println("0.- Cancelar / Parar");

            do {
              System.out.print("Ingrese el aula a eliminar : ");
              String clave = sc.next();

              if (clave.equals("0")) {
                break;
              }

              curso.eliminarAula(clave);

            } while (true);
          }
          break;

        case 7:
          System.out.println("1) Actualizar 2) Eliminar");

          if (capturarOpcionBooleana()) {
            System.out.println("Profesores en la Escuela: ");

            for (Persona persona : personas) {
              if (persona == null)
                break;
              if (persona.isEliminada())
                continue;
              if (!persona.quienSoy().equals("Profesor"))
                continue;

              Profesor profesor = (Profesor) persona;

              if (curso.poseeProfesor(profesor.getRfc()))
                continue;

              System.out.println("  > " + profesor);
            }
            System.out.println("0.- Cancelar / Parar");

            do {
              Profesor profesor = encontrarProfesor();

              if (profesor == null)
                return;

              if (curso.poseeProfesor(profesor.getRfc())) {
                System.out.println("* El profesor ya esta en el Curso. ");
                continue;
              }

              curso.asignarPrefesor(profesor);
              System.out.println("+ Profesor Agregado");
            } while (true);

          } else {
            curso.setProfesor(null);
          }
          break;
        default:
          System.out.println("* Opción no válida, seleccione de nuevo. ");
      }

    } while (true);

  }

  public void modificarAlumno() {
    System.out.println("===================[ Modificar Alumno ]===================");

    listarAlumnos();
    System.out.println("0.- Candelar");
    Alumno alumno = encontrarAlumno();

    if (alumno == null)
      return;

    alumno.modificar();
  }

  public void modificarMateria() {
    System.out.println("===================[ Modificar Materia ]===================");

    listarMaterias();
    System.out.println("0.- Candelar");
    Materia materia = encontrarMateria();

    if (materia == null)
      return;

    materia.modificar();
  }

  public void modificarProfesor() {
    System.out.println("===================[ Modificar Profesor ]===================");

    listarProfesores();
    System.out.println("0.- Candelar");
    Profesor profesor = encontrarProfesor();

    if (profesor == null)
      return;

    profesor.modificar();
  }

  public void modificarTutor() {
    System.out.println("===================[ Modificar Tutor ]===================");

    listarTutores();
    System.out.println("0.- Candelar");
    Tutor tutor = encontrarTutor();

    if (tutor == null)
      return;

    tutor.modificar();
  }

  public void modificarAlumnoPosgrado() {
    System.out.println("===================[ Modificar Alumno Posgrado ]===================");

    listarAlumnosPosgrado();
    System.out.println("0.- Candelar");
    AlumnoPosgrado alumnoPosgrado = encontrarAlumnoPosgrado();

    if (alumnoPosgrado == null)
      return;

    alumnoPosgrado.modificar();
  }

  public void modificarAula() {
    System.out.println("===================[ Modificar Aula ]===================");

    listarAulas();
    System.out.println("0.- Candelar");
    Aula aula = encontrarAula();

    if (aula == null)
      return;

    aula.modificar();
  }

  /* ===============================[ BUSCAR ]=============================== */
  public void buscarCurso() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("====================[ Buscar Curso ]====================");
    System.out.print("Ingrese Caracteres a Buscar : ");
    String cadena = scanner.nextLine();
    System.out.println("");

    for (Curso curso : cursos) {
      if (curso == null)
        break;
      if (!curso.buscar(cadena))
        continue;

      separador(2);
      curso.mostrar();

      return;
    }

    System.out.println("No se encontraron coincidencias");

  }

  public void buscarMateria() {
    Scanner sc = new Scanner(System.in);
    System.out.println("====================[ Buscar Materia ]====================");

    System.out.print("Ingrese Caracteres a Buscar : ");

    String string = sc.nextLine();

    for (Materia materia : materias) {
      if (materia == null)
        return;

      if (!materia.buscar(string))
        continue;

      materia.mostrar();
    }

    System.out.println("No se encontraron coincidencias");

  }

  public void buscarAula() {
    Scanner sc = new Scanner(System.in);
    System.out.println("====================[ Buscar Aula ]====================");

    System.out.print("Ingrese Caracteres a Buscar : ");

    String string = sc.nextLine();

    for (Aula aula : aulas) {
      if (aula == null)
        return;

      if (!aula.buscar(string))
        continue;

      aula.mostrar();
    }

    System.out.println("No se encontraron coincidencias");

  }

  public void buscarAlumno() {
    buscarPersona("Alumno");
  }

  public void buscarProfesor() {
    buscarPersona("Profesor");
  }

  public void buscarTutor() {
    buscarPersona("Tutor");
  }

  public void buscarAlumnoPosgrado() {
    buscarPersona("AlumnoPosgrado");
  }

  private void buscarPersona(String filtro) {
    Scanner sc = new Scanner(System.in);

    System.out.println("====================[ Buscar " + filtro + "]====================");

    System.out.print("Ingrese Caracteres a Buscar : ");
    String string = sc.nextLine();
    System.out.println("");

    for (Persona persona : personas) {
      if (persona == null)
        return;

      if (!persona.quienSoy().equals(filtro))
        continue;

      if (!persona.buscar(string))
        continue;

      persona.mostrar();
    }

    System.out.println("No se encontraron coincidencias");
  }
  /* =============================[ ENCONTRAR ]============================ */

  private Curso encontrarCurso() {
    Scanner sc = new Scanner(System.in);

    do {
      System.out.print("Introduzca la clave : ");
      String clave = sc.nextLine();

      if (clave.equals("0")) {
        System.out.println("+ Saliendo");
        return null;
      }

      for (Curso curso : cursos) {
        if (curso == null)
          break;
        if (curso.isEliminada())
          continue;
        if (!curso.equals(clave))
          continue;

        return curso;
      }

      System.err.println("* No se encontraron coincidencias. ");
    } while (true);
  }

  private Profesor encontrarProfesor() {
    Scanner sc = new Scanner(System.in);

    do {
      System.out.print("Introduzca el RFC : ");
      String clave = sc.nextLine();

      if (clave.equals("0")) {
        System.out.println("+ Saliendo");
        return null;
      }

      Profesor profesor = (Profesor) encontrarPersona("Profesor", clave);

      if (profesor == null)
        continue;

      return profesor;

    } while (true);
  }

  private Alumno encontrarAlumno() {
    Scanner sc = new Scanner(System.in);

    do {
      System.out.print("Ingrese el numero de control : ");
      String clave = sc.nextLine();

      if (clave.equals("0")) {
        System.out.println("+ Saliendo");
        return null;
      }

      Alumno alumno = (Alumno) encontrarPersona("Alumno", clave);

      if (alumno == null)
        continue;

      return alumno;

    } while (true);
  }

  private Tutor encontrarTutor() {
    Scanner sc = new Scanner(System.in);

    do {
      System.out.print("Ingrese el RFC : ");
      String clave = sc.nextLine();

      if (clave.equals("0")) {
        System.out.println("+ Saliendo");
        return null;
      }

      Tutor tutor = (Tutor) encontrarPersona("Tutor", clave);

      if (tutor == null)
        continue;

      return tutor;

    } while (true);
  }

  private AlumnoPosgrado encontrarAlumnoPosgrado() {
    Scanner sc = new Scanner(System.in);

    do {
      System.out.print("Introduzca el numero de control : ");
      String clave = sc.nextLine();

      if (clave.equals("0")) {
        System.out.println("+ Saliendo");
        return null;
      }

      AlumnoPosgrado alumnoPosgrado = (AlumnoPosgrado) encontrarPersona("AlumnoPosgrado", clave);

      if (alumnoPosgrado == null)
        continue;

      return alumnoPosgrado;

    } while (true);
  }

  private Materia encontrarMateria() {
    Scanner sc = new Scanner(System.in);

    do {
      System.out.print("Introduzca la clave : ");
      String clave = sc.nextLine();

      if (clave.equals("0")) {
        System.out.println("+ Saliendo");
        return null;
      }

      for (Materia materia : materias) {
        if (materia == null)
          break;
        if (materia.isEliminada())
          continue;
        if (!materia.equals(clave))
          continue;

        return materia;
      }

      System.err.println("* No se encontraron coincidencias. ");
    } while (true);
  }

  private Aula encontrarAula() {
    Scanner sc = new Scanner(System.in);

    do {
      System.out.print("Introduzca el Aula : ");
      String clave = sc.nextLine();

      if (clave.equals("0")) {
        System.out.println("+ Saliendo");
        return null;
      }

      for (Aula aula : aulas) {
        if (aula == null)
          break;
        if (aula.isEliminada())
          continue;
        if (!aula.equals(clave))
          continue;

        return aula;
      }

      System.err.println("* No se encontraron coincidencias. ");
    } while (true);
  }

  private Persona encontrarPersona(String filter, String clave) {
    for (Persona persona : personas) {
      if (persona == null)
        break;
      if (persona.isEliminada())
        continue;
      if (!persona.quienSoy().equals(filter))
        continue;
      if (!persona.equals(clave))
        continue;

      return persona;
    }

    System.err.println("* No se encontraron coincidencias. ");
    return null;
  }

  /* =============================[ GET AND SET ]============================ */

  public void mostrar() {
    String format = "%s-10: %s\n";

    System.out.println("Esculea:");
    System.out.printf(format, "  Nombre ", nombre);
    System.out.printf(format, "  Clave ", numeroControl);
    System.out.printf(format, "  Domicilio ", domicilio);
  }

  public String getNombre() {
    return nombre;
  }

  public String getClave() {
    return numeroControl;
  }

  public String getDomicilio() {
    return domicilio;
  }

  public void setClave(String clave) {
    this.numeroControl = clave;
  }

  public void setDomicilio(String domicilio) {
    this.domicilio = domicilio;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  /* =============================[ CUSTOM FUNC ]============================ */

  private int capturarOpcionNumerica(int opciones) {
    Scanner sc = new Scanner(System.in);

    do {
      int opcion = sc.nextInt();
      boolean range = (opcion >= 0 && opcion <= opciones);

      if (range)
        return opcion;

      System.out.print("Opcion no valida, vuelva a seleccionar : ");

    } while (true);
  }

  private boolean capturarOpcionBooleana() {
    Scanner sc = new Scanner(System.in);

    do {
      int opcion = sc.nextInt();

      boolean isValid = opcion == 1 || opcion == 2;

      if (isValid)
        return opcion == 1 ? true : false;

      System.out.print("Opcion no valida, ¿1.-Si o 2.-No?: ");

    } while (true);
  }

  private void separador(int nivel) {
    if (nivel == 2)
      System.out.println("---------------------------------------------------------");
  }

}
