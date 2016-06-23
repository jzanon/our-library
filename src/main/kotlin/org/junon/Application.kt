package org.junon

import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

@SpringBootApplication
open class Application {

    private val log = LoggerFactory.getLogger(Application::class.java)

    @Bean
    open fun objectMapperBuilder()
            = Jackson2ObjectMapperBuilder().modulesToInstall(KotlinModule())

    @Bean
    open fun init(repository: BookRepository) = CommandLineRunner {
        // save a couple of books
        repository.save(Book("Jack", "Bauer"))
        repository.save(Book("Chloe", "O'Brian"))
        repository.save(Book("Kim", "Bauer"))
        repository.save(Book("David", "Palmer"))
        repository.save(Book("Michelle", "Dessler"))

        // fetch all books
        log.info("Books found with findAll():")
        log.info("-------------------------------")
        for (book in repository.findAll()) {
            log.info(book.toString())
        }
        log.info("")

        // fetch an individual book by ID
        val book = repository.findOne(1L)
        log.info("Book found with findOne(1L):")
        log.info("--------------------------------")
        log.info(book.toString())
        log.info("")

        // fetch books by last name
        log.info("Book found with findByAuthor('Bauer'):")
        log.info("--------------------------------------------")
        for (bauer in repository.findByAuthor("Bauer")) {
            log.info(bauer.toString())
        }
        log.info("")
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
