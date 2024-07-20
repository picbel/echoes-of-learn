package com.picbel.app.core.domain.echo

import java.time.Instant

data class Echo(
    val title: String,
    val subTitles: List<String>,
    val data: String,
    //중요도
    val importance: Int,
    val createAt: Instant,
)
