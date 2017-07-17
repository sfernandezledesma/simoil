package simoil.estrategias.seleccionParcelas;

import simoil.EmprendimientoPetrolifero;
import simoil.Parcela;

import java.util.ArrayList;


public abstract class EstrategiaSeleccionParcelas {

    public abstract ArrayList<Parcela> seleccionarParcelasParaExcavar(
                                                                        EmprendimientoPetrolifero emprendimientoPetrolifero,
                                                                        int cantidadPozosDeseados);

}
