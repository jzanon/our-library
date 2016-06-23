package org.junon

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController @Autowired constructor(val repository: BookRepository) {

	@RequestMapping("/")
	fun findAll() = repository.findAll()

	@RequestMapping("/{title}")
	fun findByTitle(@PathVariable title:String)
			= repository.findByTitle(title)
}
