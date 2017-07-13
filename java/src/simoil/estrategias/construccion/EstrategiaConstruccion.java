package simoil.estrategias.construccion;


import simoil.ProyectoConstruccionPlanta;
import simoil.ProyectoConstruccionTanque;

import java.util.ArrayList;

public abstract class EstrategiaConstruccion {

    protected ArrayList<ProyectoConstruccionPlanta> proyectosConstruccionPlantas;
    protected ArrayList<ProyectoConstruccionTanque> proyectosConstruccionTanquesDeAgua;
    protected ArrayList<ProyectoConstruccionTanque> proyectosConstruccionTanquesDeGas;

    public EstrategiaConstruccion() {
        this.proyectosConstruccionPlantas = new ArrayList<ProyectoConstruccionPlanta>();
        this.proyectosConstruccionTanquesDeAgua = new ArrayList<ProyectoConstruccionTanque>();
        this.proyectosConstruccionTanquesDeGas = new ArrayList<ProyectoConstruccionTanque>();
    }

    public abstract void crearProyectosDeConstruccion(ArrayList<ProyectoConstruccionPlanta> catalogoPlantas,
                                                      ArrayList<ProyectoConstruccionTanque> catalogoTanques);

    public ArrayList<ProyectoConstruccionPlanta> proyectosConstruccionPlantas(){
        return proyectosConstruccionPlantas;
    }

    public ArrayList<ProyectoConstruccionTanque> proyectosConstruccionTanquesDeAgua(){
        return proyectosConstruccionTanquesDeAgua;
    }

    public ArrayList<ProyectoConstruccionTanque> proyectosConstruccionTanquesDeGas(){
        return proyectosConstruccionTanquesDeGas;
    }

}
