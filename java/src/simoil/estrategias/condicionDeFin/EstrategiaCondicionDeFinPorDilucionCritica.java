package simoil.estrategias.condicionDeFin;

import simoil.EmprendimientoPetrolifero;

public class EstrategiaCondicionDeFinPorDilucionCritica extends EstrategiaCondicionDeFin {

    @Override
    public boolean hayQueFinalizar(EmprendimientoPetrolifero emprendimientoPetrolifero, int diasTranscurridos, int maximoDias, float porcentajeCriticoPetroleo) {
        return emprendimientoPetrolifero.yacimiento().composicionDeProducto().porcentajePetroleo() <= porcentajeCriticoPetroleo
                || diasTranscurridos >= maximoDias;
    }

}