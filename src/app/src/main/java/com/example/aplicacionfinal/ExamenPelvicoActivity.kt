package com.example.aplicacionfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_examen_pelvico.*

class ExamenPelvicoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_examen_pelvico)

        webExamenPelvico.webViewClient = WebViewClient()
        webExamenPelvico.loadUrl("https://www.mayoclinic.org/es-es/tests-procedures/pelvic-exam/about/pac-20385135")

        webExamenPelvico.settings.javaScriptEnabled = true

        webExamenPelvico.settings.setSupportZoom(true)
    }

    override fun onBackPressed() {
        if (webExamenPelvico.canGoBack())
            webExamenPelvico.goBack()
        else
            super.onBackPressed()
    }
}