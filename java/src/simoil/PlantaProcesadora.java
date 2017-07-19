package simoil;

import java.util.ArrayList;

public class PlantaProcesadora {
    String nombre;
    private double capacidadProcesamientoTotal;
    private ArrayList<Tanque> tanquesDeAguaConectados;
    private ArrayList<Tanque> tanquesDeGasConectados;
    private double volumenProcesadoEnElDia = 0;

    public PlantaProcesadora(String nombre, double capacidadProcesamientoTotal) {
        this.nombre = nombre;
        if (capacidadProcesamientoTotal <= 0)
            throw new RuntimeException("La capacidad de procesamiento debe ser positiva.");
        this.capacidadProcesamientoTotal = capacidadProcesamientoTotal;
        this.tanquesDeAguaConectados = new ArrayList<>();
        this.tanquesDeGasConectados = new ArrayList<>();
    }

    public String nombre(){
        return this.nombre;
    }

    public void apagar() {
        volumenProcesadoEnElDia = 0;
    }

    public double capacidadProcesamientoTotal() {
        return capacidadProcesamientoTotal;
    }

    public double capacidadProcesamientoDisponible() {
        return capacidadProcesamientoTotal - volumenProcesadoEnElDia;
    }

    public ArrayList<Tanque> tanquesDeAguaConectados() {
        return tanquesDeAguaConectados;
    }

    public ArrayList<Tanque> tanquesDeGasConectados() {
        return tanquesDeGasConectados;
    }

    public void conectarTanqueDeAgua(Tanque tanqueDeAgua) {
        tanquesDeAguaConectados.add(tanqueDeAgua);
    }

    public void conectarTanqueDeGas(Tanque tanqueDeGas) {
        tanquesDeGasConectados.add(tanqueDeGas);
    }

    public double procesarProducto(double volumenProducto, EmprendimientoPetrolifero emprendimientoPetrolifero) {
        ComposicionDeProducto composicion = emprendimientoPetrolifero.yacimiento().composicionDeProducto();
        ArrayList<Tanque> tanquesDeAguaHabilitados = emprendimientoPetrolifero.tanquesDeAguaHabilitados();
        ArrayList<Tanque> tanquesDeGasHabilitados = emprendimientoPetrolifero.tanquesDeGasHabilitados();
        double volumenTotalProcesado = 0;
        if (capacidadProcesamientoDisponible() > 0) {
            double potencialVolumenProcesadoTotal = Math.min(capacidadProcesamientoDisponible(), volumenProducto);
            double proporcionAgua = composicion.porcentajeAgua() / 100;
            double proporcionGas = composicion.porcentajeGas() / 100;
            double potencialVolumenAguaProcesada = potencialVolumenProcesadoTotal * proporcionAgua;
            double potencialVolumenGasProcesado = potencialVolumenProcesadoTotal * proporcionGas;
            double maximoVolumenAguaAlmacenable = 0;
            double maximoVolumenGasAlmacenable = 0;
            ArrayList<Tanque> tanquesDeAguaDisponibles = new ArrayList<>();
            ArrayList<Tanque> tanquesDeGasDisponibles = new ArrayList<>();
            for (Tanque tanqueDeAguaConectado : tanquesDeAguaConectados) {
                if (emprendimientoPetrolifero.tanqueDeAguaHabilitado(tanqueDeAguaConectado.nombre())) {
                    tanquesDeAguaDisponibles.add(tanqueDeAguaConectado);
                }
            }
            for (Tanque tanqueDeGasConectado : tanquesDeGasConectados) {
                if (emprendimientoPetrolifero.tanqueDeGasHabilitado(tanqueDeGasConectado.nombre())) {
                    tanquesDeGasDisponibles.add(tanqueDeGasConectado);
                }
            }

            for (Tanque tanqueDeAguaDisponible : tanquesDeAguaDisponibles) {
                maximoVolumenAguaAlmacenable += tanqueDeAguaDisponible.capacidadDisponible();
            }
            double volumenAguaProcesadoAcotandoPorAguaAlmacenable = Math.min(potencialVolumenAguaProcesada, maximoVolumenAguaAlmacenable);
            double volumenTotalProcesadoAcotandoPorAguaAlmacenable = volumenAguaProcesadoAcotandoPorAguaAlmacenable / proporcionAgua;
            double volumenGasProcesadoAcotandoPorAguaAlmacenable = volumenTotalProcesadoAcotandoPorAguaAlmacenable * proporcionGas;

            for (Tanque tanqueDeGasDisponible : tanquesDeGasDisponibles) {
                maximoVolumenGasAlmacenable += tanqueDeGasDisponible.capacidadDisponible();
            }
            double volumenGasProcesadoAcotandoPorGasAlmacenable = Math.min(potencialVolumenGasProcesado, maximoVolumenGasAlmacenable);
            double volumenTotalProcesadoAcotandoPorGasAlmacenable = volumenGasProcesadoAcotandoPorGasAlmacenable / proporcionGas;
            double volumenAguaProcesadoAcotandoPorGasAlmacenable = volumenTotalProcesadoAcotandoPorGasAlmacenable * proporcionAgua;

            if (potencialVolumenAguaProcesada == 0) {
                // No hay agua para procesar, procesamos la mayor cantidad de gas que podamos
                volumenProcesadoEnElDia += volumenTotalProcesadoAcotandoPorGasAlmacenable;
                volumenTotalProcesado = volumenTotalProcesadoAcotandoPorGasAlmacenable;
                // Almaceno gas
                for (Tanque tanqueDeGasDisponible : tanquesDeGasDisponibles) {
                    if (volumenGasProcesadoAcotandoPorGasAlmacenable > 0)
                        volumenGasProcesadoAcotandoPorGasAlmacenable -= tanqueDeGasDisponible.cargar(volumenGasProcesadoAcotandoPorGasAlmacenable);
                }
            } else if (potencialVolumenGasProcesado == 0) {
                // No hay gas para procesar, procesamos la mayor cantidad de agua que podamos
                volumenProcesadoEnElDia += volumenTotalProcesadoAcotandoPorAguaAlmacenable;
                volumenTotalProcesado = volumenTotalProcesadoAcotandoPorAguaAlmacenable;
                // Almaceno agua
                for (Tanque tanqueDeAguaDisponible : tanquesDeAguaDisponibles) {
                    if (volumenAguaProcesadoAcotandoPorAguaAlmacenable > 0)
                        volumenAguaProcesadoAcotandoPorAguaAlmacenable -= tanqueDeAguaDisponible.cargar(volumenAguaProcesadoAcotandoPorAguaAlmacenable);
                }
            } else {
                // Tenemos que comparar cuanto gas y cuanta agua podemos almacenar y acotar por alguna de las dos
                if (volumenGasProcesadoAcotandoPorAguaAlmacenable > maximoVolumenGasAlmacenable) {
                    // No puedo acotar por agua almacenable porque no puedo almacenar el gas, tengo que acotar por gas
                    volumenProcesadoEnElDia += volumenTotalProcesadoAcotandoPorGasAlmacenable;
                    volumenTotalProcesado = volumenTotalProcesadoAcotandoPorGasAlmacenable;
                    // Almaceno agua
                    for (Tanque tanqueDeAguaDisponible : tanquesDeAguaDisponibles) {
                        if (volumenAguaProcesadoAcotandoPorGasAlmacenable > 0)
                            volumenAguaProcesadoAcotandoPorGasAlmacenable -= tanqueDeAguaDisponible.cargar(volumenAguaProcesadoAcotandoPorGasAlmacenable);
                    }
                    // Almaceno gas
                    for (Tanque tanqueDeGasDisponible : tanquesDeGasDisponibles) {
                        if (volumenGasProcesadoAcotandoPorGasAlmacenable > 0)
                            volumenGasProcesadoAcotandoPorGasAlmacenable -= tanqueDeGasDisponible.cargar(volumenGasProcesadoAcotandoPorGasAlmacenable);
                    }
                } else {
                    // Proceso acotando por agua almacenable
                    volumenProcesadoEnElDia += volumenTotalProcesadoAcotandoPorAguaAlmacenable;
                    volumenTotalProcesado = volumenTotalProcesadoAcotandoPorAguaAlmacenable;
                    // Almaceno agua
                    for (Tanque tanqueDeAguaDisponible : tanquesDeAguaDisponibles) {
                        if (volumenAguaProcesadoAcotandoPorAguaAlmacenable > 0)
                            volumenAguaProcesadoAcotandoPorAguaAlmacenable -= tanqueDeAguaDisponible.cargar(volumenAguaProcesadoAcotandoPorAguaAlmacenable);
                    }
                    // Almaceno gas
                    for (Tanque tanqueDeGasDisponible : tanquesDeGasDisponibles) {
                        if (volumenGasProcesadoAcotandoPorAguaAlmacenable > 0)
                            volumenGasProcesadoAcotandoPorAguaAlmacenable -= tanqueDeGasDisponible.cargar(volumenGasProcesadoAcotandoPorAguaAlmacenable);
                    }
                }
            }
        }
        return volumenTotalProcesado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlantaProcesadora that = (PlantaProcesadora) o;

        return nombre.equals(that.nombre);
    }

}
