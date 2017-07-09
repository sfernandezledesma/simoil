from parcela import Parcela
from terreno import Terreno
from yacimiento import Yacimiento
from rig import Rig
from alquiler_rig import AlquilerRig
from emprendimiento_petrolifero import EmprendimientoPetrolifero
from equipo_de_ingenieria import EquipoDeIngenieria
from planta_procesadora import PlantaProcesadora
from tanque_de_agua import TanqueDeAgua
from tanque_de_gas import TanqueDeGas
from plan_de_construccion import PlanDeConstruccion


def import_data_from_cvs(file_path):

    lista_alquiler_rigs = []
    rig_1 = Rig(1, 20)
    rig_2 = Rig(5, 30)
    rig_3 = Rig(10, 40)
    alquiler_rig_1 = AlquilerRig(rig_1, 10, 4)
    alquiler_rig_2 = AlquilerRig(rig_2, 20, 6)
    alquiler_rig_3 = AlquilerRig(rig_3, 50, 7)
    lista_alquiler_rigs.append(alquiler_rig_1)
    lista_alquiler_rigs.append(alquiler_rig_2)
    lista_alquiler_rigs.append(alquiler_rig_3)

    lista_planes_de_construccion_plantas = []
    planta_1 = PlantaProcesadora(50)
    planta_2 = PlantaProcesadora(100)
    planta_3 = PlantaProcesadora(150)
    plan_planta_1 = PlanDeConstruccion(planta_1, 3, 1000)
    plan_planta_2 = PlanDeConstruccion(planta_2, 5, 1500)
    plan_planta_3 = PlanDeConstruccion(planta_3, 7, 2000)
    lista_planes_de_construccion_plantas.append(plan_planta_1)
    lista_planes_de_construccion_plantas.append(plan_planta_2)
    lista_planes_de_construccion_plantas.append(plan_planta_3)

    lista_planes_de_construccion_tanques_agua = []
    tanque_agua_1 = TanqueDeAgua(100)
    tanque_agua_2 = TanqueDeAgua(200)
    plan_agua_1 = PlanDeConstruccion(tanque_agua_1, 4, 300)
    plan_agua_2 = PlanDeConstruccion(tanque_agua_2, 5, 500)
    lista_planes_de_construccion_tanques_agua.append(plan_agua_1)
    lista_planes_de_construccion_tanques_agua.append(plan_agua_2)

    lista_planes_de_construccion_tanques_gas = []
    tanque_gas_1 = TanqueDeGas(100)
    tanque_gas_2 = TanqueDeGas(200)
    plan_gas_1 = PlanDeConstruccion(tanque_gas_1, 4, 300)
    plan_gas_2 = PlanDeConstruccion(tanque_gas_2, 5, 500)
    lista_planes_de_construccion_tanques_gas.append(plan_gas_1)
    lista_planes_de_construccion_tanques_gas.append(plan_gas_2)

    lista_parcelas = []
    tipo_terreno_1 = Terreno(0.5)
    tipo_terreno_2 = Terreno(0.2)
    parcela_1 = Parcela(10, 10, tipo_terreno_1)
    parcela_2 = Parcela(20, 8, tipo_terreno_2)
    parcela_3 = Parcela(30, 5, tipo_terreno_1)
    parcela_4 = Parcela(40, 2, tipo_terreno_2)
    lista_parcelas.append(parcela_1)
    lista_parcelas.append(parcela_2)
    lista_parcelas.append(parcela_3)
    lista_parcelas.append(parcela_4)
    yacimiento = Yacimiento(200, 300, 500, lista_parcelas)
    equipo_de_ingenieria = EquipoDeIngenieria()  # FALTAN LAS ESTRATEGIAS
    emprendimiento = EmprendimientoPetrolifero(yacimiento, equipo_de_ingenieria)

    parametros_simulador = {
        'alquiler_rigs': lista_alquiler_rigs,
        'planes_de_construccion_plantas': lista_planes_de_construccion_plantas,
        'planes_de_construccion_tanques_agua': lista_planes_de_construccion_tanques_agua,
        'planes_de_construccion_tanques_gas': lista_planes_de_construccion_tanques_gas,
        'emprendimiento': emprendimiento
    }