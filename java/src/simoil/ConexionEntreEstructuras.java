package simoil;

public class ConexionEntreEstructuras {
    private String nombreEstructuraOrigen;
    private String nombreEstructuraDestino;

    public ConexionEntreEstructuras(String nombreEstructuraOrigen, String nombreEstructuraDestino) {
        if (nombreEstructuraOrigen == null) {
            throw new RuntimeException("La conexion debe conocer el nombre de la estructura origen.");
        }
        this.nombreEstructuraOrigen = nombreEstructuraOrigen;

        if (nombreEstructuraDestino == null) {
            throw new RuntimeException("La conexion debe conocer el nombre de la estructura destino.");
        }
        this.nombreEstructuraDestino = nombreEstructuraDestino;
    }

    public String nombreEstructuraOrigen() {
        return nombreEstructuraOrigen;
    }

    public String nombreEstructuraDestino() {
        return nombreEstructuraDestino;
    }
}
