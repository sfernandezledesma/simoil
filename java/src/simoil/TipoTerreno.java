package simoil;

public class TipoTerreno {
	private String nombreTipoTerreno;
	private float resistenciaALaExcavacionEnPorcentaje;
	
	public TipoTerreno(String nombreTipoTerreno, float resistenciaALaExcavacionEnPorcentaje) {
		this.nombreTipoTerreno = nombreTipoTerreno;
		if (resistenciaALaExcavacionEnPorcentaje >= 100f)
			throw new RuntimeException("El porcentaje debe ser menor que 100.");
		this.resistenciaALaExcavacionEnPorcentaje = resistenciaALaExcavacionEnPorcentaje;
	}
	
	public String nombreTipoTerreno() {
		return nombreTipoTerreno;
	}
	
	public float resistenciaALaExcavacionEnPorcentaje() {
		return resistenciaALaExcavacionEnPorcentaje;
	}
}
