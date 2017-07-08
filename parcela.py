class Parcela(object):

    def __init__(self, profundidad, presion_inicial, tipo_terreno):
        self.tiene_pozo = False
        self.pozo = None
        self.profundidad = profundidad
        self.presion_inicial = presion_inicial
        self.metros_excavados = 0
        self.tipo_terreno = tipo_terreno

    def tiene_pozo(self):
        return self.tiene_pozo

    def profundidad(self):
        return self.profundidad

    def presion_inicial(self):
        return self.presion_inicial

    def metros_excavados(self):
        return self.metros_excavados

    def tipo_terreno(self):
        return self.tipo_terreno

    def excavar(self, metros_a_excavar):
        if metros_a_excavar + self.metros_excavados > self.profundidad:
            metros_excavados_hasta_el_momento = self.metros_excavados
            self.metros_excavados = self.profundidad
            return self.profundidad - metros_excavados_hasta_el_momento
        else:
            self.metros_excavados += metros_a_excavar
            return metros_a_excavar