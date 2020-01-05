package br.com.vinimanara.chatboardapp.maps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import br.com.vinimanara.chatboardapp.R
import br.com.vinimanara.chatboardapp.about.AboutActivity
import br.com.vinimanara.chatboardapp.form.FormActivity
import br.com.vinimanara.chatboardapp.login.LoginActivity

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.maps_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.action_home -> {
                home()
                return true
            }
            R.id.action_about -> {
                about()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun about() {
        startActivity(Intent(this, AboutActivity::class.java))
        finish()
    }
    private fun home() {
        startActivity(Intent(this, FormActivity::class.java))
        finish()
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val FiapPaulista = LatLng(-23.5641095, -46.6524099)
        mMap.addMarker(MarkerOptions().position(FiapPaulista).title("FIAP Paulista"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(FiapPaulista))
        // Set a preference for minimum and maximum zoom.
        mMap.setMinZoomPreference(14.0f)
        mMap.setMaxZoomPreference(20.0f)
    }
}
