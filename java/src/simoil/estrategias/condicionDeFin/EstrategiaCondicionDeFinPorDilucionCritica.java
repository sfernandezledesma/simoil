package simoil.estrategias.condicionDeFin;

import simoil.EmprendimientoPetrolifero;

public class EstrategiaCondicionDeFinPorDilucionCritica extends EstrategiaCondicionDeFin {
    private float porcentajeCriticoPetroleo;

    public EstrategiaCondicionDeFinPorDilucionCritica(int maximoDias, float porcentajeCriticoPetroleo) {
        super(maximoDias);
        this.porcentajeCriticoPetroleo = porcentajeCriticoPetroleo;
    }

    @Override
    boolean hayQueFinalizar(EmprendimientoPetrolifero emprendimientoPetrolifero, int diasTranscurridos) {
        return emprendimientoPetrolifero.yacimiento().composicionDeProducto().porcentajePetroleo() <= porcentajeCriticoPetroleo
                || diasTranscurridos >= maximoDias;
    }
}
