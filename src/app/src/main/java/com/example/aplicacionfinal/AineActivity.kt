package com.example.aplicacionfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_aine.*
import kotlinx.android.synthetic.main.activity_ecografia.*


class AineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aine)


        webAINE.webViewClient = WebViewClient()
        webAINE.loadUrl("https://www.onsalus.com/antiinflamatorios-no-esteroideos-aines-cuales-son-tipos-y-usos-19295.html#:~:text=Los%20AINEs%20%28antiinflamatorios%20no%20esteroideos%29%20son%20una%20familia,%28aliviar%20el%20dolor%29%20y%20antipir%C3%A9ticas%20%28reducir%20la%20fiebre%29.")

        webAINE.settings.javaScriptEnabled = true

        webAINE.settings.setSupportZoom(true)
    }

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
