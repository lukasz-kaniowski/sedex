package com.sedex.connect.company

import java.util.*

interface CompanyRepository {
    fun create(company: Company): Company
}

object InMemoryCompanyRepository : CompanyRepository {
    private val companies = mutableListOf<Company>()

    override fun create(company: Company): Company {
        company.id = UUID.randomUUID()
        companies.add(company)
        return company
    }


}
