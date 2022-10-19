public class Tutor extends Profesor {
  private String otrosCursos;
  private boolean tomoDiplomado;
  private String fechaDiploma;
  private String moduloDiplomado;

  public Tutor(Persona persona, String otrosCursos, Boolean tomoDiplomado, String fechaDiploma,
      String moduloDiplomado) {
    super(persona);
    this.otrosCursos = otrosCursos;
    this.tomoDiplomado = tomoDiplomado;
    this.fechaDiploma = fechaDiploma;
    this.moduloDiplomado = moduloDiplomado;
  }

  public Tutor(Tutor tutor) {

    super(tutor.getCorreo(), tutor.getEspecializacion(), tutor.getNombre(), tutor.getRfc(),
        tutor.getTelefono());
    this.otrosCursos = tutor.getOtrosCursos();
    this.tomoDiplomado = tutor.getTomoDiplomado();
    this.fechaDiploma = tutor.getFechaDiploma();
    this.moduloDiplomado = tutor.getModuloDiplomado();
  }

  @Override
  public String quienSoy() {
    return "Tutor";
  }

  public String getOtrosCursos() {
    return otrosCursos;
  }

  public boolean getTomoDiplomado() {
    return tomoDiplomado;
  }

  public String getFechaDiploma() {
    return fechaDiploma;
  }

  public String getModuloDiplomado() {
    return moduloDiplomado;
  }

}
