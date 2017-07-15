package simoil;

public class ConexionEntreEstructuras {
    private String nombreEstructuraOrigen;
    private String nombreEstructuraDestino;

    public ConexionEntreEstructuras(String nombreEstructuraOrigen, String nombreEstructuraDestino) {
        this.nombreEstructuraOrigen = nombreEstructuraOrigen;
        this.nombreEstructuraDestino = nombreEstructuraDestino;
    }

    public String nombreEstructuraOrigen() {
        return nombreEstructuraOrigen;
    }

    public String nombreEstructuraDestino() {
        return nombreEstructuraDestino;
    }
}
