package co.uk.fugel.solarsystem.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import co.uk.fugel.solarsystem.Adapters.PlanetAdapter
import co.uk.fugel.solarsystem.Model.Planet
import co.uk.fugel.solarsystem.R
import co.uk.fugel.solarsystem.Services.DataService
import co.uk.fugel.solarsystem.Services.EXTRA_PLANET
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : PlanetAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = PlanetAdapter(this, DataService.planets)
        planetListView.adapter = adapter

        planetListView.setOnItemClickListener { parent, view, position, id ->
            val planet = DataService.planets[position]

            val planetName = planet.title

            val showPlanet = Intent(this, PlanetActivity::class.java)
            showPlanet.putExtra(EXTRA_PLANET, planetName)
            startActivity(showPlanet)
        }
    }
}
