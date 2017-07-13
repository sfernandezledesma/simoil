package simoil.estrategias.construccion;

import simoil.PlantaProcesadora;
import simoil.ProyectoConstruccionPlanta;
import simoil.ProyectoConstruccionTanque;

import java.util.ArrayList;

public class EstrategiaConstruccionPlantaUnica extends EstrategiaConstruccion {

    public EstrategiaConstruccionPlantaUnica(ArrayList<ProyectoConstruccionPlanta> catalogoPlantas, ArrayList<ProyectoConstruccionTanque> catalogoTanques) {
        super(catalogoPlantas, catalogoTanques);
    }

    @Override
    public void crearProyectosDeConstruccion() {
        ProyectoConstruccionPlanta nuevoProyectoPlanta = new ProyectoConstruccionPlanta(catalogoPlantas.get(0),1);
        this.proyectosConstruccionPlantas().add(nuevoProyectoPlanta);
        PlantaProcesadora planta = nuevoProyectoPlanta.plantaEnConstruccion();

        ProyectoConstruccionTanque nuevoProyectoTanqueAgua = new ProyectoConstruccionTanque(catalogoTanques.get(0), 1);
        this.proyectosConstruccionTanquesDeAgua().add(nuevoProyectoTanqueAgua);
        planta.conectarTanqueDeAgua(nuevoProyectoTanqueAgua.tanqueEnConstruccion());

        ProyectoConstruccionTanque nuevoProyectoTanqueGas = new ProyectoConstruccionTanque(catalogoTanques.get(0), 1);
        this.proyectosConstruccionTanquesDeGas().add(nuevoProyectoTanqueGas);
        planta.conectarTanqueDeGas(nuevoProyectoTanqueGas.tanqueEnConstruccion());
    }
}
