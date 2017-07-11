package simoil;

import java.util.List;

/**
 * Created by Sebastian on 11/07/2017.
 */
public class Yacimiento {
    private float volumenAgua;
    private float volumenGas;
    private float volumenPetroleo;
    private List<Parcela> parcelas;
    private float globalExtraido;
    private float globalReinyectado;

    public Yacimiento(float volumenAgua, float volumenGas, float volumenPetroleo, List<Parcela> parcelas) {
        if (volumenAgua < 0 || volumenGas < 0 || volumenPetroleo < 0)
            throw new RuntimeException("Los volumenes deben ser no negativos.");

        this.volumenAgua = volumenAgua;
        this.volumenGas = volumenGas;
        this.volumenPetroleo = volumenPetroleo;

        if (parcelas == null || parcelas.size() == 0)
            throw new RuntimeException("La cantidad de parcelas debe ser positiva.");
        else
            this.parcelas = parcelas;

        this.globalExtraido = 0;
        this.globalReinyectado = 0;
    }

    public float volumenTotal() {
        return volumenAgua + volumenGas + volumenPetroleo;
    }

    public ComposicionDeProducto composicionDeProducto() {
        float volumenTotal = volumenTotal();
        return new ComposicionDeProducto(volumenAgua / volumenTotal * 100,
                volumenGas / volumenTotal * 100,
                volumenPetroleo / volumenTotal * 100);
    }

    public List<Parcela> parcelas() {
        return parcelas;
    }

    public float globalExtraido() {
        return globalExtraido;
    }

    public float globalReinyectado() {
        return globalReinyectado;
    }

    public float reinyectarAguaYGas(float volumenAguaAReinyectar, float volumenGasAReinyectar) {
        float totalReinyeccion = volumenAguaAReinyectar + volumenGasAReinyectar;
        float volumenReinyectado = 0;
        if (totalReinyeccion + globalReinyectado < globalExtraido) {
            volumenAgua += volumenAguaAReinyectar;
            volumenGas += volumenGasAReinyectar;
            globalReinyectado = totalReinyeccion;
            volumenReinyectado = totalReinyeccion;
        }
        return volumenReinyectado;
    }

    public float extraerProducto(float volumenAExtraer) {
        float volumenExtraido = 0;
        if (volumenAExtraer < volumenTotal()) {
            ComposicionDeProducto composicion = composicionDeProducto();
            float volumenAguaExtraido = volumenAExtraer * composicion.porcentajeAgua() / 100;
            float volumenGasExtraido = volumenAExtraer * composicion.porcentajeGas() / 100;
            float volumenPetroleoExtraido = volumenAExtraer * composicion.porcentajePetroleo() / 100;
            volumenAgua -= volumenAguaExtraido;
            volumenGas -= volumenGasExtraido;
            volumenPetroleo -= volumenPetroleoExtraido;
            volumenExtraido = volumenAExtraer;
        }
        globalExtraido += volumenExtraido;
        return volumenExtraido;
    }
}
