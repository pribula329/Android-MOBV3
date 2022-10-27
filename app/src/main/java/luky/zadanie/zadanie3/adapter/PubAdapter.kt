package luky.zadanie.zadanie3.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import androidx.navigation.findNavController
import luky.zadanie.zadanie3.R
import luky.zadanie.zadanie3.fragment.PubListFragmentDirections
import luky.zadanie.zadanie3.model.Pub

class PubAdapter(private val context: Context, private val dataset: List<Pub>): RecyclerView.Adapter<PubAdapter.PubViewHolder>() {

    //class for ViewHolder
    class PubViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val button = view.findViewById<Button>(R.id.button_item)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PubViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_pub, parent, false)

        return PubViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: PubViewHolder, position: Int) {
        val item = dataset[position]
        holder.button.text = item.tags.name
        holder.button.setOnClickListener {
            val action = PubListFragmentDirections.actionListPubFragmentToShowFragment(
                id = item.id.toString(),
                name = "Ahoj",
                shopName = item.tags.name.toString(),
                gpsH = item.lat.toString(),
                gpsL = item.lon.toString(),
                email = item.tags.email.toString(),
                phone = item.tags.phone.toString(),
                website = item.tags.website.toString(),
                city = item.tags.city.toString(),
                street = item.tags.street.toString(),
                streetNumber = item.tags.streetNumber.toString(),
                postCode = item.tags.postCode.toString()
            )
            holder.view.findNavController().navigate(action)
        }





    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}