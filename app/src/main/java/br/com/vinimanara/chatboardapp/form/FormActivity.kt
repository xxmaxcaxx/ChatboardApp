package br.com.vinimanara.chatboardapp.form

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import br.com.vinimanara.chatboardapp.BaseActivity
import br.com.vinimanara.chatboardapp.R
import br.com.vinimanara.chatboardapp.login.LoginActivity
import br.com.vinimanara.chatboardapp.utils.RemoteConfig
import com.google.firebase.auth.FirebaseAuth
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : BaseActivity() {

    private lateinit var userId: String
    private lateinit var mAuth: FirebaseAuth
    private val firebaseReferenceNode = "CarData"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        mAuth = FirebaseAuth.getInstance()
        userId = FirebaseAuth.getInstance().currentUser?.uid ?: ""
        loadBanner()
    }

    private val defaultClearValueText = "0.0"
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.form_menu, menu)
        return true
    }

    private fun loadBanner() {
        val loginBanner = RemoteConfig.getFirebaseRemoteConfig()
            .getString("imagem1")
        Picasso.get().load(loginBanner).into(ivBanner)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.action_clear -> {
                clearData()
                return true
            }
            R.id.action_logout -> {
                logout()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
    private fun logout() {
        mAuth.signOut()
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
    private fun clearData() {

    }
}
