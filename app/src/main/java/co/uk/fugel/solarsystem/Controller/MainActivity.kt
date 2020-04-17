package co.uk.fugel.solarsystem.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import co.uk.fugel.solarsystem.Model.Planet
import co.uk.fugel.solarsystem.R
import co.uk.fugel.solarsystem.Services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : ArrayAdapter<Planet>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ArrayAdapter(this,
        android.R.layout.simple_list_item_1,
        DataService.planets)

        planetListView.adapter = adapter
    }
}
