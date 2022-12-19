package itmo.isdb.middleearth.service

import itmo.isdb.middleearth.model.Equipment

interface EquipmentService {
    fun getNecessaryEquipment(locationId: Int, raceId: Int): ArrayList<Long>
    fun getAllNecessaryEquipment(ids: List<Long>): List<Equipment>
}
