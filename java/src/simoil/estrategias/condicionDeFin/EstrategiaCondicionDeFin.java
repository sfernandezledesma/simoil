package simoil.estrategias.condicionDeFin;


import simoil.EmprendimientoPetrolifero;

public abstract class EstrategiaCondicionDeFin {

    public abstract boolean hayQueFinalizar(EmprendimientoPetrolifero emprendimientoPetrolifero,
                                            int diasTranscurridos, int maximoDias, float porcentajeCriticoPetroleo);

}
