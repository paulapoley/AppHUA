package com.example.aplicacionfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.aplicacionfinal.Paciente.HomePacienteActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.home -> {
                startActivity(Intent(this, HomePacienteActivity::class.java))
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