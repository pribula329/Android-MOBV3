package luky.zadanie.zadanie3.data

import android.content.Context
import com.google.gson.Gson
import luky.zadanie.zadanie3.model.Pub


object DataSource{
    lateinit var element: MutableList<Pub>

    fun loadDataPubs(context: Context){

        val jsonData = context.resources.openRawResource(
            context.resources.getIdentifier(
                "pubs",
                "raw",context.packageName
            )
        ).bufferedReader().use { it.readText()}

        element = Gson().fromJson(jsonData, Array<Pub>::class.java).toList().toMutableList()


    }
}