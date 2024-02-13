package com.aideia.creditapplicationsystem.service

import com.aideia.creditapplicationsystem.entity.Credit
import com.aideia.creditapplicationsystem.exception.BusinessException
import com.aideia.creditapplicationsystem.repository.CreditRepository
import com.aideia.creditapplicationsystem.service.impl.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
): ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer =customerService.finById(credit.customer?.id!!)
        }
      return  this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> = this.creditRepository.findAllByCustomerId(customerId)

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
       val credit:Credit =(this.creditRepository.findByCreditCode(creditCode)?:
       throw BusinessException("CreditCode $creditCode not found "))
        return if(credit.customer?.id == customerId) credit else throw IllegalArgumentException("Contact Admin")
    }
}