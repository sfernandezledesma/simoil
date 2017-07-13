package simoil.estrategias.reinyeccion;


import javafx.util.Pair;
import simoil.EmprendimientoPetrolifero;
import simoil.Pozo;

import java.util.ArrayList;

public abstract class EstrategiaReinyeccion {

    public abstract ArrayList<Pair<Pozo, Float>> dondeYCuantoReinyectar(EmprendimientoPetrolifero emprendimientoPetrolifero);

}
