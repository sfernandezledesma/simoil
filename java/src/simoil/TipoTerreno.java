package simoil;

public class TipoTerreno {
	private String nombre;
	private float resistenciaALaExcavacionEnPorcentaje;
	
	public TipoTerreno(String nombre, float resistenciaALaExcavacionEnPorcentaje) {
		this.nombre = nombre;
		if (resistenciaALaExcavacionEnPorcentaje >= 100f)
			throw new RuntimeException("El porcentaje debe ser menor que 100.");
		this.resistenciaALaExcavacionEnPorcentaje = resistenciaALaExcavacionEnPorcentaje;
	}
	
	public String nombre() {
		return nombre;
	}
	
	public float resistenciaALaExcavacionEnPorcentaje() {
		return resistenciaALaExcavacionEnPorcentaje;
	}
}
