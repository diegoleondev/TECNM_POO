public class Escuela {
  private String nombre;
  private String clave;
  private String domicilio;

  private Curso cursos[] = new Curso[500];
  private int cCursos;

  private Profesor profesores[] = new Profesor[500];
  private int cPorefesores;

  private Aula aulas[] = new Aula[500];
  private int cAulas;

  private Alumno alumnos[] = new Alumno[500];
  private int cAlumnos;

  private Materia materias[] = new Materia[500];
  private int cMaterias;

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
    cursos[0] = new Curso("B2L1A", "POO", true, "Ago-Dic 2022", "09:00", materias[0]);
    cursos[1] = new Curso("B2L2A", "Calculo Integral", false, "Ago-Dic", "8:00", materias[1]);
    cursos[2] = new Curso("B2L3A", "Algebra Lineal", false, "Ago-Dic 2022", "10:00", materias[2]);

    cCursos = 3;

    // DB - Profesores
    profesores[0] = new Profesor("martin@tecnm.com", "TICS", "Martin", "MART20003", "443 111 5555");
    profesores[1] = new Profesor("omar@tecnm.com", "Matematicas", "Omar", "OMAR23003", "443 555 222");
    profesores[2] = new Profesor("paco@tecnm.com", "Matematicas", "Omar", "OMAR23003", "443 555 222");

    cPorefesores = 3;

    // DB - Aulas
    aulas[0] = new Aula(true, 30, "AG", "LC1");
    aulas[1] = new Aula(true, 25, "AG", "LC2");
    aulas[2] = new Aula(false, 40, "F", "3");
    aulas[3] = new Aula(false, 32, "K", "8");

    cAulas = 4;

    // DB - Alumnos
    alumnos[0] = new Alumno("Antonio Gomez", "22120601", "441 555 6666", "antonio@email.com", "ISC", 'M');
    alumnos[1] = new Alumno("Juan Diaz", "22120602", "441 555 6666", "juan@email.com", "ISC", 'M');
    alumnos[2] = new Alumno("Alexis Lora", "22120603", "441 555 6666", "alexis@email.com", "ISC", 'M');

    cAlumnos = 3;

    // Asignaciones

    cursos[0].asignarPrefesor(profesores[0]);
    cursos[1].asignarPrefesor(profesores[1]);
    cursos[2].asignarPrefesor(profesores[2]);

    cursos[0].agregarAula(aulas[0]);
    cursos[0].agregarAula(aulas[0]);
    cursos[1].agregarAula(aulas[1]);
    cursos[2].agregarAula(aulas[2]);

    cursos[0].agregarAlumno(alumnos[0]);
    cursos[0].agregarAlumno(alumnos[1]);
    cursos[0].agregarAlumno(alumnos[2]);
    cursos[1].agregarAlumno(alumnos[0]);
    cursos[1].agregarAlumno(alumnos[1]);
    cursos[1].agregarAlumno(alumnos[2]);
    cursos[2].agregarAlumno(alumnos[0]);
    cursos[2].agregarAlumno(alumnos[1]);
    cursos[2].agregarAlumno(alumnos[2]);

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
    String format = "%-2s %-6s %-20s %-13s %-8s %-10s\n";

    System.out.println("Cursos de " + nombre);
    System.out.printf(format, "n", "Clave", "Nombre", "Periodo", "Horario", "Modalidad");

    for (int i = 0; i < cCursos; i++) {
      Curso curso = cursos[i];

      System.out.printf(
          format,
          i + 1 + "",
          curso.getClave(),
          curso.getNombre(),
          curso.getPeriodo(),
          curso.getHorario(),
          curso.isPresencial() ? "Presencial" : "Distancia");

      curso.listarAlumnos();
      curso.mostrarPromedio();
    }

    System.out.println("");

  }

  public void listarPorefesores() {
    String format = "%-2s %-20s %-20s %-16s %-11s %-11s\n";
    System.out.println("Porefesores de " + nombre);
    System.out.printf(format, "n", "Nombre", "Correo", "Especializacion", "RFC", "Telefono");

    for (int i = 0; i < cPorefesores; i++) {
      Profesor profesor = profesores[i];

      System.out.printf(
          format,
          i + 1,
          profesor.getNombre(),
          profesor.getCorreo(),
          profesor.getEspecializacion(),
          profesor.getRfc(),
          profesor.getTelefono());
    }
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

  public void listarAlumnos() {
    if (cAlumnos == 0) {
      System.out.println("No hay alumnos registrados");
      return;
    }

    String format = "%-2s %-12s %-15s %-10s %-5s %-11s %-13s\n";
    System.out.println("Alumnos de " + nombre);
    System.out.printf(format, "n", "No. Control", "Nombre", "Carrera", "Sexo", "Telefono", "Calificacion");

    // Promedio
    for (int i = 0; i < cAlumnos; i++) {
      Alumno alumno = alumnos[i];

      System.out.printf(
          format,
          i + 1,
          alumno.getNumeroControl(),
          alumno.getNombre(),
          alumno.getCarrera(),
          alumno.getGenero(),
          alumno.getTelefono(),
          alumno.getCalificacion() + "");
    }
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
    profesores[cPorefesores++] = new Profesor();
  }

  public void capturarCurso() {
    cursos[cCursos++] = new Curso();
  }

  public void capturarAlumno() {
    alumnos[cAlumnos++] = new Alumno();
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

}
