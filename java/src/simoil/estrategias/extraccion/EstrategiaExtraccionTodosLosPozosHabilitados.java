package simoil.estrategias.extraccion;

import simoil.EmprendimientoPetrolifero;
import simoil.Pozo;

import java.util.ArrayList;

public class EstrategiaExtraccionTodosLosPozosHabilitados extends EstrategiaExtraccion {
    @Override
    public void abrirValvulasDePozos(EmprendimientoPetrolifero emprendimientoPetrolifero) {
        ArrayList<Pozo> pozosHabilitados = emprendimientoPetrolifero.yacimiento().pozosHabilitadosParaExtraccion();
        for (Pozo pozo : pozosHabilitados)
            pozo.abrirValvulaPrincipal();
    }
}
