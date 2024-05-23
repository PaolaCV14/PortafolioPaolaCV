package mx.paola.nutrieconomico.TodosGoals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import mx.paola.nutrieconomico.R

class Goals5 : AppCompatActivity() {
    private lateinit var btn_sem5: Button
    private lateinit var  imagenSemana5: ImageView
    private lateinit var btn_siguiente5: Button
    companion object{
        val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goals5)

        btn_sem5 = findViewById(R.id.boton_sem5)
        imagenSemana5 = findViewById(R.id.semana5)
        btn_siguiente5 = findViewById(R.id.irsemana6)

        btn_siguiente5.setOnClickListener {
            val intent: Intent = Intent(this, Goals6::class.java)
            startActivity(intent)
        }

        btn_sem5.setOnClickListener {
            pickImageGallery()
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
            imagenSemana5.setImageURI(data?.data)
    }
}