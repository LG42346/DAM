package dam_A42346.thematiccalculator

import kotlin.math.pow

class Calculator {
    fun add(augend: Double, addend: Double): Double {
        return augend + addend
    }

    fun sub(minuend: Double, subtrahend: Double): Double {
        return minuend - subtrahend
    }

    fun mult(multiplier: Double, multiplicand: Double): Double {
        return multiplier * multiplicand
    }

    fun div(dividend: Double, divisor: Double): Double {
        return dividend / divisor
    }

    fun root(base: Double, value: Double): Double{
        return base.pow(1/value)
    }

    fun pow(base: Double, value:Double):Double{
        return base.pow(value)
    }
}