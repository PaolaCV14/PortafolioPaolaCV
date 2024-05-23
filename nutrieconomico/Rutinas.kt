package mx.paola.nutrieconomico

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class Rutinas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rutinas)
        val imagenHit = findViewById<ImageView>(R.id.hit)
        val url1 = "https://i.ibb.co/SBJWk22/hit.jpg"
        Picasso.get().load(url1).into(imagenHit)
        val imagenSuperior = findViewById<ImageView>(R.id.superior)
        val url2 = "https://i.ibb.co/HGpm85V/Screenshot-2022-03-07-215423.jpg"
        Picasso.get().load(url2).into(imagenSuperior)
        val imagenInferior = findViewById<ImageView>(R.id.inferior)
        val url3 = "https://i.ibb.co/NtvZ6Kq/Screenshot-2022-03-07-215925.jpg"
        Picasso.get().load(url3).into(imagenInferior)
        val imagenAbdomen = findViewById<ImageView>(R.id.abdomen)
        val url4 = "https://i.ibb.co/f8V05Pv/Screenshot-2022-03-07-220526.jpg"
        Picasso.get().load(url4).into(imagenAbdomen)
        val imagenCalentamiento = findViewById<ImageView>(R.id.calentamiento)
        val url5 = "https://i.ibb.co/7nkhgsQ/Screenshot-2022-03-07-220909.jpg"
        Picasso.get().load(url5).into(imagenCalentamiento)
    }

    fun hit(view: View?) {
        val i = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://www.youtube.com/watch?v=yOkFhJBEKwo&list=PLapSxVk3lXqP_e3YAsxoCfPmmGr1ez7F9")
        )
        startActivity(i)
    }

    fun superior(view: View?) {
        val i = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://www.youtube.com/watch?v=2JPfhDU7H2w&list=PLapSxVk3lXqMqS4GDH4-DjYesqNwrmjcu")
        )
        startActivity(i)
    }

    fun inferior(view: View?) {
        val i = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://www.youtube.com/watch?v=SasACgGscHg&list=PLapSxVk3lXqNZjPySS9Wjvg6Gm6uk8-st")
        )
        startActivity(i)
    }

    fun abdomen(view: View?) {
        val i = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://www.youtube.com/watch?v=6hW1lU0zSXw&list=PLapSxVk3lXqMLTO2L9B_hLkXa7Z1ElFTL")
        )
        startActivity(i)
    }

    fun calentamiento(view: View?) {
        val i = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://www.youtube.com/watch?v=g0z0rqoSmxY&list=PLapSxVk3lXqP9BRqeZotQ4dXAD7zUTzf7")
        )
        startActivity(i)
    }


}