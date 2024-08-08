package com.example.aplicacionfinal.Medico

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.aplicacionfinal.BaseActivity
import com.example.aplicacionfinal.Paciente.SobreHuaActivity
import com.example.aplicacionfinal.R
import com.example.aplicacionfinal.R.id.my_toolbar_medico

class HomeMedicoActivity : BaseMedicoActivity() {
    private lateinit var signOutButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_medico)
        setSupportActionBar(findViewById(my_toolbar_medico))

    }

    public fun onClickHome(v: View?){
        when (v?.id) {
            R.id.botonSobreHUAMed -> {
                intent = Intent(this, SobreHuaMedicoActivity::class.java)
                startActivity(intent)
            }
            R.id.botonPedirCitaMedico -> {
                intent = Intent(this, PedirCitaMedicoActivity::class.java)
                startActivity(intent)
            }
        }
    }
}