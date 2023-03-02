package me.aosamesan.batch.jobs

import me.aosamesan.batch.config.DataSourceConfig
import me.aosamesan.batch.logger
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.transaction.PlatformTransactionManager

@Configuration
@Import(DataSourceConfig::class)
class MyJob2Config: DefaultBatchConfiguration() {
    companion object {
        private val log by logger()
    }

    @Bean
    fun myJobTest2Step(jobRepository: JobRepository): Step {
        return StepBuilder("myJobTest2Step", jobRepository)
            .tasklet({ _, _ ->
                log.info("myJobTest2Step")
                RepeatStatus.FINISHED
            }, transactionManager)
            .build()
    }

    @Bean
    fun myJobTest2Job(@Qualifier("myJobTest2Step") step: Step, jobRepository: JobRepository): Job {
        return JobBuilder("myJobTestJob", jobRepository)
            .start(step)
            .build()
    }
}