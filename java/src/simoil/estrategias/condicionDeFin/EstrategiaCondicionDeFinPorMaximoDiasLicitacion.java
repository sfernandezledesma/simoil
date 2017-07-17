package simoil.estrategias.condicionDeFin;

import simoil.EmprendimientoPetrolifero;

public class EstrategiaCondicionDeFinPorMaximoDiasLicitacion extends EstrategiaCondicionDeFin {
    private int maximoDiasLicitacion;

    public EstrategiaCondicionDeFinPorMaximoDiasLicitacion(int maximoDiasLicitacion) {
        this.maximoDiasLicitacion = maximoDiasLicitacion;
    }

    @Override
    public boolean hayQueFinalizar(EmprendimientoPetrolifero emprendimientoPetrolifero, int diasTranscurridos) {
        return diasTranscurridos >= maximoDiasLicitacion;
    }

}
