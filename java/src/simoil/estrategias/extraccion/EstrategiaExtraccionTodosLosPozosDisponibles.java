package simoil.estrategias.extraccion;

import simoil.EmprendimientoPetrolifero;
import simoil.Parcela;
import simoil.Pozo;

import java.util.ArrayList;

public class EstrategiaExtraccionTodosLosPozosDisponibles extends EstrategiaExtraccion {
    @Override
    public ArrayList<Pozo> pozosDondeExtraer(EmprendimientoPetrolifero emprendimientoPetrolifero) {
        ArrayList<Parcela> parcelas = emprendimientoPetrolifero.yacimiento().parcelas();
        ArrayList<Pozo> pozos = new ArrayList<>();
        for (Parcela parcela : parcelas) {
            if (parcela.tienePozo())
                pozos.add(parcela.pozo());
        }
        return pozos;
    }
}
