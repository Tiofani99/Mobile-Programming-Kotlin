package com.tiooooo.myintentapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.tiooooo.myintentapp.model.Person

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvResult: TextView

    companion object{
        private const val REQUEST_CODE =100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveWithData: Button = findViewById(R.id.btn_move_with_data)
        btnMoveWithData.setOnClickListener(this)

        val btnMoveWithObjIntent: Button = findViewById(R.id.btn_move_with_object)
        btnMoveWithObjIntent.setOnClickListener(this)

        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        val btnMoveForResult:Button = findViewById(R.id.btn_move_with_result)
        btnMoveForResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)

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

                    val moveWithObjIntent = Intent(this, MoveWithObjectActivity::class.java)
                    moveWithObjIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                    startActivity(moveWithObjIntent)

                }

                R.id.btn_dial_number -> {
                    val phoneNumber = "081234567891"
                    val dialPhoneIntent =
                        Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                    startActivity(dialPhoneIntent)
                }

                R.id.btn_move_with_result ->{
                    val moveForResult = Intent(this,MoveForResultActivity::class.java)
                    startActivity(moveForResult)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("Error","OnActivityResult jalan")

        if (requestCode == REQUEST_CODE) {
            if (resultCode == MoveForResultActivity.RESULT_CODE) {
                val selectedValue = data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
                tvResult.text = "Hasil : $selectedValue"
            }

//        if(requestCode == REQUEST_CODE){
//            if(resultCode == MoveForResultActivity.RESULT_CODE){
//                Log.d("Error","OnActivityResult jalan")
//                val selectedValue = data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE,0)
//                    tvResult.text = "Hasil : $selectedValue"
//            }
       }
    }
}
