package simoil;

public class Parcela {
    private boolean tienePozo;
	private Pozo pozo;
	private TipoTerreno tipoTerreno;
	private float profundidadDelReservorio;
	private float presionInicial;
	
	public Parcela(TipoTerreno tipoTerreno, float profundidadDelReservorio, float presionInicial) {
		this.pozo = null;
		this.tienePozo = false;

		if (tipoTerreno == null)
			throw new RuntimeException("La parcela debe tener un tipo de terreno.");
		else
			this.tipoTerreno = tipoTerreno;
		
		if (profundidadDelReservorio <= 0)
			throw new RuntimeException("La profundidadDelReservorio de la parcela debe ser positiva.");
		else
			this.profundidadDelReservorio = profundidadDelReservorio;
		
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

    public float profundidadDelReservorio() {
        return profundidadDelReservorio;
    }

	public float presionInicial() {
	    return presionInicial;
    }

    public boolean tienePozo() {
        return tienePozo;
    }

    public void comenzarExcavacionNuevoPozo(PlantaProcesadora plantaDondeConectarElPozo) {
	    if (tienePozo()) {
	        throw new RuntimeException("No puede crearse un pozo si ya existe uno.");
        }
        if (plantaDondeConectarElPozo == null) {
	        throw new RuntimeException("Debe conectarse al menos una planta procesadora a un nuevo pozo.");
        }
        this.pozo = new Pozo(this.presionInicial(), plantaDondeConectarElPozo);
        tienePozo = true;
    }
	
	public static void main(String[] args) {
		Parcela par = new Parcela(new TipoTerreno("rocoso", 10), 10, -10);
	}
}
