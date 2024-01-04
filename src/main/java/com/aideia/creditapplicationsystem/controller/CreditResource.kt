package com.aideia.creditapplicationsystem.controller

import com.aideia.creditapplicationsystem.dto.CreditDto
import com.aideia.creditapplicationsystem.dto.CustomerDto
import com.aideia.creditapplicationsystem.entity.Credit
import com.aideia.creditapplicationsystem.service.impl.CreditService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
@RestController
@RequestMapping("/api/credits")
class CreditResource(
    private val creditService: CreditService
) {
    @PostMapping
    fun saveCredit(@RequestBody creditDto: CreditDto): String{
        val saveCredit: Credit = this.creditService.save(creditDto.toEntity())
        return "Credit ${saveCredit.creditCode} - Customer ${saveCredit.custommer?.firstName}"
    }
}