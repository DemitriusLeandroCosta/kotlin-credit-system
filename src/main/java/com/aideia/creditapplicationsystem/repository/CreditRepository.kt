package com.aideia.creditapplicationsystem.repository

import com.aideia.creditapplicationsystem.entity.Credit
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import java.util.*


interface CreditRepository : CrudRepository<Credit, Long> {
    fun findByCreditCode(creditCode: UUID): Credit?

    @Query(value = "SELECT * from CREDIT where CUSTOMMER_ID  = ?1", nativeQuery = true)
    fun findAllByCustomerId(customerId: Long): List<Credit>
}