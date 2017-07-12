package simoil;


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
