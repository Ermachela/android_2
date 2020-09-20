package by.st.school.demoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

private const val TEST_FUNCTION_ARGUMENT = 6

/**
 * Sample activity for debugging demonstration
 *
 * @author RamashkaAE
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val result = factorial(TEST_FUNCTION_ARGUMENT)
        val message = "Result: $result"
        resultTextView.text = message
    }

    private fun factorial(argument: Int): Int {
        var result = 1
        for (index in 1..argument) {
            result *= index
        }
        return result
    }
}