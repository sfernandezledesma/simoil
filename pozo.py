class Pozo(object):

    def __init__(self, presion_inicial):
        self.presion_inicial = presion_inicial
        self.presion = presion_inicial
        self.esta_abierto = False

    def abrir(self):
        self.esta_abierto = True

    def cerrar(self):
        self.esta_abierto = False

    def esta_abierto(self):
        return self.esta_abierto

    def presion_inicial(self):
        return self.presion_inicial

    def presion(self):
        return self.presion

    def actualizar_presion(self, nueva_presion):
        self.presion = nueva_presion