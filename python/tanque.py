from abc import ABC
from estructura import Estructura


class Tanque(Estructura, ABC):

    def __init__(self, capacidad_total):
        Estructura.__init__(self)
        self._capacidad_total = capacidad_total
        self._capacidad_disponible = capacidad_total

    def capacidad_total(self):
        return self._capacidad_total

    def capacidad_disponible(self):
        return self._capacidad_disponible

    def cargar(self, volumen_a_cargar):
        volumen_cargado = min([volumen_a_cargar, self.capacidad_disponible()])
        self._capacidad_disponible -= volumen_cargado
        return volumen_cargado

    def extraer(self, volumen_a_extraer):
        volumen_extraido = min([volumen_a_extraer, self.capacidad_total() - self.capacidad_disponible()])
        self._capacidad_disponible += volumen_extraido
        return volumen_extraido