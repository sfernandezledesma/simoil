from abc import ABC, abstractmethod


class EstrategiaExcavacion(ABC):
    def __init__(self, emprendimiento):
        self._emprendimiento = emprendimiento

    @abstractmethod
    def comienzo_de_excavacion_de_pozos(self):
        pass

    @abstractmethod
    def cuantos_rigs_alquilar_simultaneamente(self):
        pass

    @abstractmethod
    def que_rig_alquilar(self):
        pass