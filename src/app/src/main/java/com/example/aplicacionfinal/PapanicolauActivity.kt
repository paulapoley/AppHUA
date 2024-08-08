package com.example.aplicacionfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_papanicolau.*

class PapanicolauActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_papanicolau)

        webPapanicolau.webViewClient = WebViewClient()
        webPapanicolau.loadUrl("https://medlineplus.gov/spanish/pruebas-de-laboratorio/prueba-de-papanicolaou/")

        webPapanicolau.settings.javaScriptEnabled = true

        webPapanicolau.settings.setSupportZoom(true)
    }

    override fun onBackPressed() {
        if (webPapanicolau.canGoBack())
            webPapanicolau.goBack()
        else
            super.onBackPressed()
    }
}