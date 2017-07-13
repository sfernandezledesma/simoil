package simoil;


public class ProyectoConstruccionPlanta {
    private PlantaProcesadora plantaAConstruir;
    private float costo;
    private int diaComienzoConstruccion;
    private int tiempoConstruccionTotalEnDias;
    private int diasParaFinalizar;

    public ProyectoConstruccionPlanta(PlantaProcesadora plantaAConstruir, float costo, int tiempoConstruccionTotalEnDias) {
        this.plantaAConstruir = new PlantaProcesadora(plantaAConstruir.capacidadProcesamiento());
        this.costo = costo;
        this.tiempoConstruccionTotalEnDias = tiempoConstruccionTotalEnDias;
        this.diasParaFinalizar = tiempoConstruccionTotalEnDias;
        this.diaComienzoConstruccion = 0;
    }

    public ProyectoConstruccionPlanta(ProyectoConstruccionPlanta otroProyecto, int diaComienzoConstruccion) {
        this(otroProyecto.plantaProcesadora(), otroProyecto.costo(), otroProyecto.tiempoConstruccionTotalEnDias());
        this.diaComienzoConstruccion = diaComienzoConstruccion;
    }

    public boolean avanzarUnDia() {
        diasParaFinalizar = diasParaFinalizar - 1;
        boolean finalizada = false;
        if (diasParaFinalizar == 0)
            finalizada = true;
        return finalizada;
    }

    public PlantaProcesadora plantaProcesadora() {
        return plantaAConstruir;
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

}
