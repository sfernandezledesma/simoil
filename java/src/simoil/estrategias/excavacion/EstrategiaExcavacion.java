package simoil.estrategias.excavacion;

import simoil.AlquilerRig;
import simoil.EmprendimientoPetrolifero;
import simoil.Parcela;
import simoil.PlanDeExcavacion;

import java.util.ArrayList;


public abstract class EstrategiaExcavacion {

    public abstract ArrayList<PlanDeExcavacion> crearPlanesDeExcavacion(ArrayList<Parcela> parcelasDondeExcavar);

    public abstract int cuantosRigsAlquilarSimultaneamente(int maximaCantidadDeRigsSimultaneos);

    public abstract AlquilerRig dameNuevoAlquilerDeRig(ArrayList<AlquilerRig> catalogoAlquilerRigs, Parcela parcelaDondeExcavar);
}
