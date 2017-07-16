package simoil;

public class EspecificacionPlantaProcesadora {
    private int cantidadDiasDeConstruccion;
    private double costo;
    private double capacidadProcesamientoTotal;

    public EspecificacionPlantaProcesadora(int cantidadDiasDeConstruccion, double costo, double capacidadProcesamientoTotal) {
        this.cantidadDiasDeConstruccion = cantidadDiasDeConstruccion;
        this.costo = costo;
        this.capacidadProcesamientoTotal = capacidadProcesamientoTotal;
    }

    public int cantidadDiasDeConstruccion() {
        return cantidadDiasDeConstruccion;
    }

    public double costo() {
        return costo;
    }

    public double capacidadProcesamientoTotal() {
        return capacidadProcesamientoTotal;
    }
}
