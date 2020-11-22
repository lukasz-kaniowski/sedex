package com.sedex.connect.company

import java.util.*

data class CompanyRequest(
        val companyName: String, // this is probably required, I'm assuming that `name` in swagger spec should be `companyName`
        val companyType: String?,
        val natureofBusiness: String?,
        val incorporatedDate: Date?,
        val emailAddress: String?,
        val phoneNumber: String?
) {
    fun toCompany(): Company {
        return Company(companyName, companyType, natureofBusiness, incorporatedDate, emailAddress, phoneNumber)
    }
}

data class Company(
        val companyName: String,
        val companyType: String?,
        val natureofBusiness: String?,
        val incorporatedDate: Date?,
        val emailAddress: String?,
        val phoneNumber: String?,
        var id: UUID? = null
)
