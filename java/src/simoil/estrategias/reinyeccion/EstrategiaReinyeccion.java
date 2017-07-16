package simoil.estrategias.reinyeccion;


import simoil.EmprendimientoPetrolifero;
import simoil.Tanque;

import java.util.ArrayList;

public abstract class EstrategiaReinyeccion {
    protected float volumenGasReinyeccion = 0;
    protected float volumenAguaReinyeccion = 0;
    protected ArrayList<Tanque> tanquesDeAguaDeDondeDescargar = new ArrayList<>();
    protected ArrayList<Tanque> tanquesDeGasDeDondeDescargar = new ArrayList<>();

    public abstract float calcularTotalLitrosReinyeccion(EmprendimientoPetrolifero emprendimientoPetrolifero, float volumenMaximoReinyeccionEnUnDia);

    public float cuantosLitrosDeAguaReinyectar() {
        float resultado = volumenAguaReinyeccion;
        volumenAguaReinyeccion = 0;
        return resultado;
    }

    public float cuantosLitrosDeGasReinyectar() {
        float resultado = volumenGasReinyeccion;
        volumenGasReinyeccion = 0;
        return resultado;
    }

    public ArrayList<Tanque> tanquesDeAguaDeDondeDescargarEnOrden() {
        ArrayList<Tanque> resultado = tanquesDeAguaDeDondeDescargar;
        tanquesDeAguaDeDondeDescargar = new ArrayList<>();
        return resultado;
    }

    public ArrayList<Tanque> tanquesDeGasDeDondeDescargarEnOrden() {
        ArrayList<Tanque> resultado = tanquesDeGasDeDondeDescargar;
        tanquesDeGasDeDondeDescargar = new ArrayList<>();
        return resultado;
    }

}
