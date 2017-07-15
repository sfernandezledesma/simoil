package simoil;

public class EspecificacionTanque {
    private int cantidadDiasDeConstruccion;
    private float costo;
    private float capacidadTotal;

    public EspecificacionTanque(int cantidadDiasDeConstruccion, float costo, float capacidadTotal) {
        this.cantidadDiasDeConstruccion = cantidadDiasDeConstruccion;
        this.costo = costo;
        this.capacidadTotal = capacidadTotal;
    }

    public int cantidadDiasDeConstruccion() {
        return cantidadDiasDeConstruccion;
    }

    public float costo() {
        return costo;
    }

    public float capacidadTotal() {
        return capacidadTotal;
    }
}
