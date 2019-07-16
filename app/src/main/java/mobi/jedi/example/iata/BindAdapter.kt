package mobi.jedi.example.iata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

internal abstract class BindAdapter<T> : RecyclerView.Adapter<BindAdapter<T>.BindViewHolder>() {

    private val data = mutableListOf<T>()

    fun updateData(newData: List<T>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    protected abstract fun createViewHolder(view: View): BindViewHolder

    @LayoutRes
    protected abstract fun getLayoutResId(): Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(getLayoutResId(), parent, false)
        return createViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: BindViewHolder, position: Int) {
        holder.bind(data[position])
    }

    abstract inner class BindViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        abstract fun bind(data: T)
    }
}