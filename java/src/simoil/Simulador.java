package simoil;

import simoil.estrategias.construccion.EstrategiaConstruccion;
import simoil.estrategias.seleccionParcelas.EstrategiaSeleccionParcelas;
import java.util.ArrayList;


public class Simulador {
    private int diasTranscurridos;
    private float alphaUno;
    private float alphaDos;
    private int cantidadDePozosDeseados;
    private EmprendimientoPetrolifero emprendimientoPetrolifero;
    private ArrayList<AlquilerRig> catalogoAlquilerRigs;
    private ArrayList<ProyectoConstruccionTanque> catalogoConstruccionTanques;
    private ArrayList<ProyectoConstruccionPlanta> catalogoConstruccionPlantasProcesadoras;

    public Simulador(EmprendimientoPetrolifero emprendimientoPetrolifero, float alphaUno,
                     float alphaDos, int cantidadDePozosDeseados, ArrayList<AlquilerRig> catalogoAlquilerRigs,
                     ArrayList<ProyectoConstruccionTanque> catalogoConstruccionTanques,
                     ArrayList<ProyectoConstruccionPlanta> catalogoConstruccionPlantasProcesadoras) {
        this.emprendimientoPetrolifero = emprendimientoPetrolifero;
        this.diasTranscurridos = 0;
        this.alphaUno = alphaUno;
        this.alphaDos = alphaDos;
        this.cantidadDePozosDeseados = cantidadDePozosDeseados;
        this.catalogoAlquilerRigs = catalogoAlquilerRigs;
        this.catalogoConstruccionTanques = catalogoConstruccionTanques;
        this.catalogoConstruccionPlantasProcesadoras = catalogoConstruccionPlantasProcesadoras;
    }

    public void iniciarSimulacion() {
        EstrategiaSeleccionParcelas estrategiaSeleccionParcelas = emprendimientoPetrolifero.equipoDeIngenieria().estrategiaSeleccionParcelas();
        ArrayList<Parcela> parcelasSeleccionadas = estrategiaSeleccionParcelas.seleccionarParcelasParaExcavar(emprendimientoPetrolifero, cantidadDePozosDeseados);

        EstrategiaConstruccion estrategiaConstruccion = emprendimientoPetrolifero.equipoDeIngenieria().estrategiaConstruccion();
        estrategiaConstruccion.crearProyectosDeConstruccion();
        emprendimientoPetrolifero.definirProyectosDePlantasProcesadoras(estrategiaConstruccion.proyectosConstruccionPlantas());
        emprendimientoPetrolifero.definirProyectosDeTanquesDeAgua(estrategiaConstruccion.proyectosConstruccionTanquesDeAgua());
        emprendimientoPetrolifero.definirProyectosDeTanquesDeGas(estrategiaConstruccion.proyectosConstruccionTanquesDeGas());


    }

    private void simularUnDia() {

    }
}
