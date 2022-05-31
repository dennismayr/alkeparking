package parking

import Models.Vehicle

open class Parking {
    private var vehicleRemoved: Pair<Int, Int> = Pair(0, 0)
    private val parkingSize = 20
    private val vehicles: MutableSet<Vehicle> = mutableSetOf()


    fun addVehicle(vehicle: Vehicle): String {  // 'addVehicle' adds a vehicle, returns success or error
        return with(vehicles) {
            when {
                this.size == parkingSize -> "Sorry, check-in failed"
                this.add(vehicle) -> "Welcome to AlkeParking, customer #${this.size}"
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
        this.vehicleRemoved =
            this.vehicleRemoved.copy(first = vehicleRemoved.first, second = vehicleRemoved.second)
        println("${this.vehicleRemoved.first} vehicles have checked out and have earnings of ${this.vehicleRemoved.second}")
    }

    fun listVehicles() { // List all parked vehicles
        vehicles.forEach { println(it.plate) }
    }
}