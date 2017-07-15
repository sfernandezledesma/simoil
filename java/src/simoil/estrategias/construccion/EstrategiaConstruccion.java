package simoil.estrategias.construccion;


import simoil.*;

import java.util.ArrayList;

public abstract class EstrategiaConstruccion {

    public abstract ArrayList<ProyectoConstruccionPlanta> nuevosProyectosConstruccionPlantas(EmprendimientoPetrolifero emprendimientoPetrolifero);

    public abstract ArrayList<ProyectoConstruccionTanque> nuevosProyectosConstruccionTanquesDeAgua(EmprendimientoPetrolifero emprendimientoPetrolifero);

    public abstract ArrayList<ProyectoConstruccionTanque> nuevosProyectosConstruccionTanquesDeGas(EmprendimientoPetrolifero emprendimientoPetrolifero);

}
