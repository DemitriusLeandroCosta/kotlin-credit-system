package com.aideia.creditapplicationsystem.repository

import com.aideia.creditapplicationsystem.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

//Criação da interface
@Repository
interface CustomerRepository: JpaRepository<Customer, Long> {
}