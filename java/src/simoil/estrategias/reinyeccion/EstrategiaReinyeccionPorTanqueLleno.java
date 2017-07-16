package simoil.estrategias.reinyeccion;

import simoil.EmprendimientoPetrolifero;
import simoil.Tanque;
import simoil.Yacimiento;

import java.util.ArrayList;

public class EstrategiaReinyeccionPorTanqueLleno extends EstrategiaReinyeccion {
    @Override
    public float calcularTotalLitrosReinyeccion(EmprendimientoPetrolifero emprendimientoPetrolifero, float volumenMaximoReinyeccionEnUnDia) {
        tanquesDeAguaDeDondeDescargar = new ArrayList<>();
        tanquesDeGasDeDondeDescargar = new ArrayList<>();
        boolean tanqueLleno = false;

        Yacimiento yacimiento = emprendimientoPetrolifero.yacimiento();
        float capacidadDeReinyecccion = yacimiento.globalExtraido() - yacimiento.globalReinyectado();
        capacidadDeReinyecccion = Math.min(volumenMaximoReinyeccionEnUnDia, capacidadDeReinyecccion);
        float totalAReinyectar = capacidadDeReinyecccion * 1f;
        volumenAguaReinyeccion = totalAReinyectar * 1f;
        volumenGasReinyeccion = totalAReinyectar * 0f;

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
