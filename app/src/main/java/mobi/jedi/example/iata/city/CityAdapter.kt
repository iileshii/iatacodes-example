package mobi.jedi.example.iata.city

import android.view.View
import kotlinx.android.synthetic.main.item_city.view.*
import mobi.jedi.example.domain.City
import mobi.jedi.example.iata.BindAdapter
import mobi.jedi.example.iata.R

internal class CityAdapter : BindAdapter<City>() {

    override fun createViewHolder(view: View): BindViewHolder = object : BindViewHolder(view) {

        override fun bind(data: City) {
            itemView.name.text = data.name
            itemView.code.text = data.code
            itemView.country.text = data.countryCode
        }
    }

    override fun getLayoutResId(): Int = R.layout.item_city
}