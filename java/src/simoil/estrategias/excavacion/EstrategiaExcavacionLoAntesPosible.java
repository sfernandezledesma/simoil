package simoil.estrategias.excavacion;

import simoil.*;
import java.util.ArrayList;

public class EstrategiaExcavacionLoAntesPosible extends EstrategiaExcavacion {
    private boolean hayNuevasExcavaciones = true;
    private boolean hayNuevasConexiones = true;
    private ArrayList<Excavacion> nuevasExcavaciones;

    @Override
    public ArrayList<Excavacion> crearExcavaciones(EmprendimientoPetrolifero emprendimientoPetrolifero, ArrayList<Parcela> parcelasDondeExcavar) {
        nuevasExcavaciones = new ArrayList<>();
        if (hayNuevasExcavaciones) {
            for (Parcela parcela : parcelasDondeExcavar) {
                nuevasExcavaciones.add(new Excavacion(parcela.nombre(),1, parcela));
            }
            hayNuevasExcavaciones = false;
            parcelasDondeExcavar.clear();
        }
        return nuevasExcavaciones;
    }

    @Override
    public int cuantosRigsAlquilarSimultaneamente(int maximaCantidadDeRigsSimultaneos) {
        return maximaCantidadDeRigsSimultaneos;
    }

    @Override
    public AlquilerRig elegirUnNuevoAlquilerDeRig(ArrayList<AlquilerRig> catalogoAlquilerRigs, Excavacion excavacion) {
        if (catalogoAlquilerRigs.size() == 0) {
            throw new RuntimeException("No hay Rigs para alquilar.");
        }
        AlquilerRig alquilerSeleccionado = catalogoAlquilerRigs.get(0);
        for (AlquilerRig alquiler : catalogoAlquilerRigs) {
            if (alquiler.rig().poderExcavacion() > alquilerSeleccionado.rig().poderExcavacion()) {
                alquilerSeleccionado = alquiler;
            }
        }
        catalogoAlquilerRigs.remove(alquilerSeleccionado);
        return alquilerSeleccionado;
    }

    @Override
    public ArrayList<ConexionEntreEstructuras> nuevasConexionesDePozoAPlantas(EmprendimientoPetrolifero emprendimientoPetrolifero) {
        ArrayList<ConexionEntreEstructuras> nuevasConexiones = new ArrayList<>();
        if (hayNuevasConexiones) {
            ArrayList<ProyectoConstruccionPlanta> proyectosDePlantasProcesadorasOrdenados = new ArrayList<>(emprendimientoPetrolifero.proyectosDePlantasProcesadoras());
            proyectosDePlantasProcesadorasOrdenados.sort((p1,p2) -> Float.compare(p1.diaComienzoConstruccion() + p1.especificacionPlantaProcesadora().cantidadDiasDeConstruccion(), p2.diaComienzoConstruccion() + p2.especificacionPlantaProcesadora().cantidadDiasDeConstruccion()));
            for (Excavacion nuevaExcavacion : nuevasExcavaciones) {
                for (ProyectoConstruccionPlanta proyectoConstruccionPlanta : proyectosDePlantasProcesadorasOrdenados) {
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
            hayNuevasConexiones = false;
        }
        return nuevasConexiones;
    }
}
