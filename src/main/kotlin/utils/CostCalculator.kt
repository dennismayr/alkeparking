package utils

import vehicles.Vehicle
import java.util.*

class CostCalculator {

    fun totalTime(vehicle: Vehicle) =
        (Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis).toInt() / 3600000

    // if totalTime <= 2h -> totalTime = 2h
    // else if totalTime > 2h -> totalTime += 15m -> (totalTime + 15) <= (totalTime + 15)
    // (totalTime + 15) puede ser una variable auxiliar? e.g. additionalTime
    //
    // if discountCard = true -> totalTime + (additionalTime * n) -> 15% off, donde 'n'= 15m adicionales

    // Llamar lista de vehículos para tomar tipo y aplicar costo
    // var parkedTime = totalTime()
    fun parkingCost(totalTime: Int, vehicle: Vehicle): Int {
        return when {
            totalTime <= 2 -> vehicle.vehicleType
            totalTime > 2 -> {
                vehicle.vehicleType += (vehicle.vehicleType * 0.25).roundToInt()
            }
            else -> {}
        }
    }

    fun calculate(listVehicle: Vehicle, operation: (Vehicle) -> Long) {

    }
}