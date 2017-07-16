package simoil.estrategias.construccion;

import simoil.*;
import java.util.ArrayList;

public abstract class EstrategiaConstruccion {
    protected ArrayList<ProyectoConstruccionPlanta> nuevosProyectosPlantas = new ArrayList<>();
    protected ArrayList<ProyectoConstruccionTanque> nuevosProyectosTanquesAgua = new ArrayList<>();
    protected ArrayList<ProyectoConstruccionTanque> nuevosProyectosTanquesGas = new ArrayList<>();
    protected ArrayList<ConexionEntreEstructuras> nuevasConexionesPlantaTanqueAgua = new ArrayList<>();
    protected ArrayList<ConexionEntreEstructuras> nuevasConexionesPlantaTanqueGas = new ArrayList<>();

    public abstract void crearProyectos(EmprendimientoPetrolifero emprendimientoPetrolifero);

    public abstract ArrayList<ProyectoConstruccionPlanta> nuevosProyectosConstruccionPlantas();

    public abstract ArrayList<ProyectoConstruccionTanque> nuevosProyectosConstruccionTanquesDeAgua();

    public abstract ArrayList<ProyectoConstruccionTanque> nuevosProyectosConstruccionTanquesDeGas();

    public abstract ArrayList<ConexionEntreEstructuras> nuevasConexionesPlantaTanqueAgua();

    public abstract ArrayList<ConexionEntreEstructuras> nuevasConexionesPlantaTanqueGas();

}
