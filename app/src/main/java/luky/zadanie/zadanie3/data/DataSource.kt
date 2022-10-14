package luky.zadanie.zadanie3.data



import android.content.Context
import com.airbnb.lottie.LottieCompositionFactory.fromJson
import com.google.gson.Gson
import luky.zadanie.zadanie3.R
import luky.zadanie.zadanie3.model.Pub
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONTokener
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.Reader
import kotlin.reflect.typeOf
import com.google.gson.JsonArray as JsonArray


class DataSource(private val context: Context){

   fun loadDataPubs(): List<Pub> {

        val jsonData = context.resources.openRawResource(
            context.resources.getIdentifier(
                "pubs",
                "raw",context.packageName
            )
        ).bufferedReader().use { it.readText()}





        val elements: List<Pub> = Gson().fromJson(jsonData, Array<Pub>::class.java).toList()

        
        return elements

    }
}