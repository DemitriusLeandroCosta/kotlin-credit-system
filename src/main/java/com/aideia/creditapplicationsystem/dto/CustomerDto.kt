package com.aideia.creditapplicationsystem.dto

import com.aideia.creditapplicationsystem.entity.Address
import com.aideia.creditapplicationsystem.entity.Customer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
    @field:NotEmpty(message = "Invalid input") val firstName: String,
    @field:NotEmpty(message = "Invalid input") val lastName: String,
    @field:NotEmpty(message = "Invalid input CPF")
    @field:CPF(message = "CPF Invalid!") val cpf: String,
    @field:NotNull(message = "Inform o valor do Salubrious!") val income: BigDecimal,
    @field:NotEmpty(message = "Invalid input")
    @field:Email(message = "E-mail invalid!") val email: String,
    @field:NotEmpty(message = "Invalid input") val password: String,
    @field:NotEmpty(message = "Invalid input") val zipCode: String,
    @field:NotEmpty(message = "Invalid input") val street: String
) {
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipeCode = this.zipCode,
            street = this.street
        )
    )
}