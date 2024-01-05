package com.aideia.creditapplicationsystem.dto

import com.aideia.creditapplicationsystem.entity.Credit
import com.aideia.creditapplicationsystem.enumeration.Status
import java.math.BigDecimal
import java.util.UUID

data class CreditView(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberOffInstallment: Int,
    val status : Status,
    val emailCustomer:String?,
    val incomeCustomer: BigDecimal?
){
    constructor(credit:Credit): this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOffInstallment = credit.numberOffInstallment,
        status = credit.status,
        emailCustomer = credit.custommer?.email,
        incomeCustomer = credit.custommer?.income
    )
}
