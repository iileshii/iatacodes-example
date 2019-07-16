package mobi.jedi.example.iata.airport

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import mobi.jedi.example.domain.Airport
import mobi.jedi.example.iata.RecyclerFragment

class AirportFragment : RecyclerFragment<Airport>() {

    override fun initAdapter() = AirportAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProviders.of(this)[AirportsViewModel::class.java]
        viewModel.getAirports().observe(viewLifecycleOwner, Observer { updateList(it) })
    }
}