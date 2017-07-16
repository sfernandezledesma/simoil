package simoil;

import java.util.ArrayList;


public class EmprendimientoPetrolifero {
    private RegistroContable registroContable;
    private Yacimiento yacimiento;
    private EquipoDeIngenieria equipoDeIngenieria;
    private ArrayList<PlantaProcesadora> plantasProcesadorasHabilitadas;
    private ArrayList<Tanque> tanquesDeAguaHabilitados;
    private ArrayList<Tanque> tanquesDeGasHabilitados;
    private ArrayList<AlquilerRig> alquileresDeRigsContratados;
    private ArrayList<AlquilerRig> catalogoAlquileresRigs;
    private ArrayList<ProyectoConstruccionTanque> proyectosDeTanquesDeAgua;
    private ArrayList<ProyectoConstruccionTanque> proyectosDeTanquesDeGas;
    private ArrayList<ProyectoConstruccionPlantaProcesadora> proyectosDePlantasProcesadoras;
    private ArrayList<Excavacion> excavaciones;
    private ArrayList<EspecificacionPlantaProcesadora> catalogoPlantasProcesadoras;
    private ArrayList<EspecificacionTanque> catalogoTanques;

    public EmprendimientoPetrolifero(Yacimiento yacimiento, EquipoDeIngenieria equipoDeIngenieria,
                                     ArrayList<EspecificacionPlantaProcesadora> catalogoPlantasProcesadoras,
                                     ArrayList<EspecificacionTanque> catalogoTanques,
                                     ArrayList<AlquilerRig> catalogoAlquileresRigs) {
        this.catalogoPlantasProcesadoras = catalogoPlantasProcesadoras;
        this.catalogoTanques = catalogoTanques;
        this.catalogoAlquileresRigs = catalogoAlquileresRigs;
        this.registroContable = new RegistroContable();
        this.yacimiento = yacimiento;
        this.equipoDeIngenieria = equipoDeIngenieria;
        this.plantasProcesadorasHabilitadas = new ArrayList<>();
        this.tanquesDeAguaHabilitados = new ArrayList<>();
        this.tanquesDeGasHabilitados = new ArrayList<>();
        this.alquileresDeRigsContratados = new ArrayList<>();
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
            throw new RuntimeException("Se intento agregar un tanque de agua que ya existia.");
        this.tanquesDeAguaHabilitados.add(tanqueDeAgua);
    }

    public void habilitarTanqueDeGas(Tanque tanqueDeGas) {
        if (tanquesDeGasHabilitados.contains(tanqueDeGas) || tanquesDeAguaHabilitados.contains(tanqueDeGas))
            throw new RuntimeException("Se intento agregar un tanque de gas que ya existia.");
        this.tanquesDeGasHabilitados.add(tanqueDeGas);
    }

    public void contratarAlquilerDeRig(AlquilerRig alquilerDeRig) {
        if (alquileresDeRigsContratados.contains(alquilerDeRig))
            throw new RuntimeException("Se intento agregar un alquiler de rig que ya existia.");
        this.alquileresDeRigsContratados.add(alquilerDeRig);
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

    public void agregarProyectoDePlantaProcesadora(ProyectoConstruccionPlantaProcesadora proyectoDePlantaProcesadora) {
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

    public ArrayList<EspecificacionPlantaProcesadora> catalogoPlantasProcesadoras() {
        return catalogoPlantasProcesadoras;
    }

    public ArrayList<EspecificacionTanque> catalogoTanques() {
        return catalogoTanques;
    }

    public ArrayList<AlquilerRig> catalogoAlquileresRigs() {
        return catalogoAlquileresRigs;
    }

    public ArrayList<AlquilerRig> alquileresDeRigsContratados() {
        return alquileresDeRigsContratados;
    }

    public ArrayList<ProyectoConstruccionTanque> proyectosDeTanquesDeAgua() {
        return proyectosDeTanquesDeAgua;
    }

    public ArrayList<ProyectoConstruccionTanque> proyectosDeTanquesDeGas() {
        return proyectosDeTanquesDeGas;
    }

    public ArrayList<ProyectoConstruccionPlantaProcesadora> proyectosDePlantasProcesadoras() {
        return proyectosDePlantasProcesadoras;
    }

    public ArrayList<Excavacion> excavaciones() {
        return excavaciones;
    }

    public RegistroContable registroContable() {
        return registroContable;
    }

    public boolean plantaProcesadoraHabilitada(String nombre) {
        for (PlantaProcesadora plantaProcesadora : plantasProcesadorasHabilitadas) {
            if (plantaProcesadora.nombre().equals(nombre))
                return true;
        }
        return false;
    }

    public boolean tanqueDeAguaHabilitado(String nombre) {
        for (Tanque tanqueDeAgua : tanquesDeAguaHabilitados) {
            if (tanqueDeAgua.nombre().equals(nombre))
                return true;
        }
        return false;
    }

    public boolean tanqueDeGasHabilitado(String nombre) {
        for (Tanque tanqueDeGas : tanquesDeGasHabilitados) {
            if (tanqueDeGas.nombre().equals(nombre))
                return true;
        }
        return false;
    }

    public boolean pozoHabilitado(String nombre) {
        for (Pozo pozo : yacimiento.pozosHabilitadosParaExtraccion()) {
            if (pozo.nombre().equals(nombre))
                return true;
        }
        return false;
    }

    public PlantaProcesadora plantaProcesadoraPorNombre(String nombre) {
        for (PlantaProcesadora plantaProcesadora : plantasProcesadorasHabilitadas) {
            if (plantaProcesadora.nombre().equals(nombre))
                return plantaProcesadora;
        }
        throw new RuntimeException("No existe una planta procesadora con ese nombreTipoTerreno.");
    }

    public Tanque tanqueDeAguaPorNombre(String nombre) {
        for (Tanque tanqueDeAgua : tanquesDeAguaHabilitados) {
            if (tanqueDeAgua.nombre().equals(nombre))
                return tanqueDeAgua;
        }
        throw new RuntimeException("No existe un tanque de agua con ese nombreTipoTerreno.");
    }

    public Tanque tanqueDeGasPorNombre(String nombre) {
        for (Tanque tanqueDeGas : tanquesDeGasHabilitados) {
            if (tanqueDeGas.nombre().equals(nombre))
                return tanqueDeGas;
        }
        throw new RuntimeException("No existe un tanque de agua con ese nombreTipoTerreno.");
    }
}
