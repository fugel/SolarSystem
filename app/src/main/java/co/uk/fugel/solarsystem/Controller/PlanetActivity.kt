package co.uk.fugel.solarsystem.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import co.uk.fugel.solarsystem.R
import co.uk.fugel.solarsystem.Services.EXTRA_PLANET
import kotlinx.android.synthetic.main.activity_planet.*
import kotlinx.android.synthetic.main.planet_list_view.*

class PlanetActivity : AppCompatActivity() {

    var planetName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet)
        planetName = intent.getStringExtra(EXTRA_PLANET)

        planetText.text = planetName
    }
}
