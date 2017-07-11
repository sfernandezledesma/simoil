from estrategia_seleccion_parcelas import EstrategiaSeleccionParcelas


class EstrategiaSeleccionParcelasPorMaximaPresion(EstrategiaSeleccionParcelas):

    def __init__(self, lista_parcelas, cantidad_pozos_deseados):
        EstrategiaSeleccionParcelas.__init__(self, lista_parcelas, cantidad_pozos_deseados)

    def resultado(self):
        lista_ordenada = []
        for parcela in self._lista_parcelas:
            lista_ordenada.append([parcela.presion_inicial(), parcela])

        lista_ordenada = sorted(lista_ordenada, key=lambda parcela: parcela[0])
        return self._lista_parcelas