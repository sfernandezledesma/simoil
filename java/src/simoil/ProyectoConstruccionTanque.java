package simoil;


public class ProyectoConstruccionTanque {
    private Tanque tanqueaAConstruir;
    private float costo;
    private int diaComienzoConstruccion;
    private int tiempoConstruccionTotalEnDias;
    private int diasParaFinalizar;

    public ProyectoConstruccionTanque(Tanque tanqueaAConstruir, float costo, int tiempoConstruccionTotalEnDias) {
        this.tanqueaAConstruir = new Tanque(tanqueaAConstruir.capacidadTotal());
        this.costo = costo;
        this.tiempoConstruccionTotalEnDias = tiempoConstruccionTotalEnDias;
        this.diasParaFinalizar = tiempoConstruccionTotalEnDias;
        this.diaComienzoConstruccion = 0;
    }

    public ProyectoConstruccionTanque(ProyectoConstruccionTanque otroProyecto, int diaComienzoConstruccion) {
        this(otroProyecto.tanque(), otroProyecto.costo(), otroProyecto.tiempoConstruccionTotalEnDias());
        this.diaComienzoConstruccion = diaComienzoConstruccion;
    }

    public boolean avanzarUnDia() {
        diasParaFinalizar = diasParaFinalizar - 1;
        boolean finalizada = false;
        if (diasParaFinalizar == 0)
            finalizada = true;
        return finalizada;
    }

    public Tanque tanque() {
        return tanqueaAConstruir;
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
