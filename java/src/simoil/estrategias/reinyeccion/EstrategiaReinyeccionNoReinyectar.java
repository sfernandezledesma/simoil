package simoil.estrategias.reinyeccion;

import simoil.EmprendimientoPetrolifero;

public class EstrategiaReinyeccionNoReinyectar extends EstrategiaReinyeccion{
    @Override
    public float calcularTotalLitrosReinyeccion(EmprendimientoPetrolifero emprendimientoPetrolifero, float volumenMaximoReinyeccionEnUnDia) {
        return 0;
    }
}
