package com.suryadigital.automatedturk

import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {
    @Test
    fun testStatus() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/status").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("HEALTHY", response.content)
            }
        }
    }
}
