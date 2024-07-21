dependencies {
    implementation(project(":app-core"))
    implementation(project(":app-service"))

    testImplementation(project(":app-core", "testArtifacts"))
    testImplementation(project(":app-service", "testArtifacts"))
}

repositories {
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots")
}

sourceSets {
    val test by getting {
        java.srcDir("src/test/kotlin")
        resources.srcDir("src/test/resources")
        compileClasspath += project(":app-core").sourceSets["test"].runtimeClasspath
        runtimeClasspath += project(":app-core").sourceSets["test"].runtimeClasspath
    }
}

val testJar by tasks.registering(Jar::class) {
    archiveClassifier.set("tests")
    from(sourceSets["test"].output)
}

configurations {
    create("testArtifacts")
}

artifacts {
    add("testArtifacts", testJar)
}

