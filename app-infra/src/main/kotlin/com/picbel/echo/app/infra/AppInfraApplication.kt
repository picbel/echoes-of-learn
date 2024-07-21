package com.picbel.echo.app.infra

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AppInfraApplication

fun main(args: Array<String>) {
    runApplication<AppInfraApplication>(*args)
}
