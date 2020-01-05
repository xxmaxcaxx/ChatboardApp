package br.com.vinimanara.chatboardapp.about

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import br.com.vinimanara.chatboardapp.R
import br.com.vinimanara.chatboardapp.form.FormActivity
import br.com.vinimanara.chatboardapp.login.LoginActivity
import br.com.vinimanara.chatboardapp.maps.MapsActivity

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.about_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.action_home -> {
                home()
                return true
            }
            R.id.action_maps -> {
                maps()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun home() {
        startActivity(Intent(this, FormActivity::class.java))
        finish()
    }
    private fun maps() {
        startActivity(Intent(this, MapsActivity::class.java))
        finish()
    }
}
