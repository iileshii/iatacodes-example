package mobi.jedi.example.iata.airport

import android.view.View
import kotlinx.android.synthetic.main.item_airport.view.*
import mobi.jedi.example.domain.Airport
import mobi.jedi.example.iata.BindAdapter
import mobi.jedi.example.iata.R

internal class AirportAdapter : BindAdapter<Airport>() {

    override fun createViewHolder(view: View): BindViewHolder = object : BindViewHolder(view) {

        override fun bind(data: Airport) {
            itemView.name.text = data.name
            itemView.code.text = data.code
        }
    }

    override fun getLayoutResId(): Int = R.layout.item_airport
}