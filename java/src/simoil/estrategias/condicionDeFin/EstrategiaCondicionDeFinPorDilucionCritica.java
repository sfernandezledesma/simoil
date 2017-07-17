package simoil.estrategias.condicionDeFin;

import simoil.EmprendimientoPetrolifero;

public class EstrategiaCondicionDeFinPorDilucionCritica extends EstrategiaCondicionDeFin {
    private float porcentajeDilucionCriticaPetroleo;

    public EstrategiaCondicionDeFinPorDilucionCritica(float porcentajeDilucionCriticaPetroleo) {
        this.porcentajeDilucionCriticaPetroleo = porcentajeDilucionCriticaPetroleo;
    }

    @Override
    public boolean hayQueFinalizar(EmprendimientoPetrolifero emprendimientoPetrolifero, int diasTranscurridos) {
        return emprendimientoPetrolifero.yacimiento().composicionDeProducto().porcentajePetroleo() <= porcentajeDilucionCriticaPetroleo;
    }

}
