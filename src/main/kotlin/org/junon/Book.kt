package org.junon

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Book(
		var title: String = "",
		var author: String = "",
		@Id @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
		var id: Long = 0
)
