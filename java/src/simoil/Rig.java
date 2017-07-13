package simoil;


public class Rig {
    private float poderExcavacion;
    private float consumoCombustibleDiarioEnLitros;
    private boolean estaExcavando;

    public Rig(float poderExcavacion, float consumoCombustibleDiarioEnLitros) {
        this.estaExcavando = false;
        this.poderExcavacion = poderExcavacion;
        this.consumoCombustibleDiarioEnLitros = consumoCombustibleDiarioEnLitros;
    }

    public Rig(Rig otroRig) {
        this(otroRig.poderExcavacion(), otroRig.consumoCombustibleDiarioEnLitros());
    }

    public float excavar(Excavacion excavacion) {
        float metrosExcavados = 0;
        if (!estaExcavando) {
            estaExcavando = true;
            float resistenciaEnPorcentaje = excavacion.parcelaObjetivo().tipoTerreno().resistenciaALaExcavacionEnPorcentaje();
            float multiplicadorExcavacion = 1 - resistenciaEnPorcentaje / 100;
            float metrosAExcavar = multiplicadorExcavacion * poderExcavacion;
            metrosExcavados = excavacion.excavar(metrosAExcavar);
        } else {
            throw new RuntimeException("El Rig ya esta excavando.");
        }
        return metrosExcavados;
    }

    public void apagar() {
        estaExcavando = false;
    }

    public float poderExcavacion() {
        return poderExcavacion;
    }

    public boolean estaExcavando() {
        return estaExcavando;
    }

    public float consumoCombustibleDiarioEnLitros() {
        return consumoCombustibleDiarioEnLitros;
    }
}
