package simoil;

public class ProyectoConstruccionTanque {
    private Tanque tanqueEnConstruccion;
    private float costo;
    private int diaComienzoConstruccion;
    private int tiempoConstruccionTotalEnDias;
    private int diasParaFinalizar;

    public ProyectoConstruccionTanque(Tanque prototipoDeTanqueaAConstruir, float costo, int tiempoConstruccionTotalEnDias) {
        this.tanqueEnConstruccion = new Tanque(prototipoDeTanqueaAConstruir.capacidadTotal());
        this.costo = costo;
        this.tiempoConstruccionTotalEnDias = tiempoConstruccionTotalEnDias;
        this.diasParaFinalizar = tiempoConstruccionTotalEnDias;
        this.diaComienzoConstruccion = 0;
    }

    public ProyectoConstruccionTanque(ProyectoConstruccionTanque otroProyecto, int diaComienzoConstruccion) {
        this(otroProyecto.tanqueEnConstruccion(), otroProyecto.costo(), otroProyecto.tiempoConstruccionTotalEnDias());
        this.diaComienzoConstruccion = diaComienzoConstruccion;
    }

    public boolean construirUnDia() {
        diasParaFinalizar = diasParaFinalizar - 1;
        return diasParaFinalizar <= 0;
    }

    public Tanque tanqueEnConstruccion() {
        return tanqueEnConstruccion;
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

        ProyectoConstruccionTanque that = (ProyectoConstruccionTanque) o;

        return tanqueEnConstruccion.equals(that.tanqueEnConstruccion);
    }

    @Override
    public int hashCode() {
        return tanqueEnConstruccion.hashCode();
    }
}
