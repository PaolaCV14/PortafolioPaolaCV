package mx.paola.nutrieconomico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import mx.paola.nutrieconomico.entrar.Login
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class MainActivity : AppCompatActivity() {

    var bienvenida: TextView? = null
    private val list = mutableListOf<CarouselItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val carousel: ImageCarousel = findViewById(R.id.carousel)
        list.add(CarouselItem("https://i.ibb.co/Msj4fFb/8a934ed0-bc6a-45de-b469-11ad83e7ba07.jpg"))
        list.add(CarouselItem("https://i.ibb.co/2YwqjqF/b3009d6a-5aed-4782-86c5-9a0e424b7f7d.jpg"))
        list.add(CarouselItem("https://i.ibb.co/gjHs3hb/69cc1f35-ca41-4c76-a2da-e0498df49b4f.jpg"))
        list.add(CarouselItem("https://i.ibb.co/L0sXY10/48c9be9f-3411-4801-8d3b-47b856fca61c.jpg"))

        carousel.addData(list)

        bienvenida = findViewById( R.id.bienvenido)
        val nombre = intent.getStringExtra("recibir")
        bienvenida?.text = "Bienvenid@ $nombre"

        val calculadora: ImageView = findViewById(R.id.calculator)
        calculadora.setOnClickListener{
            val intent: Intent = Intent(this, CalcularTasa::class.java)
            startActivity(intent)}

        val comidas: ImageView = findViewById(R.id.dietas)
        comidas.setOnClickListener{
            val intent: Intent = Intent(this, Dietas::class.java)
            startActivity(intent)}

        val ejercicio: ImageView = findViewById(R.id.rutinas)
        ejercicio.setOnClickListener{
            val intent: Intent = Intent(this, Rutinas::class.java)
            startActivity(intent)}

        val lugares: ImageView = findViewById(R.id.lugares)
        lugares.setOnClickListener{
            val intent: Intent = Intent(this, IMC::class.java)
            startActivity(intent)}

        val objetivos: ImageView = findViewById(R.id.objetivos)
        objetivos.setOnClickListener {
            val intent: Intent = Intent(this, ToDoList::class.java)
            startActivity(intent)
        }

        val progreso: ImageView = findViewById(R.id.progreso)
        progreso.setOnClickListener {
            val intent: Intent = Intent(this, Metas::class.java)
            startActivity(intent)
        }

        val cerrar: Button = findViewById(R.id.cerrar)
        cerrar.setOnClickListener {
            val intent:  Intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

    }
}