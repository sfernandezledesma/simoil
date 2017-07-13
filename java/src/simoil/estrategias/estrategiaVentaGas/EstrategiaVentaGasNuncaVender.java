package simoil.estrategias.estrategiaVentaGas;

import simoil.EmprendimientoPetrolifero;

public class EstrategiaVentaGasNuncaVender extends EstrategiaVentaGas {

    @Override
    public boolean hayQueVenderElGas(EmprendimientoPetrolifero emprendimientoPetrolifero) {
        return false;
    }

}
