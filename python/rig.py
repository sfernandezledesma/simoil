class Rig(object):

    def __init__(self, poder_excavacion, consumo_combustible_diario):
        self._poder_excavacion = poder_excavacion
        self._consumo_combustible_diario = consumo_combustible_diario
        self._esta_excavando = False

    def excavar_parcela(self, parcela):
        metros_excavados = 0
        if not self._esta_excavando:
            self._esta_excavando = True
            metros_a_excavar = parcela.tipo_terreno.resistencia * self._poder_excavacion
            metros_excavados = parcela.excavar(metros_a_excavar)
        return metros_excavados
