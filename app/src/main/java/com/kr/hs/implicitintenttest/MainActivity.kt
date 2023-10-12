package com.kr.hs.implicitintenttest

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btnCall : Button
    lateinit var btnHome : Button
    lateinit var btnMap : Button
    lateinit var btnSearch : Button
    lateinit var btnSMS : Button
    lateinit var btnPicture : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "암시적 인텐트 연습"

        btnCall = findViewById(R.id.btnCall)
        btnHome = findViewById(R.id.btnHome)
        btnMap = findViewById(R.id.btnMap)
        btnSearch = findViewById(R.id.btnSearch)
        btnSMS = findViewById(R.id.btnSMS)
        btnPicture = findViewById(R.id.btnPicture)

        btnCall.setOnClickListener {
            var uri = Uri.parse("tel:010-6601-6535")
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        btnHome.setOnClickListener {
            var uri = Uri.parse("https://naver.com")
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        btnMap.setOnClickListener{
            var uri = Uri.parse("https://maps.google.com/maps?q="+37.4663507+","+128.9328951)
            var intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        btnSearch.setOnClickListener {
            var intent = Intent (Intent.ACTION_WEB_SEARCH)
            intent.putExtra(SearchManager.QUERY, "미림정보과학고")
            startActivity(intent)
        }

        btnSMS.setOnClickListener {
            var Intent = Intent(Intent.ACTION_SENDTO)
            Intent.putExtra("sms_body", "SMS는 손명수쌤 입니다")
            Intent.data = Uri.parse("smsto:" + Uri.encode("010-6601-6535"))
            startActivity(Intent)
        }

        btnPicture.setOnClickListener {
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

    }
}