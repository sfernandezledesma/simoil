package simoil.estrategias.construccion;

import simoil.PlantaProcesadora;
import simoil.ProyectoConstruccionPlanta;
import simoil.ProyectoConstruccionTanque;

import java.util.ArrayList;

public class EstrategiaConstruccionPlantaUnica extends EstrategiaConstruccion {

    @Override
    public void crearProyectosDeConstruccion(ArrayList<ProyectoConstruccionPlanta> catalogoPlantas,
                                             ArrayList<ProyectoConstruccionTanque> catalogoTanques) {

        ArrayList<ProyectoConstruccionPlanta> proyectosPlantasOrdenadosPorCapacidadProcesamientoDescendiente = new ArrayList<>(catalogoPlantas);
        proyectosPlantasOrdenadosPorCapacidadProcesamientoDescendiente.sort((p1,p2) -> Float.compare(p2.plantaEnConstruccion().capacidadProcesamientoTotal(), p1.plantaEnConstruccion().capacidadProcesamientoTotal()));

        ProyectoConstruccionPlanta nuevoProyectoPlanta = new ProyectoConstruccionPlanta(proyectosPlantasOrdenadosPorCapacidadProcesamientoDescendiente.get(0),1);
        this.proyectosConstruccionPlantas().add(nuevoProyectoPlanta);
        PlantaProcesadora planta = nuevoProyectoPlanta.plantaEnConstruccion();

        ArrayList<ProyectoConstruccionTanque> proyectosTanquesOrdenadosPorCapacidadDescendiente = new ArrayList<>(catalogoTanques);
        proyectosTanquesOrdenadosPorCapacidadDescendiente.sort((p1,p2) -> Float.compare(p2.tanqueEnConstruccion().capacidadTotal(), p1.tanqueEnConstruccion().capacidadTotal()));

        ProyectoConstruccionTanque nuevoProyectoTanqueAgua = new ProyectoConstruccionTanque(proyectosTanquesOrdenadosPorCapacidadDescendiente.get(0), 1);
        this.proyectosConstruccionTanquesDeAgua().add(nuevoProyectoTanqueAgua);
        planta.conectarTanqueDeAgua(nuevoProyectoTanqueAgua.tanqueEnConstruccion());

        ProyectoConstruccionTanque nuevoProyectoTanqueGas = new ProyectoConstruccionTanque(proyectosTanquesOrdenadosPorCapacidadDescendiente.get(0), 1);
        this.proyectosConstruccionTanquesDeGas().add(nuevoProyectoTanqueGas);
        planta.conectarTanqueDeGas(nuevoProyectoTanqueGas.tanqueEnConstruccion());
    }

}
