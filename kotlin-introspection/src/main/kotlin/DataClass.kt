import kotlinx.serialization.Serializable
import kotlin.LazyThreadSafetyMode.PUBLICATION
import kotlin.reflect.KMutableProperty1

@Serializable
data class DataClass(var id: Long?, var data: String?, val readOnly: String?, var nonNull: Int = 0)

val dataClassAccessors by lazy(PUBLICATION) {
    mapOf(
        "id" to DataClass::id,
        "data" to DataClass::data,
        "readOnly" to DataClass::readOnly,
        "nonNull" to DataClass::nonNull,
    )
}

operator fun DataClass.iterator(): Iterator<Pair<String, Any?>> = listOf(
    "id" to id,
    "data" to data,
    "readOnly" to readOnly,
    "nonNull" to nonNull,
).iterator()

operator fun DataClass.get(name: String): Any? = dataClassAccessors[name]?.get(this)

operator fun DataClass.set(name: String, value: Any?) {
    val prop = dataClassAccessors[name]
    if (prop is KMutableProperty1) {
        prop.set(this, value)
    } else throw IllegalArgumentException("No setter for $name")
}
