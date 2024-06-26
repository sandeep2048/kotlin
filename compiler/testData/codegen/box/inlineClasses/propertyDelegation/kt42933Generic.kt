// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +ValueClasses, +GenericInlineClassParameter
// JVM_ABI_K1_K2_DIFF: KT-63898

class Delegate {
    operator fun getValue(t: Any?, p: Any): String = "OK"
}

OPTIONAL_JVM_INLINE_ANNOTATION
value class Kla1<T: Int>(val default: T) {
    fun getValue(): String {
        val prop by Delegate()
        return prop
    }
}

fun box() = Kla1(1).getValue()