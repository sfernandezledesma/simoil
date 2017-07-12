package simoil;

/**
 * Created by Sebastian on 11/07/2017.
 */
public class PlanDeExcavacion {
    private int diaDeComienzoDeExcavacion;
    private Parcela parcelaObjetivo;

    public PlanDeExcavacion(int diaDeComienzoDeExcavacion, Parcela parcelaObjetivo) {
        this.diaDeComienzoDeExcavacion = diaDeComienzoDeExcavacion;
        this.parcelaObjetivo = parcelaObjetivo;
    }

    public int diaDeComienzoDeExcavacion() {
        return diaDeComienzoDeExcavacion;
    }

    public Parcela parcelaObjetivo() {
        return parcelaObjetivo;
    }
}
