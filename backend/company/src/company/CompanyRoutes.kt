package com.sedex.connect.company

import com.fasterxml.jackson.databind.JsonMappingException
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.companies() {
    route("/company") {
        post("/") {
            val body = try {
                call.receive<CompanyRequest>()
            } catch (e: JsonMappingException) {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }
            call.respond(HttpStatusCode.Created, body)
        }
    }
}
