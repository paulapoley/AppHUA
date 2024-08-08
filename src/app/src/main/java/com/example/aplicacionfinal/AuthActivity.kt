package com.example.aplicacionfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.aplicacionfinal.Medico.HomeMedicoActivity
import com.example.aplicacionfinal.Paciente.HomePacienteActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class AuthActivity : AppCompatActivity() {

    private lateinit var signUpButton: Button
    private lateinit var emailEditText: EditText
    private lateinit var passwdEditText: EditText
    private lateinit var auth: FirebaseAuth
    private lateinit var buttonLogin: Button
    private lateinit var botonSinRegistro: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        signUpButton = findViewById(R.id.buttonSignUp)
        emailEditText = findViewById(R.id.emailEditText)
        passwdEditText = findViewById(R.id.passwdEditText)
        auth = Firebase.auth
        buttonLogin = findViewById(R.id.buttonLogin)
        botonSinRegistro = findViewById(R.id.botonSinRegistro)


        setup()//Lógica de la autenticación
    }
    private fun showAlert(text: String){
        // Función que mostrará un cuadro de diálogo con el texto que le pasemos como parámetro de entrada
        // Inicializamos nuestro Dialog con la clase AlertDialog (ya que es un alerta)
        val cuadro = AlertDialog.Builder(this)
        cuadro.setTitle("Error").setMessage(text).setPositiveButton("ACEPTAR", null).show()
    }

    private fun showHome(email:String){
        FirebaseFirestore.getInstance().collection("pacientes")
            .document(email).get().addOnSuccessListener {
                if(it.exists()){
                    startActivity(Intent(this, HomePacienteActivity::class.java))
                }
                else{
                    startActivity(Intent(this, HomeMedicoActivity::class.java))
                }
            }
        /*if(email in emailMedicos){
            startActivity(Intent(this, HomeMedicoActivity::class.java))
        }else{
            startActivity(Intent(this, HomePacienteActivity::class.java))
        }*/
    }

    private fun crearDocumentoEnBD(){
        //crear un documento en la coleccion pacientes de la BD
        FirebaseFirestore.getInstance().collection("pacientes")
            .document(emailEditText.text.toString()).set(mapOf("nombre" to ""))
    }


    public fun setup(){
        //Aquì pondremos la lógica de los botones de autenticación
        signUpButton.setOnClickListener {
            //Comprobar si el correo electrónico y la contraseña no están vacíos
            if(emailEditText.text.isNotBlank() && passwdEditText.text.isNotBlank()){
                //sí podemos registrar al usuario
                auth.createUserWithEmailAndPassword(
                    emailEditText.text.toString(),
                    passwdEditText.text.toString()
                ).addOnCompleteListener {
                    if(it.isSuccessful){
                        Log.i("INFO", "Usuario creado correctamente")
                        crearDocumentoEnBD()
                        emailEditText.setText("")
                        passwdEditText.setText("")
                    }else{
                        showAlert("Se ha producido un error registrando al usuario")
                        //Toast.makeText(this, "Fallo en el registro", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        buttonLogin.setOnClickListener {
            if(emailEditText.text.isNotBlank() && passwdEditText.text.isNotBlank()){
                auth.signInWithEmailAndPassword(
                    emailEditText.text.toString(),
                    passwdEditText.text.toString()
                ).addOnCompleteListener {
                    if(it.isSuccessful){
                        Log.i("INFO", "Usuario creado correctamente")
                        showHome(emailEditText.text.toString())
                        emailEditText.setText("")
                        passwdEditText.setText("")
                    }else{
                        showAlert("Se ha producido un error autenticando al usuario")
                    }
                }
            }
        }
        botonSinRegistro.setOnClickListener {
            startActivity(Intent(this, SobreHuaModfiActivity::class.java))
        }
    }
}