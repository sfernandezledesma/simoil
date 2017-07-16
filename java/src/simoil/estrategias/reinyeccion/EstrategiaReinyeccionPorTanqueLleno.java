package simoil.estrategias.reinyeccion;

import simoil.EmprendimientoPetrolifero;
import simoil.Tanque;
import simoil.Yacimiento;

import java.util.ArrayList;

public class EstrategiaReinyeccionPorTanqueLleno extends EstrategiaReinyeccion {
    @Override
    public double calcularTotalLitrosReinyeccion(EmprendimientoPetrolifero emprendimientoPetrolifero, double volumenMaximoReinyeccionEnUnDia) {
        tanquesDeAguaDeDondeDescargar = new ArrayList<>();
        tanquesDeGasDeDondeDescargar = new ArrayList<>();
        boolean tanqueLleno = false;

        Yacimiento yacimiento = emprendimientoPetrolifero.yacimiento();
        double capacidadDeReinyecccion = yacimiento.globalExtraido() - yacimiento.globalReinyectado();
        capacidadDeReinyecccion = Math.min(volumenMaximoReinyeccionEnUnDia, capacidadDeReinyecccion);
        double totalAReinyectar = capacidadDeReinyecccion * 1.0;
        volumenAguaReinyeccion = totalAReinyectar * 1.0;
        volumenGasReinyeccion = totalAReinyectar * 0;

        for (Tanque tanqueDeAgua : emprendimientoPetrolifero.tanquesDeAguaHabilitados()) {
            tanquesDeAguaDeDondeDescargar.add(tanqueDeAgua);
            if (tanqueDeAgua.capacidadDisponible() == 0)
                tanqueLleno = true;
        }

        for (Tanque tanqueDeGas : emprendimientoPetrolifero.tanquesDeGasHabilitados()) {
            tanquesDeGasDeDondeDescargar.add(tanqueDeGas);
            if (tanqueDeGas.capacidadDisponible() == 0)
                tanqueLleno = true;
        }

        if (!tanqueLleno) {
            tanquesDeAguaDeDondeDescargar.clear();
            tanquesDeGasDeDondeDescargar.clear();
            volumenAguaReinyeccion = 0;
            volumenGasReinyeccion = 0;
        }

        return volumenAguaReinyeccion + volumenGasReinyeccion;
    }
}
