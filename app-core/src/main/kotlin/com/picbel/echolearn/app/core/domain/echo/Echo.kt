package com.picbel.echolearn.app.core.domain.echo

import java.time.Duration
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
    val comebackEchoAt: Instant?
) {
    init {
        require(importance in 1..10) { "importance must be between 1 and 10" }
        if (comebackEchoAt != null) {
            require(comebackEchoAt.isAfter(createAt)) { "comebackEchoAt must be after createAt" }
            require(comebackEchoAt.isBefore(Instant.now())) { "comebackEchoAt must be before now" }
        }
    }

    /**
     * 마지막 Echo 반환 후 지난 일수
     */
    val daysSinceComebackEcho: Int
        get() = Duration.between(
            comebackEchoAt ?: createAt,
            Instant.now()
        ).toDays().toInt()

    /**
     * 복귀 우선순위
     */
    val comebackPriority: Int
        get() = importance * daysSinceComebackEcho

    fun comeback(): Echo {
        return copy(comebackEchoAt = Instant.now())
    }
}
