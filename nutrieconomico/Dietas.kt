package mx.paola.nutrieconomico

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


var resultFinal:TextView? = null
class Dietas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dietas)


        resultFinal = findViewById(R.id.calFinal)
        val final = intent.getStringExtra("calculoFinal")
        resultFinal?.text = " Redondea y has click: $final"





    }
    fun btn_1(view: View?) {
        val i = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://docs.google.com/spreadsheets/d/1hyw0-A_wuQShxRY0em_3dAF5mYWS5Vn78nQN4_i4Ofo/edit#gid=0")
        )
        startActivity(i)
    }
    fun btn_2(view: View?) {
        val i = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://docs.google.com/spreadsheets/d/1yONJu3hQ6PtG39IOR6_8N3u0uU1stwRqGFp-ZR8kCUE/edit?usp=sharing")
        )
        startActivity(i)
    }
    fun btn_3(view: View?) {
        val i = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://docs.google.com/spreadsheets/d/1OhPYL0ODBQequfujg6bQLBzRYZnmw7Q7thaiWbw9m-g/edit?usp=sharing")
        )
        startActivity(i)
    }
    fun btn_4(view: View?) {
        val i = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://docs.google.com/spreadsheets/d/1Yea8-IZRe1XngcD-FhNloMXkpmpQyu_j2qFd3G3XqP0/edit?usp=sharing")
        )
        startActivity(i)
    }
    fun btn_5(view: View?) {
        val i = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://docs.google.com/spreadsheets/d/1K2IlC8cVT6dOhNokk_DrPwNDbidNCaaEJ1fJtMLmaVM/edit?usp=sharing")
        )
        startActivity(i)
    }
    fun btn_6(view: View?) {
        val i = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://docs.google.com/spreadsheets/d/1vU7ll_csDmhDw0w6vLf4qeevq8LrGsH2ItlTfvYBS04/edit?usp=sharing")
        )
        startActivity(i)
    }
    fun btn_7(view: View?) {
        val i = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://docs.google.com/spreadsheets/d/1klJQB0gQlmI2bFb1_1ySpkezJ6EqHhPUeuXwiFYN8tM/edit?usp=sharing")
        )
        startActivity(i)
    }
    fun btn_8(view: View?) {
        val i = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://docs.google.com/spreadsheets/d/1rmxOz-AuLUWiIr0Omk0kVkCkmnqpoOnYQLoqDU-xVkE/edit?usp=sharing")
        )
        startActivity(i)
    }
    fun btn_9(view: View?) {
        val i = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://docs.google.com/spreadsheets/d/1iAl5FtjDTp34g9_A9hSO18MoNcX6ClBsLXVxZ8ZYgY8/edit?usp=sharing")
        )
        startActivity(i)
    }
    fun btn_10(view: View?) {
        val i = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://docs.google.com/spreadsheets/d/1jhq6lovIBCMeIYRiM3yKo6ZE5IOqO7_nbc3aPbQGmfQ/edit?usp=sharing")
        )
        startActivity(i)
    }
    fun btn_11(view: View?) {
        val i = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://docs.google.com/spreadsheets/d/1a4PzdPc8F1QqPGVHp4VsvMJAir9Q7zFKsPiaxo1gn4Q/edit?usp=sharing")
        )
        startActivity(i)
    }
    fun btn_12(view: View?) {
        val i = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://docs.google.com/spreadsheets/d/1RWYLIHDiw_Fv7pekvYB74zN9m8cYdsUYYcqfWiEmvX8/edit?usp=sharing")
        )
        startActivity(i)
    }
    fun btn_13(view: View?) {
        val i = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://docs.google.com/spreadsheets/d/1rEehus-wjzEFsase78i1BF6I9WqybS-zN1GaGFzqXMY/edit?usp=sharing")
        )
        startActivity(i)
    }
    fun btn_14(view: View?) {
        val i = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://docs.google.com/spreadsheets/d/1vCtDx3P1tnb3VtmmGYlhy5nuXTDMwJNgF1nSh9o1-HQ/edit?usp=sharing")
        )
        startActivity(i)
    }

}