package simoil;

public class Pozo {
    private float presionInicial;
    private float presionActual;
    private boolean valvulaEstaAbierta;

    public Pozo(float presionInicial) {
    	if (presionInicial < 0) {
    		throw new RuntimeException("Presion debe ser no negativa");
    	}
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
    
    public static void main(String[] args) {
		Pozo pozo = new Pozo(20f);
		pozo.actualizarPresion(-5f);
	}
}
