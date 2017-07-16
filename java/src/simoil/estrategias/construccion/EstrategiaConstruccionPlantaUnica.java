package simoil.estrategias.construccion;

import simoil.*;

import java.util.ArrayList;

public class EstrategiaConstruccionPlantaUnica extends EstrategiaConstruccion {
    private boolean hayNuevosProyectos = true;

    @Override
    public void crearProyectos(EmprendimientoPetrolifero emprendimientoPetrolifero) {
        nuevosProyectosPlantas = new ArrayList<>();
        nuevosProyectosTanquesAgua = new ArrayList<>();
        nuevosProyectosTanquesGas = new ArrayList<>();
        nuevasConexionesPlantaTanqueAgua = new ArrayList<>();
        nuevasConexionesPlantaTanqueGas = new ArrayList<>();
        if (hayNuevosProyectos) {
            ArrayList<EspecificacionPlantaProcesadora> catalogoPlantasOrdenadosPorCapacidadProcesamientoDescendiente = new ArrayList<>(emprendimientoPetrolifero.catalogoPlantasProcesadoras());
            catalogoPlantasOrdenadosPorCapacidadProcesamientoDescendiente.sort((p1,p2) -> Float.compare(p2.capacidadProcesamientoTotal(), p1.capacidadProcesamientoTotal()));
            ProyectoConstruccionPlantaProcesadora nuevoProyectoPlanta = new ProyectoConstruccionPlantaProcesadora(
                    "1", 1, catalogoPlantasOrdenadosPorCapacidadProcesamientoDescendiente.get(0));
            nuevosProyectosPlantas.add(nuevoProyectoPlanta);

            ArrayList<EspecificacionTanque> catalogosTanquesOrdenadosPorCapacidadDescendiente = new ArrayList<>(emprendimientoPetrolifero.catalogoTanques());
            catalogosTanquesOrdenadosPorCapacidadDescendiente.sort((p1,p2) -> Float.compare(p2.capacidadTotal(), p1.capacidadTotal()));

            ProyectoConstruccionTanque nuevoProyectoTanqueAgua = new ProyectoConstruccionTanque(
                    "A1", 1, catalogosTanquesOrdenadosPorCapacidadDescendiente.get(0));
            nuevosProyectosTanquesAgua.add(nuevoProyectoTanqueAgua);
            nuevasConexionesPlantaTanqueAgua.add(new ConexionEntreEstructuras(
                    nuevoProyectoPlanta.nombrePlantaEnConstruccion(),
                    nuevoProyectoTanqueAgua.nombreTanqueEnConstruccion()));

            ProyectoConstruccionTanque nuevoProyectoTanqueGas = new ProyectoConstruccionTanque(
                    "G1", 1, catalogosTanquesOrdenadosPorCapacidadDescendiente.get(0));
            nuevosProyectosTanquesGas.add(nuevoProyectoTanqueGas);
            nuevasConexionesPlantaTanqueGas.add(new ConexionEntreEstructuras(
                    nuevoProyectoPlanta.nombrePlantaEnConstruccion(),
                    nuevoProyectoTanqueGas.nombreTanqueEnConstruccion()));

            hayNuevosProyectos = false;
        }
    }
}
