package simoil;


public class Tanque  {
    private String nombre;
    private double capacidadTotal;
    private double capacidadDisponible;

    public Tanque(String nombre, double capacidadTotal) {
        this.nombre = nombre;
        if (capacidadTotal <= 0)
            throw new RuntimeException("La capacidad de un tanque debe ser positiva.");
        this.capacidadTotal = capacidadTotal;
        this.capacidadDisponible = capacidadTotal;
    }

    public double capacidadTotal() {
        return capacidadTotal;
    }

    public double capacidadDisponible() {
        return capacidadDisponible;
    }

    public double volumenCargado() {
        return capacidadTotal - capacidadDisponible;
    }

    public double cargar(double volumenACargar) {
        double volumenCargado = Math.min(volumenACargar, capacidadDisponible);
        capacidadDisponible -= volumenCargado;
        return volumenCargado;
    }

    public double descargar(double volumenADescargar) {
        double volumenDescargado = Math.min(volumenADescargar, volumenCargado());
        capacidadDisponible += volumenDescargado;
        return volumenDescargado;
    }

    public double descargarTodo() {
        double volumenDescargado = volumenCargado();
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
