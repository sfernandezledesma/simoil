package simoil.estrategias.excavacion;

import simoil.AlquilerRig;
import simoil.EmprendimientoPetrolifero;
import simoil.Parcela;
import simoil.Excavacion;

import java.util.ArrayList;


public abstract class EstrategiaExcavacion {

    public abstract ArrayList<Excavacion> crearExcavaciones(EmprendimientoPetrolifero emprendimientoPetrolifero, ArrayList<Parcela> parcelasDondeExcavar);

    public abstract int cuantosRigsAlquilarSimultaneamente(int maximaCantidadDeRigsSimultaneos);

    public abstract AlquilerRig elegirUnNuevoAlquilerDeRig(ArrayList<AlquilerRig> catalogoAlquilerRigs, Parcela parcelaDondeExcavar);
}
