package luky.zadanie.zadanie3.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import androidx.navigation.findNavController
import luky.zadanie.zadanie3.PubListFragmentDirections
import luky.zadanie.zadanie3.R
import luky.zadanie.zadanie3.model.Pub

class PubAdapter(private val context: Context, private val dataset: List<Pub>): RecyclerView.Adapter<PubAdapter.PubViewHolder>() {

    //class for ViewHolder
    class PubViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val button = view.findViewById<Button>(R.id.button_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PubViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_pub, parent, false)

        return PubViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: PubViewHolder, position: Int) {
        val item = dataset[position]
        holder.button.text = item.tags.nameShop
        holder.button.setOnClickListener {
            val action = PubListFragmentDirections.actionListPubFragmentToShowFragment(
                name = "Ahoj",
                shopName = item.tags.nameShop.toString(),
                gpsH = item.lat.toString(),
                gpsL = item.lon.toString())
            holder.view.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}