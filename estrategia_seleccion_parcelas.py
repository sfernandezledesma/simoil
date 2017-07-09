from abc import ABC, abstractmethod


class EstrategiaSeleccionParcelas(ABC):
    def __init__(self, lista_parcelas):
        self._lista_parcelas = lista_parcelas

    @abstractmethod
    def resultado(self):
        pass
