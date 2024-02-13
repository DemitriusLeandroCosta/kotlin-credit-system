package com.aideia.creditapplicationsystem.exception

data class BusinesException(override val message: String? ) : RuntimeException(message) {

}
