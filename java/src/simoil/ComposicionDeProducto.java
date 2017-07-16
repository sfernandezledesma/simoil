package simoil;


public class ComposicionDeProducto {
    private double porcentajeAgua;
    private double porcentajeGas;
    private double porcentajePetroleo;

    public ComposicionDeProducto(double porcentajeAgua, double porcentajeGas, double porcentajePetroleo) {
        if (porcentajeAgua < 0 || porcentajeAgua > 100 || porcentajeGas < 0 || porcentajeGas > 100 ||
                porcentajePetroleo < 0 || porcentajePetroleo > 100)
            throw new RuntimeException("Los porcentajes deben estar entre 0 y 100 inclusive.");

        if (Math.abs(porcentajeAgua + porcentajeGas + porcentajePetroleo - 100) > 0.1)
            throw new RuntimeException("Los porcentajes deben sumar 100.");

        this.porcentajeAgua = porcentajeAgua;
        this.porcentajeGas = porcentajeGas;
        this.porcentajePetroleo = porcentajePetroleo;
    }

    public double porcentajeAgua() {
        return porcentajeAgua;
    }

    public double porcentajeGas() {
        return porcentajeGas;
    }

    public double porcentajePetroleo() {
        return porcentajePetroleo;
    }
}
