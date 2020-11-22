package company

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.sedex.connect.company.Company
import com.sedex.connect.company.CompanyRequest
import com.sedex.connect.module
import com.sedex.connect.utiils.RestHelpers.executePOST
import com.sedex.connect.utiils.SampleModels.aSampleCompanyRequest
import com.shazam.shazamcrest.matcher.Matchers.sameBeanAs
import io.ktor.http.*
import io.ktor.server.testing.*
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import kotlin.test.Test

internal class CompanyRoutesKtTest {
    val mapper = jacksonObjectMapper()

    @Test
    internal fun `POST correct company data`() {
        val expected = aSampleCompanyRequest()
        withTestApplication({ module(testing = true) }) {
            executePOST("/interview/v0/company", mapper.writeValueAsString(expected)).response.let { response ->
                assertThat(HttpStatusCode.Created, equalTo(response.status()))

                val actual: Company = mapper.readValue(response.content.orEmpty())
                assertThat(actual, sameBeanAs(expected.toCompany()).ignoring("id"))
                assertThat(actual, Matchers.hasProperty("id", notNullValue()))
            }
        }
    }

    @Test
    internal fun `POST malformed data`() {
        withTestApplication({ module(testing = true) }) {
            executePOST("/interview/v0/company", """{"malformed": "data"}""").response.let { response ->
                assertThat(HttpStatusCode.BadRequest, equalTo(response.status()))
            }
        }
    }

    @Test
    internal fun `POST invalid data`() {
        withTestApplication({ module(testing = true) }) {
            val requestBody = mapper.writeValueAsString(CompanyRequest("testCompany", emailAddress = "incorrect email"))
            executePOST("/interview/v0/company", requestBody).response.let { response ->
                assertThat(HttpStatusCode.BadRequest, equalTo(response.status()))
            }
        }
    }
}

