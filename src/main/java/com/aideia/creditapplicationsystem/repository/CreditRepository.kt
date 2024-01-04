package com.aideia.creditapplicationsystem.repository

import com.aideia.creditapplicationsystem.entity.Credit
import org.aspectj.apache.bcel.classfile.Code
import org.springframework.data.repository.CrudRepository
import java.util.UUID


interface CreditRepository : CrudRepository<Credit,Long>{
    fun findByCreditCode(creditCode: UUID): Credit?
}