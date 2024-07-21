package com.picbel.echolearn.app.core.domain.echo

import io.kotest.assertions.assertSoftly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.assertThrows
import test.util.domain.randomEcho
import java.time.Instant
import java.time.temporal.ChronoUnit
import kotlin.test.Test

class EchoTest {

    @Nested
    @DisplayName("Echo를 생성합니다")
    inner class CreateEchoTest {
        @Test
        fun `오늘 생성한 Echo는 comebackPriority가 0입니다`() {
            // given : // when :
            val sut = randomEcho(
                createAt = Instant.now()
            )
            // then :
            assertSoftly {
                sut.comebackPriority shouldBe 0
                sut.daysSinceComebackEcho shouldBe 0
            }
        }

        @Test
        fun `3일전 생성한 중요도 5의 Echo는 comebackPriority가 15입니다`() {
            // given : // when :
            val sut = randomEcho(
                createAt = Instant.now().minus(3, ChronoUnit.DAYS),
                importance = 5
            )
            // then :
            assertSoftly {
                sut.comebackPriority shouldBe 15
                sut.daysSinceComebackEcho shouldBe 3
            }
        }

        @Test
        fun `오늘 복귀한 Echo는 comebackPriority가 0입니다`() {
            // given : // when :
            val sut = randomEcho(
                createAt = Instant.now().minus(3, ChronoUnit.DAYS),
                comebackEchoAt = Instant.now()
            )
            // then :
            assertSoftly {
                sut.comebackPriority shouldBe 0
                sut.daysSinceComebackEcho shouldBe 0
            }
        }


        @Test
        fun `comebackEchoAt가 현재보다 미래 일 수 없습니다`() {
            // given : // when : // then :
            assertThrows<IllegalArgumentException> {
                randomEcho(
                    comebackEchoAt = Instant.now().plus(1, ChronoUnit.DAYS)
                )
            }
        }

        @Test
        fun `importance는 1~10 사이면 입력 가능합니다`() {
            // given : // when : // then :
            assertThrows<IllegalArgumentException> {
                randomEcho(
                    importance = Int.MAX_VALUE
                )
            }
            assertThrows<IllegalArgumentException> {
                randomEcho(
                    importance = Int.MIN_VALUE
                )
            }
        }

    }



}
