package simoil;

public class Excavacion {
    private String nombrePozoEnExcavacion;
    private int diaDeComienzoDeExcavacion;
    private float metrosExcavados;
    private Parcela parcelaExcavacion;

    public Excavacion(String nombrePozoEnExcavacion, int diaDeComienzoDeExcavacion, Parcela parcelaExcavacion) {
        this.nombrePozoEnExcavacion = nombrePozoEnExcavacion;
        this.diaDeComienzoDeExcavacion = diaDeComienzoDeExcavacion;
        this.metrosExcavados = 0;
        this.parcelaExcavacion = parcelaExcavacion;
    }

    public String nombrePozoEnExcavacion() {
        return nombrePozoEnExcavacion;
    }

    public int diaDeComienzoDeExcavacion() {
        return diaDeComienzoDeExcavacion;
    }

    public Parcela parcelaExcavacion() {
        return parcelaExcavacion;
    }

    public boolean excavacionFinalizada() {
        return metrosExcavados == parcelaExcavacion.profundidadDelReservorio();
    }

    public float excavar(float metrosAExcavar) {
        if (metrosAExcavar + metrosExcavados > parcelaExcavacion.profundidadDelReservorio()) {
            float metrosExcavadosHastaElMomento = metrosExcavados;
            metrosExcavados = parcelaExcavacion.profundidadDelReservorio();
            return parcelaExcavacion.profundidadDelReservorio() - metrosExcavadosHastaElMomento;
        } else {
            metrosExcavados += metrosAExcavar;
            return metrosAExcavar;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Excavacion that = (Excavacion) o;

        return parcelaExcavacion.equals(that.parcelaExcavacion);
    }

    @Override
    public int hashCode() {
        return parcelaExcavacion.hashCode();
    }
}
