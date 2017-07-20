package simoil;

import simoil.estrategias.condicionDeFin.EstrategiaCondicionDeFin;
import simoil.estrategias.construccion.EstrategiaConstruccion;
import simoil.estrategias.estrategiaVentaGas.EstrategiaVentaGas;
import simoil.estrategias.excavacion.EstrategiaExcavacion;
import simoil.estrategias.extraccion.EstrategiaExtraccion;
import simoil.estrategias.reinyeccion.EstrategiaReinyeccion;
import simoil.estrategias.seleccionParcelas.EstrategiaSeleccionParcelas;

public class EquipoDeIngenieria {
    private EstrategiaSeleccionParcelas estrategiaSeleccionParcelas;
    private EstrategiaExcavacion estrategiaExcavacion;
    private EstrategiaConstruccion estrategiaConstruccion;
    private EstrategiaExtraccion estrategiaExtraccion;
    private EstrategiaReinyeccion estrategiaReinyeccion;
    private EstrategiaCondicionDeFin estrategiaCondicionDeFin;
    private EstrategiaVentaGas estrategiaVentaGas;

    public EquipoDeIngenieria(EstrategiaSeleccionParcelas estrategiaSeleccionParcelas, EstrategiaExcavacion estrategiaExcavacion, EstrategiaConstruccion estrategiaConstruccion, EstrategiaExtraccion estrategiaExtraccion, EstrategiaReinyeccion estrategiaReinyeccion, EstrategiaCondicionDeFin estrategiaCondicionDeFin, EstrategiaVentaGas estrategiaVentaGas) {
        if (estrategiaSeleccionParcelas == null) {
            throw new RuntimeException("El equipo de ingenieria debe conocer una estrategia de seleccion de parcelas.");
        }
        this.estrategiaSeleccionParcelas = estrategiaSeleccionParcelas;

        if (estrategiaExcavacion == null) {
            throw new RuntimeException("El equipo de ingenieria debe conocer una estrategia de excavacion.");
        }
        this.estrategiaExcavacion = estrategiaExcavacion;

        if (estrategiaConstruccion == null) {
            throw new RuntimeException("El equipo de ingenieria debe conocer una estrategia de construccion.");
        }
        this.estrategiaConstruccion = estrategiaConstruccion;

        if (estrategiaExtraccion == null) {
            throw new RuntimeException("El equipo de ingenieria debe conocer una estrategia de extraccion.");
        }
        this.estrategiaExtraccion = estrategiaExtraccion;

        if (estrategiaReinyeccion == null) {
            throw new RuntimeException("El equipo de ingenieria debe conocer una estrategia de reinyeccion.");
        }
        this.estrategiaReinyeccion = estrategiaReinyeccion;

        if (estrategiaCondicionDeFin == null) {
            throw new RuntimeException("El equipo de ingenieria debe conocer una estrategia de condicion de fin.");
        }
        this.estrategiaCondicionDeFin = estrategiaCondicionDeFin;

        if (estrategiaVentaGas == null) {
            throw new RuntimeException("El equipo de ingenieria debe conocer una estrategia de venta de gas.");
        }
        this.estrategiaVentaGas = estrategiaVentaGas;
    }

    public EstrategiaSeleccionParcelas estrategiaSeleccionParcelas() {
        return estrategiaSeleccionParcelas;
    }

    public EstrategiaExcavacion estrategiaExcavacion() {
        return estrategiaExcavacion;
    }

    public EstrategiaConstruccion estrategiaConstruccion() {
        return estrategiaConstruccion;
    }

    public EstrategiaExtraccion estrategiaExtraccion() {
        return estrategiaExtraccion;
    }

    public EstrategiaReinyeccion estrategiaReinyeccion() {
        return estrategiaReinyeccion;
    }

    public EstrategiaCondicionDeFin estrategiaCondicionDeFin() {
        return estrategiaCondicionDeFin;
    }

    public EstrategiaVentaGas estrategiaVentaGas() {
        return estrategiaVentaGas;
    }
}
