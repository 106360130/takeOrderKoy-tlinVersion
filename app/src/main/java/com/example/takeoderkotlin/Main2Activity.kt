package com.example.takeoderkotlin

import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup

class Main2Activity : AppCompatActivity() {
    private var send_btn: Button? = null
    private var set_drink: EditText? = null
    private var set_name: EditText? = null
    private var rg1: RadioGroup? = null
    private var rg2: RadioGroup? = null
    private var rg3: RadioGroup? = null

    private var sugar = "無糖"
    private var ice = "微冰"
    private val size = "Larger"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        rg1 = findViewById(R.id.radioGroup)
        rg1!!.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.radioButton1 -> sugar = "無糖"
                R.id.radioButton2 -> sugar = "少糖"
                R.id.radioButton3 -> sugar = "半糖"
                R.id.radioButton4 -> sugar = "全糖"
            }
        }

        rg2 = findViewById(R.id.radioGroup2)
        rg2!!.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.radioButton5 -> ice = "微冰"
                R.id.radioButton6 -> ice = "少冰"
                R.id.radioButton7 -> ice = "正常冰"
            }
        }


        rg3 = findViewById(R.id.radioGroup3)
        rg3!!.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
                R.id.radioButton8 -> ice = "Larger"
                R.id.radioButton9 -> ice = "Medium"
                R.id.radioButton10 -> ice = "Small"
            }
        }
        send_btn = findViewById(R.id.btn_send)
        send_btn!!.setOnClickListener {
            set_name = findViewById(R.id.ed_name)
            set_drink = findViewById(R.id.ed_drink)

            val name = set_name!!.text.toString()
            val drink = set_drink!!.text.toString()

            val i = Intent()
            val b = Bundle()
            b.putString("name", name)
            b.putString("drink", drink)
            b.putString("size", size)
            b.putString("sugar", sugar)
            b.putString("ice", ice)
            i.putExtras(b)
            setResult(101, i)
            finish()
        }
    }
}