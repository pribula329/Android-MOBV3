package luky.zadanie.zadanie3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.findNavController
import luky.zadanie.zadanie3.databinding.FragmentInputBinding


/**
 * A simple [Fragment] subclass.
 * Use the [InputFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InputFragment : Fragment() {
    private var _binding: FragmentInputBinding? = null
    private val binding get() = _binding!!

    private lateinit var view: FragmentContainerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentInputBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    /**
     * Replaces the content of an existing view with new data
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sendButton.setOnClickListener {
            if (controlInput()){
                val action = InputFragmentDirections.actionInputFragmentToShowFragment2(
                name = binding.inputNameText.text.toString(),
                shopName = binding.inputShopText.text.toString(),
                gpsH = binding.inputHeightText.text.toString(),
                gpsL = binding.inputLenghtText.text.toString() )
                view.findNavController().navigate(action)

            }
            else{
                val toast = Toast.makeText(getActivity()?.getApplicationContext(), "Vyplň všetko", Toast.LENGTH_LONG)
                toast.show()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun controlInput(): Boolean {

        if (binding.inputLenghtText.text.isNullOrEmpty()){
            return false
        }
        else if (binding.inputHeightText.text.isNullOrEmpty()){
            return false
        }
        else if (binding.inputShopText.text.isNullOrEmpty()){
            return false
        }
        else if (binding.inputNameText.text.isNullOrEmpty()){
            return false
        }
        else{
            return true
        }
    }

}