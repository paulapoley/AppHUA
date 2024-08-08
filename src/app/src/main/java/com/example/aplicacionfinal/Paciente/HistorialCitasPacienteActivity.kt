package com.example.aplicacionfinal.Paciente

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicacionfinal.BaseActivity
import com.example.aplicacionfinal.Modelo.Cita
import com.example.aplicacionfinal.R
import com.example.aplicacionhua.Modelo.AdaptadorCitas
import com.google.firebase.Timestamp
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import java.util.*

class HistorialCitasPacienteActivity : BaseActivity() {

    private lateinit var listaCitas: RecyclerView
    private lateinit var etiquetaInfo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial_citas_paciente)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        listaCitas = findViewById(R.id.recyclerView_listaCitas)
        etiquetaInfo = findViewById(R.id.textView_infoHistorial)

        configuraListaCitas()
    }
    private fun configuraListaCitas(){
        //crear una lista de citas
        var lista = mutableListOf<Cita>()

        FirebaseFirestore.getInstance().collection("pacientes")
            .document(Firebase.auth.currentUser!!.email.toString())
            .collection("citas")
            .get().addOnSuccessListener {
                    it -> for(cita in it){
                val timestamp: Timestamp? = cita.getTimestamp("fecha y hora")
                val cal = Calendar.getInstance().apply { time = timestamp?.toDate() }
                var c = Cita(cita.id, cita.get("listmedico").toString(),cal)
                lista.add(c)
            }
                val adaptador = AdaptadorCitas(lista){it->clickCita(it)}
                listaCitas.adapter = adaptador
                listaCitas.layoutManager = LinearLayoutManager(this,
                    LinearLayoutManager.VERTICAL,false)
                etiquetaInfo.text = "Hay " + adaptador.itemCount + " citas"
            }
    }

    private fun clickCita(cita: Cita){
        intent = Intent(this, CitaActivity::class.java)
        intent.putExtra("cita",cita)
        startActivity(intent)
    }

}