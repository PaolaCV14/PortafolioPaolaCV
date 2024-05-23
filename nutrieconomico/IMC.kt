package mx.paola.nutrieconomico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class IMC : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

       val estatura: EditText =findViewById(R.id.estaturaimc)
        val peso: EditText =findViewById(R.id.pesoimc)
        val resultado: TextView =findViewById(R.id.resultadoimc)
        val botonimc: Button =findViewById(R.id.calculateimc)


        val imagenIMC = findViewById<ImageView>(R.id.IMCimagen)
        val url1 = "https://i.ibb.co/JxWtrPF/IMC.jpg"
        Picasso.get().load(url1).into(imagenIMC)

        botonimc.setOnClickListener {
            var estatura:String= estatura.text.toString()
            var peso:String= peso.text.toString()
            val estaturaI= estatura.toFloat()/100

            val result= peso.toFloat() / (estaturaI * estaturaI)
            val rsultado = result.toInt()

           // val result= ((peso.toInt()) / ((estatura.toInt()/100) * (estatura.toInt()/100)))
           // val result= 6 / 3
            val Result= rsultado.toString()

            resultado?.text= "$Result"

        }





    }
}