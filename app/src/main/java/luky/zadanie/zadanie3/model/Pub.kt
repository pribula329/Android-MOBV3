package luky.zadanie.zadanie3.model

import com.google.gson.annotations.SerializedName


data class Pub(
    var id: Long,
    var lat: Double,
    var lon: Double,
    var tags: Tags)

data class Tags(
    var name: String? = null,
    var email: String? = null,
    var phone: String? = null,
    var website: String? = null,
    @SerializedName("addr:city")
    var city: String? = null,
    @SerializedName("addr:street")
    var street: String? = null,
    @SerializedName("addr:streetnumber")
    var streetNumber: String? = null,
    @SerializedName("addr:postcode")
    var postCode: String? = null)



