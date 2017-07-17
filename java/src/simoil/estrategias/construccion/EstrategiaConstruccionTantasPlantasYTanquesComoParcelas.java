package simoil.estrategias.construccion;

import simoil.*;

import java.util.ArrayList;

public class EstrategiaConstruccionTantasPlantasYTanquesComoParcelas extends EstrategiaConstruccion {
    private boolean seCrearonLosProyectos = false;
    @Override
    public void crearProyectos(EmprendimientoPetrolifero emprendimientoPetrolifero) {
        nuevosProyectosPlantas = new ArrayList<>();
        nuevosProyectosTanquesAgua = new ArrayList<>();
        nuevosProyectosTanquesGas = new ArrayList<>();
        nuevasConexionesPlantaTanqueAgua = new ArrayList<>();
        nuevasConexionesPlantaTanqueGas = new ArrayList<>();

        if (!seCrearonLosProyectos) {
            ArrayList<EspecificacionPlantaProcesadora> catalogoPlantasOrdenadosPorCapacidadProcesamientoDescendiente = new ArrayList<>(emprendimientoPetrolifero.catalogoPlantasProcesadoras());
            catalogoPlantasOrdenadosPorCapacidadProcesamientoDescendiente.sort((p1,p2) -> Double.compare(p2.capacidadDiariaProcesamientoEnLitros(), p1.capacidadDiariaProcesamientoEnLitros()));
            EspecificacionPlantaProcesadora especificacionDeLaMejorPlanta = catalogoPlantasOrdenadosPorCapacidadProcesamientoDescendiente.get(0);

            ArrayList<EspecificacionTanque> catalogosTanquesOrdenadosPorCapacidadDescendiente = new ArrayList<>(emprendimientoPetrolifero.catalogoTanques());
            catalogosTanquesOrdenadosPorCapacidadDescendiente.sort((p1,p2) -> Double.compare(p2.capacidadAlmacenamientoEnLitros(), p1.capacidadAlmacenamientoEnLitros()));
            EspecificacionTanque especificacionDelMejorTanque = catalogosTanquesOrdenadosPorCapacidadDescendiente.get(0);

            for (Parcela parcela : emprendimientoPetrolifero.yacimiento().parcelas()) {
                ProyectoConstruccionPlantaProcesadora nuevoProyectoPlanta = new ProyectoConstruccionPlantaProcesadora(
                        parcela.nombre(), 1, especificacionDeLaMejorPlanta);
                nuevosProyectosPlantas.add(nuevoProyectoPlanta);

                ProyectoConstruccionTanque nuevoProyectoTanqueAgua = new ProyectoConstruccionTanque(
                        "A" + parcela.nombre(), 1, especificacionDelMejorTanque);
                nuevosProyectosTanquesAgua.add(nuevoProyectoTanqueAgua);

                ProyectoConstruccionTanque nuevoProyectoTanqueGas = new ProyectoConstruccionTanque(
                        "G" + parcela.nombre(), 1, especificacionDelMejorTanque);
                nuevosProyectosTanquesGas.add(nuevoProyectoTanqueGas);
            }

            for (ProyectoConstruccionPlantaProcesadora nuevoProyectoPlanta : nuevosProyectosPlantas) {
                for (ProyectoConstruccionTanque nuevoProyectoTanqueAgua : nuevosProyectosTanquesAgua) {
                    nuevasConexionesPlantaTanqueAgua.add(new ConexionEntreEstructuras(
                            nuevoProyectoPlanta.nombrePlantaEnConstruccion(),
                            nuevoProyectoTanqueAgua.nombreTanqueEnConstruccion()));
                }
                for (ProyectoConstruccionTanque nuevoProyectoTanqueGas : nuevosProyectosTanquesGas) {
                    nuevasConexionesPlantaTanqueGas.add(new ConexionEntreEstructuras(
                            nuevoProyectoPlanta.nombrePlantaEnConstruccion(),
                            nuevoProyectoTanqueGas.nombreTanqueEnConstruccion()));
                }
            }

            seCrearonLosProyectos = true;
        }
    }
}
