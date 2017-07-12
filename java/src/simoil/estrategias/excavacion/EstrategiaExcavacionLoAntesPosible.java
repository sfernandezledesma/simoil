package simoil.estrategias.excavacion;

import simoil.AlquilerRig;
import simoil.EmprendimientoPetrolifero;
import simoil.Parcela;
import simoil.PlanDeExcavacion;

import java.util.ArrayList;

/**
 * Created by Sebastian on 11/07/2017.
 */
public class EstrategiaExcavacionLoAntesPosible extends EstrategiaExcavacion {

    @Override
    public ArrayList<PlanDeExcavacion> crearPlanesDeExcavacion(ArrayList<Parcela> parcelasDondeExcavar) {
        ArrayList<PlanDeExcavacion> planes = new ArrayList<>();
        for (Parcela parcela : parcelasDondeExcavar) {
            planes.add(new PlanDeExcavacion(0, parcela));
        }
        return planes;
    }

    @Override
    public int cuantosRigsAlquilarSimultaneamente(int maximaCantidadDeRigsSimultaneos) {
        return maximaCantidadDeRigsSimultaneos;
    }

    @Override
    public AlquilerRig queRigAlquilar(ArrayList<AlquilerRig> catalogoAlquilerRigs, Parcela parcelaDondeExcavar) {
        return null;
    }

}
