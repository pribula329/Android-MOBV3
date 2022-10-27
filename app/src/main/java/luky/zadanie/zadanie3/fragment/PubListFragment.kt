package luky.zadanie.zadanie3.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import luky.zadanie.zadanie3.R
import luky.zadanie.zadanie3.adapter.PubAdapter
import luky.zadanie.zadanie3.data.DataSource
import luky.zadanie.zadanie3.databinding.FragmentListPubBinding


@Suppress("DEPRECATION")
class PubListFragment : Fragment() {
    private var _binding: FragmentListPubBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private var myDataset = DataSource.element

    private var isSortedMenu = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListPubBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recycleView
        //myDataset = DataSource().loadDataPubs(view.context)
        recyclerView.adapter = PubAdapter(view.context, myDataset)
        val buttonUser = binding.userFind
        buttonUser.setOnClickListener {
            val action = PubListFragmentDirections.actionListPubFragmentToInputFragment()
            view.findNavController().navigate(action)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    @Deprecated("Deprecated in Java", ReplaceWith(
        "inflater.inflate(R.menu.layout_menu, menu)",
        "luky.zadanie.zadanie3.R"
    )
    )
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.layout_menu, menu)
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_sort_menu -> {
                isSortedMenu = !isSortedMenu
                sortList()


                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun sortList() {
        if (isSortedMenu) {
            val sortDataset = myDataset.sortedByDescending { it.tags.name }
            recyclerView.adapter = PubAdapter(binding.recycleView.context, sortDataset)
        } else {

            val sortDataset = myDataset.sortedBy { it.tags.name }
            recyclerView.adapter = PubAdapter(binding.recycleView.context, sortDataset)
        }

    }



}