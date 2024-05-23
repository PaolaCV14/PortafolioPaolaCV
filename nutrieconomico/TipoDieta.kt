package mx.paola.nutrieconomico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class TipoDieta : AppCompatActivity() {

    var calculoPrim: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tipo_dieta)

        calculoPrim = findViewById(R.id.calcularResultado)
        val calculo = intent.getStringExtra("calculo1")
        calculoPrim?.text = "$calculo kcal"



        val subirPeso: ImageView = findViewById(R.id.aumentar)
        subirPeso.setOnClickListener{

            val subir = calculo?.toInt()
            val pesoSubir = (subir?.plus(300))
            val finalSubir = pesoSubir.toString()

            val intent: Intent = Intent(this, Dietas::class.java)
            intent.putExtra("calculoFinal","$finalSubir" )
            startActivity(intent)


        }
        val mantenerPeso: ImageView = findViewById(R.id.mantener)
        mantenerPeso.setOnClickListener{
            val subir = calculo?.toInt()

            val finalSubir = subir.toString()

            val intent: Intent = Intent(this, Dietas::class.java)
            intent.putExtra("calculoFinal","$finalSubir" )

            startActivity(intent)
        }
        val bajarPeso: ImageView = findViewById(R.id.bajar)
        bajarPeso.setOnClickListener{

            val subir = calculo?.toInt()
            val pesoSubir = (subir?.minus(300))
            val finalSubir = pesoSubir.toString()

            val intent: Intent = Intent(this, Dietas::class.java)
            intent.putExtra("calculoFinal","$finalSubir" )
            startActivity(intent)

        }
        val bajar2Peso: TextView = findViewById(R.id.bajarPeso)
        bajar2Peso.setOnClickListener{

            val subir = calculo?.toInt()
            val pesoSubir = (subir?.minus(500))
            val finalSubir = pesoSubir.toString()

            val intent: Intent = Intent(this, Dietas::class.java)
            intent.putExtra("calculoFinal","$finalSubir" )
            startActivity(intent)

        }
        val mantener2Peso: TextView = findViewById(R.id.mantenerPeso)
        mantener2Peso.setOnClickListener{

            val subir = calculo?.toInt()
            val finalSubir = subir.toString()
            val intent: Intent = Intent(this, Dietas::class.java)
            intent.putExtra("calculoFinal","$finalSubir" )
            startActivity(intent)
        }
        val subir2Peso: TextView = findViewById(R.id.subirPeso)
        subir2Peso.setOnClickListener{

            val subir = calculo?.toInt()
            val pesoSubir = (subir?.plus(300))
            val finalSubir = pesoSubir.toString()

            val intent: Intent = Intent(this, Dietas::class.java)
            intent.putExtra("calculoFinal","$finalSubir" )
            startActivity(intent)

        }
    }
}