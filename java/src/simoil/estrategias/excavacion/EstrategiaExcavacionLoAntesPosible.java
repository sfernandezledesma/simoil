package simoil.estrategias.excavacion;

import simoil.*;

import java.util.ArrayList;

public class EstrategiaExcavacionLoAntesPosible extends EstrategiaExcavacion {

    @Override
    public ArrayList<Excavacion> crearExcavaciones(EmprendimientoPetrolifero emprendimientoPetrolifero, ArrayList<Parcela> parcelasDondeExcavar) {
        nuevasExcavaciones = new ArrayList<>();
        for (Parcela parcela : parcelasDondeExcavar) {
            nuevasExcavaciones.add(new Excavacion(parcela.nombre(), 1, parcela));
        }
        return nuevasExcavaciones;
    }

    @Override
    public int cuantosRigsAlquilarSimultaneamente(int maximaCantidadDeRigsSimultaneos) {
        return maximaCantidadDeRigsSimultaneos;
    }

    @Override
    public AlquilerRig elegirUnNuevoAlquilerDeRig(EmprendimientoPetrolifero emprendimientoPetrolifero, Excavacion excavacion) {
        ArrayList<AlquilerRig> catalogoAlquilerRigs = emprendimientoPetrolifero.catalogoAlquileresRigs();
        if (catalogoAlquilerRigs.size() == 0) {
            throw new RuntimeException("No hay Rigs para alquilar.");
        }
        AlquilerRig alquilerSeleccionado = catalogoAlquilerRigs.get(0);
        for (AlquilerRig alquiler : catalogoAlquilerRigs) {
            if (alquiler.rigAlquilado().poderExcavacionEnMetros() > alquilerSeleccionado.rigAlquilado().poderExcavacionEnMetros()) {
                alquilerSeleccionado = alquiler;
            }
        }
        return alquilerSeleccionado;
    }

    @Override
    public ArrayList<ConexionEntreEstructuras> nuevasConexionesDePozoAPlantas(EmprendimientoPetrolifero emprendimientoPetrolifero) {
        ArrayList<ConexionEntreEstructuras> nuevasConexiones = new ArrayList<>();
        // Conectamos todos los pozos en excavacion a todas las plantas que podamos
        for (Excavacion nuevaExcavacion : nuevasExcavaciones) {
            for (ProyectoConstruccionPlantaProcesadora proyectoConstruccionPlanta : emprendimientoPetrolifero.proyectosDePlantasProcesadoras()) {
                nuevasConexiones.add(new ConexionEntreEstructuras(
                        nuevaExcavacion.nombrePozoEnExcavacion(),
                        proyectoConstruccionPlanta.nombrePlantaEnConstruccion()));
            }
            for (PlantaProcesadora plantaProcesadora : emprendimientoPetrolifero.plantasProcesadorasHabilitadas()) {
                nuevasConexiones.add(new ConexionEntreEstructuras(
                        nuevaExcavacion.nombrePozoEnExcavacion(),
                        plantaProcesadora.nombre()));
            }
        }
        return nuevasConexiones;
    }
}
