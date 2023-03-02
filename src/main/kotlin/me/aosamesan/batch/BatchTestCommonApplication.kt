package me.aosamesan.batch

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class BatchTestCommonApplication

fun main(args: Array<String>) {
    runApplication<BatchTestCommonApplication>(*args)
}

fun <R: Any> R.logger(): Lazy<Logger> = lazy { LoggerFactory.getLogger(this::class.java) }