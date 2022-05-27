import parking.Parking
import utils.VehicleType
import vehicles.Vehicle
import java.util.*

fun main() {
    //println("Welcome to AlkeParking®")

    /*
    Different vehicle types:
    - Cars
    - Motorcycles
    - Minibuses
    - Buses

    Costs
    - First 2 hours:
      * Cars: $20
      * Motorcycles: $15
      * Minibuses: $25
      * Buses: $30

    After the first 2 hours: additional:
    - $5 every 15 minutes
    * */

    // 'class Vehicle' must contain vehicle type
    // Interface to implement costs

    val car = Vehicle("AA111AA", VehicleType.CAR.type, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val motorCycle = Vehicle("B822BBB", VehicleType.MOTORCYCLE.type, Calendar.getInstance())
    val miniBus = Vehicle("CC333CC", VehicleType.MINIBUS.type, Calendar.getInstance())
    val bus = Vehicle("DD44400", VehicleType.BUS.type, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val car2 = Vehicle("AA111AA", VehicleType.CAR.type, Calendar.getInstance())

    val listParking = arrayOf(car, motorCycle, miniBus, bus, car2)
    val parking = Parking(mutableSetOf())


    //println(parking.vehicles.contains(car))
    //println(parking.vehicles.contains(motorCycle))
    //println(parking.vehicles.contains(miniBus))
    //println(parking.vehicles.contains(bus))
    //println(parking.addVehicle(car2))

    listParking.forEach {
        println(parking.addVehicle(it))
    }
    parking.vehicles.remove(motorCycle)

    //println(parking.addVehicle(car))
}