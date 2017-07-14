package simoil.estrategias.reinyeccion;

import javafx.util.Pair;
import simoil.EmprendimientoPetrolifero;
import simoil.Pozo;

import java.util.ArrayList;

public class EstrategiaReinyeccionNoReinyectar extends EstrategiaReinyeccion{
    @Override
    public boolean hayQueReinyectar(EmprendimientoPetrolifero emprendimientoPetrolifero) {
        return false;
    }

    @Override
    public boolean noReinyectarGas(EmprendimientoPetrolifero emprendimientoPetrolifero) {
        return true;
    }

    @Override
    public float cuantosLitrosReinyectar(EmprendimientoPetrolifero emprendimientoPetrolifero) {
        return 0;
    }
}
