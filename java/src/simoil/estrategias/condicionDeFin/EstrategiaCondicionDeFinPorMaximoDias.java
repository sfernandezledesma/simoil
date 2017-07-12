package simoil.estrategias.condicionDeFin;

import simoil.EmprendimientoPetrolifero;

public class EstrategiaCondicionDeFinPorMaximoDias extends EstrategiaCondicionDeFin {
    public EstrategiaCondicionDeFinPorMaximoDias(int maximoDias) {
        super(maximoDias);
    }

    @Override
    boolean hayQueFinalizar(EmprendimientoPetrolifero emprendimientoPetrolifero, int diasTranscurridos) {
        return diasTranscurridos >= maximoDias;
    }
}
