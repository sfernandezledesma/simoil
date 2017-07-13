package simoil;

import java.util.ArrayList;


public class EmprendimientoPetrolifero {
    private Contabilidad contabilidad;
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


    public EmprendimientoPetrolifero(Yacimiento yacimiento, EquipoDeIngenieria equipoDeIngenieria) {
        this.contabilidad = new Contabilidad();
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

    public void agregarProyectoDeTanqueDeAgua(ProyectoConstruccionTanque proyectoDeTanqueDeAgua) {
        if (proyectosDeTanquesDeAgua.contains(proyectoDeTanqueDeAgua) || proyectosDeTanquesDeGas.contains(proyectoDeTanqueDeAgua))
            throw new RuntimeException("Se intento agregar un proyecto de tanque que ya existia.");
        this.proyectosDeTanquesDeAgua.add(proyectoDeTanqueDeAgua);
    }

    public void agregarProyectoDeTanqueDeGas(ProyectoConstruccionTanque proyectoDeTanqueDeGas) {
        if (proyectosDeTanquesDeGas.contains(proyectoDeTanqueDeGas) || proyectosDeTanquesDeAgua.contains(proyectoDeTanqueDeGas))
            throw new RuntimeException("Se intento agregar un proyecto de tanque que ya existia.");
        this.proyectosDeTanquesDeGas.add(proyectoDeTanqueDeGas);
    }

    public void agregarProyectoDePlantaProcesadora(ProyectoConstruccionPlanta proyectoDePlantaProcesadora) {
        if (proyectosDePlantasProcesadoras.contains(proyectoDePlantaProcesadora))
            throw new RuntimeException("Se intento agregar un proyecto de planta que ya existia.");
        this.proyectosDePlantasProcesadoras.add(proyectoDePlantaProcesadora);
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

    public Contabilidad contabilidad() {
        return contabilidad;
    }
}
