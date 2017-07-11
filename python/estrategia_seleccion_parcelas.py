from abc import ABC, abstractmethod


class EstrategiaSeleccionParcelas(ABC):
    def __init__(self, lista_parcelas, cantidad_pozos_deseados):
        self._lista_parcelas = lista_parcelas
        self._cantidad_pozos_deseados = cantidad_pozos_deseados

    @abstractmethod
    def resultado(self):
        pass
