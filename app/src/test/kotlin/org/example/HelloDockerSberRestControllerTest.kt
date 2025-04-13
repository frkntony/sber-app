package org.example

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@WebMvcTest(HelloController::class)
class HelloDockerSberRestControllerTest(@Autowired val mockMvc: MockMvc) {

    @Test
    fun test1() {
        val result = mockMvc.get("/")
        val responseBody = result.andReturn().response.contentAsString
        assert(responseBody == "Hello Docker!") {
            "Ожидаю 'Hello Docker!', но получил: '$responseBody'"
        }
    }

    @Test
    fun test2() {
        val name = "frkntony"
        val result = mockMvc.get("/$name")
        val responseBody = result.andReturn().response.contentAsString
        assert(responseBody == "Hello Docker! Greetings from frkntony.") {
            "Ожидаю 'Hello Docker! Greetings from frkntony.', но получил: '$responseBody'"
        }
    }
}
