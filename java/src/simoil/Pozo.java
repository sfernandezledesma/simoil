package simoil;

import java.util.ArrayList;

public class Pozo {
    private String nombre;
    private double presionInicial;
    private double presionActual;
    private boolean valvulaPrincipalAbierta;
    private ArrayList<PlantaProcesadora> plantasConectadas;

    public Pozo(String nombre, double presionInicial, PlantaProcesadora plantaProcesadoraDondeConectar) {
    	if (presionInicial < 0) {
    		throw new RuntimeException("La presion de un pozo debe ser no negativa");
    	}
    	if (plantaProcesadoraDondeConectar == null) {
            throw new RuntimeException("No puede crearse un pozo sin una planta procesadora conectada.");
        }
        this.nombre = nombre;
        this.plantasConectadas = new ArrayList<>();
        this.plantasConectadas.add(plantaProcesadoraDondeConectar);
        this.presionInicial = presionInicial;
        this.presionActual = presionInicial;
        this.valvulaPrincipalAbierta = false;
    }

    public String nombre(){
        return this.nombre;
    }

    public void abrirValvulaPrincipal() {
        valvulaPrincipalAbierta = true;
    }

    public void cerrarValvulaPrincipal() {
        valvulaPrincipalAbierta = false;
    }

    public boolean valvulaPrincipalAbierta() {
        return valvulaPrincipalAbierta;
    }

    public double presionInicial() {
        return presionInicial;
    }

    public double presionActual() {
        return presionActual;
    }

    public void actualizarPresion(double nuevaPresion) {
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

    public ArrayList<PlantaProcesadora> plantasProcesadorasConectadas() {
        return plantasConectadas;
    }
}
