import java.util.Scanner;

public class Escuela {
  private String nombre;
  private String clave;
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
    this.clave = clave;
    this.domicilio = domicilio;
    this.nombre = nombre;

    inicializarDatos();
  }

  // Sobrecarga

  private void inicializarDatos() {
    // DB - Materias
    materias[0] = new Materia("AED-1287", "POO", "5", "3-2-5");
    materias[1] = new Materia("AED-1246", "Calculo Integral", "5", "1-2-3");
    materias[2] = new Materia("AED-1275", "Algebra Lineal", "4", "3-2-5");

    cMaterias = 3;

    // DB - Cursos
    cursos[0] = new Curso("B2L1A", true, "Ago-Dic 2022", "09:00", materias[0]);
    cursos[1] = new Curso("B2L2A", false, "Ago-Dic 2022", "08:00", materias[1]);
    cursos[2] = new Curso("B2L3A", false, "Ago-Dic 2022", "10:00", materias[2]);

    cCursos = 3;

    // DB - Profesores
    personas[0] = new Alumno("Antonio Gomez", "22120601", "441 555 6666", "antonio@email.com", "ISC", 'M');
    personas[1] = new Alumno("Juan Diaz", "22120602", "441 555 6666", "juan@email.com", "ISC", 'M');
    personas[2] = new Alumno("Alexis Lora", "22120603", "441 555 6666", "alexis@email.com", "ISC", 'M');
    personas[3] = new Alumno("Alexis Posgrado", "22120603", "441 555 6666", "alexis@email.com", "ISC", 'M');
    personas[4] = new Alumno("Paco Posgrado", "22120444", "441 555 6456", "paco@email.com", "ISC", 'M');
    personas[5] = new Profesor("martin@tecnm.com", "TICS", "Martin", "MART20003", "443 111 5555");
    personas[6] = new Profesor("omar@tecnm.com", "Matematicas", "Omar", "OMAR23003", "443 555 222");
    personas[7] = new Profesor("paco@tecnm.com", "Matematicas", "Paco", "PACO23003", "442 465 752");
    personas[8] = new Tutor(personas[5], "mate - quimica", true, "02/02/2010", "modulo 1");
    personas[9] = new Tutor(personas[6], "fisica - quimica", true, "08/02/205", "modulo 5");
    personas[10] = new AlumnoPosgrado(personas[0], "Chiles Maria", "Gerente", "Chiles", "Soltero", "08/10/2025",
        "tecmorelia", "Ing. Sistemas", "XXX-XXX-CEDULA");
    personas[11] = new AlumnoPosgrado(personas[1], "Tacos Jose", "Gerente", "Tacos", "Soltero", "04/04/2025",
        "tecmorelia", "Ing. Sistemas", "XXX-XXX-CEDULA");

    cPersonas = 12;

    // DB - Aulas
    aulas[0] = new Aula(true, 30, "AG", "LC1");
    aulas[1] = new Aula(true, 25, "AG", "LC2");
    aulas[2] = new Aula(false, 40, "F", "3");
    aulas[3] = new Aula(false, 32, "K", "8");

    cAulas = 4;

    // 0 - 4 Alumnos y de 8 - 9 Tutores
    /*
     * personas[0].asignarTutor(personas[8]);
     * personas[1].asignarTutor(personas[9]);
     * personas[2].asignarTutor(personas[9]);
     * personas[3].asignarTutor(personas[9]);
     * personas[4].asignarTutor(personas[8]);
     */

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

    // Asignaciones

    cursos[0].asignarPrefesor(personas[5]);
    cursos[1].asignarPrefesor(personas[6]);
    cursos[2].asignarPrefesor(personas[7]);

    cursos[0].agregarAula(aulas[0]);
    cursos[0].agregarAula(aulas[0]);
    cursos[1].agregarAula(aulas[1]);
    cursos[2].agregarAula(aulas[2]);

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

  public void listarCursos() {
    String format = "| %-1s | %-5s | %-25s | %-12s | %-7s | %-11s |\n";
    String format2 = "| %-37s | %-36s |\n";

    System.out.println("Cursos de " + nombre);

    for (int i = 0; i < cCursos; i++) {
      Curso curso = cursos[i];
      Profesor profesor = curso.getProfesor();
      Materia materia = curso.getMateria();

      System.out.println("________________________________________________________________________________");
      System.out.printf(format, "n", "Clave", "Nombre", "Periodo", "Horario", "Modalidad");

      System.out.printf(
          format,
          i + 1 + "",
          curso.getClave(),
          curso.getNombre(),
          curso.getPeriodo(),
          curso.getHorario(),
          curso.isPresencial() ? "Presencial" : "Distancia");
      System.out.println("|---------------------------------------+--------------------------------------|");
      System.out.printf(
          format2, "Profesor", "Materia");
      System.out.printf(
          format2, "Nombre  : " + profesor.getNombre(), "Nombre  : " + materia.getNombre());
      System.out.printf(
          format2, "RFC     : " + profesor.getRfc(), "Clave   : " + materia.getClave());
      System.out.printf(
          format2, "Telefono: " + profesor.getTelefono(), "Satca   : " +
              materia.getSatca());
      System.out.printf(
          format2, "Correo  : " + profesor.getCorreo(), "Unidades: " +
              materia.getUnidades());
      curso.listarAulas();
      curso.listarAlumnos();

    }

    System.out.println("");

  }

  public void listarTutores() {
    String format = "| %-15s: %-20s  %-15s: %-20s |\n";
    int cTutores = 0;
    for (int i = 0; i < cPersonas; i++) {
      if (!personas[i].quienSoy().equals("Tutor"))
        continue;
      Tutor tutor = (Tutor) personas[i];

      System.out.println("|------------------------------------------------------------------------------|");
      System.out.printf("| %-3s. Nombre: %-63s |", cTutores + 1, tutor.getNombre());
      System.out.println("\n|------------------------------------------------------------------------------|");
      System.out.printf(format,
          "Correo", tutor.getCorreo(),
          "Otros Cursos", tutor.getOtrosCursos());
      System.out.printf(format,
          "Telefono", tutor.getTelefono(),
          "TomoDiplomado", tutor.getTomoDiplomado());
      System.out.printf(format,
          "Especializacion", tutor.getEspecializacion(),
          "FechaDiploma", tutor.getFechaDiploma());
      System.out.printf(format,
          "Rfc", tutor.getRfc(),
          "ModuloDiplomado", tutor.getModuloDiplomado());

      cTutores++;
    }
    System.out.println("|______________________________________________________________________________|");

    /* Ref!!!! */

    System.out.print("Seleccione un Tutor: ");

    int index = capturarOpcionNumerica(cTutores);
    int contador = 0;
    for (int i = 0; i < cPersonas; i++) {
      if (!personas[i].quienSoy().equals("Tutor"))
        continue;

      if (index == contador) {
        Tutor tutor = (Tutor) personas[i];

        System.out.println(tutor.getNombre() + " tutora a: ");
        int c = 1;
        for (int j = 0; j < cPersonas; j++) {
          if (!personas[j].quienSoy().equals("Alumno"))
            continue;

          Alumno alumno = (Alumno) personas[j];

          if (alumno.hasTutor(tutor.getRfc()))
            System.out.println((c++) + ".- " + alumno.getNombre());
        }
      }

      contador++;
    }

  }

  public void listarAlumnosPosgrado() {
    String format2 = "| %-7s: %-13s %-7s: %-19s %-6s: %-16s |\n";
    int c = 0;
    for (int i = 0; i < cPersonas; i++) {
      if (!personas[i].quienSoy().equals("AlumnoPosgrado"))
        continue;

      AlumnoPosgrado alumno = (AlumnoPosgrado) personas[i];
      Cedula cedula = alumno.getCedula();

      System.out.println("|------------------------------------------------------------------------------|");
      System.out.printf("| %-3s. Nombre: %-63s |", (c++) + 1, alumno.getNombre());
      System.out.println("\n|------------------------------------------------------------------------------|");
      System.out.printf(format2,
          "N.Contr", alumno.getNumeroControl(),
          "Empresa", alumno.getEmpresa(),
          "Fecha", cedula.getFecha());
      System.out.printf(format2,
          "Correo", "Muy largo",
          "Puesto", alumno.getPuesto(),
          "Insti.", cedula.getInstitucion());
      System.out.printf(format2,
          "Tel", alumno.getTelefono(),
          "Interes", alumno.getLineaDeInteres(),
          "Cedula", cedula.getNumCedula());
      System.out.printf(format2,
          "Cali", alumno.getCalificacion(),
          "Estado", alumno.getEstadoCivil(),
          "Titulo", cedula.getTitulo());
    }
    System.out.println("|______________________________________________________________________________|");
  }

  public int listarPorefesores() {
    String format = "%-2s %-20s %-20s %-16s %-11s %-11s\n";
    System.out.println("Porefesores de " + nombre);
    System.out.printf(format, "n", "Nombre", "Correo", "Especializacion", "RFC", "Telefono");

    int c = 0;
    for (int i = 0; i < cPersonas; i++) {
      if (!personas[i].quienSoy().equals("Profesor"))
        continue;

      Profesor profesor = (Profesor) personas[i];

      System.out.printf(
          format,
          (c++) + 1,
          profesor.getNombre(),
          profesor.getCorreo(),
          profesor.getEspecializacion(),
          profesor.getRfc(),
          profesor.getTelefono());
    }

    return c;
  }

  public void listarAulas() {
    String format = "%-2s %-10s %-10s %-10s %-10s\n";
    System.out.println("Aulas de " + nombre);
    System.out.printf(format, "n", "Capacidad", "Edificio", "Nombre", "Tipo");

    for (int i = 0; i < cAulas; i++) {
      Aula aula = aulas[i];

      System.out.printf(
          format,
          i + 1,
          aula.getCapacidad(),
          aula.getEdificio(),
          aula.getNombre(),
          aula.isAula() ? "Laboratorio" : "Aula");
    }
  }

  public int listarAlumnos() {

    String format = "%-2s %-12s %-15s %-10s %-5s %-13s\n";
    System.out.println("Alumnos de " + nombre);
    System.out.printf(format, "n", "No. Control", "Nombre", "Carrera", "Sexo", "Telefono");

    int cAlumnos = 0;

    // Promedio
    for (int i = 0; i < cPersonas; i++) {
      if (!personas[i].quienSoy().equals("Alumno"))
        continue;

      cAlumnos++;
      Alumno alumno = (Alumno) personas[i];
      System.out.printf(
          format,
          i + 1,
          alumno.getNumeroControl(),
          alumno.getNombre(),
          alumno.getCarrera(),
          alumno.getGenero(),
          alumno.getTelefono());
      System.out.println("Tutor: " + alumno.getTutor().getNombre());
      System.out.println("Especializacion: " + alumno.getTutor().getEspecializacion());
      System.out.println("");
    }

    return cAlumnos;
  }

  public void listarMaterias() {
    String format = "%-2s %-20s %-10s %-8s %-10s\n";
    System.out.println("Materias de " + nombre);
    System.out.printf(format, "n", "Nombre", "Clave", "Unidades", "SATCA");

    for (int i = 0; i < cMaterias; i++) {
      Materia materia = materias[i];

      System.out.printf(
          format,
          i + 1,
          materia.getNombre(),
          materia.getClave(),
          materia.getUnidades(),
          materia.getSatca());
    }
  }

  public void listarDetalles(int curso) {
    System.out.println("");
    System.out.println("Detalles del curso: " + cursos[curso].getNombre());
    System.out.println("");
    cursos[curso].mostrarMateria();
    cursos[curso].mostrarProfesor();
    cursos[curso].listarAlumnos();
    cursos[curso].listarAulas();
  }

  public void mostrar() {
    String format = "%s-10: %s\n";

    System.out.println("Esculea:");
    System.out.printf(format, "  Nombre ", nombre);
    System.out.printf(format, "  Clave ", clave);
    System.out.printf(format, "  Domicilio ", domicilio);
  }

  public void capturarProfesor() {
    personas[cPersonas++] = new Profesor();
  }

  public void capturarCurso() {
    Curso curso;
    int opcion;

    listarMaterias();

    System.out.println("0.- Cancelar");
    System.out.print("Seleccione una Materia: ");

    opcion = capturarOpcionNumerica(cMaterias);

    if (opcion >= 0)
      cursos[cCursos++] = new Curso(materias[opcion]);
    else
      return;

    curso = cursos[cCursos - 1];

    System.out.print("Desea asignar profesor 1.- Si  2.- No?: ");
    if (capturarOpcionBooleana()) {
      int cProfesores = listarPorefesores();
      System.out.println("0.- Cancelar");

      System.out.print("Seleccione un Profesor: ");
      opcion = capturarOpcionNumerica(cProfesores);

      int c = 0;
      if (opcion >= 0) {
        for (int i = 0; i < cPersonas; i++) {
          if (!personas[i].quienSoy().equals("Profesor"))
            continue;

          if (c == opcion)
            curso.asignarPrefesor(personas[i]);

        }
      }

    }

    System.out.print("Desea asignar Aula 1.- Si  2.- No?: ");
    if (capturarOpcionBooleana()) {
      listarAulas();
      System.out.println("0.- Cancelar");

      do {
        System.out.print("Seleccione un Aula: ");
        opcion = capturarOpcionNumerica(cAulas);

        if (opcion >= 0)
          curso.agregarAula(aulas[opcion]);

      } while (opcion >= 0);
    }

    System.out.print("Desea asignar Alumnos 1.- Si  2.- No?: ");
    if (capturarOpcionBooleana()) {
      int cAlumnos = listarAlumnos();
      System.out.println("0.- Cancelar");

      do {
        System.out.print("Seleccione un Alumno: ");
        opcion = capturarOpcionNumerica(cAlumnos);

        int c = 0;
        if (opcion >= 0) {
          for (int i = 0; i < cPersonas; i++) {
            if (!personas[i].quienSoy().equals("Alumno"))
              continue;

            if (c == opcion)
              curso.agregarAlumno(personas[i]);
          }
        }
      } while (opcion >= 0);
    }

  }

  public void capturarAlumno() {
    personas[cPersonas++] = new Alumno();
  }

  public void capturarAula() {
    aulas[cAulas++] = new Aula();
  }

  public void capturarMateria() {
    materias[cMaterias++] = new Materia();
  }
  // ENCAPSULAMIENTO

  public String getNombre() {
    return nombre;
  }

  public String getClave() {
    return clave;
  }

  public String getDomicilio() {
    return domicilio;
  }

  public void setClave(String clave) {
    this.clave = clave;
  }

  public void setDomicilio(String domicilio) {
    this.domicilio = domicilio;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  private int capturarOpcionNumerica(int opciones) {
    Scanner sc = new Scanner(System.in);
    int opcion;

    do {
      opcion = sc.nextInt() - 1;

      if (!(opcion >= -1 && opcion < opciones))
        System.out.print("Opcion no valida, vuelve a seleccionar: ");

    } while (!(opcion >= -1 && opcion < opciones));

    return opcion;
  }

  private boolean capturarOpcionBooleana() {
    Scanner sc = new Scanner(System.in);

    boolean isValid;
    boolean respuesta = false;

    do {
      int opcion = sc.nextInt();

      isValid = opcion == 1 || opcion == 2;

      if (isValid)
        respuesta = opcion == 1 ? true : false;
      else
        System.out.print("Opcion no valida, ¿1.-Si o 2.-No?: ");

    } while (!isValid);

    return respuesta;
  }
}
