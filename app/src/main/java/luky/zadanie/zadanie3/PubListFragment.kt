package luky.zadanie.zadanie3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import luky.zadanie.zadanie3.adapter.PubAdapter
import luky.zadanie.zadanie3.data.DataSource
import luky.zadanie.zadanie3.databinding.FragmentListPubBinding
import luky.zadanie.zadanie3.model.Pub

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PubListFragment : Fragment() {
    private var _binding: FragmentListPubBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var myDataset: List<Pub>

    private var isLinearLayoutManager = true

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("publistfragment")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListPubBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recycleView
        myDataset = DataSource(view.context).loadDataPubs()
        recyclerView.adapter = PubAdapter(view.context, myDataset)
        val buttonUser = binding.userFind
        val buttonSort = binding.sortButton
        buttonUser.setOnClickListener {
            val action = PubListFragmentDirections.actionListPubFragmentToInputFragment()
            view.findNavController().navigate(action)
        }

        buttonSort.setOnClickListener {
            val sortDataset = myDataset.sortedBy { it.tags.name }
            recyclerView.adapter = PubAdapter(view.context, sortDataset)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}