package com.example.aplicacionfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_histeroscopia.*

class HisteroscopiaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_histeroscopia)

        webHisteroscopia.webViewClient = WebViewClient()
        webHisteroscopia.loadUrl("https://emergency-live.com/es/salud-y-la-seguridad/histeroscopia-diagn%C3%B3stica-y-operatoria-cuando-sea-necesaria/")

        webHisteroscopia.settings.javaScriptEnabled = true

        webHisteroscopia.settings.setSupportZoom(true)
    }

    // if you press Back button this code will work
    override fun onBackPressed() {
        // if your webview can go back it will go back
        if (webHisteroscopia.canGoBack())
            webHisteroscopia.goBack()
        // if your webview cannot go back
        // it will exit the application
        else
            super.onBackPressed()
    }
}