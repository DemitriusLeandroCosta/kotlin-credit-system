package com.aideia.creditapplicationsystem.repository

import com.aideia.creditapplicationsystem.entity.Credit
import org.springframework.data.repository.CrudRepository


interface CreditRepository : CrudRepository<Credit,Long>{
}