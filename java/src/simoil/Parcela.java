package simoil;

import java.util.ArrayList;

public class Parcela {
    private boolean tienePozo;
	private Pozo pozo;
	private TipoTerreno tipoTerreno;
	private float profundidad;
	private float presionInicial;
	
	public Parcela(TipoTerreno tipoTerreno, float profundidad, float presionInicial) {
		this.pozo = null;
		this.tienePozo = false;

		if (tipoTerreno == null)
			throw new RuntimeException("La parcela debe tener un tipo de terreno.");
		else
			this.tipoTerreno = tipoTerreno;
		
		if (profundidad <= 0)
			throw new RuntimeException("La profundidad de la parcela debe ser positiva.");
		else
			this.profundidad = profundidad;
		
		if (presionInicial < 0)
			throw new RuntimeException("La presion debe ser no negativa.");
		else
			this.presionInicial = presionInicial;
	}

	public Pozo pozo() {
	    if (!tienePozo())
	        throw new RuntimeException("No hay pozo.");
	    return pozo;
    }

    public TipoTerreno tipoTerreno() {
        return tipoTerreno;
    }

    public float profundidad() {
        return profundidad;
    }

	public float presionInicial() {
	    return presionInicial;
    }

    public boolean tienePozo() {
        return tienePozo;
    }

    public void habilitarPozo(ArrayList<PlantaProcesadora> plantasDondeConectarElPozo) {
	    if (tienePozo()) {
	        throw new RuntimeException("No puede crearse un pozo si ya existe uno.");
        }
        if (plantasDondeConectarElPozo == null || plantasDondeConectarElPozo.size() == 0) {
	        throw new RuntimeException("Debe conectarse al menos una planta procesadora a un nuevo pozo.");
        }
        this.pozo = new Pozo(this.presionInicial(), plantasDondeConectarElPozo.get(0));
        tienePozo = true;
	    for (int i = 1; i < plantasDondeConectarElPozo.size(); i++)
	        this.pozo.conectarPlantaProcesadora(plantasDondeConectarElPozo.get(i));
    }
	
	public static void main(String[] args) {
		Parcela par = new Parcela(new TipoTerreno("rocoso", 10), 10, -10);
	}
}
