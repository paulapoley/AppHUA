package com.example.aplicacionfinal.Medico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.aplicacionfinal.*

class SobreHuaMedicoActivity : BaseMedicoActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sobre_hua_medico)
        setSupportActionBar(findViewById(R.id.my_toolbar_medico))
    }
    public fun onClickHome(v: View?){
        when (v?.id) {
            R.id.botonQueEsHUAMed -> {
                intent = Intent(this, QueEsHuaActivity::class.java)
                startActivity(intent)
            }

            R.id.botonSignosysintomasMed -> {
                intent = Intent(this, SignosySintomasActivity::class.java)
                startActivity(intent)
            }
            R.id.botonCausaHUAMed -> {
                intent = Intent(this, CausaHuaActivity::class.java)
                startActivity(intent)
            }
            R.id.botonPeligrosoMed -> {
                intent = Intent(this, EsPeligrosoActivity::class.java)
                startActivity(intent)
            }
            R.id.botonDiagnosticaMed -> {
                intent = Intent(this, ComoSeDiagnosticaActivity::class.java)
                startActivity(intent)
            }
            R.id.botonTtoMed -> {
                intent = Intent(this, TratamientoActivity::class.java)
                startActivity(intent)
            }
            R.id.botonMeCuidoMed -> {
                intent = Intent(this, MeCuidoActivity::class.java)
                startActivity(intent)
            }
            R.id.botonContactarMedicoMed -> {
                intent = Intent(this, ContactarMedicoActivity::class.java)
                startActivity(intent)
            }

        }
    }
}