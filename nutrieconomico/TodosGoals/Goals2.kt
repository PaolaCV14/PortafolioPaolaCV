package mx.paola.nutrieconomico.TodosGoals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import mx.paola.nutrieconomico.Goals3
import mx.paola.nutrieconomico.R

class Goals2 : AppCompatActivity() {
    private lateinit var btn_sem2: Button
    private lateinit var  imagenSemana2: ImageView
    private lateinit var btn_siguiente2: Button
    companion object{
        val IMAGE_REQUEST_CODE = 100
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goals2)


        btn_sem2 = findViewById(R.id.boton_sem2)
        imagenSemana2 = findViewById(R.id.semana2)
        btn_siguiente2 = findViewById(R.id.irsemana3)

        btn_sem2.setOnClickListener {
            pickImageGallery()
        }


        btn_siguiente2.setOnClickListener {
            val intent: Intent = Intent(this, Goals3::class.java)
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
            imagenSemana2.setImageURI(data?.data)
    }
}