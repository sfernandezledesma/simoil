from estrategia_excavacion import EstrategiaExcavacion


class EstrategiaExcavacionLoAntesPosible(EstrategiaExcavacion):

    def __init__(self, emprendimiento, lista_catalogo_alquileres_rigs):
        EstrategiaExcavacion.__init__(self, emprendimiento, lista_catalogo_alquileres_rigs)

    def comienzo_de_excavacion_de_pozos(self):
        pass

    def cuantos_rigs_simultaneamente(self):
        pass