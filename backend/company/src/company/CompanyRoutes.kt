package com.sedex.connect.company

import com.fasterxml.jackson.databind.JsonMappingException
import com.sedex.connect.com.sedex.connect.company.CompanyRequestValidator
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.companies(companyRepository: CompanyRepository, requestValidator: CompanyRequestValidator) {
    route("/company") {
        post("/") {
            val body = try {
                call.receive<CompanyRequest>()
            } catch (e: JsonMappingException) {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }
            val errors: List<String> = requestValidator.validate(body)
            if (errors.isNotEmpty()) {
                call.respond(HttpStatusCode.BadRequest, errors)
                return@post
            }
            call.respond(HttpStatusCode.Created, companyRepository.create(body.toCompany()))
        }
    }
}
