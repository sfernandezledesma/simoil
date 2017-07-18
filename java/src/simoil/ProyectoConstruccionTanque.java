package simoil;

public class ProyectoConstruccionTanque {
    private String nombreTanqueEnConstruccion;
    private int diaComienzoConstruccion;
    private int diasParaFinalizar;
    private EspecificacionTanque especificacionTanque;

    public ProyectoConstruccionTanque(String nombreTanqueEnConstruccion, int diaComienzoConstruccion, EspecificacionTanque especificacionTanque) {
        this.nombreTanqueEnConstruccion = nombreTanqueEnConstruccion;
        this.especificacionTanque = especificacionTanque;
        this.diasParaFinalizar = especificacionTanque.cantidadDiasDeConstruccion();
        this.diaComienzoConstruccion = diaComienzoConstruccion;
    }

    public boolean construirUnDia() {
        diasParaFinalizar = diasParaFinalizar - 1;
        return diasParaFinalizar <= 0;
    }

    public Tanque finalizarConstruccion() {
        if (diasParaFinalizar() > 0) {
            throw new RuntimeException("No puede finalizarse la construccion, faltan aun " + diasParaFinalizar() + " dias.");
        }
        return new Tanque(nombreTanqueEnConstruccion, especificacionTanque.capacidadAlmacenamientoEnLitros());
    }

    public EspecificacionTanque especificacionTanque() {
        return especificacionTanque;
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

        return nombreTanqueEnConstruccion.equals(that.nombreTanqueEnConstruccion);
    }

    @Override
    public int hashCode() {
        return nombreTanqueEnConstruccion.hashCode();
    }

    public String nombreTanqueEnConstruccion(){
        return this.nombreTanqueEnConstruccion;
    }
}
