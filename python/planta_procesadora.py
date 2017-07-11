from estructura import Estructura


class PlantaProcesadora(Estructura):
    def __init__(self, capacidad_procesamiento):
        Estructura.__init__(self)
        self._capacidad_procesamiento = capacidad_procesamiento
        self._esta_habilitada = False
        self._pozos_con_porcentaje_de_extraccion = []
        self._tanques_con_porcentaje_de_almacenamiento = []

    def esta_habilitada(self):
        return self._esta_habilitada

    def asignar_pozo(self, pozo_y_porcentaje_de_extraccion):
        self._pozos_con_porcentaje_de_extraccion.append(pozo_y_porcentaje_de_extraccion)

    def asignar_tanque(self, tanque_con_porcentaje_de_almacenamiento):
        self._tanques_con_porcentaje_de_almacenamiento.append(tanque_con_porcentaje_de_almacenamiento)

    def procesar_producto(self):
        pass
