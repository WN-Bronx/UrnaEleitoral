package org.senac.urnaeleitoral

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {

    private lateinit var op : RadioGroup
    private lateinit var votar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        op = findViewById<RadioGroup>(R.id.rGroupCandidato)
        votar = findViewById<Button>(R.id.bttVotar)

    }

    fun votacao(view: View){

        val opCandidato : RadioButton = findViewById<RadioButton>(op.checkedRadioButtonId)
        val tela  = Intent(this, DadosComplementar ::class.java).apply { this
            putExtra("op", opCandidato.text.toString())
        }
        startActivity(tela)
    }
}