package com.zc.enumlookups

/**
 * Created by Zahi on 6/13/2021
 */

/**
 * Reverse lookup of an enum using ordinal.
 */
inline fun <reified T : Enum<T>> lookup(value: Int, default: T = enumValues<T>().first()): T {
    return enumValues<T>().find { it.ordinal == value } ?: default
}

/**
 * Reverse lookup of an enum using name.
 */
inline fun <reified T : Enum<T>> lookupByName(name: String, default: T = enumValues<T>().first(), ignoreCase: Boolean = true): T {
    return enumValues<T>().find { it.name.contentEquals(name, ignoreCase) } ?: default
}

/**
 * Reverse lookup of an enum using a field as key.
 */
inline fun <reified T : Enum<T>, V> ((T) -> V).lookupByValue(value: V, default: T = enumValues<T>().first()): T {
    return enumValues<T>().find { this(it) == value } ?: default
}

/**
 * Reverse lookup of enums using a predicate.
 */
inline fun <reified T : Enum<T>> lookupFilter(predicate: (T) -> Boolean): List<T> {
    return enumValues<T>().filter(predicate)
}

/**
 * Reverse lookup of an enum using a field as key.
 */
inline infix fun <reified T : Enum<T>, V> ((T) -> V).from(value: V): T {
    return lookupByValue(value)
}
