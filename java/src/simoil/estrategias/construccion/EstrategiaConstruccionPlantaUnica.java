package simoil.estrategias.construccion;

import simoil.*;

import java.util.ArrayList;

public class EstrategiaConstruccionPlantaUnica extends EstrategiaConstruccion {
    private boolean hayNuevosProyectosPlantas = true;
    private boolean hayNuevosProyectosTanquesAgua = true;
    private boolean hayNuevosProyectosTanquesGas = true;

    @Override
    public ArrayList<ProyectoConstruccionPlanta> nuevosProyectosConstruccionPlantas(EmprendimientoPetrolifero emprendimientoPetrolifero) {
        ArrayList<ProyectoConstruccionPlanta> nuevosProyectosPlantas = new ArrayList<>();
        if (hayNuevosProyectosPlantas) {
            ArrayList<EspecificacionPlantaProcesadora> catalogoPlantasOrdenadosPorCapacidadProcesamientoDescendiente = new ArrayList<>(emprendimientoPetrolifero.catalogoPlantasProcesadoras());
            catalogoPlantasOrdenadosPorCapacidadProcesamientoDescendiente.sort((p1,p2) -> Float.compare(p2.capacidadProcesamientoTotal(), p1.capacidadProcesamientoTotal()));
            ProyectoConstruccionPlanta nuevoProyectoPlanta = new ProyectoConstruccionPlanta(
                    "Planta1", 1, catalogoPlantasOrdenadosPorCapacidadProcesamientoDescendiente.get(0));
            nuevosProyectosPlantas.add(nuevoProyectoPlanta);
            hayNuevosProyectosPlantas = false;
        }
        return nuevosProyectosPlantas;
    }

    @Override
    public ArrayList<ProyectoConstruccionTanque> nuevosProyectosConstruccionTanquesDeAgua(EmprendimientoPetrolifero emprendimientoPetrolifero) {
        ArrayList<ProyectoConstruccionTanque> nuevosProyectosAgua = new ArrayList<>();
        if (hayNuevosProyectosTanquesAgua) {
            ArrayList<EspecificacionTanque> catalogosTanquesOrdenadosPorCapacidadDescendiente = new ArrayList<>(emprendimientoPetrolifero.catalogoTanques());
            catalogosTanquesOrdenadosPorCapacidadDescendiente.sort((p1,p2) -> Float.compare(p2.capacidadTotal(), p1.capacidadTotal()));
            ProyectoConstruccionTanque nuevoProyectoTanqueAgua = new ProyectoConstruccionTanque(
                    "Agua1", 1, catalogosTanquesOrdenadosPorCapacidadDescendiente.get(0));
            nuevosProyectosAgua.add(nuevoProyectoTanqueAgua);
            hayNuevosProyectosTanquesAgua = false;
        }
        return nuevosProyectosAgua;
    }

    @Override
    public ArrayList<ProyectoConstruccionTanque> nuevosProyectosConstruccionTanquesDeGas(EmprendimientoPetrolifero emprendimientoPetrolifero) {
        ArrayList<ProyectoConstruccionTanque> nuevosProyectosGas = new ArrayList<>();
        if (hayNuevosProyectosTanquesGas) {
            ArrayList<EspecificacionTanque> catalogosTanquesOrdenadosPorCapacidadDescendiente = new ArrayList<>(emprendimientoPetrolifero.catalogoTanques());
            catalogosTanquesOrdenadosPorCapacidadDescendiente.sort((p1,p2) -> Float.compare(p2.capacidadTotal(), p1.capacidadTotal()));
            ProyectoConstruccionTanque nuevoProyectoTanqueGas = new ProyectoConstruccionTanque(
                    "Gas1", 1, catalogosTanquesOrdenadosPorCapacidadDescendiente.get(0));
            nuevosProyectosGas.add(nuevoProyectoTanqueGas);
            hayNuevosProyectosTanquesGas = false;
        }
        return nuevosProyectosGas;
    }
}
