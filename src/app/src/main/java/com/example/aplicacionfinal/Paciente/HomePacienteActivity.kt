package com.example.aplicacionfinal.Paciente

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.aplicacionfinal.BaseActivity
import com.example.aplicacionfinal.R

class HomePacienteActivity : BaseActivity() {
    /*private lateinit var btnPersonalInfo : Button
    private lateinit var btnHistorial : Button
    private lateinit var btnPruebasPendientes: Button*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_paciente)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        /*
        //Inicializamos la variable --> Pasar al activity InfoPacienteActivity
        btnPersonalInfo = findViewById(R.id.btnPersonalInfo)
        btnPersonalInfo.setOnClickListener {
            intent = Intent(this, InfoPacienteActivity::class.java)
            startActivity(intent)
        }

        //Botón historial --> Mensaje de log por consola
        btnHistorial = findViewById(R.id.btnHistorial)
        btnHistorial.setOnClickListener {
            Log.i("INFO", "Hemos pulsado el botón Historial de citas")
        }

        //Botón pruebas pendientes--> Mostrar un mensaje emergente en la aplicación (TOAST)
        btnPruebasPendientes = findViewById(R.id.btnPruebasPendientes)
        btnPruebasPendientes.setOnClickListener {
            Toast.makeText(this, "Aún no hay activity", Toast.LENGTH_SHORT).show()
        }*/

    }

    // Otra forma de hacerlo, más óptima
    public fun onClickHome(v: View?){
        when (v?.id) {
            R.id.btnPersonalInfo -> {
                intent = Intent(this, InfoPacienteActivity::class.java)
                startActivity(intent)
            }

            R.id.botonHistorialCitas -> {
                intent = Intent(this, HistorialCitasPacienteActivity::class.java)
                startActivity(intent)
            }
            R.id.btnCita -> {
                intent = Intent(this, PedirCitaActivity::class.java)
                startActivity(intent)
            }
            R.id.botonSobreHUA -> {
                intent = Intent(this, SobreHuaActivity::class.java)
                startActivity(intent)
            }
        }
    }
}