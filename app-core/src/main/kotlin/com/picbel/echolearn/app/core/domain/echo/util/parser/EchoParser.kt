package com.picbel.echolearn.app.core.domain.echo.util.parser

import com.picbel.echolearn.app.core.domain.echo.Echo

interface EchoParser {
    fun parse(data: String): List<Echo>
}
