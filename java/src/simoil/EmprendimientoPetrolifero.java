package simoil;

import java.util.ArrayList;


public class EmprendimientoPetrolifero {
    private Yacimiento yacimiento;
    private EquipoDeIngenieria equipoDeIngenieria;
    private ArrayList<PlantaProcesadora> plantasProcesadoras;
    private ArrayList<Tanque> tanquesDeAgua;
    private ArrayList<Tanque> tanquesDeGas;
    private ArrayList<AlquilerRig> alquileresDeRigs;
    private ArrayList<ProyectoConstruccionTanque> proyectosDeTanquesDeAgua;
    private ArrayList<ProyectoConstruccionTanque> proyectosDeTanquesDeGas;
    private ArrayList<ProyectoConstruccionPlanta> proyectosDePlantasProcesadoras;
    private ArrayList<Excavacion> excavaciones;
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
        this.excavaciones = new ArrayList<>();
        this.ingresos = 0;
        this.gastos = 0;
    }

    public void agregarPlantaProcesadora(PlantaProcesadora plantaProcesadora) {
        if (plantasProcesadoras.contains(plantaProcesadora))
            throw new RuntimeException("Se intento agregar una planta que ya existia.");
        this.plantasProcesadoras.add(plantaProcesadora);
    }

    public void agregarTanqueDeAgua(Tanque tanqueDeAgua) {
        if (tanquesDeAgua.contains(tanqueDeAgua))
            throw new RuntimeException("Se intento agregar un tanqueEnConstruccion de agua que ya existia.");
        this.tanquesDeAgua.add(tanqueDeAgua);
    }

    public void agregarTanqueDeGas(Tanque tanqueDeGas) {
        if (tanquesDeGas.contains(tanqueDeGas))
            throw new RuntimeException("Se intento agregar un tanqueEnConstruccion de gas que ya existia.");
        this.tanquesDeGas.add(tanqueDeGas);
    }

    public void agregarAlquilerDeRig(AlquilerRig alquilerDeRig) {
        if (alquileresDeRigs.contains(alquilerDeRig))
            throw new RuntimeException("Se intento agregar un alquiler de Rig que ya existia.");
        this.alquileresDeRigs.add(alquilerDeRig);
    }

    public void definirProyectosDeTanquesDeAgua(ArrayList<ProyectoConstruccionTanque> proyectosDeTanquesDeAgua) {
        this.proyectosDeTanquesDeAgua = proyectosDeTanquesDeAgua;
    }

    public void definirProyectosDeTanquesDeGas(ArrayList<ProyectoConstruccionTanque> proyectosDeTanquesDeGas) {
        this.proyectosDeTanquesDeGas = proyectosDeTanquesDeGas;
    }

    public void definirProyectosDePlantasProcesadoras(ArrayList<ProyectoConstruccionPlanta> proyectosDePlantasProcesadoras) {
        this.proyectosDePlantasProcesadoras = proyectosDePlantasProcesadoras;
    }

    public void agregarExcavacion(Excavacion nuevaExcavacion) {
        if (excavaciones.contains(nuevaExcavacion))
            throw new RuntimeException("Se intento agregar una excavacion ya existente.");
        this.excavaciones.add(nuevaExcavacion);
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

    public ArrayList<ProyectoConstruccionTanque> proyectosDeTanquesDeAgua() {
        return proyectosDeTanquesDeAgua;
    }

    public ArrayList<ProyectoConstruccionTanque> proyectosDeTanquesDeGas() {
        return proyectosDeTanquesDeGas;
    }

    public ArrayList<ProyectoConstruccionPlanta> proyectosDePlantasProcesadoras() {
        return proyectosDePlantasProcesadoras;
    }

    public ArrayList<Excavacion> excavaciones() {
        return excavaciones;
    }

    public float ingresos() {
        return ingresos;
    }

    public float gastos() {
        return gastos;
    }
}
