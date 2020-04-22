package co.uk.fugel.solarsystem.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.uk.fugel.solarsystem.Model.Planet
import co.uk.fugel.solarsystem.R

class planetRecycleAdaptor(val context: Context, val planets: List<Planet>) : RecyclerView.Adapter<planetRecycleAdaptor.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.planet_list_view, parent, false)

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return planets.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindPlanet(planets[position], context)
    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val planetName = itemView.findViewById<TextView>(R.id.planet_name)
        val planetImage = itemView.findViewById<ImageView>(R.id.planet_image)

        fun bindPlanet(planet: Planet, context: Context){

            val resourceId = context.resources.getIdentifier(planet.image, "drawable", context.packageName)

            planetImage?.setImageResource(resourceId)
            planetName?.text = planet.title
        }
    }
}