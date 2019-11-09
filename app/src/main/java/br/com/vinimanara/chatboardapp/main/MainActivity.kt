package br.com.vinimanara.chatboardapp.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.vinimanara.chatboardapp.BaseActivity
import br.com.vinimanara.chatboardapp.R

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
