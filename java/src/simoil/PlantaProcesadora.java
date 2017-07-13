package simoil;

import java.util.ArrayList;


public class PlantaProcesadora {
    private float capacidadProcesamiento;
    private ArrayList<Pozo> pozosConectados;
    private ArrayList<Tanque> tanquesDeAguaConectados;
    private ArrayList<Tanque> tanquesDeGasConectados;

    public PlantaProcesadora(float capacidadProcesamiento) {
        this.capacidadProcesamiento = capacidadProcesamiento;
        this.pozosConectados = new ArrayList<>();
        this.tanquesDeAguaConectados = new ArrayList<>();
        this.tanquesDeGasConectados = new ArrayList<>();
    }

    public float capacidadProcesamiento() {
        return capacidadProcesamiento;
    }

    public ArrayList<Pozo> pozosConectados() {
        return pozosConectados;
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
