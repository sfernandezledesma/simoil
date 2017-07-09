class Parcela(object):

    def __init__(self, profundidad, presion_inicial, tipo_terreno):
        self._tiene_pozo = False
        self._pozo = None
        self._profundidad = profundidad
        self._presion_inicial = presion_inicial
        self._metros_excavados = 0
        self._tipo_terreno = tipo_terreno

    def tiene_pozo(self):
        return self._tiene_pozo

    def profundidad(self):
        return self._profundidad

    def presion_inicial(self):
        return self._presion_inicial

    def metros_excavados(self):
        return self._metros_excavados

    def tipo_terreno(self):
        return self._tipo_terreno

    def excavar(self, metros_a_excavar):
        if metros_a_excavar + self._metros_excavados > self._profundidad:
            metros_excavados_hasta_el_momento = self._metros_excavados
            self._metros_excavados = self._profundidad
            return self._profundidad - metros_excavados_hasta_el_momento
        else:
            self._metros_excavados += metros_a_excavar
            return metros_a_excavar