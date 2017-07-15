package simoil;

public class RegistroContable {
    private float ingresos = 0;
    private float gastos = 0;

    public float ingresos() {
        return ingresos;
    }

    public float gastos() {
        return gastos;
    }

    public float ganancia() {
        return ingresos() - gastos();
    }

    public void sumarIngreso(float nuevoIngreso) {
        if (nuevoIngreso < 0)
            throw new RuntimeException("El valor del ingreso debe ser no negativo.");
        ingresos += nuevoIngreso;
    }

    public void sumarGasto(float nuevoGasto) {
        if (nuevoGasto < 0)
            throw new RuntimeException("El valor del gasto debe ser no negativo.");
        gastos += nuevoGasto;
    }
}
