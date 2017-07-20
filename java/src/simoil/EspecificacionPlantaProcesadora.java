package simoil;

public class EspecificacionPlantaProcesadora {
    private int cantidadDiasDeConstruccion;
    private double costo;
    private double capacidadDiariaProcesamientoEnLitros;

    public EspecificacionPlantaProcesadora(int cantidadDiasDeConstruccion, double costo, double capacidadDiariaProcesamientoEnLitros) {
        if (cantidadDiasDeConstruccion < 1) {
            throw new RuntimeException("La cantidad de dias de construccion debe ser al menos 1.");
        }
        this.cantidadDiasDeConstruccion = cantidadDiasDeConstruccion;

        if (costo < 0) {
            throw new RuntimeException("El costo de construccion no puede ser negativo.");
        }
        this.costo = costo;

        if (capacidadDiariaProcesamientoEnLitros <= 0) {
            throw new RuntimeException("La capacidad de procesamiento diaria en litros debe ser positiva.");
        }
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
