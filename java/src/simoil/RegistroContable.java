package simoil;

public class RegistroContable {
    private double ingresos = 0;
    private double gastos = 0;

    public double ingresos() {
        return ingresos;
    }

    public double gastos() {
        return gastos;
    }

    public double ganancia() {
        return ingresos() - gastos();
    }

    public void sumarIngreso(double nuevoIngreso) {
        if (nuevoIngreso < 0)
            throw new RuntimeException("El valor del ingreso debe ser no negativo.");
        ingresos += nuevoIngreso;
    }

    public void sumarGasto(double nuevoGasto) {
        if (nuevoGasto < 0)
            throw new RuntimeException("El valor del gasto debe ser no negativo.");
        gastos += nuevoGasto;
    }
}
