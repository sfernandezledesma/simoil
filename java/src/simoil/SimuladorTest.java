package simoil;

import simoil.estrategias.condicionDeFin.EstrategiaCondicionDeFinPorMaximoDiasLicitacion;
import simoil.estrategias.construccion.EstrategiaConstruccionPlantaUnica;
import simoil.estrategias.construccion.EstrategiaConstruccionTantasPlantasYTanquesComoParcelas;
import simoil.estrategias.estrategiaVentaGas.EstrategiaVentaGasVenderTodosLosDias;
import simoil.estrategias.excavacion.EstrategiaExcavacionCadaTresDiasAlquilandoUnSoloRig;
import simoil.estrategias.excavacion.EstrategiaExcavacionLoAntesPosible;
import simoil.estrategias.extraccion.EstrategiaExtraccionNPozosConMayorPresion;
import simoil.estrategias.extraccion.EstrategiaExtraccionTodosLosPozosHabilitados;
import simoil.estrategias.reinyeccion.EstrategiaReinyeccionReinyectarTodoLoAlmacenadoCuandoSeLlenaUnTanque;
import simoil.estrategias.seleccionParcelas.EstrategiaSeleccionParcelasPorFacilidadDeExcavacion;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SimuladorTest {
    @org.junit.jupiter.api.Test
    void testPrimerDia() {
        TipoTerreno rocoso = new TipoTerreno("rocoso", 60);
        TipoTerreno arcilloso = new TipoTerreno("arcilloso", 0);

        ArrayList<Parcela> parcelas = new ArrayList<>();
        parcelas.add(new Parcela("1", rocoso, 16, 3300));
        parcelas.add(new Parcela("2", arcilloso, 16, 3200));

        Yacimiento yacimiento = new Yacimiento(
                1,
                1,
                20000000,
                30000000,
                50000000,
                parcelas);

        ArrayList<EspecificacionPlantaProcesadora> catalogoPlantas = new ArrayList<>();
        EspecificacionPlantaProcesadora ep1 = new EspecificacionPlantaProcesadora(2, 10000, 100000);
        EspecificacionPlantaProcesadora ep2 = new EspecificacionPlantaProcesadora(1, 2000, 50000);
        catalogoPlantas.add(ep1);
        catalogoPlantas.add(ep2);

        ArrayList<EspecificacionTanque> catalogoTanques = new ArrayList<>();
        EspecificacionTanque et1 = new EspecificacionTanque(2, 1500, 500000);
        EspecificacionTanque et2 = new EspecificacionTanque(1, 1000, 300000);
        catalogoTanques.add(et1);
        catalogoTanques.add(et2);

        ArrayList<AlquilerRig> catalogoAlquileresRigs = new ArrayList<>();
        Rig rig1 = new Rig("1", 2, 10);
        Rig rig2 = new Rig("2", 4, 15);
        Rig rig3 = new Rig("3", 8, 20);
        catalogoAlquileresRigs.add(new AlquilerRig(60, 1, rig1));
        catalogoAlquileresRigs.add(new AlquilerRig(100, 1, rig2));
        catalogoAlquileresRigs.add(new AlquilerRig(200, 1, rig3));

        EquipoDeIngenieria equipo = new EquipoDeIngenieria(
                new EstrategiaSeleccionParcelasPorFacilidadDeExcavacion(),
                new EstrategiaExcavacionLoAntesPosible(),
                new EstrategiaConstruccionPlantaUnica(),
                new EstrategiaExtraccionTodosLosPozosHabilitados(),
                new EstrategiaReinyeccionReinyectarTodoLoAlmacenadoCuandoSeLlenaUnTanque(),
                new EstrategiaCondicionDeFinPorMaximoDiasLicitacion(1),
                new EstrategiaVentaGasVenderTodosLosDias());

        EmprendimientoPetrolifero emprendimiento = new EmprendimientoPetrolifero(
                yacimiento,
                equipo,
                catalogoPlantas,
                catalogoTanques,
                catalogoAlquileresRigs);

        Simulador sim = new Simulador(
                1000,
                3,
                100000000,
                1,
                1,
                1,
                1,
                1,
                emprendimiento);

        sim.iniciarSimulacion();

        assertEquals(2, emprendimiento.catalogoPlantasProcesadoras().size());
        assertEquals(2, emprendimiento.catalogoTanques().size());

        assertTrue(yacimiento.volumenTotalActual() == 100000000);
        assertEquals(0, yacimiento.volumenGlobalExtraido());
        assertEquals(0, yacimiento.volumenGlobalReinyectado());
        assertEquals(2, yacimiento.parcelas().size());
        assertEquals(false, yacimiento.parcelas().get(0).tienePozo());
        assertEquals(false, yacimiento.parcelas().get(1).tienePozo());

        assertEquals(1, emprendimiento.excavacionesActivas().size());
        assertEquals(0, emprendimiento.excavacionesPendientesDeFinalizacion().size());
        assertEquals("2", emprendimiento.excavacionesActivas().get(0).nombrePozoEnExcavacion());
        assertEquals(8.0, emprendimiento.excavacionesActivas().get(0).metrosExcavados());

        assertEquals(2, emprendimiento.catalogoAlquileresRigs().size());
        assertEquals(1, emprendimiento.alquileresDeRigsContratados().size());
        assertEquals(rig3, emprendimiento.alquileresDeRigsContratados().get(0).rigAlquilado());
        assertEquals(1, emprendimiento.alquileresDeRigsContratados().get(0).diasAlquilado());

        assertEquals(1, emprendimiento.proyectosDePlantasProcesadoras().size());
        assertEquals(ep1, emprendimiento.proyectosDePlantasProcesadoras().get(0).especificacionPlantaProcesadora());

        assertEquals(1, emprendimiento.proyectosDeTanquesDeAgua().size());
        assertEquals(et1, emprendimiento.proyectosDeTanquesDeAgua().get(0).especificacionTanque());

        assertEquals(1, emprendimiento.proyectosDeTanquesDeGas().size());
        assertEquals(et1, emprendimiento.proyectosDeTanquesDeGas().get(0).especificacionTanque());

        assertEquals(sim.diasTranscurridos() * rig3.consumoCombustibleDiarioEnLitros()
                + sim.diasTranscurridos() * emprendimiento.alquileresDeRigsContratados().get(0).costoDiario()
                + ep1.costo() + 2 * et1.costo(), emprendimiento.registroContable().gastos());
        assertEquals(0.0, emprendimiento.registroContable().ingresos());
        assertEquals(emprendimiento.registroContable().ingresos() - emprendimiento.registroContable().gastos(),
                emprendimiento.registroContable().ganancia());
    }

    @org.junit.jupiter.api.Test
    void testSegundoDia() {
        TipoTerreno rocoso = new TipoTerreno("rocoso", 60);
        TipoTerreno arcilloso = new TipoTerreno("arcilloso", 0);

        ArrayList<Parcela> parcelas = new ArrayList<>();
        parcelas.add(new Parcela("1", rocoso, 16, 3300));
        parcelas.add(new Parcela("2", arcilloso, 16, 3200));

        Yacimiento yacimiento = new Yacimiento(
                1,
                1,
                20000000,
                30000000,
                50000000,
                parcelas);

        ArrayList<EspecificacionPlantaProcesadora> catalogoPlantas = new ArrayList<>();
        EspecificacionPlantaProcesadora ep1 = new EspecificacionPlantaProcesadora(2, 10000, 100000);
        EspecificacionPlantaProcesadora ep2 = new EspecificacionPlantaProcesadora(1, 2000, 50000);
        catalogoPlantas.add(ep1);
        catalogoPlantas.add(ep2);

        ArrayList<EspecificacionTanque> catalogoTanques = new ArrayList<>();
        EspecificacionTanque et1 = new EspecificacionTanque(2, 1500, 500000);
        EspecificacionTanque et2 = new EspecificacionTanque(1, 1000, 300000);
        catalogoTanques.add(et1);
        catalogoTanques.add(et2);

        ArrayList<AlquilerRig> catalogoAlquileresRigs = new ArrayList<>();
        Rig rig1 = new Rig("1", 2, 10);
        Rig rig2 = new Rig("2", 4, 15);
        Rig rig3 = new Rig("3", 8, 20);
        catalogoAlquileresRigs.add(new AlquilerRig(60, 1, rig1));
        catalogoAlquileresRigs.add(new AlquilerRig(100, 1, rig2));
        catalogoAlquileresRigs.add(new AlquilerRig(200, 1, rig3));

        EquipoDeIngenieria equipo = new EquipoDeIngenieria(
                new EstrategiaSeleccionParcelasPorFacilidadDeExcavacion(),
                new EstrategiaExcavacionLoAntesPosible(),
                new EstrategiaConstruccionPlantaUnica(),
                new EstrategiaExtraccionTodosLosPozosHabilitados(),
                new EstrategiaReinyeccionReinyectarTodoLoAlmacenadoCuandoSeLlenaUnTanque(),
                new EstrategiaCondicionDeFinPorMaximoDiasLicitacion(2),
                new EstrategiaVentaGasVenderTodosLosDias());

        EmprendimientoPetrolifero emprendimiento = new EmprendimientoPetrolifero(
                yacimiento,
                equipo,
                catalogoPlantas,
                catalogoTanques,
                catalogoAlquileresRigs);

        Simulador sim = new Simulador(
                1000,
                3,
                100000000,
                1,
                1,
                1,
                1,
                1,
                emprendimiento);

        sim.iniciarSimulacion();

        assertEquals(2, emprendimiento.catalogoPlantasProcesadoras().size());
        assertEquals(2, emprendimiento.catalogoTanques().size());

        assertTrue(yacimiento.volumenTotalActual() == 100000000);
        assertEquals(0, yacimiento.volumenGlobalExtraido());
        assertEquals(0, yacimiento.volumenGlobalReinyectado());
        assertEquals(2, yacimiento.parcelas().size());
        assertEquals(false, yacimiento.parcelas().get(0).tienePozo());
        assertEquals(true, yacimiento.parcelas().get(1).tienePozo());

        assertEquals(yacimiento.parcelas().get(1).nombre(), yacimiento.parcelas().get(1).pozo().nombre());
        assertEquals(false, yacimiento.parcelas().get(1).pozo().valvulaPrincipalAbierta());

        assertEquals(0, emprendimiento.excavacionesActivas().size());
        assertEquals(0, emprendimiento.excavacionesPendientesDeFinalizacion().size());

        assertEquals(2, emprendimiento.catalogoAlquileresRigs().size());
        assertEquals(1, emprendimiento.alquileresDeRigsContratados().size());
        assertEquals(rig3, emprendimiento.alquileresDeRigsContratados().get(0).rigAlquilado());
        assertEquals(2, emprendimiento.alquileresDeRigsContratados().get(0).diasAlquilado());

        assertEquals(0, emprendimiento.proyectosDePlantasProcesadoras().size());
        assertEquals(0, emprendimiento.proyectosDeTanquesDeAgua().size());
        assertEquals(0, emprendimiento.proyectosDeTanquesDeGas().size());

        assertEquals(1, emprendimiento.plantasProcesadorasHabilitadas().size());
        assertEquals(1, emprendimiento.tanquesDeAguaHabilitados().size());
        assertEquals(1, emprendimiento.tanquesDeGasHabilitados().size());
        assertEquals(1, emprendimiento.plantasProcesadorasHabilitadas().get(0).tanquesDeAguaConectados().size());
        assertEquals(emprendimiento.tanquesDeAguaHabilitados().get(0),
                emprendimiento.plantasProcesadorasHabilitadas().get(0).tanquesDeAguaConectados().get(0));
        assertEquals(1, emprendimiento.plantasProcesadorasHabilitadas().get(0).tanquesDeGasConectados().size());
        assertEquals(emprendimiento.tanquesDeGasHabilitados().get(0),
                emprendimiento.plantasProcesadorasHabilitadas().get(0).tanquesDeGasConectados().get(0));


        assertEquals(sim.diasTranscurridos() * rig3.consumoCombustibleDiarioEnLitros()
                + sim.diasTranscurridos() * emprendimiento.alquileresDeRigsContratados().get(0).costoDiario()
                + ep1.costo() + 2 * et1.costo(), emprendimiento.registroContable().gastos());
        assertEquals(0.0, emprendimiento.registroContable().ingresos());
        assertEquals(emprendimiento.registroContable().ingresos() - emprendimiento.registroContable().gastos(),
                emprendimiento.registroContable().ganancia());
    }

    @org.junit.jupiter.api.Test
    void testTercerDia() {
        TipoTerreno rocoso = new TipoTerreno("rocoso", 60);
        TipoTerreno arcilloso = new TipoTerreno("arcilloso", 0);

        ArrayList<Parcela> parcelas = new ArrayList<>();
        parcelas.add(new Parcela("1", rocoso, 16, 3300));
        parcelas.add(new Parcela("2", arcilloso, 16, 3200));

        Yacimiento yacimiento = new Yacimiento(
                1,
                1,
                20000000,
                30000000,
                50000000,
                parcelas);

        ArrayList<EspecificacionPlantaProcesadora> catalogoPlantas = new ArrayList<>();
        EspecificacionPlantaProcesadora ep1 = new EspecificacionPlantaProcesadora(2, 10000, 100000);
        EspecificacionPlantaProcesadora ep2 = new EspecificacionPlantaProcesadora(1, 2000, 50000);
        catalogoPlantas.add(ep1);
        catalogoPlantas.add(ep2);

        ArrayList<EspecificacionTanque> catalogoTanques = new ArrayList<>();
        EspecificacionTanque et1 = new EspecificacionTanque(2, 1500, 500000);
        EspecificacionTanque et2 = new EspecificacionTanque(1, 1000, 300000);
        catalogoTanques.add(et1);
        catalogoTanques.add(et2);

        ArrayList<AlquilerRig> catalogoAlquileresRigs = new ArrayList<>();
        Rig rig1 = new Rig("1", 2, 10);
        Rig rig2 = new Rig("2", 4, 15);
        Rig rig3 = new Rig("3", 8, 20);
        catalogoAlquileresRigs.add(new AlquilerRig(60, 1, rig1));
        catalogoAlquileresRigs.add(new AlquilerRig(100, 1, rig2));
        catalogoAlquileresRigs.add(new AlquilerRig(200, 1, rig3));

        EquipoDeIngenieria equipo = new EquipoDeIngenieria(
                new EstrategiaSeleccionParcelasPorFacilidadDeExcavacion(),
                new EstrategiaExcavacionLoAntesPosible(),
                new EstrategiaConstruccionPlantaUnica(),
                new EstrategiaExtraccionTodosLosPozosHabilitados(),
                new EstrategiaReinyeccionReinyectarTodoLoAlmacenadoCuandoSeLlenaUnTanque(),
                new EstrategiaCondicionDeFinPorMaximoDiasLicitacion(3),
                new EstrategiaVentaGasVenderTodosLosDias());

        EmprendimientoPetrolifero emprendimiento = new EmprendimientoPetrolifero(
                yacimiento,
                equipo,
                catalogoPlantas,
                catalogoTanques,
                catalogoAlquileresRigs);

        Simulador sim = new Simulador(
                1000,
                3,
                100000000,
                1,
                1,
                1,
                1,
                1,
                emprendimiento);

        sim.iniciarSimulacion();

        assertEquals(2, emprendimiento.catalogoPlantasProcesadoras().size());
        assertEquals(2, emprendimiento.catalogoTanques().size());
        assertTrue(yacimiento.volumenGlobalExtraido() > 0);
        assertTrue(yacimiento.volumenTotalActual() < 100000000);
        assertEquals(0, yacimiento.volumenGlobalReinyectado());
        assertEquals(2, yacimiento.parcelas().size());
        assertEquals(false, yacimiento.parcelas().get(0).tienePozo());
        assertEquals(true, yacimiento.parcelas().get(1).tienePozo());

        assertEquals(yacimiento.parcelas().get(1).nombre(), yacimiento.parcelas().get(1).pozo().nombre());
        assertEquals(false, yacimiento.parcelas().get(1).pozo().valvulaPrincipalAbierta());
        assertTrue(yacimiento.parcelas().get(1).pozo().presionActual() < yacimiento.parcelas().get(1).pozo().presionInicial());

        assertEquals(0, emprendimiento.excavacionesActivas().size());
        assertEquals(0, emprendimiento.excavacionesPendientesDeFinalizacion().size());

        assertEquals(3, emprendimiento.catalogoAlquileresRigs().size());
        assertEquals(0, emprendimiento.alquileresDeRigsContratados().size());

        assertEquals(0, emprendimiento.proyectosDePlantasProcesadoras().size());
        assertEquals(0, emprendimiento.proyectosDeTanquesDeAgua().size());
        assertEquals(0, emprendimiento.proyectosDeTanquesDeGas().size());

        assertEquals(1, emprendimiento.plantasProcesadorasHabilitadas().size());
        assertEquals(1, emprendimiento.tanquesDeAguaHabilitados().size());
        assertEquals(1, emprendimiento.tanquesDeGasHabilitados().size());
        assertEquals(1, emprendimiento.plantasProcesadorasHabilitadas().get(0).tanquesDeAguaConectados().size());
        assertEquals(emprendimiento.tanquesDeAguaHabilitados().get(0),
                emprendimiento.plantasProcesadorasHabilitadas().get(0).tanquesDeAguaConectados().get(0));
        assertEquals(1, emprendimiento.plantasProcesadorasHabilitadas().get(0).tanquesDeGasConectados().size());
        assertEquals(emprendimiento.tanquesDeGasHabilitados().get(0),
                emprendimiento.plantasProcesadorasHabilitadas().get(0).tanquesDeGasConectados().get(0));


        assertEquals(2 * rig3.consumoCombustibleDiarioEnLitros()
                + 2 * emprendimiento.catalogoAlquileresRigs().get(2).costoDiario()
                + ep1.costo() + 2 * et1.costo(), emprendimiento.registroContable().gastos());
        assertTrue(emprendimiento.registroContable().ingresos() > 0);
        assertEquals(emprendimiento.registroContable().ingresos() - emprendimiento.registroContable().gastos(),
                emprendimiento.registroContable().ganancia());
    }

}