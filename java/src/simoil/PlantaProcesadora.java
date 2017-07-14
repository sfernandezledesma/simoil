package simoil;

import java.util.ArrayList;

public class PlantaProcesadora {
    private float capacidadProcesamiento;
    private ArrayList<Tanque> tanquesDeAguaConectados;
    private ArrayList<Tanque> tanquesDeGasConectados;

    public PlantaProcesadora(float capacidadProcesamiento) {
        if (capacidadProcesamiento <= 0)
            throw new RuntimeException("La capacidad de procesamiento debe ser positiva.");
        this.capacidadProcesamiento = capacidadProcesamiento;
        this.tanquesDeAguaConectados = new ArrayList<>();
        this.tanquesDeGasConectados = new ArrayList<>();
    }

    public float capacidadProcesamiento() {
        return capacidadProcesamiento;
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

    //TODO procesar()
}
