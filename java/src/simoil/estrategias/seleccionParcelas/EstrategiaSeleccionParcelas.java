package simoil.estrategias.seleccionParcelas;

import simoil.Parcela;

import java.util.ArrayList;


public abstract class EstrategiaSeleccionParcelas {
    protected ArrayList<Parcela> parcelas;
    protected int cantidadPozosDeseados;

    public EstrategiaSeleccionParcelas(ArrayList<Parcela> parcelas, int cantidadPozosDeseados) {
        this.parcelas = parcelas;
        this.cantidadPozosDeseados = cantidadPozosDeseados;
    }

    public abstract ArrayList<Parcela> seleccionarParcelasParaExcavar();
}
