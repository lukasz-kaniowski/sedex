package company

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.sedex.connect.module
import com.sedex.connect.utiils.RestHelpers.executePOST
import com.sedex.connect.utiils.SampleModels.aSampleCompanyRequest
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

internal class CompanyRoutesKtTest {
    val mapper = jacksonObjectMapper()

    @Test
    internal fun `POST correct company data`() {
        val expected = aSampleCompanyRequest()
        withTestApplication({ module(testing = true) }) {
            executePOST("/interview/v0/company", mapper.writeValueAsString(expected)).response.let { response ->
                assertEquals(HttpStatusCode.Created, response.status())
            }
        }
    }

    @Test
    internal fun `POST malformed data`() {
        withTestApplication({ module(testing = true) }) {
            executePOST("/interview/v0/company", """{"malformed": "data"}""").response.let { response ->
                assertEquals(HttpStatusCode.BadRequest, response.status())
            }
        }
    }

}

