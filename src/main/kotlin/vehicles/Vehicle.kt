package vehicles

import utils.VehicleCost

data class Vehicle(
    val plate: String,
    val vehicleType: VehicleCost,
    val checkInTime: Long,
    val parkedTime: Long,
    val discountCard: Boolean
) {

    override fun equals(other: Any?): Boolean {
        if (other is Vehicle) {
            return this.plate == other.plate
        }

        return super.equals(other)
    }

    override fun hashCode() = this.plate.hashCode()

    // Por mover a otra clase, por mientras acá
    fun totalTime(checkIn: Long, checkout: Long) = (checkout - checkIn).toInt()

}