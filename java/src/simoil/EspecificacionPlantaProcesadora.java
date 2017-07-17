package simoil;

public class EspecificacionPlantaProcesadora {
    private int cantidadDiasDeConstruccion;
    private double costo;
    private double capacidadDiariaProcesamientoEnLitros;

    public EspecificacionPlantaProcesadora(int cantidadDiasDeConstruccion, double costo, double capacidadDiariaProcesamientoEnLitros) {
        this.cantidadDiasDeConstruccion = cantidadDiasDeConstruccion;
        this.costo = costo;
        this.capacidadDiariaProcesamientoEnLitros = capacidadDiariaProcesamientoEnLitros;
    }

    public int cantidadDiasDeConstruccion() {
        return cantidadDiasDeConstruccion;
    }

    public double costo() {
        return costo;
    }

    public double capacidadDiariaProcesamientoEnLitros() {
        return capacidadDiariaProcesamientoEnLitros;
    }
}
