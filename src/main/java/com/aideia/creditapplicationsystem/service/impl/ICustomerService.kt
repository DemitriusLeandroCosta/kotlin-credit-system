package com.aideia.creditapplicationsystem.service.impl

import com.aideia.creditapplicationsystem.entity.Customer

interface ICustomerService {
    fun save(customer: Customer): Customer
    fun finById(id: Long): Customer
    fun delete(id:Long)
}