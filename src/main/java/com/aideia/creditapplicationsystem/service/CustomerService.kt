package com.aideia.creditapplicationsystem.service

import com.aideia.creditapplicationsystem.entity.Customer
import com.aideia.creditapplicationsystem.exception.BusinessException
import com.aideia.creditapplicationsystem.repository.CustomerRepository
import com.aideia.creditapplicationsystem.service.impl.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) : ICustomerService {
    override fun save(customer: Customer): Customer {
        return this.customerRepository.save(customer)
    }

    override fun finById(id: Long): Customer {
        return this.customerRepository.findById(id).orElseThrow {
             throw BusinessException("ID $id not found")
        }
    }

    //override fun delete(id: Long) = this.customerRepository.deleteById(id)
    override fun delete(id: Long){
       val customer: Customer = this.finById(id)
        this.customerRepository.delete(customer)
    }
}