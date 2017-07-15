package simoil;

public class ProyectoConstruccionPlanta {
    private String nombrePlantaEnConstruccion;
    private int diaComienzoConstruccion;
    private int diasParaFinalizar;
    private EspecificacionPlantaProcesadora especificacionPlantaProcesadora;

    public ProyectoConstruccionPlanta(String nombrePlanta, int diaComienzoConstruccion, EspecificacionPlantaProcesadora especificacionPlantaProcesadora) {
        this.nombrePlantaEnConstruccion = nombrePlanta;
        this.especificacionPlantaProcesadora = especificacionPlantaProcesadora;
        this.diasParaFinalizar = especificacionPlantaProcesadora.cantidadDiasDeConstruccion();
        this.diaComienzoConstruccion = diaComienzoConstruccion;
    }

    public EspecificacionPlantaProcesadora especificacionPlantaProcesadora() {
        return especificacionPlantaProcesadora;
    }

    public boolean construirUnDia() {
        diasParaFinalizar = diasParaFinalizar - 1;
        return diasParaFinalizar <= 0;
    }

    public PlantaProcesadora finalizarConstruccion() {
        if (diasParaFinalizar() > 0) {
            throw new RuntimeException("No puede finalizarse la construccion, faltan aun " + diasParaFinalizar() + " dias.");
        }
        return new PlantaProcesadora(nombrePlantaEnConstruccion, especificacionPlantaProcesadora.capacidadProcesamientoTotal());
    }

    public int diasParaFinalizar() {
        return diasParaFinalizar;
    }

    public int diaComienzoConstruccion() {
        return diaComienzoConstruccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProyectoConstruccionPlanta that = (ProyectoConstruccionPlanta) o;

        return nombrePlantaEnConstruccion.equals(that.nombrePlantaEnConstruccion);
    }

    @Override
    public int hashCode() {
        return nombrePlantaEnConstruccion.hashCode();
    }

    public String nombrePlantaEnConstruccion(){
        return this.nombrePlantaEnConstruccion;
    }
}
