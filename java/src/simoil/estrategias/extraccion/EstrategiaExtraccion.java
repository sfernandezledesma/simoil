package simoil.estrategias.extraccion;


import simoil.EmprendimientoPetrolifero;
import simoil.Pozo;

import java.util.ArrayList;

public abstract class EstrategiaExtraccion {

    public abstract ArrayList<Pozo> pozosDondeExtraer(EmprendimientoPetrolifero emprendimientoPetrolifero);
}
