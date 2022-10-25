package luky.zadanie.zadanie3

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.set
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.airbnb.lottie.LottieAnimationView
import luky.zadanie.zadanie3.data.DataSource
import luky.zadanie.zadanie3.databinding.FragmentShowBinding



/**
 * A simple [Fragment] subclass.
 * Use the [ShowFragment.newInstance] factory method to
 * create an instance of this fragment.
 */


class ShowFragment : Fragment() {
    @SuppressLint("MissingInflatedId")


    companion object {
        const val ID = "id"
        const val NAME = "name"
        const val SHOP = "shopName"
        const val GPS_HEIGHT = "gpsH"
        const val GPS_LENGHT = "gpsL"
        const val EMAIL = "email"
        const val PHONE = "phone"
        const val WEBSITE = "website"
        const val CITY = "city"
        const val STREET = "street"
        const val STREET_NUMBER = "streetNumber"
        const val POST_CODE = "postCode"

    }
    private lateinit var id: String
    private lateinit var name: String
    private lateinit var shop: String
    private lateinit var gpsHeight: String
    private lateinit var gpsLenght: String
    private lateinit var emailShow: String
    private lateinit var phoneShow: String
    private lateinit var websiteShow: String
    private lateinit var cityShow: String
    private lateinit var streetShow: String
    private lateinit var streetNumberShow: String
    private lateinit var postCodeShow: String

    private var _binding: FragmentShowBinding? = null
    private val binding get() = _binding!!



    private val args: ShowFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getString(ID).toString()
            println(id)
            name = it.getString(NAME).toString()
            println(name)
            shop = it.getString(SHOP).toString()
            println(shop)
            gpsHeight = it.getString(GPS_HEIGHT).toString()
            println(gpsHeight)
            gpsLenght = it.getString(GPS_LENGHT).toString()
            println(gpsLenght)
            emailShow = it.getString(EMAIL).toString()
            println(emailShow)
            phoneShow = it.getString(PHONE).toString()
            println(phoneShow)
            websiteShow = it.getString(WEBSITE).toString()
            println(websiteShow)
            cityShow = it.getString(CITY).toString()
            println(cityShow)
            streetShow = it.getString(STREET).toString()
            println(streetShow)
            streetNumberShow = it.getString(STREET_NUMBER).toString()
            println(streetNumberShow)
            postCodeShow = it.getString(POST_CODE).toString()
            println(postCodeShow)

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
        textInformation()
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

        binding.websiteView.setOnClickListener {
            val webUri = Uri.parse(websiteShow)
            val websiteIntent = Intent(Intent.ACTION_VIEW, webUri)
            startActivity(websiteIntent)
        }

        binding.phoneView.setOnClickListener {
            val phoneUri = Uri.parse("tel:$phoneShow")
            val phoneIntent = Intent(Intent.ACTION_DIAL, phoneUri)
            startActivity(phoneIntent)
        }
        binding.emailView.setOnClickListener {
            val emailUri = Uri.parse("mailto:$emailShow")
            val emailIntent = Intent(Intent.ACTION_SENDTO, emailUri)
            startActivity(emailIntent)
        }



        binding.deleteButton.setOnClickListener{
            val action = ShowFragmentDirections.actionShowFragmentToListPubFragment()
            view.findNavController().navigate(action)
            var deleteId: Int? = null
            for (i in 0..DataSource.element.size){
                if (DataSource.element.get(i).id==id.toLong()){
                    deleteId = i
                    break
                }
            }
            println("dostal som sa sem")
            println(id.toString())
            println(deleteId)
            if (deleteId!=null){
                DataSource.element.removeAt(deleteId)
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun startAnimation(){
        val screen: View = binding.showScreen
        val animationCoctail : LottieAnimationView = binding.animationView
        animationCoctail.playAnimation()
        screen.setOnClickListener {
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

    private fun textInformation(){
        binding.nameView.text = name
        binding.shopView.text = shop
        if (!emailShow.toString().equals("null")) {
            binding.emailView.text = emailShow
            binding.emailView.visibility = View.VISIBLE
        }
        if (!phoneShow.toString().equals("null")) {
            binding.phoneView.visibility = View.VISIBLE
            binding.phoneView.text= phoneShow
        }
        if (!websiteShow.toString().equals("null")) {
            binding.websiteView.text = websiteShow
            binding.websiteView.visibility = View.VISIBLE
        }
        if (!cityShow.toString().equals("null")) {
            binding.cityView.text = cityShow
            binding.cityView.visibility = View.VISIBLE
        }
        if (!streetShow.toString().equals("null")) {
            binding.streetView.text = streetShow
            binding.streetView.visibility = View.VISIBLE
        }
        if (!streetNumberShow.toString().equals("null")) {
            binding.streetNumberView.text = streetNumberShow
            binding.streetNumberView.visibility = View.VISIBLE
        }
        if (!postCodeShow.toString().equals("null")) {
            binding.postCodeView.text = postCodeShow
            binding.postCodeView.visibility = View.VISIBLE
        }
        if (!id.toString().equals("null")) {
            binding.deleteButton.visibility = View.VISIBLE
        }

    }


}