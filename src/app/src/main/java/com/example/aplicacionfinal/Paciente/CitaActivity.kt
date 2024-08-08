package com.example.aplicacionfinal.Paciente

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.aplicacionfinal.BaseActivity
import com.example.aplicacionfinal.Modelo.Cita
import com.example.aplicacionfinal.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat

class CitaActivity : BaseActivity() {

    private lateinit var infoCita: TextView
    private lateinit var cancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cita)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        infoCita = findViewById(R.id.textView_infoCita)
        cancelar = findViewById(R.id.btn_cancelarCita)


        val cita = intent.extras?.getSerializable("cita") as Cita
        infoCita.text = cita.listmedico + " " + SimpleDateFormat("dd/MM/yyyy - HH:mm").format(cita.fechahora.time)

        cancelar.setOnClickListener{borrarcitaBD(cita)}
    }

    private fun borrarcitaBD(cita: Cita){
        if(cancelar.text.toString()=="CANCELAR CITA") {
            FirebaseFirestore.getInstance().collection("pacientes")
                .document(Firebase.auth.currentUser!!.email.toString())
                .collection("citas")
                .document(cita.id)
                .delete().addOnSuccessListener {
                    cancelar.text = "VOLVER"
                    infoCita.text = "La cita ha sido cancelada"
                }
        }
        else{
            intent = Intent(this, HistorialCitasPacienteActivity::class.java)
            startActivity(intent)
        }
    }
}