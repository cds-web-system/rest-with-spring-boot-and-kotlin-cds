package br.com.cds

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    val counter: AtomicLong = AtomicLong()

    @RequestMapping("/greeting") // mapeia a requisição para greeting, quando digitar no browser ele retorna
    fun greeting(@RequestParam(value="name", defaultValue = "Não digitou nada") name: String?): Greeting{
        return Greeting(counter.incrementAndGet(), content = "Hello, $name!")
    }
}