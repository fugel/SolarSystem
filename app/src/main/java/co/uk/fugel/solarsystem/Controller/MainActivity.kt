package co.uk.fugel.solarsystem.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import co.uk.fugel.solarsystem.Adapters.PlanetAdapter
import co.uk.fugel.solarsystem.Model.Planet
import co.uk.fugel.solarsystem.R
import co.uk.fugel.solarsystem.Services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : PlanetAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = PlanetAdapter(this, DataService.planets)

        planetListView.adapter = adapter
    }
}
