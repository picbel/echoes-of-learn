package test.util.domain


private val alphanumeric = ('a'..'z') + ('A'..'Z') + ('0'..'9')

fun randomAlphanumeric(minLength: Int = 1, maxLength: Int = 10): String {
    require(minLength <= maxLength) { "minLength must be less than or equal to maxLength" }
    require(minLength >= 0 && maxLength >= 0) { "minLength, maxLength must be greater than or equal to 0" }
    return (minLength..maxLength).map { alphanumeric.random() }.joinToString("")
}

