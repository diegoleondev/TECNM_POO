public class App {
  public static void main(String []args) {
    Alumno alumno = new Alumno();
    alumno.capturar();
    alumno.mostrar();
    System.out.println("------------------------");

    Aula aula = new Aula();
    aula.capturar();
    aula.mostrar();
    System.out.println("------------------------");

    Curso curso = new Curso();
    curso.capturar();
    curso.mostrar();
    System.out.println("------------------------");

    Materia materia = new Materia();
    materia.capturar();
    materia.mostrar();
    System.out.println("------------------------");

    Profesor profesor = new Profesor();
    profesor.capturar();
    profesor.mostrar();
    System.out.println("------------------------");
    
  } 
}
