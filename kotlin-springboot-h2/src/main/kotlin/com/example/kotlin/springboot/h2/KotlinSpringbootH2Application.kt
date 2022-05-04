package com.example.kotlin.springboot.h2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSpringbootH2Application

fun main(args: Array<String>) {
	runApplication<KotlinSpringbootH2Application>(*args)
}
