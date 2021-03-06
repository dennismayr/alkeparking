package models

import java.util.*

data class Vehicle(
    val plate: String,
    val vehicleType: Int,
    val checkInTime: Calendar,
    val discountCard: String? = null,
) {

    override fun equals(other: Any?): Boolean {
        if (other is Vehicle) {
            return this.plate == other.plate
        }
        return super.equals(other)
    }

    override fun hashCode() = this.plate.hashCode()
}