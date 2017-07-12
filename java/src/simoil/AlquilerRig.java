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

    public AlquilerRig(AlquilerRig otroAlquiler) {
        this(otroAlquiler.costoDiario(), otroAlquiler.minimoDias(), new Rig(otroAlquiler.rig()));
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
}
