package simoil;

/**
 * Created by Sebastian on 11/07/2017.
 */
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

    public float excavarParcela(Parcela parcela) {
        float metrosExcavados = 0;
        if (!estaExcavando) {
            estaExcavando = true;
            float resistenciaEnPorcentaje = parcela.tipoTerreno().resistenciaALaExcavacionEnPorcentaje();
            float multiplicadorExcavacion = 1 - resistenciaEnPorcentaje / 100;
            float metrosAExcavar = multiplicadorExcavacion * poderExcavacion;
            metrosExcavados = parcela.excavar(metrosAExcavar);
        }
        return metrosExcavados;
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
