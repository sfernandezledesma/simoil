class Yacimiento(object):

    def __init__(self, volumen_agua, volumen_gas, volumen_petroleo, lista_parcelas):
        self.volumen_agua = volumen_agua
        self.volumen_gas = volumen_gas
        self.volumen_petroleo = volumen_petroleo
        self.parcelas = lista_parcelas
        self.global_extraido = 0
        self.global_reinyectado = 0

    def composicion_de_producto(self):
        volumen_total = self.volumen_total()
        return {'agua': self.volumen_agua/volumen_total*100, 'gas': self.volumen_gas/volumen_total*100,
                'petroleo': volumen_total/self.volumen_petroleo*100}

    def volumen_total(self):
        return self.volumen_agua + self.volumen_gas + self.volumen_petroleo

    def parcelas(self):
        return self.parcelas

    def reinyectar_agua_y_gas(self, volumen_agua, volumen_gas):
        total_reinyeccion = self.volumen_agua + self.volumen_gas
        if total_reinyeccion + self.global_reinyectado < self.global_extraido:
            self.volumen_agua += volumen_agua
            self.volumen_gas += volumen_gas
            self.global_reinyectado += total_reinyeccion
            return True
        return False

    def extraer_producto(self, cantidad_de_producto):
        if cantidad_de_producto < self.volumen_total():
            volumen_agua_extraido = cantidad_de_producto * self.composicion_de_producto()['agua'] / 100
            volumen_gas_extraido = cantidad_de_producto * self.composicion_de_producto()['gas'] / 100
            volumen_petroleo_extraido = cantidad_de_producto * self.composicion_de_producto()['petroleo'] / 100
            self.volumen_agua -= volumen_agua_extraido
            self.volumen_gas -= volumen_gas_extraido
            self.volumen_petroleo -= volumen_petroleo_extraido
            return True
        return False




