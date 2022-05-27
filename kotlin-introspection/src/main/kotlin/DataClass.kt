import kotlinx.serialization.Serializable
import kotlin.reflect.KMutableProperty1

@Serializable
data class DataClass(var id: Long?, var data: String?, val readOnly: String?)

val accessors = mapOf(
    "id" to DataClass::id,
    "data" to DataClass::data,
    "readOnly" to DataClass::readOnly,
)

operator fun DataClass.iterator(): Iterator<Pair<String, Any?>> = listOf(
    "id" to id,
    "data" to data,
    "readOnly" to readOnly,
).iterator()

operator fun DataClass.get(name: String): Any? = accessors[name]?.get(this)

operator fun DataClass.set(name: String, value: Any?) {
    val prop = accessors[name]
    if (prop is KMutableProperty1) {
        prop.set(this, value)
    }
    else throw IllegalArgumentException("No setter for $name")
}
