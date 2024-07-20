package com.picbel.app.core.domain.echo.util.parser

import com.picbel.app.core.domain.echo.Echo
import java.io.InputStream

interface EchoParser {
    fun parse(data: String): List<Echo>
}