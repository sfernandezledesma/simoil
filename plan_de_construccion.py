class PlanDeConstruccion:

    def __init__(self, estructura, dias_necesarios_construccion, costo):
        self._costo = costo
        self._estructura = estructura
        self._tiempo_de_construccion = dias_necesarios_construccion
        self._dias_para_finalizar = dias_necesarios_construccion

    def costo(self):
        return self._costo

    def estructura(self):
        return self._estructura

    def tiempo_de_construccion(self):
        return self._tiempo_de_construccion

    def nuevo_dia(self):
        if self._dias_para_finalizar > 0:
            self._dias_para_finalizar -=1