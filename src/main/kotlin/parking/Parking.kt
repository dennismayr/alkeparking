package parking

import vehicles.Vehicle

data class Parking(val vehicles : MutableSet<Vehicle>){

    private lateinit var vehicleRemoved: Pair<Int, Int>
    private var totalVehicleRemoved = 0
    private var totalEarnings = 0

    fun addVehicle(vehicle: Vehicle): String {  // Function for addVehicle, return success or error
        return with(vehicles) {
            when {
                this.size == 19 -> "Sorry, the check-in falled"
                this.add(vehicle) -> "Welcome to AlkeParking"
                else -> "Sorry, the check-in falled"
            }
        }
    }

    fun searchableForPlate(plate: String): Vehicle? {  // Function search vehicle for its plate
        return vehicles.find { it.plate == plate }
    }


    fun remove(vehicle: Vehicle) {  // Function removed vehicle
        vehicles.remove(vehicle)
    }

    fun backUp(vehicleRemoved: Pair<Int, Int>) {  // Function print total Removed vehicles of the parking and total earnings
        this.vehicleRemoved = Pair(kotlin.run {
            totalVehicleRemoved += vehicleRemoved.first
            totalVehicleRemoved
        }, kotlin.run {
            totalEarnings += vehicleRemoved.second
            totalEarnings
        })
        println("${vehicleRemoved.first} vehicles have checked out and have eamings of ${vehicleRemoved.second}")
    }


}