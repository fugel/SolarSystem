package co.uk.fugel.solarsystem.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.uk.fugel.solarsystem.R
import co.uk.fugel.solarsystem.Services.EXTRA_PLANET_DETAILS
import co.uk.fugel.solarsystem.Services.EXTRA_PLANET_IMAGE
import co.uk.fugel.solarsystem.Services.EXTRA_PLANET_NAME
import kotlinx.android.synthetic.main.activity_planet.*

class PlanetActivity : AppCompatActivity() {

    var planetName = ""
    var planetImage = ""
    var planetDetails = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet)
        planetName = intent.getStringExtra(EXTRA_PLANET_NAME)
        planetImage = intent.getStringExtra(EXTRA_PLANET_IMAGE)
        planetDetails = intent.getStringExtra(EXTRA_PLANET_DETAILS)

        planet_text.text = planetName
        planet_details.text = planetDetails

        val resourceId = this.resources.getIdentifier(planetImage, "drawable", this.packageName)
        planet_image?.setImageResource(resourceId)

    }
}
