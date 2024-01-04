package com.aideia.creditapplicationsystem.dto

import com.aideia.creditapplicationsystem.entity.Credit
import com.aideia.creditapplicationsystem.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    val creditValue:BigDecimal,
    val dayFirstInstallment : LocalDate,
    val numberOffInstallment: Int,
    val customerId: Long
){
    fun toEntity():Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstInstallment,
        numberOffInstallment = this.numberOffInstallment,
       // custommer = Customer(id = this.customerId)
    )
}
