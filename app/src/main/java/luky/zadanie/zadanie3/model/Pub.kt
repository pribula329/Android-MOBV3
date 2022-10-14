package luky.zadanie.zadanie3.model


data class Pub(
    var id: Long,
    var lat: Double,
    var lon: Double,
    var tags: Tags) {

}

data class Tags(
    var name: String? = null,
    var email: String? = null,
    var phone: String? = null,
    var website: String? = null,
    var address: Address? = null) {

}

data class Address(
    var city: String? = null,
    var street: String? = null,
    var streetNumber: String? = null,
    var postCode: String? = null
){

}


