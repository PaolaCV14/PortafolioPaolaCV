package mx.paola.nutrieconomico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso
import mx.paola.nutrieconomico.TodosGoals.*

class Metas : AppCompatActivity() {
    private lateinit var week1: ImageView
    private lateinit var week2: ImageView
    private lateinit var week3: ImageView
    private lateinit var week4: ImageView
    private lateinit var week5: ImageView
    private lateinit var week6: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metas)
        week1 = findViewById(R.id.week1)
        week2 = findViewById(R.id.week2)
        week3 = findViewById(R.id.week3)
        week4 = findViewById(R.id.week4)
        week5 = findViewById(R.id.week5)
        week6 = findViewById(R.id.week6)



        val url1: String = "https://i.ibb.co/nBFwhbX/Screenshot-2022-03-08-211832.jpg"
        Picasso.get().load(url1).into(week1)
        week1.setOnClickListener {
            val intent: Intent = Intent(this, Goals::class.java)
            startActivity(intent)
        }

        val url2: String = "https://i.ibb.co/2c4GJgd/Screenshot-2022-03-08-214631.jpg"
        Picasso.get().load(url2).into(week2)
        week2.setOnClickListener {
            val intent: Intent = Intent(this, Goals2::class.java)
            startActivity(intent)
        }

        val url3: String = "https://i.ibb.co/RhgM7SG/Screenshot-2022-03-08-215104.jpg"
        Picasso.get().load(url3).into(week3)
        week3.setOnClickListener {
            val intent: Intent = Intent(this, Goals3::class.java)
            startActivity(intent)
        }

        val url4 = "https://i.ibb.co/gD0Z5CQ/Screenshot-2022-03-08-215353.jpg"
        Picasso.get().load(url4).into(week4)
        week4.setOnClickListener {
            val intent: Intent = Intent(this, Goals4::class.java)
            startActivity(intent)
        }

        val url5 = "https://i.ibb.co/nbPdGj2/Screenshot-2022-03-08-215857.jpg"
        Picasso.get().load(url5).into(week5)
        week5.setOnClickListener {
            val intent: Intent = Intent(this, Goals5::class.java)
            startActivity(intent)
        }

        val url6 = "https://i.ibb.co/X4RfLng/Screenshot-2022-03-08-220308.jpg"
        Picasso.get().load(url6).into(week6)
        week6.setOnClickListener {
            val intent: Intent = Intent(this, Goals6::class.java)
            startActivity(intent)
        }



    }
}