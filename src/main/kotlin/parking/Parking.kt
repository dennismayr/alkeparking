package parking

import Models.Vehicle

open class Parking {
    private lateinit var vehicleRemoved: Pair<Int, Int>
    private val parkingSize = 20
    private val vehicles: MutableSet<Vehicle> = mutableSetOf()


    fun addVehicle(vehicle: Vehicle): String {  // 'addVehicle' adds a vehicle, returns success or error
        return with(vehicles) {
            when {
                this.size == parkingSize -> "Sorry, check-in failed"
                this.add(vehicle) -> "Welcome to AlkeParking"
                else -> "Sorry, check-in failed"
            }
        }
    }

    fun searchableForPlate(plate: String): Vehicle? {  // Function searches a vehicle by its plate
        return vehicles.find { it.plate == plate }
    }


    fun remove(vehicle: Vehicle) {  //  This removes a vehicle from the list
        vehicles.remove(vehicle)
    }

    fun backUp(vehicleRemoved: Pair<Int, Int>) {  // Prints total removed vehicles from the parking, plus total earnings
        this.vehicleRemoved = Pair(vehicleRemoved.first, vehicleRemoved.second)
        println("${vehicleRemoved.first} vehicles have checked out and have earnings of ${vehicleRemoved.second}")
    }

    fun listVehicles() { // List all parked vehicles
        vehicles.forEach { println(it.plate) }
    }


}