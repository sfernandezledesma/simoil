package simoil.estrategias.seleccionParcelas;

import simoil.EmprendimientoPetrolifero;
import simoil.Excavacion;
import simoil.Parcela;

import java.util.ArrayList;

public class EstrategiaSeleccionParcelasPorFacilidadDeExcavacion extends EstrategiaSeleccionParcelas {
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

        parcelasSeleccionadas.sort((p1, p2) -> Double.compare(multiplicadorExcavacion(p2), multiplicadorExcavacion(p1)));

        while (parcelasSeleccionadas.size() > cantidadPozosDeseados)
            parcelasSeleccionadas.remove(parcelasSeleccionadas.size() - 1);

        return parcelasSeleccionadas;
    }

    private double multiplicadorExcavacion(Parcela parcela) {
        return 1.0 - parcela.tipoTerreno().resistenciaALaExcavacionEnPorcentaje() / 100.0;
    }
}
