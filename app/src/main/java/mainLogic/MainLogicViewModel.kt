package mainLogic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

private val CORRECT_BUZZ_PATTERN = longArrayOf(100, 100, 100, 100, 100, 100)
private val PANIC_BUZZ_PATTERN = longArrayOf(0, 200)
private val GAME_OVER_BUZZ_PATTERN = longArrayOf(0, 2000)
private val NO_BUZZ_PATTERN = longArrayOf(0)

class MainLogicViewModel : ViewModel() {

    public enum class BuzzType(val pattern: LongArray) {
        CORRECT(CORRECT_BUZZ_PATTERN),
        GAME_OVER(GAME_OVER_BUZZ_PATTERN),
        COUNTDOWN_PANIC(PANIC_BUZZ_PATTERN),
        NO_BUZZ(NO_BUZZ_PATTERN)
    }

    var fromCurrency = MutableLiveData<String>()
    lateinit var toCurrency : String

    private val _eventFinish = MutableLiveData<Boolean>()
    val eventFinish: LiveData<Boolean>
        get() = _eventFinish

    init {
        _eventFinish.value = false
        Timber.i("MainViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("MainViewModel destroyed")
    }
    fun checkRate(): Double {
        var rate = 0.0
        if(fromCurrency.value == "UAH") {
            if (toCurrency == "UAH") {
                rate =  1.0
            } else if (toCurrency == "USD") {
                rate = 0.036
            } else if (toCurrency == "EUR") {
                rate = 0.03
            } else if (toCurrency == "INR") {
                rate = 2.65
            } else if (toCurrency == "JPY") {
                rate = 3.71
            } else if (toCurrency == "RUB") {
                rate = 2.6
            } else if (toCurrency == "TRY") {
                rate = 0.28
            } else if (toCurrency == "RON") {
                rate = 0.14
            } else if (toCurrency == "MNT") {
                rate = 102.68
            } else if (toCurrency == "CNY") {
                rate = 0.23
            }
        } else if (fromCurrency.value == "USD") {
            if (toCurrency == "UAH") {
                rate = 27.12
            } else if (toCurrency == "USD") {
                rate = 1.0
            } else if (toCurrency == "EUR") {
                rate = 0.82
            } else if (toCurrency == "INR") {
                rate = 73.55
            } else if (toCurrency == "JPY") {
                rate = 103.64
            } else if (toCurrency == "RUB") {
                rate = 73.75
            } else if (toCurrency == "TRY") {
                rate = 7.83
            } else if (toCurrency == "RON") {
                rate = 4.00
            } else if (toCurrency == "MNT") {
                rate = 2845.0
            } else if (toCurrency == "CNY") {
                rate = 6.5
            }
        } else if (fromCurrency.value == "EUR") {
            if (toCurrency == "UAH") {
                rate = 32.68
            } else if (toCurrency == "USD") {
                rate = 1.2
            } else if (toCurrency == "EUR") {
                rate = 1.0
            } else if (toCurrency == "INR") {
                rate = 89.37
            } else if (toCurrency == "JPY") {
                rate = 125.99
            } else if (toCurrency == "RUB") {
                rate = 89.18
            } else if (toCurrency == "TRY") {
                rate = 9.52
            } else if (toCurrency == "RON") {
                rate = 4.86
            } else if (toCurrency == "MNT") {
                rate = 3463.81
            } else if (toCurrency == "CNY") {
                rate = 7.95
            }
        } else if (fromCurrency.value == "INR") {
            if (toCurrency == "UAH") {
                return 0.37
            } else if (toCurrency == "USD") {
                return 0.013
            } else if (toCurrency == "EUR") {
                return 0.011
            } else if (toCurrency == "INR") {
                return 1.0
            } else if (toCurrency == "JPY") {
                return 1.4
            } else if (toCurrency == "RUB") {
                return 0.99
            } else if (toCurrency == "TRY") {
                return 0.10
            } else if (toCurrency == "RON") {
                return 0.05
            } else if (toCurrency == "MNT") {
                return 38.73
            } else if (toCurrency == "CNY") {
                return 0.08
            }
        } else if (fromCurrency.value == "JPY") {
            if (toCurrency == "UAH") {
                return 0.26
            } else if (toCurrency == "USD") {
                return 0.0096
            } else if (toCurrency == "EUR") {
                return 0.0079
            } else if (toCurrency == "INR") {
                return 0.7
            } else if (toCurrency == "JPY") {
                return 1.0
            } else if (toCurrency == "RUB") {
                return 0.7
            } else if (toCurrency == "TRY") {
                return 0.07
            } else if (toCurrency == "RON") {
                return 0.03
            } else if (toCurrency == "MNT") {
                return 27.49
            } else if (toCurrency == "CNY") {
                return 0.063
            }
        } else if (fromCurrency.value == "RUB") {
            if (toCurrency == "UAH") {
                return 0.37
            } else if (toCurrency == "USD") {
                return 0.01
            } else if (toCurrency == "EUR") {
                return 0.011
            } else if (toCurrency == "INR") {
                return 1.0026
            } else if (toCurrency == "JPY") {
                return 1.41
            } else if (toCurrency == "RUB") {
                return 1.0
            } else if (toCurrency == "TRY") {
                return 0.10
            } else if (toCurrency == "RON") {
                return 0.054
            } else if (toCurrency == "MNT") {
                return 38.83
            } else if (toCurrency == "CNY") {
                return 0.089
            }
        } else if (fromCurrency.value == "TRY") {
            if (toCurrency == "UAH") {
                return 3.54
            } else if (toCurrency == "USD") {
                return 0.12
            } else if (toCurrency == "EUR") {
                return 0.10
            } else if (toCurrency == "INR") {
                return 9.38
            } else if (toCurrency == "JPY") {
                return 13.22
            } else if (toCurrency == "RUB") {
                return 9.3
            } else if (toCurrency == "TRY") {
                return 1.1
            } else if (toCurrency == "RON") {
                return 0.51
            } else if (toCurrency == "MNT") {
                return 363.56
            } else if (toCurrency == "CNY") {
                return 0.83
            }
        } else if (fromCurrency.value == "RON") {
            if (toCurrency == "UAH") {
                return 6.9
            } else if (toCurrency == "USD") {
                return 0.25
            } else if (toCurrency == "EUR") {
                return 0.20
            } else if (toCurrency == "INR") {
                return 18.36
            } else if (toCurrency == "JPY") {
                return 25.88
            } else if (toCurrency == "RUB") {
                return 18.31
            } else if (toCurrency == "TRY") {
                return 1.95
            } else if (toCurrency == "RON") {
                return 1.1
            } else if (toCurrency == "MNT") {
                return 711.43
            } else if (toCurrency == "CNY") {
                return 1.63
            }
        } else if (fromCurrency.value == "MNT") {
            if (toCurrency == "UAH") {
                return 0.0097
            } else if (toCurrency == "USD") {
                return 0.0004
            } else if (toCurrency == "EUR") {
                return 0.0003
            } else if (toCurrency == "INR") {
                return 0.025
            } else if (toCurrency == "JPY") {
                return 0.036
            } else if (toCurrency == "RUB") {
                return 0.025
            } else if (toCurrency == "TRY") {
                return 0.0028
            } else if (toCurrency == "RON") {
                return 0.0014
            } else if (toCurrency == "MNT") {
                return 1.1
            } else if (toCurrency == "CNY") {
                return 0.0023
            }
        } else if (fromCurrency.value == "CNY") {
            if (toCurrency == "UAH") {

            } else if (toCurrency == "USD") {
                return 0.15
            } else if (toCurrency == "EUR") {
                return 0.12
            } else if (toCurrency == "INR") {
                return 11.24
            } else if (toCurrency == "JPY") {
                return 15.86
            } else if (toCurrency == "RUB") {
                return 11.21
            } else if (toCurrency == "TRY") {
                return 1.19
            } else if (toCurrency == "RON") {
                return 0.6124
            } else if (toCurrency == "MNT") {
                return 435.661
            } else if (toCurrency == "CNY") {
                return 1.0
            }
        }
        _eventFinish.value = true
        return rate
    }

    fun onFinishComplete() {
        _eventFinish.value = false
    }
}