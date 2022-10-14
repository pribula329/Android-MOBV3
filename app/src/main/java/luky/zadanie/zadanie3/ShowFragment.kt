package luky.zadanie.zadanie3

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.airbnb.lottie.LottieAnimationView
import luky.zadanie.zadanie3.databinding.FragmentShowBinding



/**
 * A simple [Fragment] subclass.
 * Use the [ShowFragment.newInstance] factory method to
 * create an instance of this fragment.
 */


class ShowFragment : Fragment() {
    @SuppressLint("MissingInflatedId")
    // TODO: Rename and change types of parameters

    companion object {
        const val NAME = "name"
        const val SHOP = "shopName"
        const val GPS_HEIGHT = "gpsH"
        const val GPS_LENGHT = "gpsL"
        const val EMAIL = "email"
        const val PHONE = "phone"
        const val WEBSITE = "website"
        //TODO: adress
    }
    private lateinit var name: String
    private lateinit var shop: String
    private lateinit var gpsHeight: String
    private lateinit var gpsLenght: String
    private lateinit var emailShow: String
    private lateinit var phoneShow: String
    private lateinit var websiteShow: String

    private var _binding: FragmentShowBinding? = null
    private val binding get() = _binding!!



    private val args: ShowFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(NAME).toString()
            println(name)
            shop = it.getString(SHOP).toString()
            println(shop)
            gpsHeight = it.getString(GPS_HEIGHT).toString()
            println(gpsHeight)
            gpsLenght = it.getString(GPS_LENGHT).toString()
            println(gpsLenght)
            emailShow = it.getString(EMAIL).toString()
            phoneShow = it.getString(PHONE).toString()
            websiteShow = it.getString(WEBSITE).toString()

        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentShowBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startAnimation()
        binding.nameView.text = name
        binding.shopView.text = shop
        binding.emailView.text = emailShow
        binding.phoneView.text = phoneShow
        binding.websiteView.text = websiteShow
        binding.showButton.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:${gpsHeight.toDouble()},${gpsLenght.toDouble()}")
            println(gmmIntentUri)
            // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            // Make the Intent explicit by setting the Google Maps package
            mapIntent.setPackage("com.google.android.apps.maps")
            // Attempt to start an activity that can handle the Intent
            startActivity(mapIntent)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun startAnimation(){
        val screen: View? = binding.showScreen
        val animationCoctail : LottieAnimationView = binding.animationView
        animationCoctail.playAnimation()
        screen?.setOnClickListener {
            stopAndPlayAnimation()
        }
    }

    private fun stopAndPlayAnimation(){
        val animationCoctail : LottieAnimationView = binding.animationView

        if (animationCoctail.isAnimating){
            animationCoctail.pauseAnimation()
        }
        else{
            animationCoctail.resumeAnimation()
        }


    }
}