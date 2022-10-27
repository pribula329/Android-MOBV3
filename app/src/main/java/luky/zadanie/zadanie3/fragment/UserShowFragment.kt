package luky.zadanie.zadanie3.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.lottie.LottieAnimationView
import luky.zadanie.zadanie3.databinding.FragmentUserShowBinding
import kotlin.properties.Delegates


class UserShowFragment : Fragment() {

    companion object {
        const val USER_NAME = "userName"
        const val USER_SHOP = "userShopName"
        const val USER_GPS_HEIGHT = "userGpsH"
        const val USER_GPS_LENGHT = "userGpsL"


    }

    private lateinit var userName: String
    private lateinit var userShopName: String
    private var userGpsHeight by Delegates.notNull<Float>()
    private var userGpsLenght by Delegates.notNull<Float>()

    private var _binding: FragmentUserShowBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userName = it.getString(USER_NAME).toString()
            println(userName)
            userShopName = it.getString(USER_SHOP).toString()
            println(userShopName)
            userGpsHeight = it.getFloat(USER_GPS_HEIGHT)
            println(userGpsHeight)
            userGpsLenght = it.getFloat(USER_GPS_LENGHT)
            println(userGpsLenght)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentUserShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startAnimation()
        binding.userNameView.text = userName
        binding.userShopView.text = userShopName
        binding.userShowButton.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:${userGpsHeight},${userGpsLenght}")
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
        val screen: View = binding.userShowScreen
        val animationCoctail : LottieAnimationView = binding.userAnimationView
        animationCoctail.playAnimation()
        screen.setOnClickListener {
            stopAndPlayAnimation(animationCoctail)
        }
    }

    private fun stopAndPlayAnimation(animationCoctail: LottieAnimationView){

        if (animationCoctail.isAnimating){
            animationCoctail.pauseAnimation()
        }
        else{
            animationCoctail.resumeAnimation()
        }


    }


}