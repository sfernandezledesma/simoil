class EquipoDeIngenieria:

    def __init__(self,
                 estrategia_seleccion_parcelas,
                 estrategia_excavacion,
                 estrategia_construccion,
                 estrategia_extraccion,
                 estrategia_reinyeccion,
                 estrategia_condicion_de_fin
                 ):
        self._estrategia_seleccion_parcelas = estrategia_seleccion_parcelas
        self._estrategia_excavacion = estrategia_excavacion
        self._estrategia_construccion = estrategia_construccion
        self._estrategia_extraccion = estrategia_extraccion
        self._estrategia_reinyeccion = estrategia_reinyeccion
        self._estrategia_condicion_de_fin = estrategia_condicion_de_fin

    def estrategia_seleccion_parcelas(self):
        return self._estrategia_seleccion_parcelas

    def estrategia_excavacion(self):
        return self._estrategia_excavacion

    def estrategia_construccion(self):
        return self._estrategia_construccion

    def estrategia_extraccion(self):
        return self._estrategia_extraccion

    def estrategia_reinyeccion(self):
        return self._estrategia_reinyeccion

    def estrategia_condicion_de_fin(self):
        return self._estrategia_condicion_de_fin