package me.aosamesan.batch.jobs

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.batch.core.Job
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.test.JobLauncherTestUtils
import org.springframework.batch.test.context.SpringBatchTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig

@SpringBatchTest
@SpringJUnitConfig(MyJobConfig::class)
class MyJobTests {
    @Autowired
    lateinit var jobLauncherTestUtils: JobLauncherTestUtils
    @Autowired
    lateinit var jobRepositoryTestUtils: JobLauncherTestUtils

    @Test
    fun testJobTest(@Qualifier("myJobTestJob") job: Job) {
        val jobParameters = JobParametersBuilder()
            .toJobParameters()
        jobLauncherTestUtils.job = job
        jobLauncherTestUtils.launchJob(jobParameters)
    }

}