package simoil;

public class EspecificacionTanque {
    private int cantidadDiasDeConstruccion;
    private double costo;
    private double capacidadTotal;

    public EspecificacionTanque(int cantidadDiasDeConstruccion, double costo, double capacidadTotal) {
        this.cantidadDiasDeConstruccion = cantidadDiasDeConstruccion;
        this.costo = costo;
        this.capacidadTotal = capacidadTotal;
    }

    public int cantidadDiasDeConstruccion() {
        return cantidadDiasDeConstruccion;
    }

    public double costo() {
        return costo;
    }

    public double capacidadTotal() {
        return capacidadTotal;
    }
}
