dependencies {
    implementation(project(":app-core"))

    implementation("org.springframework.boot:spring-boot-starter")

    testImplementation(project(":app-core", "testArtifacts"))

    testImplementation("org.springframework.boot:spring-boot-starter-test")
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

