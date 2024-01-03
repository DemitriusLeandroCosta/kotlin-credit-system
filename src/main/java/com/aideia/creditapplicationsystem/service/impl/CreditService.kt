package com.aideia.creditapplicationsystem.service.impl

import com.aideia.creditapplicationsystem.entity.Credit
import com.aideia.creditapplicationsystem.repository.CreditRepository
import com.aideia.creditapplicationsystem.service.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository
): ICreditService {
    override fun save(credit: Credit): Credit {
        TODO("Not yet implemented")
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> {
        TODO("Not yet implemented")
    }

    override fun findByCreditCode(creditCode: UUID): Credit {
        TODO("Not yet implemented")
    }
}