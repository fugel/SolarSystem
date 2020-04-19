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
import co.uk.fugel.solarsystem.Services.EXTRA_PLANET_DETAILS
import co.uk.fugel.solarsystem.Services.EXTRA_PLANET_NAME
import co.uk.fugel.solarsystem.Services.EXTRA_PLANET_IMAGE
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_planet.*
import kotlinx.android.synthetic.main.planet_list_view.*

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
            val planetImage = planet.image
            val planetDetails = planet.details

            val showPlanet = Intent(this, PlanetActivity::class.java)
            showPlanet.putExtra(EXTRA_PLANET_NAME, planetName)
            showPlanet.putExtra(EXTRA_PLANET_IMAGE, planetImage)
            showPlanet.putExtra(EXTRA_PLANET_DETAILS, planetDetails)
            startActivity(showPlanet)
        }
    }
}
