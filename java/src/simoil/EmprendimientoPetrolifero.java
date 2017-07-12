package simoil;

import java.util.ArrayList;

/**
 * Created by Sebastian on 11/07/2017.
 */
public class EmprendimientoPetrolifero {
    private Yacimiento yacimiento;
    private EquipoDeIngenieria equipoDeIngenieria;
    private ArrayList<PlantaProcesadora> plantasProcesadoras;
    private ArrayList<Tanque> tanquesDeAgua;
    private ArrayList<Tanque> tanquesDeGas;
    private ArrayList<AlquilerRig> alquileresDeRigs;
    private ArrayList<ProyectoConstruccion> proyectosDeTanquesDeAgua;
    private ArrayList<ProyectoConstruccion> proyectosDeTanquesDeGas;
    private ArrayList<ProyectoConstruccion> proyectosDePlantasProcesadoras;
    private ArrayList<PlanDeExcavacion> planesDeExcavacion;
    private float ingresos;
    private float gastos;

    public EmprendimientoPetrolifero(Yacimiento yacimiento, EquipoDeIngenieria equipoDeIngenieria) {
        this.yacimiento = yacimiento;
        this.equipoDeIngenieria = equipoDeIngenieria;
        this.plantasProcesadoras = new ArrayList<>();
        this.tanquesDeAgua = new ArrayList<>();
        this.tanquesDeGas = new ArrayList<>();
        this.alquileresDeRigs = new ArrayList<>();
        this.proyectosDeTanquesDeAgua = new ArrayList<>();
        this.proyectosDeTanquesDeGas = new ArrayList<>();
        this.proyectosDePlantasProcesadoras = new ArrayList<>();
        this.planesDeExcavacion = new ArrayList<>();
        this.ingresos = 0;
        this.gastos = 0;
    }

    public Yacimiento yacimiento() {
        return yacimiento;
    }

    public EquipoDeIngenieria equipoDeIngenieria() {
        return equipoDeIngenieria;
    }

    public ArrayList<PlantaProcesadora> plantasProcesadoras() {
        return plantasProcesadoras;
    }

    public ArrayList<Tanque> tanquesDeAgua() {
        return tanquesDeAgua;
    }

    public ArrayList<Tanque> tanquesDeGas() {
        return tanquesDeGas;
    }

    public ArrayList<AlquilerRig> alquileresDeRigs() {
        return alquileresDeRigs;
    }

    public ArrayList<ProyectoConstruccion> proyectosDeTanquesDeAgua() {
        return proyectosDeTanquesDeAgua;
    }

    public ArrayList<ProyectoConstruccion> proyectosDeTanquesDeGas() {
        return proyectosDeTanquesDeGas;
    }

    public ArrayList<ProyectoConstruccion> proyectosDePlantasProcesadoras() {
        return proyectosDePlantasProcesadoras;
    }

    public ArrayList<PlanDeExcavacion> planesDeExcavacion() {
        return planesDeExcavacion;
    }

    public float ingresos() {
        return ingresos;
    }

    public float gastos() {
        return gastos;
    }
}
