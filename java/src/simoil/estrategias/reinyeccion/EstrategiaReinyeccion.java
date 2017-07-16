package simoil.estrategias.reinyeccion;


import simoil.EmprendimientoPetrolifero;
import simoil.Tanque;

import java.util.ArrayList;

public abstract class EstrategiaReinyeccion {
    protected double volumenGasReinyeccion = 0;
    protected double volumenAguaReinyeccion = 0;
    protected ArrayList<Tanque> tanquesDeAguaDeDondeDescargar = new ArrayList<>();
    protected ArrayList<Tanque> tanquesDeGasDeDondeDescargar = new ArrayList<>();

    public abstract double calcularTotalLitrosReinyeccion(EmprendimientoPetrolifero emprendimientoPetrolifero, double volumenMaximoReinyeccionEnUnDia);

    public double cuantosLitrosDeAguaReinyectar() {
        double resultado = volumenAguaReinyeccion;
        volumenAguaReinyeccion = 0;
        return resultado;
    }

    public double cuantosLitrosDeGasReinyectar() {
        double resultado = volumenGasReinyeccion;
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
