package simoil.estrategias.extraccion;

import simoil.EmprendimientoPetrolifero;
import simoil.Parcela;
import simoil.Pozo;

import java.util.ArrayList;

public class EstrategiaExtraccionTodosLosPozosHabilitados extends EstrategiaExtraccion {
    @Override
    public void abrirValvulasDePozos(EmprendimientoPetrolifero emprendimientoPetrolifero) {
        ArrayList<Pozo> pozosHabilitados = emprendimientoPetrolifero.yacimiento().pozosHabilitados();
        for (Pozo pozo : pozosHabilitados)
            pozo.abrirValvulaPrincipal();
    }
}
