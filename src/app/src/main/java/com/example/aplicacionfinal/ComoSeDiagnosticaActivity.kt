package com.example.aplicacionfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ComoSeDiagnosticaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_como_se_diagnostica)
    }
    public fun onClickHome(v: View?) {
        when (v?.id) {
            R.id.botonTodos -> {
                intent = Intent(this, TodosDiagnosticosActivity::class.java)
                startActivity(intent)
            }
        }
    }
}