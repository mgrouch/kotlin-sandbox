
fun main(args: Array<String>) {
    val obj = DataClass(1L, "name", "readOnly")
    println("$obj")
    println("${obj[DataClass::readOnly.name]}")

    obj[DataClass::data.name] = "name2"
    println("$obj")

    for ((key, value) in obj) {
        println("$key=$value")
    }
}
