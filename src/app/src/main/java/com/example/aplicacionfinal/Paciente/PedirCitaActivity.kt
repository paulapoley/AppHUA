package com.example.aplicacionfinal.Paciente

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import com.example.aplicacionfinal.BaseActivity
import com.example.aplicacionfinal.Modelo.SeleccionFecha
import com.example.aplicacionfinal.Modelo.SeleccionHora
import com.example.aplicacionfinal.R
import com.google.firebase.Timestamp
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import java.util.*

class PedirCitaActivity : BaseActivity() {

    private lateinit var botonAbrirCalendario : Button
    private lateinit var listaMedicos : Spinner
    private lateinit var textoFechaCita: TextView

    private var fechahora: Calendar = Calendar.getInstance()

    val opciones = arrayOf("SELECCIONAR MÉDICO", "Francisco Román González", "Macarena Ayllón Murillo", "Isabella Gómez Sánchez")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedir_cita)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        botonAbrirCalendario = findViewById(R.id.btn_abreCalendario)
        botonAbrirCalendario.setOnClickListener { gestionarCita() }
        textoFechaCita = findViewById(R.id.textView_textoFechaCita)

        listaMedicos = findViewById(R.id.spinner_listmedico)
        crearAdaptador()
    }
    private fun gestionarCita(){
        when(botonAbrirCalendario.text){
            "VOLVER" -> {
                startActivity(Intent(this, HomePacienteActivity::class.java))
            }
            "SELECCIONAR DÍA PARA CITA" -> {
                val seleccion =  SeleccionFecha{d,m,a-> procesarFecha(d,m,a)}
                seleccion.show(supportFragmentManager, "seleccionDeFecha")
            }
            "SELECCIONAR HORA" -> {
                val seleccion =  SeleccionHora{h,m-> procesarHora(h,m)}
                seleccion.show(supportFragmentManager, "seleccionDeHora")
            }
        }
    }

    fun añadirCitaBD(){
        //en fechahora está la fecha y hora seleccionada por el usuario

        val myDoc = FirebaseFirestore.getInstance().collection("pacientes")
            .document(Firebase.auth.currentUser!!.email.toString())

        myDoc.collection("citas").add(mapOf(
            "listmedico" to listaMedicos.selectedItem.toString(),
            "fecha y hora" to Timestamp(fechahora.time)
        ))
        //acceder a la colección "citas" del documento anterior

    }

    private fun procesarHora(hora:Int, minutos:Int){
        textoFechaCita.text = "Se ha seleccionado la hora: " + hora.toString() + ":" + minutos.toString()
        botonAbrirCalendario.text =  "VOLVER"
        fechahora.set(Calendar.HOUR_OF_DAY,hora)
        fechahora.set(Calendar.MINUTE,minutos)

        añadirCitaBD()
        showAlert("Se ha añadido la cita con éxito")
    }

    private fun procesarFecha(dia:Int, mes:Int, anyo:Int){
        listaMedicos.isEnabled = false
        textoFechaCita.text = "Se ha seleccionado la fecha: " + dia.toString() + "/" + mes.toString() + "/" + anyo.toString()
        botonAbrirCalendario.text =  "SELECCIONAR HORA"

        fechahora.set(Calendar.YEAR,anyo)
        fechahora.set(Calendar.MONTH,mes)
        fechahora.set(Calendar.DAY_OF_MONTH,dia)
    }

    private fun showAlert(text: String){
        // Función que mostrará un cuadro de diálogo con el texto que le pasemos como parámetro de entrada
        // Inicializamos nuestro Dialog con la clase AlertDialog (ya que es un alerta)
        val cuadro = AlertDialog.Builder(this)
        cuadro.setTitle("Info").setMessage(text).setPositiveButton("ACEPTAR", null).show()
    }

    private fun crearAdaptador(){
        val adaptador = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, opciones)
        listaMedicos.adapter = adaptador
        listaMedicos.onItemSelectedListener = SpinnerActivity()
    }

    inner class SpinnerActivity : Activity(), AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
            when(pos){
                0 -> {
                    botonAbrirCalendario.isVisible = false
                }
                //1 -> {ATENCIÓN PRIMARIA}
                //...
                else -> {
                    botonAbrirCalendario.isVisible = true
                }
            }
        }

        override fun onNothingSelected(parent: AdapterView<*>) {
            // Another interface callback
        }
    }

}