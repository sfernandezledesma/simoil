package simoil;

/**
 * Created by Sebastian on 11/07/2017.
 */
public class ComposicionDeProducto {
    private float porcentajeAgua;
    private float porcentajeGas;
    private float porcentajePetroleo;

    public ComposicionDeProducto(float porcentajeAgua, float porcentajeGas, float porcentajePetroleo) {
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
