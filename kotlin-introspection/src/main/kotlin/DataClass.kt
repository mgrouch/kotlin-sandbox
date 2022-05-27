import DataClassMeta.accessors
import kotlinx.serialization.Serializable
import kotlin.LazyThreadSafetyMode.PUBLICATION
import kotlin.reflect.KMutableProperty1

@Serializable
data class DataClass(var id: Long?, var data: String?, val readOnly: String?, var nonNull: Int = 0)

object DataClassMeta {
    val accessors by lazy(PUBLICATION) {
        mapOf(
            "id" to DataClass::id,
            "data" to DataClass::data,
            "readOnly" to DataClass::readOnly,
            "nonNull" to DataClass::nonNull,
        )
    }
}

@Serializable
data class DbColumnMeta(
    val columnName : String,
    val columnSize: Int,
    val decimalDigits: Int,
    val datatype: String,
    val isNullable: Boolean,
)

operator fun DataClass.iterator(): Iterator<Pair<String, Any?>> = listOf(
    "id" to id,
    "data" to data,
    "readOnly" to readOnly,
    "nonNull" to nonNull,
).iterator()

operator fun DataClass.get(name: String): Any? = accessors[name]?.get(this)

operator fun DataClass.set(name: String, value: Any?) {
    val prop = accessors[name]
    if (prop is KMutableProperty1) {
        prop.set(this, value)
    } else throw IllegalArgumentException("No setter for $name")
}
