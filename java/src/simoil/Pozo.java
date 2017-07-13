package simoil;

import java.util.ArrayList;

public class Pozo {
    private float presionInicial;
    private float presionActual;
    private boolean valvulaEstaAbierta;
    private ArrayList<PlantaProcesadora> plantasConectadas;

    public Pozo(float presionInicial, PlantaProcesadora plantaProcesadoraDondeConectar) {
    	if (presionInicial < 0) {
    		throw new RuntimeException("Presion debe ser no negativa");
    	}
    	if (plantaProcesadoraDondeConectar == null) {
            throw new RuntimeException("No puede crearse un pozo sin una planta procesadora conectada.");
        }
        this.plantasConectadas = new ArrayList<>();
        this.plantasConectadas.add(plantaProcesadoraDondeConectar);
        this.presionInicial = presionInicial;
        this.presionActual = presionInicial;
        this.valvulaEstaAbierta = false;
    }

    public void abrir() {
        valvulaEstaAbierta = true;
    }

    public void cerrar() {
        valvulaEstaAbierta = false;
    }

    public boolean valvulaEstaAbierta() {
        return valvulaEstaAbierta;
    }

    public float presionInicial() {
        return presionInicial;
    }

    public float presionActual() {
        return presionActual;
    }

    public void actualizarPresion(float nuevaPresion) {
    	if (nuevaPresion < 0) {
    		throw new RuntimeException("Presion debe ser no negativa");
    	}
    	presionActual = nuevaPresion;
    }

    public void conectarPlantaProcesadora(PlantaProcesadora plantaProcesadoraAConectar) {
        if (plantasConectadas.contains(plantaProcesadoraAConectar)) {
            throw new RuntimeException("Se intento conectar una planta ya conectada.");
        }
        plantasConectadas.add(plantaProcesadoraAConectar);
    }
    
    public static void main(String[] args) {
        Pozo pozoa = null;
        pozoa.presionInicial();
        PlantaProcesadora planta = new PlantaProcesadora(100);
		Pozo pozo = new Pozo(20f, planta);
		pozo.conectarPlantaProcesadora(planta);
	}
}
