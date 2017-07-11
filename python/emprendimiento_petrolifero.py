class EmprendimientoPetrolifero:

    def __init__(self, yacimiento, equipo_de_ingenieria):
        self._yacimiento = yacimiento
        self._alquiler_rigs = []
        self._tanques = []
        self._plantas_procesadoras = []
        self._planes_de_construccion = []
        self._gastos = 0
        self._ingresos = 0
        self._equipo_de_ingenieria = equipo_de_ingenieria

    def agregar_alquiler_rig(self, alquiler_rig):
        self._alquiler_rigs.append(alquiler_rig)

    def agregar_tanque(self, tanque):
        self._tanques.append(tanque)

    def agregar_planta_procesadora(self, planta_procesadora):
        self._plantas_procesadoras.append(planta_procesadora)

    def agregar_plan_de_construccion(self, plan_de_construccion):
        self._planes_de_construccion.append(plan_de_construccion)

    def alquiler_rigs(self):
        return self._alquiler_rigs

    def tanques(self):
        return self._tanques

    def equipo_de_ingenieria(self):
        return self._equipo_de_ingenieria

    def plantas_procesadoras(self):
        return self._plantas_procesadoras

    def planes_de_construccion(self):
        return self._planes_de_construccion

    def sumar_gasto(self, monto):
        self._gastos += monto

    def sumar_ingreso(self, monto):
        self._ingresos += monto

    def ganancia_total(self):
        return self._ingresos - self._gastos