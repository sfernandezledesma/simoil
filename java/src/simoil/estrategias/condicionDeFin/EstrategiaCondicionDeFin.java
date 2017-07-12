package simoil.estrategias.condicionDeFin;


import simoil.EmprendimientoPetrolifero;

public abstract class EstrategiaCondicionDeFin {
    protected int maximoDias;

    public EstrategiaCondicionDeFin(int maximoDias) {
        this.maximoDias = maximoDias;
    }

    abstract boolean hayQueFinalizar(EmprendimientoPetrolifero emprendimientoPetrolifero, int diasTranscurridos);

}
