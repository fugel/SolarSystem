package co.uk.fugel.solarsystem.Controller

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import co.uk.fugel.solarsystem.Adapters.planetRecycleAdaptor
import co.uk.fugel.solarsystem.R
import co.uk.fugel.solarsystem.Services.DataService
import co.uk.fugel.solarsystem.Services.EXTRA_PLANET
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: planetRecycleAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = planetRecycleAdaptor(this, DataService.planets) { planet ->
            val planetIntent = Intent(this, PlanetActivity::class.java)
            planetIntent.putExtra(EXTRA_PLANET, planet)
            startActivity(planetIntent)
        }
        planetListView.adapter = adapter

        val orientation = resources.configuration.orientation

        val layoutManager: LinearLayoutManager

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            layoutManager = LinearLayoutManager(this)
        } else {
            layoutManager = GridLayoutManager(this, 3)
        }

        planetListView.layoutManager = layoutManager
        planetListView.setHasFixedSize(true)
    }
}
