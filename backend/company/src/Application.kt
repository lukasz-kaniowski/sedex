package com.sedex.connect

import com.fasterxml.jackson.databind.SerializationFeature
import com.sedex.connect.com.sedex.connect.company.CompanyRequestValidatorImpl
import com.sedex.connect.company.InMemoryCompanyRepository
import com.sedex.connect.company.companies
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.jackson.*
import io.ktor.response.*
import io.ktor.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }


    routing {
        get("/") {
            call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
        }

        route("/interview/v0") {
            companies(InMemoryCompanyRepository, CompanyRequestValidatorImpl())
        }
    }
}


