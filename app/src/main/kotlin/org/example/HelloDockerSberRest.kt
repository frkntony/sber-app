package org.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class HelloDockerSberRest

fun main(args: Array<String>) {
    runApplication<HelloDockerSberRest>(*args)
}

// усложнил по приколу классом, с приватной переменной и публичным сеттером и геттером
class Person {
    private var name: String = ""

    fun getName(): String {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }
}

@RestController
class HelloController {

    @GetMapping("/")
    fun hello(): String {
        return "Hello Docker!"
    }

    @GetMapping("/{name}")
    fun greet(@PathVariable name: String): String {
        // создаю объект
        val person = Person()
        // через сеттер переменку перезаписываю
        person.setName(name)

        // вызываю геттер у объекта
        return "Hello Docker! Greetings from ${person.getName()}."
    }

    // Это версия без ООП
    // @GetMapping("/{name}")
    // fun greet(@PathVariable name: String): String {
    //     return "Hello Docker! Greetings from $name."
    // }
}
