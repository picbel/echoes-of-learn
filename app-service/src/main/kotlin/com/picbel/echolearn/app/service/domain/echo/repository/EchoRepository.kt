package com.picbel.echolearn.app.service.domain.echo.repository

import com.picbel.echolearn.app.core.domain.echo.Echo

interface EchoRepository {

    /*
     * @since 240721 현재는 전부다 가져오는 방향으로 구현
     * 외부 git에서 adoc파일 읽어서 가져오는것으로 구현
     */
    fun findAll(): List<Echo>

    fun saveAll(echos: List<Echo>): List<Echo>

    fun save(echo: Echo): Echo
}
