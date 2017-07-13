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
        this.estrategiaSeleccionParcelas = estrategiaSeleccionParcelas;
        this.estrategiaExcavacion = estrategiaExcavacion;
        this.estrategiaConstruccion = estrategiaConstruccion;
        this.estrategiaExtraccion = estrategiaExtraccion;
        this.estrategiaReinyeccion = estrategiaReinyeccion;
        this.estrategiaCondicionDeFin = estrategiaCondicionDeFin;
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
