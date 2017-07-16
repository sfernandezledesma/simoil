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

    public ArrayList<ProyectoConstruccionPlanta> nuevosProyectosConstruccionPlantas() {
        ArrayList<ProyectoConstruccionPlanta> resultado = nuevosProyectosPlantas;
        nuevosProyectosPlantas = new ArrayList<>();
        return resultado;
    }

    public ArrayList<ProyectoConstruccionTanque> nuevosProyectosConstruccionTanquesDeAgua() {
        ArrayList<ProyectoConstruccionTanque> resultado = nuevosProyectosTanquesAgua;
        nuevosProyectosTanquesAgua = new ArrayList<>();
        return resultado;
    }

    public ArrayList<ProyectoConstruccionTanque> nuevosProyectosConstruccionTanquesDeGas() {
        ArrayList<ProyectoConstruccionTanque> resultado = nuevosProyectosTanquesGas;
        nuevosProyectosTanquesGas = new ArrayList<>();
        return resultado;
    }

    public ArrayList<ConexionEntreEstructuras> nuevasConexionesPlantaTanqueAgua() {
        ArrayList<ConexionEntreEstructuras> resultado = nuevasConexionesPlantaTanqueAgua;
        nuevasConexionesPlantaTanqueAgua = new ArrayList<>();
        return resultado;
    }

    public ArrayList<ConexionEntreEstructuras> nuevasConexionesPlantaTanqueGas() {
        ArrayList<ConexionEntreEstructuras> resultado = nuevasConexionesPlantaTanqueGas;
        nuevasConexionesPlantaTanqueGas = new ArrayList<>();
        return resultado;
    }

}
