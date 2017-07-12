package simoil;


public class ProyectoConstruccion {
    private Estructura estructuraAConstruir;
    private float costo;
    private int diaComienzoConstruccion;
    private int tiempoConstruccionTotalEnDias;
    private int diasParaFinalizar;

    public ProyectoConstruccion(Estructura estructuraAConstruir, float costo, int tiempoConstruccionTotalEnDias) {
        this.estructuraAConstruir = estructuraAConstruir.clonar();
        this.costo = costo;
        this.tiempoConstruccionTotalEnDias = tiempoConstruccionTotalEnDias;
        this.diasParaFinalizar = tiempoConstruccionTotalEnDias;
        this.diaComienzoConstruccion = 0;
    }

    public ProyectoConstruccion(ProyectoConstruccion otroProyecto, int diaComienzoConstruccion) {
        this(otroProyecto.estructura(), otroProyecto.costo(), otroProyecto.tiempoConstruccionTotalEnDias());
        this.diaComienzoConstruccion = diaComienzoConstruccion;
    }

    public boolean avanzarUnDia() {
        diasParaFinalizar = diasParaFinalizar - 1;
        boolean finalizada = false;
        if (diasParaFinalizar == 0)
            finalizada = true;
        return finalizada;
    }

    public Estructura estructura() {
        return estructuraAConstruir;
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
