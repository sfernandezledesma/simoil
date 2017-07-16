package simoil.estrategias.excavacion;

import simoil.*;

import java.util.ArrayList;


public abstract class EstrategiaExcavacion {
    protected ArrayList<Excavacion> nuevasExcavaciones = new ArrayList<>();

    public abstract ArrayList<Excavacion> crearExcavaciones(EmprendimientoPetrolifero emprendimientoPetrolifero, ArrayList<Parcela> parcelasDondeExcavar);

    public abstract int cuantosRigsAlquilarSimultaneamente(int maximaCantidadDeRigsSimultaneos);

    public abstract AlquilerRig elegirUnNuevoAlquilerDeRig(EmprendimientoPetrolifero emprendimientoPetrolifero, Excavacion excavacion);

    public abstract ArrayList<ConexionEntreEstructuras> nuevasConexionesDePozoAPlantas(EmprendimientoPetrolifero emprendimientoPetrolifero);
}
