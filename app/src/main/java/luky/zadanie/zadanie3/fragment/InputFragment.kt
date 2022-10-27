package luky.zadanie.zadanie3.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import luky.zadanie.zadanie3.databinding.FragmentInputBinding



class InputFragment : Fragment() {
    private var _binding: FragmentInputBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentInputBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Replaces the content of an existing view with new data
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sendButton.setOnClickListener {
            if (controlInput()){
                val action = InputFragmentDirections.actionInputFragmentToUserShowFragment(
                    userName = binding.inputNameText.text.toString(),
                    userShopName = binding.inputShopText.text.toString(),
                    userGpsH = binding.inputHeightText.text.toString().toFloat(),
                    userGpsL = binding.inputLenghtText.text.toString().toFloat()
                )
                view.findNavController().navigate(action)

            }
            else{
                val toast = Toast.makeText(activity?.applicationContext, "Vyplň všetko", Toast.LENGTH_LONG)
                toast.show()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun controlInput(): Boolean {

        return if (binding.inputLenghtText.text.isNullOrEmpty()){
            false
        } else if (binding.inputHeightText.text.isNullOrEmpty()){
            false
        } else if (binding.inputShopText.text.isNullOrEmpty()){
            false
        } else !binding.inputNameText.text.isNullOrEmpty()
    }

}