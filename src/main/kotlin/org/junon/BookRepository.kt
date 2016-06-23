package org.junon

import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<Book, Long> {

    fun findByTitle(title: String): Iterable<Book>
    fun findByAuthor(author: String): Iterable<Book>
}
