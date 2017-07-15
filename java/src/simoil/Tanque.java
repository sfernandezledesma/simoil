package simoil;


public class Tanque  {
    private String nombre;
    private float capacidadTotal;
    private float capacidadDisponible;

    public Tanque(String nombre, float capacidadTotal) {
        this.nombre = nombre;
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

    public String nombre(){
        return this.nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tanque tanque = (Tanque) o;

        return nombre.equals(tanque.nombre);
    }

}
