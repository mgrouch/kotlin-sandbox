
fun main(args: Array<String>) {
    val obj = DataClass(1L, "name", "readOnly", -1)
    println("$obj")

    // it's kind of inefficient (if prop name is not a variable)
    println("${obj[DataClass::readOnly.name]} ${obj[DataClass::nonNull.name]}")

    // better just
    println("${DataClass::readOnly.get(obj)} ${DataClass::nonNull.get(obj)}")

    // it's kind of inefficient (if prop name is not a variable)
    obj[DataClass::data.name] = "name2"
    obj[DataClass::nonNull.name] = -3
    println("$obj")

    // better just
    DataClass::data.set(obj, "name3")
    println("$obj")

    for ((key, value) in obj) {
        println("$key=$value")
    }
}
