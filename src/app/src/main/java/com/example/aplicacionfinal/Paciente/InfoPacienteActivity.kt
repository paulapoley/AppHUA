package com.example.aplicacionfinal.Paciente

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.aplicacionfinal.BaseActivity
import com.example.aplicacionfinal.R
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class InfoPacienteActivity : BaseActivity() {
    private lateinit var telefono : EditText
    private lateinit var grupo: RadioGroup
    private lateinit var textSexo: TextView
    private lateinit var email: EditText

    private lateinit var nombre : EditText
    private lateinit var dni : EditText
    private lateinit var apellidos: EditText
    private lateinit var fechaNacimiento: EditText
    private lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_paciente)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        telefono = findViewById(R.id.editTextPhone)
        grupo = findViewById(R.id.radioGroup)
        textSexo = findViewById(R.id.textViewSexo)
        email = findViewById(R.id.editTextTextEmailAddress)

        nombre = findViewById(R.id.editTextTextPersonName)
        dni = findViewById(R.id.editTextDni)
        apellidos = findViewById(R.id.editTextTextPersonSurname)
        fechaNacimiento = findViewById(R.id.editTextDate)
        password = findViewById(R.id.editTextTextPassword)

        /*Queremos obtener la información del usuario logueado para poner su correo
        en la información personal
         */
        val user = Firebase.auth.currentUser //Info del usuario logueado en ESE MOMENTO en la app
        if(user!=null){
            email.setText(user.email)
            email.isEnabled = false
        }
        muestraInfoPaciente()
    }
    private fun muestraInfoPaciente(){
        FirebaseFirestore.getInstance().collection("pacientes")
            .document(email.text.toString()).get().addOnSuccessListener {
                var n1 = if (it.get("nombre").toString()!="null") it.get("nombre").toString() else ""
                nombre.setText(n1)
                var n2 = if (it.get("apellidos").toString()!="null") it.get("apellidos").toString() else ""
                apellidos.setText(n2)
                var t = if (it.get("telefono").toString()!="null") it.get("telefono").toString() else ""
                telefono.setText(t)
                var fn = if (it.get("fecha de nacimiento").toString()!="null") it.get("fecha de nacimiento").toString() else ""
                fechaNacimiento.setText(fn)
                var n3 = if (it.get("dni").toString()!="null") it.get("dni").toString() else ""
                dni.setText(n3)

                if(it.get("sexo").toString()!=null) {
                    when(it.get("sexo")){
                        "N/C" -> grupo.check(R.id.radioButtonNC)
                        "Mujer" -> grupo.check(R.id.radioButtonMujer)
                        "Hombre" -> grupo.check(R.id.radioButtonHombre)
                    }
                }
            }
    }

    public fun onClickUpdate(v: View?){
        val e1 = Regex("^(\\+34|0034|34)?[67]\\d{8}\$")
        var error1 = !e1.matches(telefono.text.toString())
        if(error1){
            //Error
            Log.e("ERROR", "El teléfono no es correcto")
            telefono.error = "Teléfono incorrecto"
        }
        val e2 = Regex("\\d{2}/\\d{2}/\\d{4}")
        var error2 = !e2.matches(fechaNacimiento.text.toString())
        if(error2){
            //Error
            Log.e("ERROR", "La fecha de nacimiento no es correcta")
            fechaNacimiento.error = "Fecha incorrecta"
        }
        val e3 = Regex("^[0-9]{8,8}[A-Za-z]\$")
        var error3 = !e3.matches(dni.text.toString())
        if (error3) {
            //Error
            Log.e("ERROR", "El DNI no es correcto")
            dni.error = "DNI incorrecto"
        }


        if(!error1 && !error2 && !error3){
            actualizaDocumentoBD()
            showAlert("Información actualizada")
        }
    }

    fun actualizaDocumentoBD(){
        val pacientes = FirebaseFirestore.getInstance().collection("pacientes")
        var emailPac = email.text.toString() //Firebase.auth.currentUser.email

        var nombrePac = nombre.text.toString()
        var dniPac = dni.text.toString()
        var apellidosPac = apellidos.text.toString()
        var fechaNacPac = fechaNacimiento.text.toString()
        var sexoPac = textSexo.text.toString()
        var telefonoPac = telefono.text.toString()

        pacientes.document(emailPac).set(mapOf("nombre" to nombrePac,
            "dni" to dniPac,
            "apellidos" to apellidosPac,
            "fecha de nacimiento" to fechaNacPac,
            "sexo" to sexoPac,
            "telefono" to telefonoPac))

        //modificar la contraseña
        if(password.text.toString().isNotEmpty()){
            val user = Firebase.auth.currentUser

            user!!.updatePassword(password.text.toString())
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.i("Info", "User password updated.")
                    }
                }
        }
    }

    private fun showAlert(text: String){
        val cuadro = AlertDialog.Builder(this)
        cuadro.setTitle("Info").setMessage(text).setPositiveButton("ACEPTAR", null).show()
    }

    public fun onRadioButtonClicked(v: View){
        var opcion = ""
        when(grupo.checkedRadioButtonId){//Comprobamos cuál es el id del radioButton que se ha seleccionado
            R.id.radioButtonNC -> opcion = "N/C"
            R.id.radioButtonHombre -> opcion = "Hombre"
            R.id.radioButtonMujer -> opcion = "Mujer"
        }
        //Asignamos un valor al texto
        textSexo.text = "Opción seleccionada: $opcion"
    }

}