package mx.paola.nutrieconomico.entrar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import mx.paola.nutrieconomico.MainActivity
import mx.paola.nutrieconomico.R

class Login : AppCompatActivity() {

    private lateinit var logo: ImageView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        logo = findViewById(R.id.nutrilogo)
        logo.setImageResource(R.drawable.logo)

        val botonLogin: Button = findViewById(R.id.login)
        botonLogin.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            val nom = findViewById<EditText>(R.id.tuNombre)
            val nombre: String = nom.text.toString()
            intent.putExtra("recibir", nombre)
            startActivity(intent)

        }
    }
}