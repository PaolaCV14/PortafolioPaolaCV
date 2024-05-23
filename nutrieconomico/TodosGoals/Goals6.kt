package mx.paola.nutrieconomico.TodosGoals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import mx.paola.nutrieconomico.R

class Goals6 : AppCompatActivity() {
    private lateinit var btn_sem6: Button
    private lateinit var  imagenSemana6: ImageView

    companion object{
        val IMAGE_REQUEST_CODE = 100
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goals6)

        btn_sem6 = findViewById(R.id.boton_sem6)
        imagenSemana6 = findViewById(R.id.semana6)

        btn_sem6.setOnClickListener {
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
            imagenSemana6.setImageURI(data?.data)
    }
}