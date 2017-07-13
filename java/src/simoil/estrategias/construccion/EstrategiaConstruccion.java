package simoil.estrategias.construccion;


import simoil.ProyectoConstruccionPlanta;
import simoil.ProyectoConstruccionTanque;

import java.util.ArrayList;

public abstract class EstrategiaConstruccion {

    protected ArrayList<ProyectoConstruccionPlanta> catalogoPlantas;
    protected ArrayList<ProyectoConstruccionTanque> catalogoTanques;
    protected ArrayList<ProyectoConstruccionPlanta> proyectosConstruccionPlantas;
    protected ArrayList<ProyectoConstruccionTanque> proyectosConstruccionTanquesDeAgua;
    protected ArrayList<ProyectoConstruccionTanque> proyectosConstruccionTanquesDeGas;

    public EstrategiaConstruccion(ArrayList<ProyectoConstruccionPlanta> catalogoPlantas,
                                  ArrayList<ProyectoConstruccionTanque> catalogoTanques) {
        this.catalogoPlantas = catalogoPlantas;
        this.catalogoTanques = catalogoTanques;
        this.proyectosConstruccionPlantas = new ArrayList<ProyectoConstruccionPlanta>();
        this.proyectosConstruccionTanquesDeAgua = new ArrayList<ProyectoConstruccionTanque>();
        this.proyectosConstruccionTanquesDeGas = new ArrayList<ProyectoConstruccionTanque>();
    }

    public abstract void crearProyectosDeConstruccion();

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
