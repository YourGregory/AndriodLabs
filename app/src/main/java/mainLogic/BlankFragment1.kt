package mainLogic

import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.*
import android.widget.*
import androidx.core.content.getSystemService
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.androidlab25.R
import timber.log.Timber

class BlankFragment1 : Fragment() {

    lateinit var amount: TextView
    lateinit var convertedAmountField : TextView
    lateinit var fromSpinner: Spinner
    lateinit var toSpinner: Spinner
    private lateinit var button: Button

    private lateinit var viewModel : MainLogicViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_blank1, container, false)

        viewModel = ViewModelProviders.of(this).get(MainLogicViewModel::class.java)

        viewModel.fromCurrency.observe(viewLifecycleOwner, Observer { newValue ->

        })

        fromSpinner = view.findViewById(R.id.from)
        toSpinner = view.findViewById(R.id.to)
        amount = view.findViewById(R.id.amount)
        convertedAmountField = view.findViewById(R.id.converted_amount)

        fromSpinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (adapterView != null) {
                    viewModel.fromCurrency.value = adapterView.getItemAtPosition(position).toString()
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
        toSpinner.onItemSelectedListener = object :

            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (adapterView != null) {
                    viewModel.toCurrency = adapterView.getItemAtPosition(position).toString()
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

        viewModel.eventFinish.observe(viewLifecycleOwner, Observer{ hasFinished ->
            if (hasFinished) {
                finish()
                viewModel.onFinishComplete()
            }
        })

        button = view.findViewById(R.id.button)
        button.setOnClickListener {
            convert(it)
        }

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        return inflater.inflate(R.menu.menu, menu)
    }

    fun convert(view: View) {

        val reverseCurrency = viewModel.fromCurrency.value
        viewModel.fromCurrency.value = viewModel.toCurrency
        if (reverseCurrency != null) {
            viewModel.toCurrency = reverseCurrency
        }
        Timber.i("fromCurrency is $viewModel.fromCurrency")
        Timber.i("toCurrency is $viewModel.toCurrency")

        val doubleAmount: Double = amount.text.toString().toDouble()
        convertedAmountField.text = (doubleAmount*viewModel.checkRate()).toString()
    }

    private fun finish() {
        Toast.makeText(this.activity, "you got your result!", Toast.LENGTH_SHORT).show()
        buzz(longArrayOf(100, 100, 100, 100, 100, 100))
    }

    private fun buzz(pattern: LongArray) {
        val buzzer = activity?.getSystemService<Vibrator>()

        buzzer?.let {
            if (Build.VERSION.SDK_INT >= Build .VERSION_CODES.O) {
                buzzer.vibrate(VibrationEffect.createWaveform(pattern, -1))
            } else {
                //deprecated in API 26
                buzzer.vibrate(pattern, -1)
            }
        }
    }
}