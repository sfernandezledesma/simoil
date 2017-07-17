package simoil.estrategias.reinyeccion;

import simoil.EmprendimientoPetrolifero;
import simoil.Tanque;
import simoil.Yacimiento;

import java.util.ArrayList;

public class EstrategiaReinyeccionReinyectarTodoLoAlmacenadoCuandoSeLlenaUnTanque extends EstrategiaReinyeccion {
    @Override
    public double calcularTotalLitrosReinyeccion(EmprendimientoPetrolifero emprendimientoPetrolifero, double volumenMaximoReinyeccionEnUnDia) {
        tanquesDeAguaDeDondeDescargar = new ArrayList<>();
        tanquesDeGasDeDondeDescargar = new ArrayList<>();
        boolean tanqueLleno = false;

        Yacimiento yacimiento = emprendimientoPetrolifero.yacimiento();
        double capacidadDeReinyeccion = yacimiento.globalExtraido() - yacimiento.globalReinyectado();
        capacidadDeReinyeccion = Math.min(volumenMaximoReinyeccionEnUnDia, capacidadDeReinyeccion);
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

        if (!tanqueLleno) {
            tanquesDeAguaDeDondeDescargar.clear();
            tanquesDeGasDeDondeDescargar.clear();
            volumenAguaReinyeccion = 0;
            volumenGasReinyeccion = 0;
        }

        return volumenAguaReinyeccion + volumenGasReinyeccion;
    }
}
