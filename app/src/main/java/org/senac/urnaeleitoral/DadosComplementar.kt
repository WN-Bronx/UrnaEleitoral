package org.senac.urnaeleitoral

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class DadosComplementar : AppCompatActivity() {

    private lateinit var idade :EditText
    private lateinit var sexo : RadioGroup
    private lateinit var formacao : Spinner
    private lateinit var casa : RadioGroup
    private lateinit var votar : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dados_complementar)

        idade = findViewById<EditText>(R.id.eTextIdade)
        sexo = findViewById<RadioGroup>(R.id.rGroupSexo)
        formacao = findViewById<Spinner>(R.id.spFormacao)
        casa = findViewById<RadioGroup>(R.id.rGroupSouN)
        votar = findViewById<Button>(R.id.bttVotacao)

        ArrayAdapter.createFromResource(
            this,
            R.array.formacao_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
            formacao.adapter = adapter
        }
    }

    fun votacao(view: View) {
        if (validador()) {
            val op = intent.getStringExtra("op")
                Toast.makeText(this, "Obrigado por participar da entrevista. Seu voto foi no candidato : ${op}", Toast.LENGTH_LONG).show()
        }
    }

    fun validador() : Boolean{
        var validador = true

        if (idade.text.trim().length == 0 || idade.text.toString().toInt() < 16){
            idade.setError(" Você não tem 16 anos ou + para participar")
            validador = false
        }

        return validador
    }
}