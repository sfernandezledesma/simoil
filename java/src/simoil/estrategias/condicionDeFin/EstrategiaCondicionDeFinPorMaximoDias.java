package simoil.estrategias.condicionDeFin;

import simoil.EmprendimientoPetrolifero;

public class EstrategiaCondicionDeFinPorMaximoDias extends EstrategiaCondicionDeFin {

    @Override
    public boolean hayQueFinalizar(EmprendimientoPetrolifero emprendimientoPetrolifero, int diasTranscurridos, int maximoDias, double porcentajeCriticoPetroleo) {
        return diasTranscurridos >= maximoDias;
    }

}
