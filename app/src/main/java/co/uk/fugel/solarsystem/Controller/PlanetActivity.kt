package co.uk.fugel.solarsystem.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.uk.fugel.solarsystem.Model.Planet
import co.uk.fugel.solarsystem.R
import co.uk.fugel.solarsystem.Services.EXTRA_PLANET
import kotlinx.android.synthetic.main.activity_planet.*

class PlanetActivity : AppCompatActivity() {

    private lateinit var planet : Planet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet)
        planet = intent.getParcelableExtra(EXTRA_PLANET)

        planet_text.text = planet.title
        planet_details.text = planet.details

        val resourceId = this.resources.getIdentifier(planet.image, "drawable", this.packageName)
        planet_image.setImageResource(resourceId)

    }
}
