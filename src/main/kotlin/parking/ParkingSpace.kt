package parking

import vehicles.Vehicle
import java.util.*

data class ParkingSpace(val vehicleParkingSpace: Vehicle, val instanceParking: Parking) {

    private var i: Int = 0

    //val parkedTime : Long
    private fun totalTime(checkInTime: Calendar) =
        (Calendar.getInstance().timeInMillis - checkInTime.timeInMillis).toInt() / 3600000

    // if totalTime <= 2h -> totalTime = 2h
    // else if totalTime > 2h -> totalTime += 15m -> (totalTime + 15) <= (totalTime + 15)
    // (totalTime + 15) puede ser una variable auxiliar? e.g. additionalTime
    //
    // if discountCard = true -> totalTime + (additionalTime * n) -> 15% off, donde 'n'= 15m adicionales

    // Llamar lista de vehículos para tomar tipo y aplicar costo
    // var parkedTime = totalTime()
    private fun calculateFee(vehiculeType: Int, totalTime: Int, hasDiscountCard: String?): Int {  // function for calculate the parkingCost
        val totalParkingCost = when {
            totalTime <= 2 -> vehiculeType
            totalTime > 2 -> {
                (vehiculeType + with(totalTime - 2) {
                    var five = 0
                    while (this > 0) {
                        five += 5
                        this - 15
                    }
                    five
                })
            }
            else -> 0
        }
        return hasDiscountCard?.let { totalParkingCost * 0.015.toInt() } ?: totalParkingCost
    }

    private fun checkOutVehicle(plate: String, onSuccess: (Int) -> Int, onError: (Unit)) {
        instanceParking.searchableForPlate(plate)?.let {
            val cost =
                onSuccess(calculateFee(it.vehicleType, totalTime(it.checkInTime), it.discountCard))
            instanceParking.remove(it)
            instanceParking.backUp(Pair(i++, cost))
        } ?: onError()
    }

    private fun onSuccess(totalParkingCost: Int) {
        println("Your fee is  $totalParkingCost, Come back soon")
    }

    private fun onError() {  // function for happen error
        println("Sorry, check-out failed")
        // function return error to do checkOutVehicle
    }

}