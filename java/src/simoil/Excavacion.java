package simoil;


import java.util.ArrayList;

public class Excavacion {
    private int diaDeComienzoDeExcavacion;
    private float metrosExcavados;
    private Parcela parcelaObjetivo;
    private ArrayList<PlantaProcesadora> plantasProcesadorasDondeConectarElPozo;

    public Excavacion(int diaDeComienzoDeExcavacion, Parcela parcelaObjetivo, PlantaProcesadora plantaDondeConectar) {
        this.diaDeComienzoDeExcavacion = diaDeComienzoDeExcavacion;
        this.metrosExcavados = 0;
        this.parcelaObjetivo = parcelaObjetivo;
        if (plantaDondeConectar == null)
            throw new RuntimeException("Debe haber al menos una planta procesadora donde conectar el pozo.");
        this.plantasProcesadorasDondeConectarElPozo = new ArrayList<>();
        this.plantasProcesadorasDondeConectarElPozo.add(plantaDondeConectar);
    }

    public int diaDeComienzoDeExcavacion() {
        return diaDeComienzoDeExcavacion;
    }

    public Parcela parcelaObjetivo() {
        return parcelaObjetivo;
    }

    public boolean excavacionFinalizada() {
        return metrosExcavados == parcelaObjetivo.profundidad();
    }

    public float excavar(float metrosAExcavar) {
        if (metrosAExcavar + metrosExcavados > parcelaObjetivo.profundidad()) {
            float metrosExcavadosHastaElMomento = metrosExcavados;
            metrosExcavados = parcelaObjetivo.profundidad();
            return parcelaObjetivo.profundidad() - metrosExcavadosHastaElMomento;
        } else {
            metrosExcavados += metrosAExcavar;
            return metrosAExcavar;
        }
    }

    public void conectarPlantaProcesadora(PlantaProcesadora plantaProcesadora) {
        if (plantasProcesadorasDondeConectarElPozo.contains(plantaProcesadora))
            throw new RuntimeException("Ya existe esa planta en el plan de excavacion.");
        plantasProcesadorasDondeConectarElPozo.add(plantaProcesadora);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Excavacion that = (Excavacion) o;

        return parcelaObjetivo.equals(that.parcelaObjetivo);
    }

    @Override
    public int hashCode() {
        return parcelaObjetivo.hashCode();
    }
}
