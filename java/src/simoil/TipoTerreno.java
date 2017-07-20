package simoil;

public class TipoTerreno {
	private String nombreTipoTerreno;
	private double resistenciaALaExcavacionEnPorcentaje;
	
	public TipoTerreno(String nombreTipoTerreno, double resistenciaALaExcavacionEnPorcentaje) {
		if (nombreTipoTerreno == null) {
            throw new RuntimeException("El tipo de terreno debe tener un nombre.");
        }
		this.nombreTipoTerreno = nombreTipoTerreno;

		if (resistenciaALaExcavacionEnPorcentaje >= 100f)
			throw new RuntimeException("El porcentaje debe ser menor que 100.");
		this.resistenciaALaExcavacionEnPorcentaje = resistenciaALaExcavacionEnPorcentaje;
	}
	
	public String nombreTipoTerreno() {
		return nombreTipoTerreno;
	}
	
	public double resistenciaALaExcavacionEnPorcentaje() {
		return resistenciaALaExcavacionEnPorcentaje;
	}
}
