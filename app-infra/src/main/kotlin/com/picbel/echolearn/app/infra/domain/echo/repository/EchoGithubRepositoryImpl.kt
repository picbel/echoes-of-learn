package com.picbel.echolearn.app.infra.domain.echo.repository

import com.picbel.echolearn.app.core.domain.echo.Echo
import com.picbel.echolearn.app.service.domain.echo.repository.EchoRepository

class EchoGithubRepositoryImpl : EchoRepository {
    override fun findAll(): List<Echo> {
        TODO()
    }

    override fun saveAll(echos: List<Echo>): List<Echo> {
        TODO("Not yet implemented")
    }

    override fun save(echo: Echo): Echo {
        TODO("Not yet implemented")
    }
}
