package com.example.aplicacionfinal.Medico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.aplicacionfinal.AuthActivity
import com.example.aplicacionfinal.Paciente.HomePacienteActivity
import com.example.aplicacionfinal.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

open class BaseMedicoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_medico)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.home -> {
                startActivity(Intent(this, HomeMedicoActivity::class.java))
                true
            }
            R.id.logOut -> {
                Firebase.auth.signOut()
                startActivity(Intent(this, AuthActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}