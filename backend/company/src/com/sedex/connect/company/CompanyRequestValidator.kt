package com.sedex.connect.com.sedex.connect.company

import com.sedex.connect.company.CompanyRequest
import java.util.regex.Pattern

interface CompanyRequestValidator {
    fun validate(companyRequest: CompanyRequest): List<String>
}

class CompanyRequestValidatorImpl : CompanyRequestValidator {
    val EMAIL_REGEX = Pattern.compile("^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})")

    override fun validate(companyRequest: CompanyRequest): List<String> {
        val errors = mutableListOf<String>()
        if (companyRequest.emailAddress != null && !isValidEmail(companyRequest.emailAddress)) {
            errors.add("Invalid email")
        }
        return errors
    }

    private fun isValidEmail(email: String) =
            EMAIL_REGEX.matcher(email).matches()
}
