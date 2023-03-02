package me.aosamesan.batch.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactory
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType
import org.springframework.jdbc.support.JdbcTransactionManager
import org.springframework.transaction.PlatformTransactionManager

@Configuration
class DataSourceConfig {
    @Bean
    fun dataSource() = EmbeddedDatabaseBuilder()
        .setType(EmbeddedDatabaseType.HSQL)
        .addScript("classpath:/org/springframework/batch/core/schema-hsqldb.sql")
        .build()

    @Bean
    fun transactionManager(): PlatformTransactionManager = JdbcTransactionManager(dataSource())
}