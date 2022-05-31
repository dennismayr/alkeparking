package parking

import vehicles.Vehicle
import java.util.*

data class ParkingSpace(val vehicleParkingSpace: Vehicle, val instanceParking: Parking) {

    private var i: Int = 0
    private val baseFee: Int = 120 // nuestra unidad de medida: minutos (así es más ordenado calcular el adicional)

    //val parkedTime : Long
    private fun totalTime(checkInTime: Calendar) =
        (Calendar.getInstance().timeInMillis - checkInTime.timeInMillis).toInt() / 60000 // retorna

    // if totalTime <= 2h -> totalTime = 2h
    // else if totalTime > 2h -> totalTime += 15m -> (totalTime + 15) <= (totalTime + 15)
    // (totalTime + 15) puede ser una variable auxiliar? e.g. additionalTime
    //
    // if discountCard = true -> totalTime + (additionalTime * n) -> 15% off, donde 'n'= 15m adicionales

    // Llamar lista de vehículos para tomar tipo y aplicar costo

    private fun calculateFee(
        vehicleType: Int,
        totalTime: Int,
        hasDiscountCard: String?
    ): Int {  // function for calculate the parkingCost
        val totalParkingCost = when {
            totalTime <= baseFee -> vehicleType  // totalTime o totalTime()?
            totalTime > baseFee -> {
                (vehicleType + with(totalTime - baseFee) {
                    var additionalFee = 0
                    while (this > 0) {
                        additionalFee += 5
                        this - 15
                    }
                    additionalFee
                })
            }
            else -> 0
        }
        return hasDiscountCard?.let { totalParkingCost * 0.015.toInt() } ?: totalParkingCost
    }

    private fun checkOutVehicle(plate: String) {
        instanceParking.searchableForPlate(plate)?.let {
            val parkedTime = totalTime(it.checkInTime)
            val cost = calculateFee(it.vehicleType, parkedTime, it.discountCard)
            onSuccess(cost)
            instanceParking.remove(it)
            instanceParking.backUp(Pair(i.inc(), cost))
        } ?: onError()
    }

    private fun onSuccess(totalParkingCost: Int) {
        println("Your fee is $totalParkingCost - Come back soon!")
    }

    private fun onError() {  // function for happen error
        println("Sorry, check-out failed")
        // function return error to do checkOutVehicle
    }
}