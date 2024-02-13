package com.aideia.creditapplicationsystem.service.impl

import com.aideia.creditapplicationsystem.entity.Credit
import java.util.UUID

interface ICreditService {
    fun save(credit: Credit): Credit
    fun findAllByCustomer(customerId: Long):List<Credit>
    fun findByCreditCode(customerId: Long, creditCode: UUID): Credit
}