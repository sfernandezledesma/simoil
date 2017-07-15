package simoil;


public class AlquilerRig {
    private float costoDiario;
    private int minimoDias;
    private Rig rig;
    private int diasAlquilado;

    public AlquilerRig(float costoDiario, int minimoDias, Rig rig) {
        this.costoDiario = costoDiario;
        this.minimoDias = minimoDias;
        this.rig = rig;
    }

    public float costoDiario() {
        return costoDiario;
    }

    public int minimoDias() {
        return minimoDias;
    }

    public Rig rig() {
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
