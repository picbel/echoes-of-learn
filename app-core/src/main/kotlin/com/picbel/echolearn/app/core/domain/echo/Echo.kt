package com.picbel.echolearn.app.core.domain.echo

import java.time.Instant

data class Echo(
    /**
     * 제목
     */
    val title: String,
    /**
     * 부제목들
     *
     * content내의 목차
     */
    val subTitles: List<String>,
    /**
     * 내용
     */
    val content: String,
    /**
     * 중요도
     */
    val importance: Int,
    /**
     * 생성일
     */
    val createAt: Instant,
    /**
     * 마지막 Echo를 반환된 시간
     */
    val returnEchoAt: Instant?
) {
    init {
        require(importance > 0) { "importance must be greater than 0" }
    }
}
