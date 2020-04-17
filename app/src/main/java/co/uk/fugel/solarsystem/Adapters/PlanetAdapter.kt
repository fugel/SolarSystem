package co.uk.fugel.solarsystem.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import co.uk.fugel.solarsystem.Model.Planet
import co.uk.fugel.solarsystem.R
import kotlinx.android.synthetic.main.activity_main.view.*

class PlanetAdapter(context: Context, planets: List<Planet>) : BaseAdapter() {

    val context = context
    val planets = planets

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val planetView: View

        planetView = LayoutInflater.from(context).inflate(R.layout.planet_list_view, null)

        val planetImage : ImageView = planetView.findViewById(R.id.planetImage)
        val planetName : TextView = planetView.findViewById(R.id.planetName)

        val planet = planets[position]

        val resourceId = context.resources.getIdentifier(planet.image, "drawable", context.packageName)

        planetImage.setImageResource(resourceId)
        planetName.text = planet.title

        return planetView
    }

    override fun getItem(position: Int): Any {
        return planets[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return planets.count()
    }
}