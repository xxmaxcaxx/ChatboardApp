package br.com.vinimanara.chatboardapp.utils

import android.app.Activity
import br.com.vinimanara.chatboardapp.form.FormActivity
import br.com.vinimanara.chatboardapp.login.LoginActivity
import br.com.vinimanara.chatboardapp.signup.SignUpActivity
import br.com.vinimanara.chatboardapp.splash.SplashActivity

class ScreenMap {
    companion object {
        val SCREEN_NOT_TRACKING = "SCREEN_NOT_TRACKING"
        private fun getScreenNameBy(className: String): String {
            val screensNames = getScreenNames()
            return if (screensNames[className] == null) SCREEN_NOT_TRACKING else screensNames[className]!!
        }
        fun getScreenNameBy(activty: Activity): String {
            return getScreenNameBy(activty::class.java.simpleName)
        }

        fun getClassName(screenName: String): String {
            val screenNames = getScreenNames()
            for (o in screenNames.keys) {
                if (screenNames[o] == screenName) {
                    return o
                }
            }
            return ""
        }
        private fun getScreenNames(): Map<String, String> {
            return mapOf(
                //Login
                Pair(FormActivity::class.java.simpleName, "Pagina Inicial"),
                Pair(LoginActivity::class.java.simpleName, "Login_Usuario"),
                Pair(SignUpActivity::class.java.simpleName, "Criacao_Usuario"),
                Pair(SplashActivity::class.java.simpleName, "Splash")
            )
        }
    }
}