package co.uk.fugel.solarsystem.Controller

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import co.uk.fugel.solarsystem.Adapters.PlanetAdapter
import co.uk.fugel.solarsystem.R
import co.uk.fugel.solarsystem.Services.DataService
import co.uk.fugel.solarsystem.Services.EXTRA_PLANET
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter : PlanetAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = PlanetAdapter(this, DataService.planets)
        planetListView.adapter = adapter

        planetListView.setOnItemClickListener { parent, view, position, id ->
            val planet = DataService.planets[position]

            val showPlanet = Intent(this, PlanetActivity::class.java)
            showPlanet.putExtra(EXTRA_PLANET, planet)

            startActivity(showPlanet)
        }
    }
}
