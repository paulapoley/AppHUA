package com.example.aplicacionfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_analisis_sangre.*

class AnalisisSangreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analisis_sangre)


        webAnalisisSangre.webViewClient = WebViewClient()
        webAnalisisSangre.loadUrl("https://medlineplus.gov/spanish/bloodcounttests.html")

        webAnalisisSangre.settings.javaScriptEnabled = true

        webAnalisisSangre.settings.setSupportZoom(true)
    }

    override fun onBackPressed() {
        if (webAnalisisSangre.canGoBack())
            webAnalisisSangre.goBack()
        else
            super.onBackPressed()
    }
}