package simoil;

public class Excavacion {
    private int diaDeComienzoDeExcavacion;
    private float metrosExcavados;
    private Parcela parcelaExcavacion;

    public Excavacion(int diaDeComienzoDeExcavacion, Parcela parcelaExcavacion, PlantaProcesadora plantaDondeConectar) {
        this.diaDeComienzoDeExcavacion = diaDeComienzoDeExcavacion;
        this.metrosExcavados = 0;
        this.parcelaExcavacion = parcelaExcavacion;
        if (plantaDondeConectar == null)
            throw new RuntimeException("Debe haber al menos una planta procesadora donde conectar el pozo.");
        this.parcelaExcavacion.comenzarExcavacionNuevoPozo(plantaDondeConectar);
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
