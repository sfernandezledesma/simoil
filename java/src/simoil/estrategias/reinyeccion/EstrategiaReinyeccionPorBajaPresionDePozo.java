package simoil.estrategias.reinyeccion;

import simoil.EmprendimientoPetrolifero;
import simoil.Pozo;
import simoil.Tanque;
import simoil.Yacimiento;

import java.util.ArrayList;

public class EstrategiaReinyeccionPorBajaPresionDePozo extends EstrategiaReinyeccion {
    private float minimaPresion;

    public EstrategiaReinyeccionPorBajaPresionDePozo(float minimaPresion) {
        this.minimaPresion = minimaPresion;
    }

    @Override
    public double calcularTotalLitrosReinyeccion(EmprendimientoPetrolifero emprendimientoPetrolifero, double volumenMaximoReinyeccionEnUnDia) {
        tanquesDeAguaDeDondeDescargar = new ArrayList<>();
        tanquesDeGasDeDondeDescargar = new ArrayList<>();
        Yacimiento yacimiento = emprendimientoPetrolifero.yacimiento();
        double capacidadDeReinyeccion = yacimiento.volumenGlobalExtraido() - yacimiento.volumenGlobalReinyectado();
        capacidadDeReinyeccion = Math.min(volumenMaximoReinyeccionEnUnDia, capacidadDeReinyeccion);
        volumenAguaReinyeccion = 0;
        volumenGasReinyeccion = 0;
        boolean reinyectar = false;

        for (Pozo pozo : emprendimientoPetrolifero.yacimiento().pozosHabilitadosParaExtraccion()) {
            if (pozo.presionActual() < minimaPresion) {
                reinyectar = true;
                break;
            }
        }

        if (reinyectar) {
            for (Tanque tanqueDeAgua : emprendimientoPetrolifero.tanquesDeAguaHabilitados()) {
                tanquesDeAguaDeDondeDescargar.add(tanqueDeAgua);
                volumenAguaReinyeccion += tanqueDeAgua.volumenCargado();
            }

            for (Tanque tanqueDeGas : emprendimientoPetrolifero.tanquesDeGasHabilitados()) {
                tanquesDeGasDeDondeDescargar.add(tanqueDeGas);
                volumenGasReinyeccion += tanqueDeGas.volumenCargado();
            }

            double volumenTotalReinyeccionUsandoSoloTanques = volumenAguaReinyeccion + volumenGasReinyeccion;
            double proporcionAguaReinyeccion = volumenAguaReinyeccion / volumenTotalReinyeccionUsandoSoloTanques;
            double proporcionGasReinyeccion = volumenGasReinyeccion / volumenTotalReinyeccionUsandoSoloTanques;

            volumenTotalReinyeccionUsandoSoloTanques = Math.min(volumenTotalReinyeccionUsandoSoloTanques, capacidadDeReinyeccion);
            volumenAguaReinyeccion = volumenTotalReinyeccionUsandoSoloTanques * proporcionAguaReinyeccion;
            volumenGasReinyeccion = volumenTotalReinyeccionUsandoSoloTanques * proporcionGasReinyeccion;
            volumenAguaReinyeccion += (capacidadDeReinyeccion > volumenTotalReinyeccionUsandoSoloTanques) ? capacidadDeReinyeccion - volumenTotalReinyeccionUsandoSoloTanques : 0;
        }

        return volumenAguaReinyeccion + volumenGasReinyeccion;
    }
}
