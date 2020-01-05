package br.com.vinimanara.chatboardapp

import androidx.appcompat.app.AppCompatActivity
import br.com.vinimanara.chatboardapp.utils.ChatBoardTracker
import br.com.vinimanara.chatboardapp.utils.ScreenMap

open class BaseActivity : AppCompatActivity() {
    open fun getScreenName(): String {
        return ScreenMap.getScreenNameBy(this)
    }
    override fun onStart() {
        super.onStart()
        ChatBoardTracker.trackScreen(this, getScreenName())
    }
}