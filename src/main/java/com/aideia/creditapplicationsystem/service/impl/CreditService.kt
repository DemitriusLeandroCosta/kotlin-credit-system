package com.aideia.creditapplicationsystem.service.impl

import com.aideia.creditapplicationsystem.entity.Credit
import com.aideia.creditapplicationsystem.repository.CreditRepository
import com.aideia.creditapplicationsystem.service.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
): ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            custommer =customerService.finById(credit.custommer?.id!!)
        }
      return  this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> {
        TODO("Not yet implemented")
    }

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
       val credit:Credit =(this.creditRepository.findByCreditCode(creditCode)?:
       throw RuntimeException("Credit Code inexistente"))
        return if(credit.custommer?.id == customerId) credit else throw RuntimeException("Contact Admin")
    }
}