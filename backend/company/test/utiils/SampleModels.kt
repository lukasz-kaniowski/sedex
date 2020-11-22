package com.sedex.connect.utiils

import com.sedex.connect.company.CompanyRequest
import java.util.*


object SampleModels {
    internal fun aSampleCompanyRequest(): CompanyRequest {
        return CompanyRequest(
                "sampleCompanyName",
                "sampleCompanyType",
                "sampleNatureofBusiness",
                Date(),
                "sampleEmailAddress",
                "samplePhoneNumber"
        )
    }
}
