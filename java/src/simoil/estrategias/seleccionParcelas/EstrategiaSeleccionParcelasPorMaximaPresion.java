package simoil.estrategias.seleccionParcelas;

import simoil.EmprendimientoPetrolifero;
import simoil.Excavacion;
import simoil.Parcela;
import java.util.ArrayList;

public class EstrategiaSeleccionParcelasPorMaximaPresion extends EstrategiaSeleccionParcelas {

    @Override
    public ArrayList<Parcela> seleccionarParcelasParaExcavar(EmprendimientoPetrolifero emprendimientoPetrolifero, int cantidadPozosDeseados) {
        ArrayList<Parcela> parcelasSeleccionadas = new ArrayList<>();

        for (Parcela parcela : emprendimientoPetrolifero.yacimiento().parcelas()) {
            String nombrePotencialPozo = parcela.nombre();
            boolean todoOk = true;
            if (parcela.tienePozo()) { // Si tiene pozo, no podemos seleccionarla
                todoOk = false;
            } else {
                // Si el pozo ya esta en excavacion, tampoco se puede seleccionar
                for (Excavacion excavacionActiva : emprendimientoPetrolifero.excavacionesActivas()) {
                    if (excavacionActiva.nombrePozoEnExcavacion().equals(nombrePotencialPozo)) {
                        todoOk = false;
                        break;
                    }
                }
                for (Excavacion excavacionPendienteFinalizacion : emprendimientoPetrolifero.excavacionesPendientesDeFinalizacion()) {
                    if (excavacionPendienteFinalizacion.nombrePozoEnExcavacion().equals(nombrePotencialPozo)) {
                        todoOk = false;
                        break;
                    }
                }
            }
            if (todoOk) {
                parcelasSeleccionadas.add(parcela);
            }
        }

        parcelasSeleccionadas.sort((p1, p2) -> Double.compare(p2.presionInicial(), p1.presionInicial()));

        while (parcelasSeleccionadas.size() > cantidadPozosDeseados)
            parcelasSeleccionadas.remove(parcelasSeleccionadas.size() - 1);

        return parcelasSeleccionadas;
    }

}
