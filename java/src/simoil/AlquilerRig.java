package simoil;


public class AlquilerRig {
    private double costoDiario;
    private int minimoDias;
    private Rig rig;
    private int diasAlquilado;

    public AlquilerRig(double costoDiario, int minimoDias, Rig rig) {
        this.costoDiario = costoDiario;
        this.minimoDias = minimoDias;
        this.rig = rig;
        this.diasAlquilado = 0;
    }

    public void finalizarAlquiler() {
        if (diasAlquilado() < minimoDiasAlquilado()) {
            throw new RuntimeException("No se puede finalizar un alquiler antes del minimo de dias.");
        }
        this.diasAlquilado = 0;
    }

    public double costoDiario() {
        return costoDiario;
    }

    public int minimoDiasAlquilado() {
        return minimoDias;
    }

    public Rig rigAlquilado() {
        return rig;
    }

    public int diasAlquilado() {
        return diasAlquilado;
    }

    public void avanzarUnDia() {
        diasAlquilado = diasAlquilado + 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlquilerRig that = (AlquilerRig) o;

        return rig.equals(that.rig);
    }

    @Override
    public int hashCode() {
        return rig.hashCode();
    }
}
