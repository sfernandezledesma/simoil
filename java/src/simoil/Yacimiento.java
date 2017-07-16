package simoil;

import java.util.ArrayList;

public class Yacimiento {
    private float alpha1;
    private float alpha2;
    private float volumenAgua;
    private float volumenGas;
    private float volumenPetroleo;
    private float volumenTotalInicial;
    private float globalExtraido;
    private float globalReinyectado;
    private ArrayList<Parcela> parcelas;

    public Yacimiento(float alpha1, float alpha2, float volumenAgua, float volumenGas, float volumenPetroleo, ArrayList<Parcela> parcelas) {
        this.alpha1 = alpha1;
        this.alpha2 = alpha2;
        if (volumenAgua < 0 || volumenGas < 0 || volumenPetroleo < 0)
            throw new RuntimeException("Los volumenes deben ser no negativos.");

        this.volumenAgua = volumenAgua;
        this.volumenGas = volumenGas;
        this.volumenPetroleo = volumenPetroleo;
        this.volumenTotalInicial = volumenAgua + volumenGas + volumenPetroleo;
        this.globalExtraido = 0;
        this.globalReinyectado = 0;

        if (parcelas == null || parcelas.size() == 0)
            throw new RuntimeException("La cantidad de parcelas debe ser positiva.");
        else
            this.parcelas = parcelas;

    }

    public float volumenTotalActual() {
        return volumenAgua + volumenGas + volumenPetroleo;
    }

    public ComposicionDeProducto composicionDeProducto() {
        float volumenTotal = volumenTotalActual();
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
        if (volumenAExtraer <= volumenTotalActual()) {
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

    public float volumenPotencialDiarioPozo(Pozo pozo) {
        if (!pozo.valvulaPrincipalAbierta()) {
            throw new RuntimeException("El pozo tiene la valvula cerrada, no puede extraer.");
        }
        float presionBocaDePozo = pozo.presionActual();
        int cantidadPozosAbiertos = cantidadPozosAbiertos();
        float presionSobrePozosHabilitados = presionBocaDePozo / cantidadPozosAbiertos;

        return Math.min(volumenTotalActual(), alpha1 * presionSobrePozosHabilitados + alpha2 * (float) Math.pow(presionSobrePozosHabilitados, 2f));
    }

    public int cantidadPozosAbiertos() {
        int cantidadPozosAbiertos = 0;
        for (Pozo pozo : pozosHabilitadosParaExtraccion()) {
            if (pozo.valvulaPrincipalAbierta()) {
                cantidadPozosAbiertos++;
            }
        }
        return cantidadPozosAbiertos;
    }

    public void actualizarPresionesPozos() {
        if (cantidadPozosAbiertos() > 0) {
            float beta = 0.1f * (volumenTotalActual() / volumenTotalInicial) / (float) Math.pow(cantidadPozosAbiertos(), 4.0 / 3.0);
            for (Pozo pozo : pozosHabilitadosParaExtraccion()) {
                if (pozo.valvulaPrincipalAbierta()) {
                    float nuevaPresion = pozo.presionActual() * (float) Math.exp(-beta);
                    pozo.actualizarPresion(nuevaPresion);
                }
            }
        }
    }

    public ArrayList<Pozo> pozosHabilitadosParaExtraccion() {
        ArrayList<Pozo> pozosHabilitadosParaExtraccion = new ArrayList<>();
        for (Parcela parcela : parcelas()) {
            if (parcela.tienePozo()) {
                pozosHabilitadosParaExtraccion.add(parcela.pozo());
            }
        }
        return pozosHabilitadosParaExtraccion;
    }

    public Pozo pozoPorNombre(String nombre) {
        for (Pozo pozo : this.pozosHabilitadosParaExtraccion()) {
            if (pozo.nombre().equals(nombre))
                return pozo;
        }
        throw new RuntimeException("No existe un pozo con ese nombre.");
    }
}
