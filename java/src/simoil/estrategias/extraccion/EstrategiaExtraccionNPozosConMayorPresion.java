package simoil.estrategias.extraccion;

import simoil.EmprendimientoPetrolifero;
import simoil.Pozo;

import java.util.ArrayList;

public class EstrategiaExtraccionNPozosConMayorPresion extends EstrategiaExtraccion{
    private int cantidadPozosExtraccion;

    public EstrategiaExtraccionNPozosConMayorPresion(int cantidadPozosExtraccion) {
        this.cantidadPozosExtraccion = cantidadPozosExtraccion;
    }

    @Override
    public void abrirValvulasDePozos(EmprendimientoPetrolifero emprendimientoPetrolifero) {
        ArrayList<Pozo> pozosOrdenadosMayorAMenor = new ArrayList<>(emprendimientoPetrolifero.yacimiento().pozosHabilitadosParaExtraccion());
        pozosOrdenadosMayorAMenor.sort((p1,p2) -> Double.compare(p2.presionActual(), p1.presionActual()));
        int cantidadEfectivaPozosParaAbrir = Math.min(cantidadPozosExtraccion, pozosOrdenadosMayorAMenor.size());
        for (int i = 0; i < cantidadEfectivaPozosParaAbrir; i++) {
            pozosOrdenadosMayorAMenor.get(i).abrirValvulaPrincipal();
        }
    }
}
