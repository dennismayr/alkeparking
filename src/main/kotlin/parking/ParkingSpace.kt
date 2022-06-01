package parking

import java.util.*
import kotlin.math.roundToInt

class ParkingSpace : Parking() {

    private var vehicleCounter = 0
    private val baseFee = 120 //  Our time measuring unit: seconds (easier to calculate totals)
    private val MINUTES_IN_MILISECONDS = 60000
    private var saveCost = 0
    private var cost = 0
    private var parkedTime = 0L
    private var totalRest = 0L


    private fun parkedTime(checkInTime: Calendar) =
        (Calendar.getInstance().timeInMillis - checkInTime.timeInMillis) / MINUTES_IN_MILISECONDS // Function to calculate total parking time and evaluate conditions where a discount applies

    private fun calculateFee(
        vehicleType: Int,
        totalTime: Long,
        hasDiscountCard: String?,
    ): Int {  // function to calculate the parkingCost
        val totalParkingCost = when {
            totalTime <= baseFee -> vehicleType
            totalTime > baseFee -> {
                (vehicleType + with(totalTime - baseFee) {
                    totalRest = this
                    var additionalFee = 0
                    while (totalRest > 0) {
                        additionalFee += 5
                        totalRest -= 15
                    }
                    additionalFee
                })
            }
            else -> 0
        }
        return hasDiscountCard?.let { (totalParkingCost * 0.15).roundToInt() } ?: totalParkingCost
    }

    fun checkOutVehicle(plate: String) { // Let a vehicle go and calculate individual parked time and fee
        searchableByPlate(plate)?.let {
            parkedTime = parkedTime(it.checkInTime)
            cost = calculateFee(it.vehicleType, parkedTime, it.discountCard)
            onSuccess(cost)
            remove(it)
            vehicleCounter++
            saveCost += cost
            backUp(Pair(vehicleCounter, saveCost))
        } ?: onError()
    }

    private fun onSuccess(totalParkingCost: Int) { // function returns success if checkOutVehicle works
        println("Your fee is $totalParkingCost - Come back soon!")
    }

    private fun onError() {  // function returns error if checkOutVehicle fails
        println("Sorry, check-out failed")
    }
}