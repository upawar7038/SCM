package com.contactmanager.ContactManager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ContactManagerApplication

fun main(args: Array<String>) {
	runApplication<ContactManagerApplication>(*args)
}
