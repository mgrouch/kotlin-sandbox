package s57

// https://github.com/quickbirdstudios/crc-kotlin

fun UByte.toBigEndianUInt(): UInt = this.toUInt() shl 24

@OptIn(ExperimentalUnsignedTypes::class)
class CRC32(private val polynomial: UInt = 0x04C11DB7.toUInt()) {

    private val lookupTable: List<UInt> = (0 until 256).map { crc32(it.toUByte(), polynomial) }

    var value: UInt = 0.toUInt()
        private set

    fun update(inputs: UByteArray) {
        value = crc32(inputs, value)
    }

    fun reset() {
        value = 0.toUInt()
    }

    private fun crc32(inputs: UByteArray, initialValue: UInt = 0.toUInt()): UInt {
        return inputs.fold(initialValue) { remainder, byte ->
            val bigEndianInput = byte.toBigEndianUInt()
            val index = (bigEndianInput xor remainder) shr 24
            lookupTable[index.toInt()] xor (remainder shl 8)
        }
    }

    private fun crc32(input: UByte, polynomial: UInt): UInt {
        val bigEndianInput = input.toBigEndianUInt()

        return (0 until 8).fold(bigEndianInput) { result, _ ->
            val isMostSignificantBitOne = result and 0x80000000.toUInt() != 0.toUInt()
            val shiftedResult = result shl 1

            when (isMostSignificantBitOne) {
                true -> shiftedResult xor polynomial
                false -> shiftedResult
            }
        }
    }
}