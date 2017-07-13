package simoil.estrategias.construccion;


import simoil.ProyectoConstruccionPlanta;
import simoil.ProyectoConstruccionTanque;

import java.util.ArrayList;

public abstract class EstrategiaConstruccion {

    protected ArrayList<ProyectoConstruccionPlanta> catalogoPlantas;
    protected ArrayList<ProyectoConstruccionTanque> catalogoTanques;
    protected ArrayList<ProyectoConstruccionPlanta> proyectosConstruccionPlantas;
    protected ArrayList<ProyectoConstruccionTanque> proyectosConstruccionTanques;

    public EstrategiaConstruccion(ArrayList<ProyectoConstruccionPlanta> catalogoPlantas,
                                  ArrayList<ProyectoConstruccionTanque> catalogoTanques) {
        this.catalogoPlantas = catalogoPlantas;
        this.catalogoTanques = catalogoTanques;
        this.proyectosConstruccionPlantas = new ArrayList<ProyectoConstruccionPlanta>();
        this.proyectosConstruccionTanques = new ArrayList<ProyectoConstruccionTanque>();
    }

    public abstract void crearProyectosDeConstruccion();

    public ArrayList<ProyectoConstruccionPlanta> proyectosConstruccionPlantas(){
        return proyectosConstruccionPlantas;
    }

    public ArrayList<ProyectoConstruccionTanque> proyectosConstruccionTanques(){
        return proyectosConstruccionTanques;
    }

}
