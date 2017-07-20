package simoil;

public class EspecificacionTanque {
    private int cantidadDiasDeConstruccion;
    private double costo;
    private double capacidadAlmacenamientoEnLitros;

    public EspecificacionTanque(int cantidadDiasDeConstruccion, double costo, double capacidadAlmacenamientoEnLitros) {
        if (cantidadDiasDeConstruccion < 1) {
            throw new RuntimeException("La cantidad de dias de construccion debe ser al menos 1.");
        }
        this.cantidadDiasDeConstruccion = cantidadDiasDeConstruccion;

        if (costo < 0) {
            throw new RuntimeException("El costo de construccion no puede ser negativo.");
        }
        this.costo = costo;

        if (capacidadAlmacenamientoEnLitros <= 0) {
            throw new RuntimeException("La capacidad de almacenamiento en litros debe ser positiva.");
        }
        this.capacidadAlmacenamientoEnLitros = capacidadAlmacenamientoEnLitros;
    }

    public int cantidadDiasDeConstruccion() {
        return cantidadDiasDeConstruccion;
    }

    public double costo() {
        return costo;
    }

    public double capacidadAlmacenamientoEnLitros() {
        return capacidadAlmacenamientoEnLitros;
    }
}
