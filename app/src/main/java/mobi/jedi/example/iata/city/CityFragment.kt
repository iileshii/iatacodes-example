package mobi.jedi.example.iata.city

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import mobi.jedi.example.domain.City
import mobi.jedi.example.iata.RecyclerFragment

class CityFragment : RecyclerFragment<City>() {

    override fun initAdapter() = CityAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProviders.of(this)[CitiesViewModel::class.java]
        viewModel.getCities().observe(viewLifecycleOwner, Observer { updateList(it) })
    }
}