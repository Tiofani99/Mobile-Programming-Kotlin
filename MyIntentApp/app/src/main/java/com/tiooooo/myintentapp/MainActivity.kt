package com.tiooooo.myintentapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.tiooooo.myintentapp.model.Person

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithData: Button = findViewById(R.id.btn_move_with_data)
        btnMoveWithData.setOnClickListener(this)

        val btnMoveWithObjIntent: Button = findViewById(R.id.btn_move_with_object)
        btnMoveWithObjIntent.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.btn_move_activity -> {
                    val intent = Intent(this, MoveActivity::class.java)
                    startActivity(intent)
                }

                R.id.btn_move_with_data -> {
                    val moveWithDataIntent = Intent(this, MoveWithDataActivity::class.java)
                    moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "TIO FANI")
                    moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5)
                    startActivity(moveWithDataIntent)
                }

                R.id.btn_move_with_object -> {
                    val person = Person(
                        "Tio Fani",
                        20,
                        "tiofani03@gmail.com",
                        "Purwokerto"
                    )

                    val moveWithObjIntent = Intent(this,MoveWithObjectActivity::class.java)
                    moveWithObjIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON,person)
                    startActivity(moveWithObjIntent)

                }
            }
        }
    }
}
