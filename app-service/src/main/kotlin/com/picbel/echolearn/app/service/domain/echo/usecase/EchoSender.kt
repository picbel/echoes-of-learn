package com.picbel.echolearn.app.service.domain.echo.usecase

import com.picbel.echolearn.app.core.domain.echo.Echo

interface EchoSender {

    fun send(echo: Echo) : Echo
}
