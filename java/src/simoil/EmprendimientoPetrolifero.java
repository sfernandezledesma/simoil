package simoil;

import java.util.ArrayList;


public class EmprendimientoPetrolifero {
    private Yacimiento yacimiento;
    private EquipoDeIngenieria equipoDeIngenieria;
    private ArrayList<PlantaProcesadora> plantasProcesadoras;
    private ArrayList<Tanque> tanquesDeAgua;
    private ArrayList<Tanque> tanquesDeGas;
    private ArrayList<AlquilerRig> alquileresDeRigs;

    public void agregarPlantaProcesadora(PlantaProcesadora plantaProcesadora) {
        this.plantasProcesadoras.add(plantaProcesadora);
    }

    public void agregarTanqueDeAgua(Tanque tanqueDeAgua) {
        this.tanquesDeAgua.add(tanqueDeAgua);
    }

    public void agregarTanqueDeGas(Tanque tanqueDeGas) {
        this.tanquesDeGas.add(tanqueDeGas);
    }

    public void agregarAlquilerDeRig(AlquilerRig alquilerDeRig) {
        this.alquileresDeRigs.add(alquilerDeRig);
    }

    public void definirProyectosDeTanquesDeAgua(ArrayList<ProyectoConstruccionPlanta> proyectosDeTanquesDeAgua) {
        this.proyectosDeTanquesDeAgua = proyectosDeTanquesDeAgua;
    }

    public void definirProyectosDeTanquesDeGas(ArrayList<ProyectoConstruccionPlanta> proyectosDeTanquesDeGas) {
        this.proyectosDeTanquesDeGas = proyectosDeTanquesDeGas;
    }

    public void definirProyectosDePlantasProcesadoras(ArrayList<ProyectoConstruccionPlanta> proyectosDePlantasProcesadoras) {
        this.proyectosDePlantasProcesadoras = proyectosDePlantasProcesadoras;
    }

    public void definirPlanesDeExcavacion(ArrayList<PlanDeExcavacion> planesDeExcavacion) {
        this.planesDeExcavacion = planesDeExcavacion;
    }

    private ArrayList<ProyectoConstruccionPlanta> proyectosDeTanquesDeAgua;
    private ArrayList<ProyectoConstruccionPlanta> proyectosDeTanquesDeGas;
    private ArrayList<ProyectoConstruccionPlanta> proyectosDePlantasProcesadoras;
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

    public ArrayList<ProyectoConstruccionPlanta> proyectosDeTanquesDeAgua() {
        return proyectosDeTanquesDeAgua;
    }

    public ArrayList<ProyectoConstruccionPlanta> proyectosDeTanquesDeGas() {
        return proyectosDeTanquesDeGas;
    }

    public ArrayList<ProyectoConstruccionPlanta> proyectosDePlantasProcesadoras() {
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
