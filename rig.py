class Rig(object):

    def __init__(self, poder_excavacion, costo_alquiler_diario, consumo_combustible_diario):
        self.poder_excavacion = poder_excavacion
        self.costo_alquiler_diario = costo_alquiler_diario
        self.consumo_combustible_diario = consumo_combustible_diario
        self.esta_excavando = False

    def excavar_parcela(self, parcela):
        metros_excavados = 0
        if not self.esta_excavando:
            self.esta_excavando = True
            metros_a_excavar = parcela.tipo_terreno.resistencia * self.poder_excavacion
            metros_excavados = parcela.excavar(metros_a_excavar)
        return metros_excavados