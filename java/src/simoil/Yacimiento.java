package simoil;

import java.util.ArrayList;

public class Yacimiento {
    private float volumenAgua;
    private float volumenGas;
    private float volumenPetroleo;
    private float globalExtraido;
    private float globalReinyectado;
    private ArrayList<Parcela> parcelas;
    private ArrayList<Pozo> pozosHabilitados;

    public Yacimiento(float volumenAgua, float volumenGas, float volumenPetroleo, ArrayList<Parcela> parcelas) {
        if (volumenAgua < 0 || volumenGas < 0 || volumenPetroleo < 0)
            throw new RuntimeException("Los volumenes deben ser no negativos.");

        this.volumenAgua = volumenAgua;
        this.volumenGas = volumenGas;
        this.volumenPetroleo = volumenPetroleo;
        this.globalExtraido = 0;
        this.globalReinyectado = 0;

        if (parcelas == null || parcelas.size() == 0)
            throw new RuntimeException("La cantidad de parcelas debe ser positiva.");
        else
            this.parcelas = parcelas;

        pozosHabilitados = new ArrayList<>();
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

    public ArrayList<Parcela> parcelas() {
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

    public void habilitarPozo(Pozo pozoAHabilitar) {
        int cantidadAparicionesPozoEnYacimiento = 0;
        for (Parcela parcela : parcelas) {
            if (parcela.tienePozo() && parcela.pozo() == pozoAHabilitar) {
                cantidadAparicionesPozoEnYacimiento++;
            }
        }
        if (cantidadAparicionesPozoEnYacimiento == 0) {
            throw new RuntimeException("El pozo que se quiere habilitar no existe en el yacimiento.");
        } else if (cantidadAparicionesPozoEnYacimiento > 1) {
            throw new RuntimeException("Hay multiples copias del pozo que se quiere habilitar en el yacimiento.");
        } else {
            pozosHabilitados.add(pozoAHabilitar);
        }
    }

    public ArrayList<Pozo> pozosHabilitados() {
        return new ArrayList<>(pozosHabilitados);
    }
}
