class AlquilerRig:

    def __init__(self, rig, costo_diario, cantidad_minima_dias):
        self._costo_diario = costo_diario
        self._cantidad_minima_dias = cantidad_minima_dias
        self._rig = rig
        self._dias_alquilado = 0

    def costo_diario(self):
        return self._costo_diario

    def cantidad_minima_dias(self):
        return self._cantidad_minima_dias

    def rig(self):
        return self._rig

    def nuevo_dia(self):
        self._dias_alquilado +=1

    def dias_alquilado(self):
        return self._dias_alquilado




