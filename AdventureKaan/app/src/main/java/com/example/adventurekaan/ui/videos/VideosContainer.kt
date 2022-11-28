package com.example.adventurekaan.ui.videos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.adventurekaan.R

class VideosContainer : Fragment() {


    //Variables
    private var BASE_URL = "https://www.youtube.com/watch?v=qwb8qSw1d7s&t=621s"
    private lateinit var Urls: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_videos_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val posicion : Int = arguments?.getInt("01")!!.toInt()

        Urls = arrayOf(
            "https://www.youtube.com/watch?v=mrTzjGYHJxI",
            "https://www.youtube.com/watch?v=9yc4JIMcZQg",
            "https://www.youtube.com/watch?v=rv3k9mGTRvo",
            "https://www.youtube.com/watch?v=Pmb-h56Nt9M",
            "https://www.youtube.com/watch?v=h6BTnR_pZsY",
        )

        BASE_URL = Urls[posicion]

        //WebView
        val webView : WebView = view.findViewById(R.id.WebView)

        webView.webChromeClient = object :  WebChromeClient() {
        }

        webView.webViewClient = object : WebViewClient(){

        }

        //Activamos java script en el web View
        val settings : WebSettings = webView.settings
        settings.javaScriptEnabled = true

        //Cargamos link del video
        webView.loadUrl(BASE_URL)
    }


}