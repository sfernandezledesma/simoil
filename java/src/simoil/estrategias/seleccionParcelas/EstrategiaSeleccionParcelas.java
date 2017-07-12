package simoil.estrategias.seleccionParcelas;

import simoil.Parcela;

import java.util.ArrayList;

/**
 * Created by Sebastian on 11/07/2017.
 */
public abstract class EstrategiaSeleccionParcelas {
    protected ArrayList<Parcela> parcelas;
    protected int cantidadPozosDeseados;

    public EstrategiaSeleccionParcelas(ArrayList<Parcela> parcelas, int cantidadPozosDeseados) {
        this.parcelas = parcelas;
        this.cantidadPozosDeseados = cantidadPozosDeseados;
    }

    public abstract ArrayList<Parcela> seleccionarParcelasParaExcavar();
}
