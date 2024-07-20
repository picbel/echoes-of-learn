package com.picbel.appinfra

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AppInfraApplication

fun main(args: Array<String>) {
    runApplication<AppInfraApplication>(*args)
}
