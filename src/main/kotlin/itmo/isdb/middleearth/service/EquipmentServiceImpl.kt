package itmo.isdb.middleearth.service

import itmo.isdb.middleearth.model.Equipment
import itmo.isdb.middleearth.repository.EquipmentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class EquipmentServiceImpl(
    val equipmentRepository: EquipmentRepository
) : EquipmentService {
    @Transactional
    override fun getNecessaryEquipment(locationIds: ArrayList<Int>, raceId: Int): ArrayList<Equipment> =
        try {
            val setOfEquipmentIds = mutableSetOf<Int>()
            val necessaryEquipment = arrayListOf<Equipment>()
            locationIds.forEach {
                setOfEquipmentIds.addAll(equipmentRepository.getNecessaryEquipment(it, raceId))
            }
            necessaryEquipment.addAll(equipmentRepository.findByIdIn(setOfEquipmentIds.toList()))

            necessaryEquipment
        } catch (e: Exception) {
            e.printStackTrace()
            arrayListOf()
        }

    override fun getTotalEquipmentPrice(necessaryEquipment: ArrayList<Equipment>): Int =
        necessaryEquipment.sumOf { it.price }
}
