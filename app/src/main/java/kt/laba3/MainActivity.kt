package kt.laba3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var fraza: EditText
    private lateinit var res: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fraza = findViewById(R.id.fraza)
        res = findViewById(R.id.res)
        button = findViewById(R.id.button)

        button.setOnClickListener{
            val phrase: String = fraza.text.toString()

            if (isPalindrome(phrase)) {
                res.text = ("Данная фраза является палиндромом")
            } else {
                res.text = ("Данная фраза не является палиндромом")
            }
        }
    }

    private fun isPalindrome(phrase: String): Boolean {
        val cleanPhrase = phrase.replace("[^\\p{L}\\p{Nd}]".toRegex(), "").lowercase()
        return cleanPhrase == cleanPhrase.reversed()
    }
}