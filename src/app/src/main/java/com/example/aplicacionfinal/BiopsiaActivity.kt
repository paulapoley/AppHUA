package com.example.aplicacionfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_biopsia.*


class BiopsiaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biopsia)

        webBiopsia.webViewClient = WebViewClient()
        webBiopsia.loadUrl("https://medlineplus.gov/spanish/biopsy.html")

        webBiopsia.settings.javaScriptEnabled = true

        webBiopsia.settings.setSupportZoom(true)
    }

    override fun onBackPressed() {
        if (webBiopsia.canGoBack())
            webBiopsia.goBack()
        else
            super.onBackPressed()
    }
}