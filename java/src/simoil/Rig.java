package simoil;


public class Rig {
    private String nombre;
    private float poderExcavacion;
    private float consumoCombustibleDiarioEnLitros;
    private boolean estaExcavando;

    public Rig(String nombre, float poderExcavacion, float consumoCombustibleDiarioEnLitros) {
        this.nombre = nombre;
        this.estaExcavando = false;
        this.poderExcavacion = poderExcavacion;
        this.consumoCombustibleDiarioEnLitros = consumoCombustibleDiarioEnLitros;
    }

    public Rig(String nombre, Rig otroRig) {
        this(nombre, otroRig.poderExcavacion(), otroRig.consumoCombustibleDiarioEnLitros());
    }

    public float excavar(Excavacion excavacion) {
        float metrosExcavados = 0;
        if (!estaExcavando) {
            estaExcavando = true;
            float resistenciaEnPorcentaje = excavacion.parcelaEnExcavacion().tipoTerreno().resistenciaALaExcavacionEnPorcentaje();
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

    public String nombre(){
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rig rig = (Rig) o;

        return nombre.equals(rig.nombre);
    }
}
