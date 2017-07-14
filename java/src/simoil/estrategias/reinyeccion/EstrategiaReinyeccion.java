package simoil.estrategias.reinyeccion;


import javafx.util.Pair;
import simoil.EmprendimientoPetrolifero;
import simoil.Pozo;

import java.util.ArrayList;

public abstract class EstrategiaReinyeccion {

    public abstract boolean hayQueReinyectar(EmprendimientoPetrolifero emprendimientoPetrolifero);

    public abstract boolean noReinyectarGas(EmprendimientoPetrolifero emprendimientoPetrolifero);

    public abstract float cuantosLitrosReinyectar(EmprendimientoPetrolifero emprendimientoPetrolifero);

}
