package simoil;


public class Rig {
    private String nombre;
    private double poderExcavacionEnMetros;
    private double consumoCombustibleDiarioEnLitros;
    private boolean estaExcavando;

    public Rig(String nombre, double poderExcavacionEnMetros, double consumoCombustibleDiarioEnLitros) {
        this.nombre = nombre;
        this.estaExcavando = false;
        this.poderExcavacionEnMetros = poderExcavacionEnMetros;
        this.consumoCombustibleDiarioEnLitros = consumoCombustibleDiarioEnLitros;
    }

    public double excavar(Excavacion excavacion) {
        double metrosExcavados = 0;
        if (!estaExcavando) {
            estaExcavando = true;
            double resistenciaEnPorcentaje = excavacion.parcelaEnExcavacion().tipoTerreno().resistenciaALaExcavacionEnPorcentaje();
            double multiplicadorExcavacion = 1 - resistenciaEnPorcentaje / 100;
            double metrosAExcavar = multiplicadorExcavacion * poderExcavacionEnMetros;
            metrosExcavados = excavacion.excavar(metrosAExcavar);
        } else {
            throw new RuntimeException("Se intento excavar con un rig que ya estaba excavando.");
        }
        return metrosExcavados;
    }

    public void apagar() {
        estaExcavando = false;
    }

    public double poderExcavacionEnMetros() {
        return poderExcavacionEnMetros;
    }

    public boolean estaExcavando() {
        return estaExcavando;
    }

    public double consumoCombustibleDiarioEnLitros() {
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
