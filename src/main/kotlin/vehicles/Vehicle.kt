package vehicles

import utils.VehicleCost

data class Vehicle(val plate: String, val vehicleType: VehicleCost) {

    override fun equals(other: Any?): Boolean {
        if (other is Vehicle) {
            return this.plate == other.plate
        }

        return super.equals(other)
    }

    override fun hashCode() = this.plate.hashCode()
}