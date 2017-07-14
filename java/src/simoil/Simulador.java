package simoil;

import simoil.estrategias.condicionDeFin.EstrategiaCondicionDeFin;
import simoil.estrategias.condicionDeFin.EstrategiaCondicionDeFinPorDilucionCritica;
import simoil.estrategias.construccion.EstrategiaConstruccion;
import simoil.estrategias.construccion.EstrategiaConstruccionPlantaUnica;
import simoil.estrategias.estrategiaVentaGas.EstrategiaVentaGasVenderTodosLosDias;
import simoil.estrategias.excavacion.EstrategiaExcavacion;
import simoil.estrategias.excavacion.EstrategiaExcavacionLoAntesPosible;
import simoil.estrategias.extraccion.EstrategiaExtraccionTodosLosPozosHabilitados;
import simoil.estrategias.reinyeccion.EstrategiaReinyeccionNoReinyectar;
import simoil.estrategias.seleccionParcelas.EstrategiaSeleccionParcelas;
import simoil.estrategias.seleccionParcelas.EstrategiaSeleccionParcelasPorMaximaPresion;

import java.util.ArrayList;
import java.util.Iterator;

public class Simulador {
    private int diaActual = 1;
    private Logger logger = new Logger();
    private int maximoDias;
    private int maximaCantidadRigsSimultaneos;
    private float volumenMaximoReinyeccionEnUnDia;
    private float porcentajeCriticoPetroleo;
    private int cantidadDePozosDeseados;
    private float precioLitroDeCombustibleRig;
    private float precioLitroGas;
    private float precioLitroPetroleo;
    private float precioLitroAguaEspecialComprada;
    private EmprendimientoPetrolifero emprendimientoPetrolifero;
    private ArrayList<AlquilerRig> catalogoAlquilerRigs;
    private ArrayList<ProyectoConstruccionTanque> catalogoConstruccionTanques;
    private ArrayList<ProyectoConstruccionPlanta> catalogoConstruccionPlantasProcesadoras;

    public Simulador(int maximoDias, int maximaCantidadRigsSimultaneos, float volumenMaximoReinyeccionEnUnDia, float porcentajeCriticoPetroleo, int cantidadDePozosDeseados, float precioLitroDeCombustibleRig, float precioLitroGas, float precioLitroPetroleo, float precioLitroAguaEspecialComprada, EmprendimientoPetrolifero emprendimientoPetrolifero, ArrayList<AlquilerRig> catalogoAlquilerRigs, ArrayList<ProyectoConstruccionTanque> catalogoConstruccionTanques, ArrayList<ProyectoConstruccionPlanta> catalogoConstruccionPlantasProcesadoras) {
        this.maximoDias = maximoDias;
        this.maximaCantidadRigsSimultaneos = maximaCantidadRigsSimultaneos;
        this.volumenMaximoReinyeccionEnUnDia = volumenMaximoReinyeccionEnUnDia;
        this.porcentajeCriticoPetroleo = porcentajeCriticoPetroleo;
        this.cantidadDePozosDeseados = cantidadDePozosDeseados;
        this.precioLitroDeCombustibleRig = precioLitroDeCombustibleRig;
        this.precioLitroGas = precioLitroGas;
        this.precioLitroPetroleo = precioLitroPetroleo;
        this.precioLitroAguaEspecialComprada = precioLitroAguaEspecialComprada;
        this.emprendimientoPetrolifero = emprendimientoPetrolifero;
        this.catalogoAlquilerRigs = catalogoAlquilerRigs;
        this.catalogoConstruccionTanques = catalogoConstruccionTanques;
        this.catalogoConstruccionPlantasProcesadoras = catalogoConstruccionPlantasProcesadoras;
    }

    public void iniciarSimulacion() {
        // Primero necesitamos conocer las parcelas donde vamos a excavar los pozos
        EstrategiaSeleccionParcelas estrategiaSeleccionParcelas = emprendimientoPetrolifero.equipoDeIngenieria().estrategiaSeleccionParcelas();
        ArrayList<Parcela> parcelasSeleccionadas = estrategiaSeleccionParcelas.seleccionarParcelasParaExcavar(emprendimientoPetrolifero, cantidadDePozosDeseados);

        // Tambien necesitamos definir los proyectos de construccion de plantas procesadoras y tanques
        EstrategiaConstruccion estrategiaConstruccion = emprendimientoPetrolifero.equipoDeIngenieria().estrategiaConstruccion();
        estrategiaConstruccion.crearProyectosDeConstruccion(catalogoConstruccionPlantasProcesadoras, catalogoConstruccionTanques);

        ArrayList<ProyectoConstruccionPlanta> proyectosNuevosPlantas = estrategiaConstruccion.proyectosConstruccionPlantas();
        for (ProyectoConstruccionPlanta proyectoPlanta : proyectosNuevosPlantas) {
            emprendimientoPetrolifero.agregarProyectoDePlantaProcesadora(proyectoPlanta);
            emprendimientoPetrolifero.contabilidad().sumarGasto(proyectoPlanta.costo());
            logger.log("Se proyecto una nueva planta procesadora. Su construccion comienza el dia " +
                    proyectoPlanta.diaComienzoConstruccion() + " y su costo fue de $" + proyectoPlanta.costo() + ".");
        }

        ArrayList<ProyectoConstruccionTanque> proyectosNuevosTanquesDeAgua = estrategiaConstruccion.proyectosConstruccionTanquesDeAgua();
        for (ProyectoConstruccionTanque proyectoTanqueAgua : proyectosNuevosTanquesDeAgua) {
            emprendimientoPetrolifero.agregarProyectoDeTanqueDeAgua(proyectoTanqueAgua);
            emprendimientoPetrolifero.contabilidad().sumarGasto(proyectoTanqueAgua.costo());
            logger.log("Se proyecto un nuevo tanque de agua. Su construccion comienza el dia " +
                    proyectoTanqueAgua.diaComienzoConstruccion() + " y su costo fue de $" + proyectoTanqueAgua.costo() + ".");
        }

        ArrayList<ProyectoConstruccionTanque> proyectosNuevosTanquesDeGas = estrategiaConstruccion.proyectosConstruccionTanquesDeGas();
        for (ProyectoConstruccionTanque proyectoTanqueGas : proyectosNuevosTanquesDeGas) {
            emprendimientoPetrolifero.agregarProyectoDeTanqueDeGas(proyectoTanqueGas);
            emprendimientoPetrolifero.contabilidad().sumarGasto(proyectoTanqueGas.costo());
            logger.log("Se proyecto un nuevo tanque de gas. Su construccion comienza el dia " +
                    proyectoTanqueGas.diaComienzoConstruccion() + " y su costo fue de $" + proyectoTanqueGas.costo() + ".");
        }

        // Con estos dos datos, ya podemos definir cuando excavar y a que planta conectar cada pozo
        EstrategiaExcavacion estrategiaExcavacion = emprendimientoPetrolifero.equipoDeIngenieria().estrategiaExcavacion();
        ArrayList<Excavacion> excavaciones = estrategiaExcavacion.crearExcavaciones(emprendimientoPetrolifero, parcelasSeleccionadas);
        for (Excavacion nuevaExcavacion : excavaciones)
            emprendimientoPetrolifero.agregarExcavacion(nuevaExcavacion);

        // Ahora podemos empezar a simular dia a dia chequeando si hay que finalizar con la estrategia de condicion de fin
        EstrategiaCondicionDeFin estrategiaCondicionDeFin = emprendimientoPetrolifero.equipoDeIngenieria().estrategiaCondicionDeFin();
        while (!estrategiaCondicionDeFin.hayQueFinalizar(emprendimientoPetrolifero, diaActual, maximoDias, porcentajeCriticoPetroleo)) {
            simularUnDia();
        }
    }

    private void simularUnDia() {
        logger.log("Dia " + diaActual + ":");
        // Primero tenemos que decidir si vamos a vender el gas que almacenamos anteriormente
        if (emprendimientoPetrolifero.equipoDeIngenieria().estrategiaVentaGas().hayQueVenderElGas(emprendimientoPetrolifero)) {
            venderGas();
        }

        // Ahora hay decidir si reinyectar o extraer producto
        if (emprendimientoPetrolifero.equipoDeIngenieria().estrategiaReinyeccion().hayQueReinyectar(emprendimientoPetrolifero)) {
            // Hay que reinyectar, hoy no podemos extraer de ningun pozo
            reinyectar();
        } else { // Si no se reinyecta, se intenta extraer
            extraerProducto();
        }

        // Avanzamos con las construcciones de tanques y plantas procesadoras
        construir();

        // Avanzamos con las excavaciones de pozos
        excavar();

        // Finalmente cerramos el dia: Apagamos Rigs y plantas procesadoras, cerramos valvulas de los pozos, etc.
        finalizarDia();
    }

    private void extraerProducto() {
        emprendimientoPetrolifero.equipoDeIngenieria().estrategiaExtraccion().abrirValvulasDePozos(emprendimientoPetrolifero);
        Yacimiento yacimiento = emprendimientoPetrolifero.yacimiento();
        ComposicionDeProducto composicionDeProducto = yacimiento.composicionDeProducto();
        float volumenPetroleoExtraidoEnElDia = 0;
        float proporcionPetroleo = yacimiento.composicionDeProducto().porcentajePetroleo() / 100f;
        for (Pozo pozo : yacimiento.pozosHabilitados()) {
            if (pozo.valvulaPrincipalAbierta()) {
                float volumenPotencialDelPozo = yacimiento.volumenPotencialDiarioPozo(pozo);
                logger.log("El pozo puede extraer potencialmente " +  volumenPotencialDelPozo +" litros de producto.");
                float volumenAExtraerDelPozo = 0;
                // Tenemos que definir cuantos litros podemos realmente extraer segun plantas procesadoras conectadas al pozo
                for (PlantaProcesadora plantaProcesadora : pozo.plantasConectadas()) {
                    if (volumenPotencialDelPozo <= 0) {
                        break;
                    }
                    // Chequeamos que la planta procesadora conectada esta efectivamente habilitada en el yacimiento
                    if (emprendimientoPetrolifero.plantasProcesadorasHabilitadas().contains(plantaProcesadora)) {
                        float volumenProcesado = plantaProcesadora.procesarProducto(volumenPotencialDelPozo, emprendimientoPetrolifero);
                        if (volumenProcesado > 0) {
                            logger.log("La planta procesadora proceso " + volumenProcesado + " litros de producto.");
                        } else {
                            logger.log("La planta procesadora no puede procesar mas producto.");
                        }
                        volumenPotencialDelPozo -= volumenProcesado;
                        volumenAExtraerDelPozo += volumenProcesado;
                    }
                }
                if( Math.abs(volumenAExtraerDelPozo - yacimiento.extraerProducto(volumenAExtraerDelPozo)) > 0.1 ) {
                    throw new RuntimeException("El volumen que se extrajo del yacimiento no es el esperado.");
                }
                volumenPetroleoExtraidoEnElDia += volumenAExtraerDelPozo * proporcionPetroleo;
                if (volumenAExtraerDelPozo > 0) {
                    logger.log("El pozo extrajo " + volumenAExtraerDelPozo + " litros de producto del yacimiento.");
                } else {
                    pozo.cerrarValvulaPrincipal(); // Si no podemos extraer, cerramos el pozo para que su presion no cambie.
                }
            }
        }
        if (volumenPetroleoExtraidoEnElDia > 0) {
            float ingresoPorPetroleo = volumenPetroleoExtraidoEnElDia * precioLitroPetroleo;
            emprendimientoPetrolifero.contabilidad().sumarIngreso(ingresoPorPetroleo);
            logger.log("Se vendieron " + volumenPetroleoExtraidoEnElDia + " litros de petroleo por $" + ingresoPorPetroleo + ".");
        }
        yacimiento.actualizarPresionesPozos();
    }

    private void reinyectar() {
        //TODO
    }

    private void finalizarDia() {
        // Cerramos valvulas principales de todos los pozos
        for (Pozo pozo : emprendimientoPetrolifero.yacimiento().pozosHabilitados())
            pozo.cerrarValvulaPrincipal();
        // Apagamos Rigs
        for (AlquilerRig alquilerRig : emprendimientoPetrolifero.alquileresDeRigs())
            alquilerRig.rig().apagar();
        // Apagamos plantas procesadoras
        for (PlantaProcesadora plantaProcesadora : emprendimientoPetrolifero.plantasProcesadorasHabilitadas())
            plantaProcesadora.apagar();

        float ganancia = emprendimientoPetrolifero.contabilidad().ganancia();
        logger.log(
                "Total ingresos: $" + emprendimientoPetrolifero.contabilidad().ingresos() +
                ". Total gastos: $" + emprendimientoPetrolifero.contabilidad().gastos() +
                ". Ganancia: " + (ganancia < 0 ? "-$" : "$") + Math.abs(ganancia) + ".");
        diaActual++;
    }

    private void construir() {
        Iterator<ProyectoConstruccionPlanta> itProyectoPlanta = emprendimientoPetrolifero.proyectosDePlantasProcesadoras().iterator();
        while (itProyectoPlanta.hasNext()) {
            ProyectoConstruccionPlanta proyectoConstruccionPlanta = itProyectoPlanta.next();
            if (proyectoConstruccionPlanta.diaComienzoConstruccion() <= diaActual && proyectoConstruccionPlanta.construirUnDia()) {
                itProyectoPlanta.remove();
                emprendimientoPetrolifero.habilitarPlantaProcesadora(proyectoConstruccionPlanta.plantaEnConstruccion());
                logger.log("La construccion de la planta finalizo hoy.");
            }
        }
        Iterator<ProyectoConstruccionTanque> itProyectoTanqueAgua = emprendimientoPetrolifero.proyectosDeTanquesDeAgua().iterator();
        while (itProyectoTanqueAgua.hasNext()) {
            ProyectoConstruccionTanque proyectoConstruccionTanqueAgua = itProyectoTanqueAgua.next();
            if (proyectoConstruccionTanqueAgua.diaComienzoConstruccion() <= diaActual && proyectoConstruccionTanqueAgua.construirUnDia()) {
                itProyectoTanqueAgua.remove();
                emprendimientoPetrolifero.habilitarTanqueDeAgua(proyectoConstruccionTanqueAgua.tanqueEnConstruccion());
                logger.log("La construccion del tanque de agua finalizo hoy.");
            }
        }
        Iterator<ProyectoConstruccionTanque> itProyectoTanqueGas = emprendimientoPetrolifero.proyectosDeTanquesDeGas().iterator();
        while (itProyectoTanqueGas.hasNext()) {
            ProyectoConstruccionTanque proyectoConstruccionTanqueGas = itProyectoTanqueGas.next();
            if (proyectoConstruccionTanqueGas.diaComienzoConstruccion() <= diaActual && proyectoConstruccionTanqueGas.construirUnDia()) {
                itProyectoTanqueGas.remove();
                emprendimientoPetrolifero.habilitarTanqueDeGas(proyectoConstruccionTanqueGas.tanqueEnConstruccion());
                logger.log("La construccion del tanque de gas finalizo hoy.");
            }
        }
    }

    private void excavar() {
        EstrategiaExcavacion estrategiaExcavacion = emprendimientoPetrolifero.equipoDeIngenieria().estrategiaExcavacion();
        Iterator<Excavacion> itExcavacion = emprendimientoPetrolifero.excavaciones().iterator();
        Iterator<AlquilerRig> itAlquilerRig = emprendimientoPetrolifero.alquileresDeRigs().iterator();
        int cantidadRigsAlquilados = emprendimientoPetrolifero.alquileresDeRigs().size();
        ArrayList<AlquilerRig> nuevosAlquileres = new ArrayList<>();
        while (itExcavacion.hasNext()) {
            Excavacion excavacion = itExcavacion.next();
            if (excavacion.diaDeComienzoDeExcavacion() <= diaActual) {
                Rig rig = null;
                if (itAlquilerRig.hasNext()) {
                    AlquilerRig alquilerRig = itAlquilerRig.next();
                    rig = alquilerRig.rig();
                } else {
                    if (cantidadRigsAlquilados < estrategiaExcavacion.cuantosRigsAlquilarSimultaneamente(maximaCantidadRigsSimultaneos)) {
                        AlquilerRig nuevoAlquiler = estrategiaExcavacion.elegirUnNuevoAlquilerDeRig(catalogoAlquilerRigs, excavacion);
                        nuevosAlquileres.add(nuevoAlquiler);
                        rig = nuevoAlquiler.rig();
                        cantidadRigsAlquilados = cantidadRigsAlquilados + 1;
                    }
                }
                if (rig != null) {
                    float costoCombustibleConsumido = rig.consumoCombustibleDiarioEnLitros() * precioLitroDeCombustibleRig;
                    emprendimientoPetrolifero.contabilidad().sumarGasto(costoCombustibleConsumido);
                    float metrosExcavados = rig.excavar(excavacion);
                    logger.log("El rig excavo " + metrosExcavados + " metros.");
                    if (excavacion.excavacionFinalizada()) {
                        itExcavacion.remove();
                        emprendimientoPetrolifero.yacimiento().habilitarPozo(excavacion.parcelaExcavacion().pozo());
                        logger.log("Se finalizo la excavacion del pozo.");
                    }
                }
            }
        }
        while (itAlquilerRig.hasNext()) { // Si hubo Rigs que no se usaron, intentamos cancelar el alquiler
            AlquilerRig alquilerRig = itAlquilerRig.next();
            if (alquilerRig.diasAlquilado() >= alquilerRig.minimoDias()) {
                itAlquilerRig.remove();
            }
        }
        for (AlquilerRig nuevoAlquiler : nuevosAlquileres) {
            emprendimientoPetrolifero.agregarAlquilerDeRig(nuevoAlquiler);
        }
        float costoTotalAlquileresHoy = 0;
        for (AlquilerRig alquilerRig : emprendimientoPetrolifero.alquileresDeRigs()) {
            costoTotalAlquileresHoy += alquilerRig.costoDiario();
            alquilerRig.avanzarUnDia();
        }
        if (costoTotalAlquileresHoy > 0)
            logger.log("Hoy se gasto $" + costoTotalAlquileresHoy + " en alquileres de Rigs.");
        emprendimientoPetrolifero.contabilidad().sumarGasto(costoTotalAlquileresHoy);
    }

    private void venderGas() {
        float totalLitrosDeGasVendidos = 0;
        ArrayList<Tanque> tanquesDeGas = emprendimientoPetrolifero.tanquesDeGasHabilitados();
        for (Tanque tanqueGas : tanquesDeGas) {
            totalLitrosDeGasVendidos += tanqueGas.descargarTodo();
        }
        float precioDelGasVendido = totalLitrosDeGasVendidos * precioLitroGas;
        emprendimientoPetrolifero.contabilidad().sumarIngreso(precioDelGasVendido);
        if (precioDelGasVendido > 0)
            logger.log("Se vendieron " + totalLitrosDeGasVendidos + " litros de gas por $" + precioDelGasVendido + ".");
    }

    public static void main(String[] args) {
        TipoTerreno rocoso = new TipoTerreno("rocoso", 60);
        TipoTerreno arcilloso = new TipoTerreno("arcilloso", -10);
        ArrayList<Parcela> parcelas = new ArrayList<>();
        parcelas.add(new Parcela(rocoso, 10, 3100));
        parcelas.add(new Parcela(rocoso, 20, 3200));
        parcelas.add(new Parcela(arcilloso, 30, 3300));
        Yacimiento yacimiento = new Yacimiento(
                0.1f,
                0.01f,
                10000000,
                10000000,
                80000000,
                parcelas);

        ArrayList<ProyectoConstruccionPlanta> catalogoPlantas = new ArrayList<>();
        catalogoPlantas.add(new ProyectoConstruccionPlanta(new PlantaProcesadora(20000), 200, 3));
        catalogoPlantas.add(new ProyectoConstruccionPlanta(new PlantaProcesadora(50000), 1000, 5));
        ArrayList<ProyectoConstruccionTanque> catalogoTanques = new ArrayList<>();
        catalogoTanques.add(new ProyectoConstruccionTanque(new Tanque(30000), 100, 2));
        catalogoTanques.add(new ProyectoConstruccionTanque(new Tanque(40000), 150, 3));
        ArrayList<AlquilerRig> catalogoAlquilerRigs = new ArrayList<>();
        catalogoAlquilerRigs.add(new AlquilerRig(5, 3, new Rig(2, 10)));
        catalogoAlquilerRigs.add(new AlquilerRig(7, 5, new Rig(4, 15)));

        EquipoDeIngenieria equipo = new EquipoDeIngenieria(new EstrategiaSeleccionParcelasPorMaximaPresion(), new EstrategiaExcavacionLoAntesPosible(), new EstrategiaConstruccionPlantaUnica(), new EstrategiaExtraccionTodosLosPozosHabilitados(), new EstrategiaReinyeccionNoReinyectar(), new EstrategiaCondicionDeFinPorDilucionCritica(), new EstrategiaVentaGasVenderTodosLosDias());
        EmprendimientoPetrolifero emprendimiento = new EmprendimientoPetrolifero(yacimiento, equipo);
        Simulador sim = new Simulador(
                25,
                2,
                1000,
                35,
                3,
                10,
                0.1f,
                0.22f,
                0.03f,
                emprendimiento, catalogoAlquilerRigs, catalogoTanques, catalogoPlantas);

        sim.iniciarSimulacion();
    }
}
