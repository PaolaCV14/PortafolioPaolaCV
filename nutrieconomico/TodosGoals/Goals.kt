package mx.paola.nutrieconomico.TodosGoals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import mx.paola.nutrieconomico.R

class Goals : AppCompatActivity() {
    private lateinit var btn_sem1: Button
    private lateinit var  imagenSemana1: ImageView
    private lateinit var btn_siguiente1: Button
    companion object{
        val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goals)

        btn_sem1 = findViewById(R.id.boton_sem1)
        imagenSemana1 = findViewById(R.id.semana1)
        btn_siguiente1 = findViewById(R.id.irsemana2)

        btn_sem1.setOnClickListener {
            pickImageGallery()
        }
        btn_siguiente1.setOnClickListener {
            val intent: Intent = Intent(this, Goals2::class.java)
            startActivity(intent)
        }
    }



    private fun pickImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        @Suppress("DEPRECATION")
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        @Suppress("DEPRECATION")
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK)
            imagenSemana1.setImageURI(data?.data)
    }
}