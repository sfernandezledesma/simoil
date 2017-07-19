package simoil.estrategias.construccion;

import simoil.*;

import java.util.ArrayList;

public class EstrategiaConstruccionPlantaUnica extends EstrategiaConstruccion {
    private boolean hayNuevosProyectos = true;

    @Override
    public void crearProyectos(EmprendimientoPetrolifero emprendimientoPetrolifero) {
        nuevosProyectosPlantas.clear();
        nuevosProyectosTanquesAgua.clear();
        nuevosProyectosTanquesGas.clear();
        nuevasConexionesPlantaTanqueAgua.clear();
        nuevasConexionesPlantaTanqueGas.clear();
        if (hayNuevosProyectos) {
            ArrayList<EspecificacionPlantaProcesadora> catalogoPlantas = emprendimientoPetrolifero.catalogoPlantasProcesadoras();
            ArrayList<EspecificacionTanque> catalogosTanques = emprendimientoPetrolifero.catalogoTanques();

            EspecificacionPlantaProcesadora especificacionPlantaElegida = catalogoPlantas.get(0);

            ProyectoConstruccionPlantaProcesadora nuevoProyectoPlanta = new ProyectoConstruccionPlantaProcesadora(
                    "1", 1, especificacionPlantaElegida);
            nuevosProyectosPlantas.add(nuevoProyectoPlanta);


            EspecificacionTanque especificacionTanqueElegida = catalogosTanques.get(0);

            ProyectoConstruccionTanque nuevoProyectoTanqueAgua = new ProyectoConstruccionTanque(
                    "A1", 1, especificacionTanqueElegida);
            nuevosProyectosTanquesAgua.add(nuevoProyectoTanqueAgua);
            nuevasConexionesPlantaTanqueAgua.add(new ConexionEntreEstructuras(
                    nuevoProyectoPlanta.nombrePlantaEnConstruccion(),
                    nuevoProyectoTanqueAgua.nombreTanqueEnConstruccion()));

            ProyectoConstruccionTanque nuevoProyectoTanqueGas = new ProyectoConstruccionTanque(
                    "G1", 1, especificacionTanqueElegida);
            nuevosProyectosTanquesGas.add(nuevoProyectoTanqueGas);
            nuevasConexionesPlantaTanqueGas.add(new ConexionEntreEstructuras(
                    nuevoProyectoPlanta.nombrePlantaEnConstruccion(),
                    nuevoProyectoTanqueGas.nombreTanqueEnConstruccion()));

            hayNuevosProyectos = false;
        }
    }
}
