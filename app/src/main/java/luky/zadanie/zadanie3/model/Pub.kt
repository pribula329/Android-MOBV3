package luky.zadanie.zadanie3.model


data class Pub(
    var id: Long,
    var lat: Double,
    var lon: Double,
    var tags: Tags) {

}

data class Tags(
    var nameShop: String? = null) {

}


