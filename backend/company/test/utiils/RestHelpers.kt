package com.sedex.connect.utiils

import io.ktor.http.*
import io.ktor.server.testing.*

object RestHelpers {
    internal fun TestApplicationEngine.executePOST(path: String, body: String): TestApplicationCall {
        return handleRequest(HttpMethod.Post, path) {
            addHeader(HttpHeaders.ContentType, "application/json")
            setBody(body)
        }
    }
}
