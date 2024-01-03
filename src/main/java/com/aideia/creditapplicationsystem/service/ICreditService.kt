package com.aideia.creditapplicationsystem.service

import com.aideia.creditapplicationsystem.entity.Credit
import java.util.UUID

interface ICreditService {
    fun save(credit: Credit): Credit
    fun findAllByCustomer(customerId: Long):List<Credit>
    fun findByCreditCode(creditCode: UUID): Credit
}