dependencies {
    implementation(project(":app-core"))
    implementation(project(":app-service"))
    implementation(project(":app-infra"))

    implementation("org.springframework.boot:spring-boot-starter")

    testImplementation(project(":app-core", "testArtifacts"))
    testImplementation(project(":app-service", "testArtifacts"))
    testImplementation(project(":app-infra", "testArtifacts"))

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