package mx.paola.nutrieconomico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import mx.paola.nutrieconomico.TodosGoals.Goals
import mx.paola.nutrieconomico.TodosGoals.Goals4

class Goals3 : AppCompatActivity() {
    private lateinit var btn_sem3: Button
    private lateinit var  imagenSemana3: ImageView
    private lateinit var btn_siguiente3: Button

    companion object{
        val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goals3)
        btn_sem3 = findViewById(R.id.boton_sem3)
        imagenSemana3 = findViewById(R.id.semana3)
        btn_siguiente3 = findViewById(R.id.irsemana4)

        btn_sem3.setOnClickListener {
            pickImageGallery()
        }
        btn_siguiente3.setOnClickListener {
            val intent: Intent = Intent(this, Goals4::class.java)
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
            imagenSemana3.setImageURI(data?.data)
    }
}