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
    override fun getNecessaryEquipment(locationId: Int, raceId: Int): ArrayList<Long> =
        try {
            equipmentRepository.getNecessaryEquipment(locationId, raceId)
        } catch (e: Exception) {
            e.printStackTrace()
            arrayListOf()
        }

    override fun getAllNecessaryEquipment(ids: List<Long>): List<Equipment> {
        return equipmentRepository.findByIdIn(ids)
    }
}
