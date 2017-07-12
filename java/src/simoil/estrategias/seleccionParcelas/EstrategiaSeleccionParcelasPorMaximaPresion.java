package simoil.estrategias.seleccionParcelas;

import simoil.Parcela;
import simoil.TipoTerreno;

import java.util.ArrayList;

/**
 * Created by Sebastian on 11/07/2017.
 */
public class EstrategiaSeleccionParcelasPorMaximaPresion extends EstrategiaSeleccionParcelas {

    public EstrategiaSeleccionParcelasPorMaximaPresion(ArrayList<Parcela> parcelas, int cantidadPozosDeseados) {
        super(parcelas, cantidadPozosDeseados);
    }

    @Override
    public ArrayList<Parcela> seleccionarParcelasParaExcavar() {
        ArrayList<Parcela> parcelasSeleccionadas = new ArrayList<>(parcelas);

        parcelasSeleccionadas.sort((p1, p2) -> Float.compare(p2.presionInicial(), p1.presionInicial()));

        while (parcelasSeleccionadas.size() > cantidadPozosDeseados)
            parcelasSeleccionadas.remove(parcelasSeleccionadas.size() - 1);

        return parcelasSeleccionadas;
    }

    public static void main(String[] args) {
        Parcela par1 = new Parcela(new TipoTerreno("asd", 10), 10, 1);
        Parcela par2 = new Parcela(new TipoTerreno("asd", 10), 10, 2);
        Parcela par3 = new Parcela(new TipoTerreno("asd", 10), 10, 3);
        ArrayList<Parcela> lista = new ArrayList<>();
        lista.add(par1);
        lista.add(par2);
        lista.add(par3);
        int cantidadPozos = 2;

        for (Parcela p : lista)
            System.out.println(p.presionInicial());

        System.out.println("---");
        EstrategiaSeleccionParcelasPorMaximaPresion e = new EstrategiaSeleccionParcelasPorMaximaPresion(lista, cantidadPozos);
        ArrayList<Parcela> listaSeleccion = e.seleccionarParcelasParaExcavar();

        for (Parcela p : listaSeleccion)
            System.out.println(p.presionInicial());
    }
}
