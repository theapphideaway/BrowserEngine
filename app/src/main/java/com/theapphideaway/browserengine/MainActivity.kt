package com.theapphideaway.browserengine

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.theapphideaway.browserengine.R.id.search_button

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myWebView: WebView = findViewById(R.id.web_view)
        myWebView.webViewClient = Callback()

        
        url_search_edit_text.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                var url = url_search_edit_text.text.toString()

                if(!url.contains("https://www."))
                    url = "https://www.$url"

                myWebView.loadUrl(url)
                return@OnKeyListener true

            }
            false
        })

    }

    private inner class Callback : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView, url: WebResourceRequest): Boolean {
            return false
        }

    }
}
