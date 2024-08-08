package com.example.aplicacionfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class TodosDiagnosticosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todos_diagnosticos)
    }

    public fun onClickHome(v: View?) {
        when (v?.id) {
            R.id.botonEcografia -> {
                intent = Intent(this, EcografiaActivity::class.java)
                startActivity(intent)
            }

            R.id.botonHisteroscopia -> {
                intent = Intent(this, HisteroscopiaActivity::class.java)
                startActivity(intent)
            }
            R.id.botonExamenPelvico -> {
                intent = Intent(this, ExamenPelvicoActivity::class.java)
                startActivity(intent)
            }
            R.id.botonBiopsia -> {
                intent = Intent(this, BiopsiaActivity::class.java)
                startActivity(intent)
            }
            R.id.botonAnalisisSangre -> {
                intent = Intent(this, AnalisisSangreActivity::class.java)
                startActivity(intent)
            }
            R.id.botonPapanicolau -> {
                intent = Intent(this, PapanicolauActivity::class.java)
                startActivity(intent)
            }

        }
    }
}
