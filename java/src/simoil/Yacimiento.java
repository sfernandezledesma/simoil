package simoil;

import java.util.ArrayList;

public class Yacimiento {
    private double alpha1;
    private double alpha2;
    private double volumenAgua;
    private double volumenGas;
    private double volumenPetroleo;
    private double volumenTotalInicial;
    private double globalExtraido;
    private double globalReinyectado;
    private ArrayList<Parcela> parcelas;

    public Yacimiento(double alpha1, double alpha2, double volumenAgua, double volumenGas, double volumenPetroleo, ArrayList<Parcela> parcelas) {
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

    public double volumenTotalActual() {
        return volumenAgua + volumenGas + volumenPetroleo;
    }

    public ComposicionDeProducto composicionDeProducto() {
        double volumenTotal = volumenTotalActual();
        return new ComposicionDeProducto(volumenAgua / volumenTotal * 100,
                volumenGas / volumenTotal * 100,
                volumenPetroleo / volumenTotal * 100);
    }

    public ArrayList<Parcela> parcelas() {
        return parcelas;
    }

    public double volumenGlobalExtraido() {
        return globalExtraido;
    }

    public double volumenGlobalReinyectado() {
        return globalReinyectado;
    }

    public double reinyectarAguaYGas(double volumenAguaAReinyectar, double volumenGasAReinyectar) {
        double totalReinyeccion = volumenAguaAReinyectar + volumenGasAReinyectar;
        double volumenReinyectado = 0;
        if (totalReinyeccion + globalReinyectado > globalExtraido) {
            throw new RuntimeException("Se intento reinyectar mas volumen de lo que el yacimiento soporta.");
        }
        volumenAgua += volumenAguaAReinyectar;
        volumenGas += volumenGasAReinyectar;
        globalReinyectado = totalReinyeccion;
        volumenReinyectado = totalReinyeccion;
        return volumenReinyectado;
    }

    public double extraerProducto(double volumenAExtraer) {
        double volumenExtraido = 0;
        if (volumenAExtraer <= volumenTotalActual()) {
            ComposicionDeProducto composicion = composicionDeProducto();
            double volumenAguaExtraido = volumenAExtraer * composicion.porcentajeAgua() / 100.0;
            double volumenGasExtraido = volumenAExtraer * composicion.porcentajeGas() / 100.0;
            double volumenPetroleoExtraido = volumenAExtraer * composicion.porcentajePetroleo() / 100.0;
            volumenAgua -= volumenAguaExtraido;
            volumenGas -= volumenGasExtraido;
            volumenPetroleo -= volumenPetroleoExtraido;
            volumenExtraido = volumenAExtraer;
        }
        globalExtraido += volumenExtraido;
        return volumenExtraido;
    }

    public double volumenPotencialDiarioPozo(Pozo pozo) {
        if (!pozo.valvulaPrincipalAbierta()) {
            throw new RuntimeException("El pozo tiene la valvula cerrada, no puede extraer.");
        }
        double presionBocaDePozo = pozo.presionActual();
        int cantidadPozosAbiertos = cantidadPozosAbiertos();
        double presionSobrePozosHabilitados = presionBocaDePozo / cantidadPozosAbiertos;

        return Math.min(volumenTotalActual(), alpha1 * presionSobrePozosHabilitados + alpha2 * Math.pow(presionSobrePozosHabilitados, 2.0));
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

    public void actualizarPresionesPozosPorExtraccion() {
        if (cantidadPozosAbiertos() > 0) {
            double beta = 0.1 * (volumenTotalActual() / volumenTotalInicial) / (double) Math.pow(cantidadPozosAbiertos(), 4.0 / 3.0);
            for (Pozo pozo : pozosHabilitadosParaExtraccion()) {
                if (pozo.valvulaPrincipalAbierta()) {
                    double nuevaPresion = pozo.presionActual() * (double) Math.exp(-beta);
                    pozo.actualizarPresion(nuevaPresion);
                }
            }
        }
    }

    public void actualizarPresionesPozosPorReinyeccion() {
        for (Pozo pozo : pozosHabilitadosParaExtraccion()) {
            double nuevaPresion = pozo.presionInicial() * (volumenTotalInicial - volumenGlobalExtraido() + volumenGlobalReinyectado()) / volumenTotalInicial;
            pozo.actualizarPresion(nuevaPresion);
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

    public boolean pozoHabilitado(String nombre) {
        for (Pozo pozo : this.pozosHabilitadosParaExtraccion()) {
            if (pozo.nombre().equals(nombre))
                return true;
        }
        return false;
    }

    public Pozo pozoPorNombre(String nombre) {
        for (Pozo pozo : this.pozosHabilitadosParaExtraccion()) {
            if (pozo.nombre().equals(nombre))
                return pozo;
        }
        throw new RuntimeException("No existe un pozo con ese nombre.");
    }
}
