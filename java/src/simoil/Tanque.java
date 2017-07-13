package simoil;


public class Tanque  {
    private float capacidadTotal;
    private float capacidadDisponible;

    public Tanque(float capacidadTotal) {
        if (capacidadTotal <= 0)
            throw new RuntimeException("La capacidad de un tanque debe ser positiva.");
        this.capacidadTotal = capacidadTotal;
        this.capacidadDisponible = capacidadTotal;
    }

    public float capacidadTotal() {
        return capacidadTotal;
    }

    public float capacidadDisponible() {
        return capacidadDisponible;
    }

    public float volumenCargado() {
        return capacidadTotal - capacidadDisponible;
    }

    public float cargar(float volumenACargar) {
        float volumenCargado = Math.min(volumenACargar, capacidadDisponible);
        capacidadDisponible -= volumenCargado;
        return volumenCargado;
    }

    public float descargar(float volumenADescargar) {
        float volumenDescargado = Math.min(volumenADescargar, volumenCargado());
        capacidadDisponible += volumenDescargado;
        return volumenDescargado;
    }

    public float descargarTodo() {
        float volumenDescargado = volumenCargado();
        capacidadDisponible = capacidadTotal;
        return volumenDescargado;
    }

}
