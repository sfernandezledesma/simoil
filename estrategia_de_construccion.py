from abc import ABC, abstractmethod


class EstrategiaConstruccion(ABC):
    def __init__(self, empresa_petrolifera):
        self._empresa_petrolifera = empresa_petrolifera

    @abstractmethod
    def resultado(self):
        pass
