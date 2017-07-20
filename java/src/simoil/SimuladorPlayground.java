package simoil;

import simoil.*;
import simoil.estrategias.condicionDeFin.EstrategiaCondicionDeFinPorMaximoDiasLicitacion;
import simoil.estrategias.construccion.EstrategiaConstruccionTantasPlantasYTanquesComoParcelas;
import simoil.estrategias.estrategiaVentaGas.EstrategiaVentaGasVenderTodosLosDias;
import simoil.estrategias.excavacion.EstrategiaExcavacionCadaTresDiasAlquilandoUnSoloRig;
import simoil.estrategias.extraccion.EstrategiaExtraccionNPozosConMayorPresion;
import simoil.estrategias.reinyeccion.EstrategiaReinyeccionReinyectarTodoLoAlmacenadoCuandoSeLlenaUnTanque;
import simoil.estrategias.seleccionParcelas.EstrategiaSeleccionParcelasPorFacilidadDeExcavacion;

import java.util.ArrayList;

public class SimuladorPlayground {
    public static void main(String[] args) {
        TipoTerreno rocoso = new TipoTerreno("rocoso", 60);
        TipoTerreno arcilloso = new TipoTerreno("arcilloso", -10);
        ArrayList<Parcela> parcelas = new ArrayList<>();
        parcelas.add(new Parcela("1", rocoso, 10, 3300));
        parcelas.add(new Parcela("2", rocoso, 20, 3250));
        parcelas.add(new Parcela("3", arcilloso, 30, 3400));
        parcelas.add(new Parcela("4", rocoso, 10, 3400));
        parcelas.add(new Parcela("5", rocoso, 10, 3500));
        parcelas.add(new Parcela("6", arcilloso, 20, 3333));
        /*for (int i = 7; i <= 30; i++) {
            parcelas.add(new Parcela(Integer.toString(i), arcilloso, 20, 3333));
        }*/

        Yacimiento yacimiento = new Yacimiento(
                0.6,
                0.05,
                20000000,
                30000000,
                50000000,
                parcelas);

        ArrayList<EspecificacionPlantaProcesadora> catalogoPlantas = new ArrayList<>();
        catalogoPlantas.add(new EspecificacionPlantaProcesadora(10, 10000, 100000));
        catalogoPlantas.add(new EspecificacionPlantaProcesadora(5, 2000, 50000));
        ArrayList<EspecificacionTanque> catalogoTanques = new ArrayList<>();
        catalogoTanques.add(new EspecificacionTanque(3, 1500, 500000));
        catalogoTanques.add(new EspecificacionTanque(2, 1000, 300000));
        ArrayList<AlquilerRig> catalogoAlquileresRigs = new ArrayList<>();
        catalogoAlquileresRigs.add(new AlquilerRig(60, 3, new Rig("1", 2, 10)));
        catalogoAlquileresRigs.add(new AlquilerRig(100, 5, new Rig("2", 4, 15)));
        catalogoAlquileresRigs.add(new AlquilerRig(200, 5, new Rig("3", 8, 20)));
        catalogoAlquileresRigs.add(new AlquilerRig(220, 7, new Rig("4", 8, 21)));

        EquipoDeIngenieria equipo = new EquipoDeIngenieria(
                new EstrategiaSeleccionParcelasPorFacilidadDeExcavacion(),
                new EstrategiaExcavacionCadaTresDiasAlquilandoUnSoloRig(),
                new EstrategiaConstruccionTantasPlantasYTanquesComoParcelas(),
                new EstrategiaExtraccionNPozosConMayorPresion(1),
                new EstrategiaReinyeccionReinyectarTodoLoAlmacenadoCuandoSeLlenaUnTanque(),//new EstrategiaReinyeccionPorBajaPresionDePozo(3000),
                new EstrategiaCondicionDeFinPorMaximoDiasLicitacion(100),
                new EstrategiaVentaGasVenderTodosLosDias());
        EmprendimientoPetrolifero emprendimiento = new EmprendimientoPetrolifero(yacimiento, equipo, catalogoPlantas, catalogoTanques, catalogoAlquileresRigs);
        Simulador sim = new Simulador(
                1000,
                3,
                100000000,
                20,
                10,
                0.1,
                0.22,
                0.03,
                emprendimiento);

        sim.iniciarSimulacion();
    }
}
