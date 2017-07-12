package simoil;

import java.util.ArrayList;


public class Simulador {
    private int diasTranscurridos;
    private float alphaUno;
    private float alphaDos;
    private int cantidadDePozosDeseados;
    private EmprendimientoPetrolifero emprendimientoPetrolifero;
    private ArrayList<AlquilerRig> catalogoAlquilerRigs;
    private ArrayList<ProyectoConstruccion> catalogoConstruccionTanquesDeAgua;
    private ArrayList<ProyectoConstruccion> catalogoConstruccionTanquesDeGas;
    private ArrayList<ProyectoConstruccion> catalogoConstruccionPlantasProcesadoras;

    public Simulador(EmprendimientoPetrolifero emprendimientoPetrolifero, int diasTranscurridos, float alphaUno,
                     float alphaDos, int cantidadDePozosDeseados, ArrayList<AlquilerRig> catalogoAlquilerRigs,
                     ArrayList<ProyectoConstruccion> catalogoConstruccionTanquesDeAgua,
                     ArrayList<ProyectoConstruccion> catalogoConstruccionTanquesDeGas,
                     ArrayList<ProyectoConstruccion> catalogoConstruccionPlantasProcesadoras) {
        this.emprendimientoPetrolifero = emprendimientoPetrolifero;
        this.diasTranscurridos = diasTranscurridos;
        this.alphaUno = alphaUno;
        this.alphaDos = alphaDos;
        this.cantidadDePozosDeseados = cantidadDePozosDeseados;
        this.catalogoAlquilerRigs = catalogoAlquilerRigs;
        this.catalogoConstruccionTanquesDeAgua = catalogoConstruccionTanquesDeAgua;
        this.catalogoConstruccionTanquesDeGas = catalogoConstruccionTanquesDeGas;
        this.catalogoConstruccionPlantasProcesadoras = catalogoConstruccionPlantasProcesadoras;
    }
}
