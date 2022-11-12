import java.util.Scanner;

public class AlumnoPosgrado extends Alumno {
  private String empresa;
  private String puesto;
  private String lineaDeInteres;
  private String estadoCivil;
  private Cedula cedula;

  public AlumnoPosgrado(Persona persona, String empresa, String puesto, String lineaDeInteres, String estadoCivil,
      String fecha, String institucion, String titulo, String numCedula) {
    super(persona);
    this.empresa = empresa;
    this.puesto = puesto;
    this.lineaDeInteres = lineaDeInteres;
    this.estadoCivil = estadoCivil;

    this.cedula = new Cedula(fecha, institucion, titulo, numCedula);
  }

  public AlumnoPosgrado() {
  }

  /* ==============================[ LOGUICA ]============================= */

  @Override
  public void modificar() {
    if (eliminada)
      return;

    Scanner sc = new Scanner(System.in);

    do {
      System.out.println("1) Nombre           2) Correo    3) Telefono       4) Carrera");
      System.out.println("5) Calificacion     6) Genero    7) Tutor          8) Empresa");
      System.out.println("9) Linea de Interes 9) Puesto 11) Estado Civil   0) Cancelar");
      System.out.print("Seleccione un parametro a Modificar : ");

      switch (sc.nextInt()) {
        case 0:
          return;
        case 1:
          System.out.print("\nIntroduzca el nuevo nombre : ");
          sc.nextLine();
          nombre = sc.nextLine();
          break;
        case 2:
          System.out.print("\nIntroduzca las nuevo correo : ");
          sc.nextLine();
          correo = sc.nextLine();
          break;
        case 3:
          System.out.print("\nIntroduzca el nuevo telefono : ");
          sc.nextLine();
          telefono = sc.nextLine();
          break;
        case 4:
          System.out.print("\nIntroduzca el nuevo carrera : ");
          sc.nextLine();
          carrera = sc.nextLine();
          break;
        case 5:
          System.out.print("\nIntroduzca el nuevo calificacion : ");
          sc.nextLine();
          calificacion = sc.nextInt();
          break;
        case 6:
          System.out.print("\nIntroduzca el nuevo genero : ");
          sc.nextLine();
          genero = sc.next().charAt(0);
          break;
        case 7:
          System.out.print("\nIntroduzca el nuevo Tutor : ( -- PENDIENTE -- ) ");
          sc.nextLine();
          break;
        case 8:
          System.out.print("\nIntroduzca la nueva empresa : ");
          sc.nextLine();
          empresa = sc.nextLine();
          break;
        case 9:
          System.out.print("\nIntroduzca la nueva linea de interes : ");
          sc.nextLine();
          lineaDeInteres = sc.nextLine();
          break;
        case 10:
          System.out.print("\nIntroduzca el nuevo puesto : ");
          sc.nextLine();
          puesto = sc.nextLine();
          break;
        case 11:
          System.out.print("\nIntroduzca el nuevo estado civil : ");
          sc.nextLine();
          estadoCivil = sc.nextLine();
          break;
        default:
          System.out.println("Opccion no valida. ");
          break;
      }

      System.out.println("");
    } while (true);
  }

  @Override
  public void capturar() {
    Scanner scanner = new Scanner(System.in);

    super.capturar();

    System.out.print("Empresa : ");
    empresa = scanner.nextLine();

    System.out.print("Puesto : ");
    puesto = scanner.nextLine();

    System.out.print("Linea de Interes : ");
    lineaDeInteres = scanner.nextLine();

    System.out.print("Estado Civil : ");
    estadoCivil = scanner.next();

    cedula = new Cedula();
  }

  @Override
  public void mostrar() {
    String format = "%-15s: %s\n";

    super.mostrar();
    System.out.printf(format, "Empresa", empresa);
    System.out.printf(format, "Puesto", puesto);
    System.out.printf(format, "Linea de Interes", lineaDeInteres);
    System.out.printf(format, "Estado civil", estadoCivil);
    cedula.mostrar();
  }

  @Override
  public boolean buscar(String string) {
    String contenido = empresa + puesto + lineaDeInteres + estadoCivil + cedula + correo + nombre + telefono + eliminada
        + numeroControl + carrera + calificacion + genero + tutor;

    return contenido.indexOf(string) >= 0 ? true : false;

  }

  @Override
  public String quienSoy() {
    return "AlumnoPosgrado";
  }

  /* ==============================[ GET & SET ]============================= */

  public String getEmpresa() {
    return empresa;
  };

  public String getPuesto() {
    return puesto;
  };

  public String getLineaDeInteres() {
    return lineaDeInteres;
  };

  public String getEstadoCivil() {
    return estadoCivil;
  };

  public Cedula getCedula() {
    return cedula;
  };
}
