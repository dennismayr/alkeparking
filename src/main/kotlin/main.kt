import models.Vehicle
import parking.ParkingSpace
import utils.VehicleType
import java.util.*

fun main() {

    val car = Vehicle("AA111AA", VehicleType.CAR.type, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val motorCycle = Vehicle("B822BBB", VehicleType.MOTORCYCLE.type, Calendar.getInstance())
    val miniBus = Vehicle("CC333CC", VehicleType.MINIBUS.type, Calendar.getInstance())
    val bus = Vehicle("DD44400", VehicleType.BUS.type, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val car2 = Vehicle("FF222AA", VehicleType.CAR.type, Calendar.getInstance())
    val motorCycle2 =
        Vehicle("DJS85G", VehicleType.MOTORCYCLE.type, Calendar.getInstance(), "DISCOUNT_CARD_003")
    val minibus2 = Vehicle("DFS222FF", VehicleType.MINIBUS.type, Calendar.getInstance())
    val bus2 = Vehicle("JJ111FF", VehicleType.BUS.type, Calendar.getInstance(), "DISCOUNT_CARD_004")
    val car3 =
        Vehicle("AAA111WW", VehicleType.CAR.type, Calendar.getInstance(), "DISCOUNT_CARD_005")
    val motorCycle3 = Vehicle("QQQ22Q", VehicleType.MOTORCYCLE.type, Calendar.getInstance())
    val miniBus3 = Vehicle("DDD22DD", VehicleType.MINIBUS.type, Calendar.getInstance())
    val bus3 = Vehicle("JJJ06FF", VehicleType.BUS.type, Calendar.getInstance(), "DISCOUNT_CARD_006")
    val car4 = Vehicle("WWW22WW", VehicleType.CAR.type, Calendar.getInstance(), "DISCOUNT_CARD_007")
    val motorCycle4 =
        Vehicle("GGG333F", VehicleType.MOTORCYCLE.type, Calendar.getInstance(), "DISCOUNT_CARD_008")
    val miniBus4 = Vehicle("CCC22DD", VehicleType.MINIBUS.type, Calendar.getInstance())
    val bus4 = Vehicle("VVV22DD", VehicleType.BUS.type, Calendar.getInstance())
    val car5 = Vehicle("GGG32D", VehicleType.BUS.type, Calendar.getInstance(), "DISCOUNT_CARD_009")
    val motorCycle5 = Vehicle("KKK33KS", VehicleType.BUS.type, Calendar.getInstance())
    val miniBus5 = Vehicle("MMM33MM", VehicleType.MINIBUS.type, Calendar.getInstance())
    val car6 = Vehicle("TTT22EE", VehicleType.CAR.type, Calendar.getInstance())

    // --------------------------------------------    20 vehicles          ------------------------------------------ //


    val motorCycle6 = Vehicle("DDD123DD", VehicleType.MOTORCYCLE.type, Calendar.getInstance())

    val miniBus6 = Vehicle("TTT22EE", VehicleType.MINIBUS.type, Calendar.getInstance())

    val listParking = arrayOf(
        car,
        motorCycle,
        miniBus,
        bus,
        car2,
        motorCycle2,
        minibus2,
        bus2,
        car3,
        motorCycle3,
        miniBus3,
        bus3,
        car4,
        motorCycle4,
        miniBus4,
        bus4,
        car5,
        motorCycle5,
        miniBus5,
        car6,
        motorCycle6,
        miniBus6
    )
    val parkingSpace = ParkingSpace()

    listParking.forEach {
        println(parkingSpace.addVehicle(it))
    }

    // do check-out vehicle
    parkingSpace.checkOutVehicle(car.plate)
    parkingSpace.checkOutVehicle(car2.plate)
    parkingSpace.checkOutVehicle(car3.plate)


    // List vehicles by their plates
    parkingSpace.listVehicles()

}