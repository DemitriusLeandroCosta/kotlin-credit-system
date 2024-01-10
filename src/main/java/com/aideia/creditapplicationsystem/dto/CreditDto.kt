package com.aideia.creditapplicationsystem.dto

import com.aideia.creditapplicationsystem.entity.Credit
import com.aideia.creditapplicationsystem.entity.Customer
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotEmpty
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field:NotEmpty(message = "Invalid input") val creditValue: BigDecimal,
    @field:Future val dayFirstInstallment: LocalDate,
    val numberOffInstallment: Int,
    val customerId: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstInstallment,
        numberOffInstallment = this.numberOffInstallment,
        // custommer = Customer(id = this.customerId)
    )
}
