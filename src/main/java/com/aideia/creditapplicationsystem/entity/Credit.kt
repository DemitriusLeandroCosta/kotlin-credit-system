package com.aideia.creditapplicationsystem.entity

import com.aideia.creditapplicationsystem.enumeration.Status
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*
@Entity
data class Credit (
    @Column(nullable = false, unique = true) val creditCode: UUID = UUID.randomUUID(),
    @Column(nullable = false) val creditValue: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false) val dayFirstInstallment: LocalDate,
    @Column(nullable = false) val numberOffInstallment: Int = 0,
    @Enumerated val status: Status = Status.IN_PROGRESS,
    @ManyToOne val custommer: Customer?=null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
)
