package simoil.estrategias.reinyeccion;

import simoil.EmprendimientoPetrolifero;
import simoil.Tanque;
import simoil.Yacimiento;

import java.util.ArrayList;

public class EstrategiaReinyeccionReinyectarTodoCuandoSeLlenaUnTanque extends EstrategiaReinyeccion {
    @Override
    public double calcularTotalLitrosReinyeccion(EmprendimientoPetrolifero emprendimientoPetrolifero, double volumenMaximoReinyeccionEnUnDia) {
        tanquesDeAguaDeDondeDescargar = new ArrayList<>();
        tanquesDeGasDeDondeDescargar = new ArrayList<>();
        boolean tanqueLleno = false;

        Yacimiento yacimiento = emprendimientoPetrolifero.yacimiento();
        double capacidadDeReinyeccion = yacimiento.globalExtraido() - yacimiento.globalReinyectado();
        capacidadDeReinyeccion = Math.min(volumenMaximoReinyeccionEnUnDia, capacidadDeReinyeccion);
        //double totalAReinyectar = capacidadDeReinyecccion * 1.0;
        volumenAguaReinyeccion = 0;
        volumenGasReinyeccion = 0;

        for (Tanque tanqueDeAgua : emprendimientoPetrolifero.tanquesDeAguaHabilitados()) {
            tanquesDeAguaDeDondeDescargar.add(tanqueDeAgua);
            volumenAguaReinyeccion += tanqueDeAgua.volumenCargado();
            if (tanqueDeAgua.capacidadDisponible() == 0)
                tanqueLleno = true;
        }

        for (Tanque tanqueDeGas : emprendimientoPetrolifero.tanquesDeGasHabilitados()) {
            tanquesDeGasDeDondeDescargar.add(tanqueDeGas);
            volumenGasReinyeccion += tanqueDeGas.volumenCargado();
            if (tanqueDeGas.capacidadDisponible() == 0)
                tanqueLleno = true;
        }

        double volumenTotalReinyeccionUsandoSoloTanques = volumenAguaReinyeccion + volumenGasReinyeccion;
        double proporcionAguaReinyeccion = volumenAguaReinyeccion / volumenTotalReinyeccionUsandoSoloTanques;
        double proporcionGasReinyeccion = volumenGasReinyeccion / volumenTotalReinyeccionUsandoSoloTanques;

        volumenTotalReinyeccionUsandoSoloTanques = Math.min(volumenTotalReinyeccionUsandoSoloTanques, capacidadDeReinyeccion);
        volumenAguaReinyeccion = volumenTotalReinyeccionUsandoSoloTanques * proporcionAguaReinyeccion;
        volumenGasReinyeccion = volumenTotalReinyeccionUsandoSoloTanques * proporcionGasReinyeccion;
        volumenAguaReinyeccion += (capacidadDeReinyeccion > volumenTotalReinyeccionUsandoSoloTanques) ? capacidadDeReinyeccion - volumenTotalReinyeccionUsandoSoloTanques : 0;

        if (!tanqueLleno) {
            tanquesDeAguaDeDondeDescargar.clear();
            tanquesDeGasDeDondeDescargar.clear();
            volumenAguaReinyeccion = 0;
            volumenGasReinyeccion = 0;
        }

        return volumenAguaReinyeccion + volumenGasReinyeccion;
    }
}
