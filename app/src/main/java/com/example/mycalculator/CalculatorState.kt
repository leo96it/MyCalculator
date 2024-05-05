data class CalculatorState(
    var currentValue: String,
    var firstNumber: Double,
    var secondNumber: Double,
    var operator: String, // + - / *
    var operation: String
){
    companion object
    {
        val Initialize = CalculatorState(
            currentValue = "",
            firstNumber = 0.0,
            secondNumber = 0.0,
            operator = "",
            operation = ""
            )
    }
}