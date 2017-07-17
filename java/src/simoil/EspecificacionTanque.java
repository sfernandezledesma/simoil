package simoil;

public class EspecificacionTanque {
    private int cantidadDiasDeConstruccion;
    private double costo;
    private double capacidadAlmacenamientoEnLitros;

    public EspecificacionTanque(int cantidadDiasDeConstruccion, double costo, double capacidadAlmacenamientoEnLitros) {
        this.cantidadDiasDeConstruccion = cantidadDiasDeConstruccion;
        this.costo = costo;
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
