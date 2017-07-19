package simoil.estrategias.construccion;

import simoil.*;
import java.util.ArrayList;

public abstract class EstrategiaConstruccion {
    protected ArrayList<ProyectoConstruccionPlantaProcesadora> nuevosProyectosPlantas = new ArrayList<>();
    protected ArrayList<ProyectoConstruccionTanque> nuevosProyectosTanquesAgua = new ArrayList<>();
    protected ArrayList<ProyectoConstruccionTanque> nuevosProyectosTanquesGas = new ArrayList<>();
    protected ArrayList<ConexionEntreEstructuras> nuevasConexionesPlantaTanqueAgua = new ArrayList<>();
    protected ArrayList<ConexionEntreEstructuras> nuevasConexionesPlantaTanqueGas = new ArrayList<>();

    public abstract void crearProyectos(EmprendimientoPetrolifero emprendimientoPetrolifero);

    public ArrayList<ProyectoConstruccionPlantaProcesadora> nuevosProyectosConstruccionPlantas() {
        return nuevosProyectosPlantas;
    }

    public ArrayList<ProyectoConstruccionTanque> nuevosProyectosConstruccionTanquesDeAgua() {
        return nuevosProyectosTanquesAgua;
    }

    public ArrayList<ProyectoConstruccionTanque> nuevosProyectosConstruccionTanquesDeGas() {
        return nuevosProyectosTanquesGas;
    }

    public ArrayList<ConexionEntreEstructuras> nuevasConexionesPlantaTanqueAgua() {
        return nuevasConexionesPlantaTanqueAgua;
    }

    public ArrayList<ConexionEntreEstructuras> nuevasConexionesPlantaTanqueGas() {
        return nuevasConexionesPlantaTanqueGas;
    }

}
