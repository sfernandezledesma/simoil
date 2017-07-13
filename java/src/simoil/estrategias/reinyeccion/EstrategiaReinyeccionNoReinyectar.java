package simoil.estrategias.reinyeccion;

import javafx.util.Pair;
import simoil.EmprendimientoPetrolifero;
import simoil.Pozo;

import java.util.ArrayList;

public class EstrategiaReinyeccionNoReinyectar extends EstrategiaReinyeccion{
    @Override
    public ArrayList<Pair<Pozo, Float>> dondeYCuantoReinyectar(EmprendimientoPetrolifero emprendimientoPetrolifero) {
        return new ArrayList<>();
    }
}
