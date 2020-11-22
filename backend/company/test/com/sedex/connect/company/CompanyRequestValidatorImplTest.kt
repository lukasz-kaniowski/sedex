package com.sedex.connect.company

import com.sedex.connect.com.sedex.connect.company.CompanyRequestValidatorImpl
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import kotlin.test.Test


internal class CompanyRequestValidatorImplTest {
    val underTest = CompanyRequestValidatorImpl()

    @Test
    internal fun correct_emails() {
        listOf(null, "asdf@asdf.com").forEach {
            val company = CompanyRequest("name", emailAddress = it)
            assertThat(underTest.validate(company), equalTo(emptyList()))
        }
    }

    @Test
    internal fun incorrect_emails() {
        listOf("", "abdc", "adbc.", "adsfb@", "adb@.sdf", "adb@fsadf.").forEach {
            val company = CompanyRequest("name", emailAddress = it)
            assertThat(underTest.validate(company), equalTo(listOf("Invalid email")))
        }
    }
}
