package com.manager.app.common.extenstions

import java.util.regex.Pattern


fun Any?.isEmptyString() = this?.toString().isEmptyString()

fun Any?.getString(default: String = ""): String {
    return this?.toString() ?: default
}

fun Any?.getInt(default: Int = 0): Int {
    return if (this == null) {
        default
    } else {
        if (this is Int || this is Long) {
            this.toString().toLong().toInt()
        } else {
            try {
                this.toString().toDouble().toInt()
            } catch (e: Exception) {
                default
            }
        }
    }
}

fun Boolean?.getInt(default: Int = 0): Int {
    return if (this == null) {
        default
    } else {
        if (this) 1 else 0
    }
}

fun Any?.getDouble(default: Double = 0.0): Double {
    return try {
        this?.toString()?.toDouble() ?: default
    } catch (e: Exception) {
        try {
            this?.toString()?.replace("^ +".toRegex(), "")?.toDouble()
                ?: default
        } catch (e: Exception) {
            default
        }
    }
}

fun Any?.getLong(default: Long = 0): Long {
    return if (this == null) {
        default
    } else {
        if (this is Long) {
            this
        } else if (this is Int) {
            this.toLong()
        } else {
            try {
                this.toString().toDouble().toLong()
            } catch (e: Exception) {
                default
            }
        }
    }
}
fun String?.isNumeric(): Boolean {
    if (this.isNullOrEmpty()) {
        return false
    } else {
        return Pattern.compile("^[0-9]*.?[0-9]+(([E|e])?[0-9]+)?$")
            .matcher(this.replace(" ", "")).matches()
    }
}
fun Any?.getLong(): Long = this.getLong(0)


fun Any?.getBoolean(default: Boolean = false): Boolean {
    return if (this == null) {
        default
    } else {
        if (this is Boolean) {
            this
        } else if (this is Number || this is Long || this is Int) {
            this.toString().toDouble().toInt().getBoolean(default)
        } else {
            default
        }
    }
}

fun Any?.getFloat(default: Float = 0f): Float {
    return if (this == null) {
        default
    } else {
        if (this is Number) {
            return try {
                this.toFloat()
            } catch (e: Exception) {
                default
            }
        }
        try {
            this.toString().toFloat()
        } catch (e: Exception) {
            default
        }
    }
}

fun Any.getInstanceName(): String {
    return this.javaClass.name + ":" + this.hashCode()
}

















