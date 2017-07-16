package simoil.estrategias.reinyeccion;

import simoil.EmprendimientoPetrolifero;

public class EstrategiaReinyeccionNoReinyectar extends EstrategiaReinyeccion{
    @Override
    public double calcularTotalLitrosReinyeccion(EmprendimientoPetrolifero emprendimientoPetrolifero, double volumenMaximoReinyeccionEnUnDia) {
        return 0;
    }
}
