package mx.paola.nutrieconomico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class CalcularTasa : AppCompatActivity() {

    lateinit var estatura: EditText
    lateinit var peso: EditText
    lateinit var edad: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calcular_tasa)

        this.estatura = this.findViewById(R.id.height)
        this.peso = this.findViewById(R.id.weight)
        this.edad = this.findViewById(R.id.age)




        val botonHombre: Button = findViewById(R.id.Hombre)
        botonHombre.setOnClickListener {

            val calculoHombre: Button = findViewById(R.id.calculate_buttom)

            var estatura1:String= estatura.text.toString()
            var edad1:String= edad.text.toString()
            var peso1:String= peso.text.toString()

            val resultH = (66.5 + (13.75 * peso1.toDouble())+(5.003 * estatura1.toDouble())-(6.755*edad1.toDouble()))


            val ejercicioNada1: Button = findViewById(R.id.nadaEjercicio)
            ejercicioNada1.setOnClickListener {
                val result1 = (resultH * 1.2)
                val resultH1: Int = result1.toInt()
                val Result1: String = resultH1.toString()
                calculoHombre.setOnClickListener {
                    val intent = Intent(this, TipoDieta::class.java)
                    intent.putExtra("calculo1", "$Result1")

                    startActivity(intent)
                }

            }
            val ejercicioLigero1: Button = findViewById(R.id.ligeroEjercicio)
            ejercicioLigero1.setOnClickListener {
                val result2 = (resultH * 1.375)
                val resultH2:Int = (result2.toInt())
                val Result2 = resultH2.toString()
                calculoHombre.setOnClickListener {
                    val intent = Intent(this, TipoDieta::class.java)
                    intent.putExtra("calculo1","$Result2" )
                    startActivity(intent)

                }}
            val ejercicioModerado1: Button = findViewById(R.id.moderadoEjercicio)
            ejercicioModerado1.setOnClickListener {
                val result3 = (resultH * 1.55)
                val resultH3: Int = (result3.toInt())
                val Result3 = resultH3.toString()
                calculoHombre.setOnClickListener {
                    val intent = Intent(this, TipoDieta::class.java)
                    intent.putExtra("calculo1","$Result3" )
                    startActivity(intent)


                }}
            val ejercicioIntenso: Button = findViewById(R.id.intensoEjercicio)
            ejercicioIntenso.setOnClickListener {
                val result4 = (resultH * 1.725)
                val resultH4: Int = (result4.toInt())
                val Result4 = resultH4.toString()
                calculoHombre.setOnClickListener {
                    val intent = Intent(this, TipoDieta::class.java)
                    intent.putExtra("calculo1","$Result4" )
                    startActivity(intent)


                }

            }}

        val botonMujer: Button = findViewById(R.id.Mujer)
        botonMujer.setOnClickListener {

            val calculoHombre: Button = findViewById(R.id.calculate_buttom)

            var estatura2:String= estatura.text.toString()
            var edad2:String= edad.text.toString()
            var peso2:String= peso.text.toString()


            val resultM = (655.1 + (9.563 * peso2.toDouble())+(1.850 * estatura2.toDouble())-(4.676 * edad2.toDouble()))

            val ejercicioNada2: Button = findViewById(R.id.nadaEjercicio)
            ejercicioNada2.setOnClickListener {
                val resultM1 = (resultM * 1.2)
                val resultMu1: Int = (resultM1.toInt())
                val ResultM1 = resultMu1.toString()

                calculoHombre.setOnClickListener {
                    val intent = Intent(this, TipoDieta::class.java)
                    intent.putExtra("calculo1","$ResultM1" )
                    startActivity(intent)


                }
            }
            val ejercicioLigero2: Button = findViewById(R.id.ligeroEjercicio)
            ejercicioLigero2.setOnClickListener {
                val resultM2 = (resultM * 1.375)
                val resultMu2: Int = (resultM2.toInt())
                val ResultM2 = resultMu2.toString()
                calculoHombre.setOnClickListener {
                    val intent = Intent(this, TipoDieta::class.java)
                    intent.putExtra("calculo1","$ResultM2" )
                    startActivity(intent)


                }
            }
            val ejercicioModerado2: Button = findViewById(R.id.moderadoEjercicio)
            ejercicioModerado2.setOnClickListener {
                val resultM3 = (resultM * 1.55)
                val resultMu3: Int = (resultM3.toInt())
                val ResultM3 = resultMu3.toString()
                calculoHombre.setOnClickListener {
                    val intent = Intent(this, TipoDieta::class.java)
                    intent.putExtra("calculo1","$ResultM3" )
                    startActivity(intent)


                }
            }
            val ejercicioIntenso2: Button = findViewById(R.id.intensoEjercicio)
            ejercicioIntenso2.setOnClickListener {
                val resultM4 = (resultM * 1.725)
                val resultMu4: Int = (resultM4.toInt())
                val ResultM4 = resultMu4.toString()
                calculoHombre.setOnClickListener {
                    val intent = Intent(this, TipoDieta::class.java)
                    intent.putExtra("calculo1","$ResultM4" )
                    startActivity(intent)


                }
            }

        }



    }
}