package mx.paola.nutrieconomico.TodosGoals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import mx.paola.nutrieconomico.R

class Goals4 : AppCompatActivity() {
    private lateinit var btn_sem4: Button
    private lateinit var  imagenSemana4: ImageView
    private lateinit var btn_siguiente4: Button
    companion object{
        val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goals4)

        btn_sem4 = findViewById(R.id.boton_sem4)
        imagenSemana4 = findViewById(R.id.semana4)
        btn_siguiente4 = findViewById(R.id.irsemana5)

        btn_sem4.setOnClickListener {
            pickImageGallery()
        }


        btn_siguiente4.setOnClickListener {
            val intent: Intent = Intent(this, Goals5::class.java)
            startActivity(intent)
        }
    }
    private fun pickImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        @Suppress("DEPRECATION")
        startActivityForResult(intent, Goals.IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        @Suppress("DEPRECATION")
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Goals.IMAGE_REQUEST_CODE && resultCode == RESULT_OK)
            imagenSemana4.setImageURI(data?.data)
    }
}