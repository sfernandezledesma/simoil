package simoil.estrategias.construccion;

import simoil.*;

import java.lang.reflect.Array;
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
            ProyectoConstruccionPlanta nuevoProyectoPlanta = new ProyectoConstruccionPlanta(
                    "Planta1", 1, catalogoPlantasOrdenadosPorCapacidadProcesamientoDescendiente.get(0));
            nuevosProyectosPlantas.add(nuevoProyectoPlanta);

            ArrayList<EspecificacionTanque> catalogosTanquesOrdenadosPorCapacidadDescendiente = new ArrayList<>(emprendimientoPetrolifero.catalogoTanques());
            catalogosTanquesOrdenadosPorCapacidadDescendiente.sort((p1,p2) -> Float.compare(p2.capacidadTotal(), p1.capacidadTotal()));

            ProyectoConstruccionTanque nuevoProyectoTanqueAgua = new ProyectoConstruccionTanque(
                    "Agua1", 1, catalogosTanquesOrdenadosPorCapacidadDescendiente.get(0));
            nuevosProyectosTanquesAgua.add(nuevoProyectoTanqueAgua);
            nuevasConexionesPlantaTanqueAgua.add(new ConexionEntreEstructuras(
                    nuevoProyectoPlanta.nombrePlantaEnConstruccion(),
                    nuevoProyectoTanqueAgua.nombreTanqueEnConstruccion()));

            ProyectoConstruccionTanque nuevoProyectoTanqueGas = new ProyectoConstruccionTanque(
                    "Gas1", 1, catalogosTanquesOrdenadosPorCapacidadDescendiente.get(0));
            nuevosProyectosTanquesGas.add(nuevoProyectoTanqueGas);
            nuevasConexionesPlantaTanqueGas.add(new ConexionEntreEstructuras(
                    nuevoProyectoPlanta.nombrePlantaEnConstruccion(),
                    nuevoProyectoTanqueGas.nombreTanqueEnConstruccion()));

            hayNuevosProyectos = false;
        }
    }

    @Override
    public ArrayList<ProyectoConstruccionPlanta> nuevosProyectosConstruccionPlantas() {
        ArrayList<ProyectoConstruccionPlanta> resultado = nuevosProyectosPlantas;
        nuevosProyectosPlantas = new ArrayList<>();
        return resultado;
    }

    @Override
    public ArrayList<ProyectoConstruccionTanque> nuevosProyectosConstruccionTanquesDeAgua() {
        ArrayList<ProyectoConstruccionTanque> resultado = nuevosProyectosTanquesAgua;
        nuevosProyectosTanquesAgua = new ArrayList<>();
        return resultado;
    }

    @Override
    public ArrayList<ProyectoConstruccionTanque> nuevosProyectosConstruccionTanquesDeGas() {
        ArrayList<ProyectoConstruccionTanque> resultado = nuevosProyectosTanquesGas;
        nuevosProyectosTanquesGas = new ArrayList<>();
        return resultado;
    }

    @Override
    public ArrayList<ConexionEntreEstructuras> nuevasConexionesPlantaTanqueAgua() {
        ArrayList<ConexionEntreEstructuras> resultado = nuevasConexionesPlantaTanqueAgua;
        nuevasConexionesPlantaTanqueAgua = new ArrayList<>();
        return resultado;
    }

    @Override
    public ArrayList<ConexionEntreEstructuras> nuevasConexionesPlantaTanqueGas() {
        ArrayList<ConexionEntreEstructuras> resultado = nuevasConexionesPlantaTanqueGas;
        nuevasConexionesPlantaTanqueGas = new ArrayList<>();
        return resultado;
    }
}
