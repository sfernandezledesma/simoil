package simoil.estrategias.excavacion;

import simoil.*;

import java.util.ArrayList;


public class EstrategiaExcavacionLoAntesPosible extends EstrategiaExcavacion {

    @Override
    public ArrayList<Excavacion> crearExcavaciones(EmprendimientoPetrolifero emprendimientoPetrolifero, ArrayList<Parcela> parcelasDondeExcavar) {
        ArrayList<Excavacion> excavaciones = new ArrayList<>();
        ArrayList<ProyectoConstruccionPlanta> proyectosDePlantasProcesadoras = new ArrayList(emprendimientoPetrolifero.proyectosDePlantasProcesadoras());
        proyectosDePlantasProcesadoras.sort((p1,p2) -> Float.compare(p1.diaComienzoConstruccion() + p1.tiempoConstruccionTotalEnDias(), p2.diaComienzoConstruccion() + p2.tiempoConstruccionTotalEnDias()));
        int i = 0, n = proyectosDePlantasProcesadoras.size();
        for (Parcela parcela : parcelasDondeExcavar) {
            excavaciones.add(new Excavacion(0, parcela, proyectosDePlantasProcesadoras.get(i).plantaEnConstruccion()));
            i = i + 1 % n;
        }
        return excavaciones;
    }

    @Override
    public int cuantosRigsAlquilarSimultaneamente(int maximaCantidadDeRigsSimultaneos) {
        return maximaCantidadDeRigsSimultaneos;
    }

    @Override
    public AlquilerRig elegirUnNuevoAlquilerDeRig(ArrayList<AlquilerRig> catalogoAlquilerRigs, Parcela parcelaDondeExcavar) {
        AlquilerRig alquilerSeleccionado = catalogoAlquilerRigs.get(0);
        for (AlquilerRig alquiler : catalogoAlquilerRigs) {
            if (alquiler.rig().poderExcavacion() > alquilerSeleccionado.rig().poderExcavacion()) {
                alquilerSeleccionado = alquiler;
            }
        }
        return new AlquilerRig(alquilerSeleccionado);
    }

}
