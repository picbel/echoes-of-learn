package com.picbel.echolearn.app.service.domain.echo.usecase

import com.picbel.echolearn.app.core.domain.echo.Echo

interface EchoEmailSender : EchoSender {

}

internal class EchoEmailSenderImpl : EchoEmailSender {

    override fun send(echo: Echo): Echo {
        TODO()
    }
}
