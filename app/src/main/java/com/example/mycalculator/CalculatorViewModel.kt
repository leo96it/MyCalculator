import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CalculatorViewModel: ViewModel()
{
    /* Expose screen UI state */

    // Mutable deve essere private perchè deve poter essere modificata solo dal viewmodel
    private val _uiState = MutableStateFlow(CalculatorState.Initialize)
    //private val _uiState: MutableStateFlow<CalculatorState> = MutableStateFlow(CalculatorState("0"))
    // Immutable espone il valore di uiState in modalità read-only
    val uiState: StateFlow<CalculatorState> = _uiState.asStateFlow()


    /* Handle business logic */

    // Quando viene premuto un numero aggiunge questo alla schermata
    fun numberAppend(number: String)
    {
        if (uiState.value.operation.isEmpty())
            _uiState.update { uiState.value.copy(
                currentValue = uiState.value.currentValue + number,
                operation = uiState.value.currentValue + number
            )}
        else if(!uiState.value.operation.endsWith("="))
            _uiState.update { uiState.value.copy(
                currentValue = uiState.value.currentValue + number,
                operation = uiState.value.operation + number
            )}
        else
        {
            this.deleteAll()
            _uiState.update { uiState.value.copy(
                currentValue = uiState.value.currentValue + number,
                operation = uiState.value.currentValue + number
            )}
        }
    }

    fun operatorAppend(action: String)
    {
        val currentValue = uiState.value.currentValue
        val operator = uiState.value.operator
        val operation = uiState.value.operation

        if (currentValue.isNotEmpty() && !operation.endsWith("="))
        {
            if (action == "=")
            {
                _uiState.update {
                    uiState.value.copy(
                        secondNumber = currentValue.toDouble(),
                        operation = "$operation $action"
                    )
                }
                calculate(operator)
            }
            else
            {
                if(action == ",")
                    _uiState.update { uiState.value.copy(
                        currentValue = currentValue + action,
                        operation = "$currentValue$action"
                    )}
                else
                    _uiState.update { uiState.value.copy(
                            firstNumber = currentValue.replace(",", ".").toDouble(),
                            operation = "$currentValue $action ",
                            currentValue = "",
                            operator = action
                    )}
            }
        }
    }

    fun calculate(operand: String)
    {
        val firstNumber = uiState.value.firstNumber
        val secondNumber = uiState.value.secondNumber

        when(operand)
        {
            "+" -> _uiState.update { uiState.value.copy(
                currentValue = (firstNumber + secondNumber).toString()
            )}
            "-" -> _uiState.update { uiState.value.copy(
                currentValue = (firstNumber - secondNumber).toString()
            )}
            "x" -> _uiState.update { uiState.value.copy(
                currentValue = (firstNumber * secondNumber).toString()
            )}
            "÷" -> _uiState.update { uiState.value.copy(
                currentValue = (firstNumber / secondNumber).toString()
            )}
        }

        if (uiState.value.currentValue.contains(".0"))
            _uiState.update { uiState.value.copy(
                currentValue = uiState.value.currentValue.dropLast(2)
            )}
        _uiState.update { uiState.value.copy(
            currentValue = uiState.value.currentValue.replace(".", ",")
        )}

    }

    fun deleteAll()
    {
        _uiState.update { uiState.value.copy(
            currentValue = "",
            firstNumber = 0.0,
            secondNumber = 0.0,
            operation = "") }
    }

    fun deleteLast()
    {
        val currentValue = uiState.value.currentValue
        val operation = uiState.value.operation

        _uiState.update { uiState.value.copy(
            currentValue = currentValue.dropLast(1),
            operation = operation.dropLast(1)
        )}
    }


}