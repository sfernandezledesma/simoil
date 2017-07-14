package simoil;

import java.util.ArrayList;


public class EmprendimientoPetrolifero {
    private Contabilidad contabilidad;
    private Yacimiento yacimiento;
    private EquipoDeIngenieria equipoDeIngenieria;
    private ArrayList<PlantaProcesadora> plantasProcesadorasHabilitadas;
    private ArrayList<Tanque> tanquesDeAguaHabilitados;
    private ArrayList<Tanque> tanquesDeGasHabilitados;
    private ArrayList<AlquilerRig> alquileresDeRigs;
    private ArrayList<ProyectoConstruccionTanque> proyectosDeTanquesDeAgua;
    private ArrayList<ProyectoConstruccionTanque> proyectosDeTanquesDeGas;
    private ArrayList<ProyectoConstruccionPlanta> proyectosDePlantasProcesadoras;
    private ArrayList<Excavacion> excavaciones;


    public EmprendimientoPetrolifero(Yacimiento yacimiento, EquipoDeIngenieria equipoDeIngenieria) {
        this.contabilidad = new Contabilidad();
        this.yacimiento = yacimiento;
        this.equipoDeIngenieria = equipoDeIngenieria;
        this.plantasProcesadorasHabilitadas = new ArrayList<>();
        this.tanquesDeAguaHabilitados = new ArrayList<>();
        this.tanquesDeGasHabilitados = new ArrayList<>();
        this.alquileresDeRigs = new ArrayList<>();
        this.proyectosDeTanquesDeAgua = new ArrayList<>();
        this.proyectosDeTanquesDeGas = new ArrayList<>();
        this.proyectosDePlantasProcesadoras = new ArrayList<>();
        this.excavaciones = new ArrayList<>();
    }

    public void habilitarPlantaProcesadora(PlantaProcesadora plantaProcesadora) {
        if (plantasProcesadorasHabilitadas.contains(plantaProcesadora))
            throw new RuntimeException("Se intento agregar una planta que ya existia.");
        this.plantasProcesadorasHabilitadas.add(plantaProcesadora);
    }

    public void habilitarTanqueDeAgua(Tanque tanqueDeAgua) {
        if (tanquesDeAguaHabilitados.contains(tanqueDeAgua) || tanquesDeGasHabilitados.contains(tanqueDeAgua))
            throw new RuntimeException("Se intento agregar un tanqueEnConstruccion de agua que ya existia.");
        this.tanquesDeAguaHabilitados.add(tanqueDeAgua);
    }

    public void habilitarTanqueDeGas(Tanque tanqueDeGas) {
        if (tanquesDeGasHabilitados.contains(tanqueDeGas) || tanquesDeAguaHabilitados.contains(tanqueDeGas))
            throw new RuntimeException("Se intento agregar un tanqueEnConstruccion de gas que ya existia.");
        this.tanquesDeGasHabilitados.add(tanqueDeGas);
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

    public ArrayList<PlantaProcesadora> plantasProcesadorasHabilitadas() {
        return new ArrayList<PlantaProcesadora>(plantasProcesadorasHabilitadas);
    }

    public ArrayList<Tanque> tanquesDeAguaHabilitados() {
        return new ArrayList<Tanque>(tanquesDeAguaHabilitados);
    }

    public ArrayList<Tanque> tanquesDeGasHabilitados() {
        return new ArrayList<Tanque>(tanquesDeGasHabilitados);
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
