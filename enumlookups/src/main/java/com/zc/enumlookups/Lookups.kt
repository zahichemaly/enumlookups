package com.zc.enumlookups

/**
 * Created by Zahi on 6/13/2021
 */

/**
 * Reverse lookup of an enum using ordinal.
 * @param value: Ordinal value.
 * @param default: Default enum if not found. If not specified, the first enum is returned.
 */
inline fun <reified T : Enum<T>> lookup(value: Int, default: T = enumValues<T>().first()): T {
    return enumValues<T>().find { it.ordinal == value } ?: default
}

/**
 * Reverse lookup of an enum using name.
 * @param name: Name of enum
 * @param default: Default enum if not found. If not specified, the first enum is returned.
 * @param ignoreCase: `true` to ignore character case when comparing enum names.
 */
inline fun <reified T : Enum<T>> lookupByName(name: String, default: T = enumValues<T>().first(), ignoreCase: Boolean = true): T {
    return enumValues<T>().find { it.name.contentEquals(name, ignoreCase) } ?: default
}

/**
 * Reverse lookup of an enum using a field as key.
 * @param value: Value of enum.
 */
inline fun <reified T : Enum<T>, V> ((T) -> V).lookupByValue(value: V, default: T = enumValues<T>().first()): T {
    return enumValues<T>().find { this(it) == value } ?: default
}

/**
 * Returns a list of enums matching the predicate.
 */
inline fun <reified T : Enum<T>> lookupFilter(predicate: (T) -> Boolean): List<T> {
    return enumValues<T>().filter(predicate)
}

/**
 * Reverse lookup operator. Calls [lookupByValue] with default params.
 * @param value: Value of enum.
 */
inline infix fun <reified T : Enum<T>, V> ((T) -> V).from(value: V): T {
    return lookupByValue(value)
}
