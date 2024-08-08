package com.example.aplicacionfinal.Paciente

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.aplicacionfinal.*

class SobreHuaActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sobre_huaactivity)
        setSupportActionBar(findViewById(R.id.my_toolbar))
    }

    public fun onClickHome(v: View?){
        when (v?.id) {
            R.id.botonQueEsHUA -> {
                intent = Intent(this, QueEsHuaActivity::class.java)
                startActivity(intent)
            }

            R.id.botonSignosysintomas -> {
                intent = Intent(this, SignosySintomasActivity::class.java)
                startActivity(intent)
            }
            R.id.botonCausaHUA -> {
                intent = Intent(this, CausaHuaActivity::class.java)
                startActivity(intent)
            }
            R.id.botonPeligroso -> {
                intent = Intent(this, EsPeligrosoActivity::class.java)
                startActivity(intent)
            }
            R.id.botonDiagnostica -> {
                intent = Intent(this, TodosDiagnosticosActivity::class.java)
                startActivity(intent)
            }
            R.id.botonTto -> {
                intent = Intent(this, TratamientoActivity::class.java)
                startActivity(intent)
            }
            R.id.botonMeCuido -> {
                intent = Intent(this, MeCuidoActivity::class.java)
                startActivity(intent)
            }
            R.id.botonContactarMedico -> {
                intent = Intent(this, ContactarConMedicoPacienteActivity::class.java)
                startActivity(intent)
            }

        }
    }
}