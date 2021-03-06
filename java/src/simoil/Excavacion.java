package simoil;

public class Excavacion {
    private String nombrePozoEnExcavacion;
    private int diaDeComienzoDeExcavacion;
    private double metrosExcavados;
    private Parcela parcelaEnExcavacion;

    public Excavacion(String nombrePozoEnExcavacion, int diaDeComienzoDeExcavacion, Parcela parcelaEnExcavacion) {
        this.nombrePozoEnExcavacion = nombrePozoEnExcavacion;
        this.diaDeComienzoDeExcavacion = diaDeComienzoDeExcavacion;
        this.metrosExcavados = 0;
        this.parcelaEnExcavacion = parcelaEnExcavacion;
    }

    public String nombrePozoEnExcavacion() {
        return nombrePozoEnExcavacion;
    }

    public int diaDeComienzoDeExcavacion() {
        return diaDeComienzoDeExcavacion;
    }

    public double metrosExcavados() {
        return metrosExcavados;
    }

    public Parcela parcelaEnExcavacion() {
        return parcelaEnExcavacion;
    }

    public boolean excavacionFinalizada() {
        return metrosExcavados == parcelaEnExcavacion.profundidadDelReservorio();
    }

    public double excavar(double metrosAExcavar) {
        if (metrosAExcavar + metrosExcavados > parcelaEnExcavacion.profundidadDelReservorio()) {
            double metrosExcavadosHastaElMomento = metrosExcavados;
            metrosExcavados = parcelaEnExcavacion.profundidadDelReservorio();
            return parcelaEnExcavacion.profundidadDelReservorio() - metrosExcavadosHastaElMomento;
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

        return parcelaEnExcavacion.equals(that.parcelaEnExcavacion);
    }

    @Override
    public int hashCode() {
        return parcelaEnExcavacion.hashCode();
    }
}
