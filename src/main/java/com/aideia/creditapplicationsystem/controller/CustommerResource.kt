package com.aideia.creditapplicationsystem.controller

import com.aideia.creditapplicationsystem.dto.CustomerDto
import com.aideia.creditapplicationsystem.dto.CustomerUpdateDto
import com.aideia.creditapplicationsystem.dto.CustomerView
import com.aideia.creditapplicationsystem.entity.Customer
import com.aideia.creditapplicationsystem.service.impl.CustomerService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/customers")
class CustommerResource(
    private val customerService: CustomerService
) {
    @PostMapping
    fun saveCustomer(@RequestBody customerDto: CustomerDto): String{
       val saveCustomer = this.customerService.save(customerDto.toEntity())
        return "Customer ${saveCustomer.email} saved!"
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id:Long): CustomerView {
      var customer:Customer = this.customerService.finById(id)
        return CustomerView(customer)
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id:Long) = this.customerService.delete(id)

    @PatchMapping
    fun updateCustomer(@RequestParam(value = "customerId") id: Long,
                       @RequestBody customerUpdateDto: CustomerUpdateDto): CustomerView{
       val customer: Customer =  this.customerService.finById(id)
       val customerToUpdate: Customer =  customerUpdateDto.toEntity(customer)
       val customerUptaded : Customer =  this.customerService.save(customerToUpdate)
        return CustomerView(customerUptaded)
    }
}