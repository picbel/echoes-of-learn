pluginManagement {
    plugins {
        val kotlinVersion: String by settings
        val springBootVersion: String by settings
        val springDependencyManagementVersion: String by settings
        val allOpenVersion: String by settings
        id("org.springframework.boot") version springBootVersion
        id("io.spring.dependency-management") version springDependencyManagementVersion

        kotlin("jvm") version kotlinVersion
        kotlin("plugin.spring") version kotlinVersion
    }
}
rootProject.name = "echoes-of-learn"
include(":app-core")
include(":app-service")
include(":app-infra")
include(":app")
