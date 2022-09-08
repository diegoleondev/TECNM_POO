public class App {
  public static void main(String []args) {
    Escuela escuela = new Escuela("16TIC", "Av. Tecnologuico #500", "Tecnologuico de Morelia");
    
    Curso[] cursos = {
      new Curso("B2L1A", "Programacion 2", true, "Ago-Dic 2022", "09:00"),
      new Curso("B2L2A", "Calculo Integral", false, "Ago-Dic 2022", "10:00"),
    };

    Alumno[] alumnos = {
      new Alumno("22120601", "Antonio", "441 555 6666", "ISC", 'M'),
      new Alumno("22120602", "Juan", "441 555 6666", "ISC", 'M'),
      new Alumno("22120603", "Alexis", "441 555 6666", "ISC", 'M'),
      new Alumno("22120604", "Maria", "441 555 6666", "ISC", 'F'),
      new Alumno("22120605", "Pepe", "441 555 6666", "ISC", 'M'),
      new Alumno("22120606", "Diego", "441 555 6666", "ISC", 'M'),
      new Alumno("22120607", "Marco", "441 555 6666", "ISC", 'M'),
      new Alumno("22120608", "Polo", "441 555 6666", "ISC", 'M'),
      new Alumno("22120609", "Jose", "441 555 6666", "ISC", 'M'),
      new Alumno("22120610", "Mario", "441 555 6666", "ISC", 'M'),
    };

    cursos[0].agregarAlumnos(alumnos);

    escuela.agregarCursos(cursos);    
    escuela.listarCursos();
    escuela.getCursos()[0].listarAlumnos();

    
  } 
}
