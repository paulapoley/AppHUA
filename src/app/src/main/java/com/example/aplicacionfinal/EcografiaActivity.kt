package com.example.aplicacionfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_ecografia.*

class EcografiaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecografia)

        webEcografia.webViewClient = WebViewClient()
        webEcografia.loadUrl("https://medlineplus.gov/spanish/ency/article/003779.htm")

        webEcografia.settings.javaScriptEnabled = true

        webEcografia.settings.setSupportZoom(true)
    }

    // if you press Back button this code will work
    override fun onBackPressed() {
        // if your webview can go back it will go back
        if (webEcografia.canGoBack())
            webEcografia.goBack()
        // if your webview cannot go back
        // it will exit the application
        else
            super.onBackPressed()
    }
}