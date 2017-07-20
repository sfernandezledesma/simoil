package simoil.estrategias.condicionDeFin;

import simoil.EmprendimientoPetrolifero;

public class EstrategiaCondicionDeFinPorDilucionCritica extends EstrategiaCondicionDeFin {
    private float porcentajeDilucionCriticaPetroleo;

    public EstrategiaCondicionDeFinPorDilucionCritica(float porcentajeDilucionCriticaPetroleo) {
        if (porcentajeDilucionCriticaPetroleo < 0 || porcentajeDilucionCriticaPetroleo > 100) {
            throw new RuntimeException("El porcentaje de dilucion critica de petroleo debe estar en el intervalo [0,100].");
        }
        this.porcentajeDilucionCriticaPetroleo = porcentajeDilucionCriticaPetroleo;
    }

    @Override
    public boolean hayQueFinalizar(EmprendimientoPetrolifero emprendimientoPetrolifero, int diasTranscurridos) {
        return emprendimientoPetrolifero.yacimiento().composicionDeProducto().porcentajePetroleo() <= porcentajeDilucionCriticaPetroleo;
    }

}
