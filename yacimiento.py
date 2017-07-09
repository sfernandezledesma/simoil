class Yacimiento(object):

    def __init__(self, volumen_agua, volumen_gas, volumen_petroleo, lista_parcelas):
        self._volumen_agua = volumen_agua
        self._volumen_gas = volumen_gas
        self._volumen_petroleo = volumen_petroleo
        self._parcelas = lista_parcelas
        self._global_extraido = 0
        self._global_reinyectado = 0

    def composicion_de_producto(self):
        volumen_total = self.volumen_total()
        return {'agua': self._volumen_agua / volumen_total * 100, 'gas': self._volumen_gas / volumen_total * 100,
                'petroleo': volumen_total / self._volumen_petroleo * 100}

    def volumen_total(self):
        return self._volumen_agua + self._volumen_gas + self._volumen_petroleo

    def parcelas(self):
        return self._parcelas

    def reinyectar_agua_y_gas(self, volumen_agua, volumen_gas):
        total_reinyeccion = self._volumen_agua + self._volumen_gas
        if total_reinyeccion + self._global_reinyectado < self._global_extraido:
            self._volumen_agua += volumen_agua
            self._volumen_gas += volumen_gas
            self._global_reinyectado += total_reinyeccion
            return True
        return False

    def extraer_producto(self, cantidad_de_producto):
        if cantidad_de_producto < self.volumen_total():
            volumen_agua_extraido = cantidad_de_producto * self.composicion_de_producto()['agua'] / 100
            volumen_gas_extraido = cantidad_de_producto * self.composicion_de_producto()['gas'] / 100
            volumen_petroleo_extraido = cantidad_de_producto * self.composicion_de_producto()['petroleo'] / 100
            self._volumen_agua -= volumen_agua_extraido
            self._volumen_gas -= volumen_gas_extraido
            self._volumen_petroleo -= volumen_petroleo_extraido
            self._global_extraido += cantidad_de_producto
            return True
        return False




