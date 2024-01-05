package com.aideia.creditapplicationsystem.dto

import com.aideia.creditapplicationsystem.entity.Credit
import java.math.BigDecimal
import java.util.UUID

data class CreditViewList(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberOffInstallment: Int
){
    constructor(credit: Credit): this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOffInstallment = credit.numberOffInstallment
    )
}
