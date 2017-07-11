package simoil;

public class Parcela {
	private Pozo pozo;
	private TipoTerreno tipoTerreno;
	private float profundidad;
	private float presionInicial;
	private float metrosExcavados;
	private boolean tienePozo;
	
	public Parcela(TipoTerreno tipoTerreno, float profundidad, float presionInicial) {
		this.pozo = null;
		this.tienePozo = false;
		this.metrosExcavados = 0;

		if (tipoTerreno == null)
			throw new RuntimeException("La parcela debe tener un tipo de terreno.");
		else
			this.tipoTerreno = tipoTerreno;
		
		if (profundidad < 0)
			throw new RuntimeException("La profundidad de la parcela debe ser no negativa.");
		else
			this.profundidad = profundidad;
		
		if (presionInicial < 0)
			throw new RuntimeException("La presion debe ser no negativa.");
		else
			this.presionInicial = presionInicial;
	}

	public Pozo pozo() {
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

    public float metrosExcavados() {
	    return metrosExcavados;
    }

    public boolean tienePozo() {
        return tienePozo;
    }

    public float excavar(float metrosAExcavar) {
        if (metrosAExcavar + metrosExcavados > profundidad) {
            float metrosExcavadosHastaElMomento = metrosExcavados;
            metrosExcavados = profundidad;
            return profundidad - metrosExcavadosHastaElMomento;
        } else {
            metrosExcavados += metrosAExcavar;
            return metrosAExcavar;
        }
    }
	
	public static void main(String[] args) {
		Parcela par = new Parcela(new TipoTerreno("rocoso", 10), 10, -10);
	}
}
