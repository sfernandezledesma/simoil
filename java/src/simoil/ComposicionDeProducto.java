package simoil;


public class ComposicionDeProducto {
    private float porcentajeAgua;
    private float porcentajeGas;
    private float porcentajePetroleo;

    public ComposicionDeProducto(float porcentajeAgua, float porcentajeGas, float porcentajePetroleo) {
        if (porcentajeAgua < 0 || porcentajeAgua > 100 || porcentajeGas < 0 || porcentajeGas > 100 ||
                porcentajePetroleo < 0 || porcentajePetroleo > 100)
            throw new RuntimeException("Los porcentajes deben estar entre 0 y 100 inclusive.");

        if (Math.abs(porcentajeAgua + porcentajeGas + porcentajePetroleo - 100f) > 0.1f)
            throw new RuntimeException("Los porcentajes deben sumar 100.");

        this.porcentajeAgua = porcentajeAgua;
        this.porcentajeGas = porcentajeGas;
        this.porcentajePetroleo = porcentajePetroleo;
    }

    public float porcentajeAgua() {
        return porcentajeAgua;
    }

    public float porcentajeGas() {
        return porcentajeGas;
    }

    public float porcentajePetroleo() {
        return porcentajePetroleo;
    }
}
