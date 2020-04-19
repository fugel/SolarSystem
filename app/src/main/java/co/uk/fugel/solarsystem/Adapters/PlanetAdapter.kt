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

class PlanetAdapter(context: Context, planets: List<Planet>) : BaseAdapter() {

    val context = context
    val planets = planets

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val planetView: View
        val holder: ViewHolder

        if (convertView == null) {
            planetView = LayoutInflater.from(context).inflate(R.layout.planet_list_view, null)
            holder = ViewHolder()
            holder.planetImage = planetView.findViewById(R.id.planet_image)
            holder.planetName = planetView.findViewById(R.id.planetName)

            planetView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
            planetView = convertView
        }

        val planet = planets[position]

        val resourceId = context.resources.getIdentifier(planet.image, "drawable", context.packageName)

        holder.planetImage?.setImageResource(resourceId)
        holder.planetName?.text = planet.title

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

    private class ViewHolder {
        var planetImage: ImageView? = null
        var planetName: TextView? = null
    }
}