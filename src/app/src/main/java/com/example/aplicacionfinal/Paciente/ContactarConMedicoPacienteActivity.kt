package com.example.aplicacionfinal.Paciente

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.aplicacionfinal.R

class ContactarConMedicoPacienteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactar_con_medico_paciente)
    }

    public fun onClickHome(v: View?) {
        when (v?.id) {
            R.id.botonIraCita -> {
                intent = Intent(this, PedirCitaActivity::class.java)
                startActivity(intent)
            }
        }
    }
}