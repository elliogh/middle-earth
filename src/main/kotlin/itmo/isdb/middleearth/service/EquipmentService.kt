package itmo.isdb.middleearth.service

import itmo.isdb.middleearth.model.Equipment

interface EquipmentService {
    fun getNecessaryEquipment(locationIds: ArrayList<Int>, raceId: Int): ArrayList<Equipment>
    fun getTotalEquipmentPrice(necessaryEquipment: ArrayList<Equipment>): Int
}
