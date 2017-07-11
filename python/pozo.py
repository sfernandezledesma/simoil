class Pozo(object):

    def __init__(self, presion_inicial):
        self._presion_inicial = presion_inicial
        self._presion = presion_inicial
        self._esta_abierto = False

    def abrir(self):
        self._esta_abierto = True

    def cerrar(self):
        self._esta_abierto = False

    def esta_abierto(self):
        return self._esta_abierto

    def presion_inicial(self):
        return self._presion_inicial

    def presion(self):
        return self._presion

    def actualizar_presion(self, nueva_presion):
        self._presion = nueva_presion