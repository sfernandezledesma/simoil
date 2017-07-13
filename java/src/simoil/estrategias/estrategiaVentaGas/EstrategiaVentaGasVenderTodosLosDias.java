package simoil.estrategias.estrategiaVentaGas;

import simoil.EmprendimientoPetrolifero;

public class EstrategiaVentaGasVenderTodosLosDias extends EstrategiaVentaGas {

    @Override
    public boolean hayQueVenderElGas(EmprendimientoPetrolifero emprendimientoPetrolifero) {
        return true;
    }

}
