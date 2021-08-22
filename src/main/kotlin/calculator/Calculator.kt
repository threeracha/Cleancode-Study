package calculator

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.IllegalArgumentException
import java.util.*

class Calculator(
    _expression: String
) {
    val expression: String
    var result: Int = 0
    var operator: String ?= null
    var operand: Int = 0

    init {
        if (_expression == " ")
            throw IllegalArgumentException("Wrong input")
        else
            expression = _expression
    }

    fun calculate() {
        result = when (operator) {
            "+" -> add(result, operand)
            "-" -> subtract(result, operand)
            "*" -> multiply(result, operand)
            "/" -> divide(result, operand)
            else -> throw throw IllegalArgumentException("Not a valid operator")
        }
    }

    companion object {
        internal fun add(x: Int, y: Int): Int {
            return x + y
        }

        internal fun subtract(x: Int, y: Int): Int {
            return x - y
        }

        internal fun multiply(x: Int, y: Int): Int {
            return x * y
        }

        internal fun divide(x: Int, y: Int): Int {
            return x / y
        }
    }
}

fun main(args: Array<String>) {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))
    val calculator = Calculator(bufferedReader.readLine())
    val token = StringTokenizer(calculator.expression, " ")

    calculator.result = token.nextToken().toInt()
    while(token.hasMoreTokens()) {
        calculator.operator = token.nextToken()
        calculator.operand = token.nextToken().toInt()
        calculator.calculate()
    }

    bufferedWriter.write(calculator.result.toString())
    bufferedReader.close()
    bufferedWriter.close()
}