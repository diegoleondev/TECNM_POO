public class AlumnoPosgrado extends Alumno {
  private String empresa;
  private String puesto;
  private String lineaDeInteres;
  private String estadoCivil;
  private Cedula cedula;

  public AlumnoPosgrado(Persona persona, String empresa, String puesto, String lineaDeInteres, String estadoCivil,
      String fecha, String institucion, String titulo, String numCedula) {
    /*  */
    super(persona);
    /*  */
    this.empresa = empresa;
    this.puesto = puesto;
    this.lineaDeInteres = lineaDeInteres;
    this.estadoCivil = estadoCivil;

    this.cedula = new Cedula(fecha, institucion, titulo, numCedula);
  }

  public AlumnoPosgrado() {
    capturar();
  }

  @Override
  public String quienSoy() {
    return "AlumnoPosgrado";
  }

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
