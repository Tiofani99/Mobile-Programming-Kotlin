package com.tiooooo.myintentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.tiooooo.myintentapp.model.Person

class MoveWithObjectActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_PERSON = "person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        val tvMoveWithObj:TextView = findViewById(R.id.tv_obj_received)
        val person = intent.getParcelableExtra(EXTRA_PERSON) as Person
        val text = "Name : ${person.name.toString()},\nEmail : ${person.email.toString()}\n" +
                "Age : ${person.age.toString()}\n" +
                "Location : ${person.city}"

        tvMoveWithObj.text = text
    }
}
