package simoil;

public class ProyectoConstruccionPlanta {
    private PlantaProcesadora plantaEnConstruccion;
    private float costo;
    private int diaComienzoConstruccion;
    private int tiempoConstruccionTotalEnDias;
    private int diasParaFinalizar;

    public ProyectoConstruccionPlanta(PlantaProcesadora prototipoDePlantaAConstruir, float costo, int tiempoConstruccionTotalEnDias) {
        this.plantaEnConstruccion = new PlantaProcesadora(prototipoDePlantaAConstruir.capacidadProcesamiento());
        this.costo = costo;
        this.tiempoConstruccionTotalEnDias = tiempoConstruccionTotalEnDias;
        this.diasParaFinalizar = tiempoConstruccionTotalEnDias;
        this.diaComienzoConstruccion = 0;
    }

    public ProyectoConstruccionPlanta(ProyectoConstruccionPlanta otroProyecto, int diaComienzoConstruccion) {
        this(otroProyecto.plantaEnConstruccion(), otroProyecto.costo(), otroProyecto.tiempoConstruccionTotalEnDias());
        this.diaComienzoConstruccion = diaComienzoConstruccion;
    }

    public boolean construirUnDia() {
        diasParaFinalizar = diasParaFinalizar - 1;
        return diasParaFinalizar <= 0;
    }

    public PlantaProcesadora plantaEnConstruccion() {
        return plantaEnConstruccion;
    }

    public float costo() {
        return costo;
    }

    public int tiempoConstruccionTotalEnDias() {
        return tiempoConstruccionTotalEnDias;
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

        return plantaEnConstruccion.equals(that.plantaEnConstruccion);
    }

    @Override
    public int hashCode() {
        return plantaEnConstruccion.hashCode();
    }
}
