package simoil;

public class EspecificacionPlantaProcesadora {
    private int cantidadDiasDeConstruccion;
    private float costo;
    private float capacidadProcesamientoTotal;

    public EspecificacionPlantaProcesadora(int cantidadDiasDeConstruccion, float costo, float capacidadProcesamientoTotal) {
        this.cantidadDiasDeConstruccion = cantidadDiasDeConstruccion;
        this.costo = costo;
        this.capacidadProcesamientoTotal = capacidadProcesamientoTotal;
    }

    public int cantidadDiasDeConstruccion() {
        return cantidadDiasDeConstruccion;
    }

    public float costo() {
        return costo;
    }

    public float capacidadProcesamientoTotal() {
        return capacidadProcesamientoTotal;
    }
}
