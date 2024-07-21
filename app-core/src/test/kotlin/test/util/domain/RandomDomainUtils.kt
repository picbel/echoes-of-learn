package test.util.domain

import com.github.javafaker.Faker
import com.picbel.echolearn.app.core.domain.echo.Echo
import java.time.Instant
import java.util.concurrent.TimeUnit


object RandomDomainUtils

    private val faker = Faker()

    fun randomEcho(
        title: String = faker.letterify(randomAlphanumeric()),
        subTitles: List<String> = listOf(
            randomAlphanumeric(),
            randomAlphanumeric(),
        ),
        content: String = """
            ${subTitles.random()}
            ${randomAlphanumeric(maxLength = 100)}
            ${subTitles.random()}
            ${randomAlphanumeric(maxLength = 100)}
        """.trimIndent(),
        importance: Int = faker.number().numberBetween(1, 10),
        createAt: Instant = faker.date().past(365, TimeUnit.DAYS).toInstant(),
        comebackEchoAt: Instant? = null,
    ): Echo {
        return Echo(
            title = title,
            subTitles = subTitles,
            content = content,
            importance = importance,
            createAt = createAt,
            comebackEchoAt = comebackEchoAt,
        )
    }

