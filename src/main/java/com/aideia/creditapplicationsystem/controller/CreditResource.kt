package com.aideia.creditapplicationsystem.controller

import com.aideia.creditapplicationsystem.dto.CreditDto
import com.aideia.creditapplicationsystem.dto.CreditView
import com.aideia.creditapplicationsystem.dto.CreditViewList
import com.aideia.creditapplicationsystem.entity.Credit
import com.aideia.creditapplicationsystem.service.impl.CreditService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import java.util.stream.Collectors

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
    @GetMapping
    fun findAllCustomerId(@RequestParam(value= "customerId") customerId: Long): List<CreditViewList>{
        return this.creditService.findAllByCustomer(customerId).stream()
            .map {credit:Credit -> CreditViewList(credit)}.collect(Collectors.toList())
    }

    @GetMapping("/{creditCode}")
    fun findByCreditCode(@RequestParam(value= "customerId") customerId: Long,
                         @PathVariable creditCode: UUID): CreditView {
      val credit: Credit =  this.creditService.findByCreditCode(customerId, creditCode)
        return CreditView(credit)
    }

}