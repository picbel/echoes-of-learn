dependencies {
    implementation(project(":app-core"))

    implementation("org.springframework.boot:spring-boot")

    testImplementation(project(":app-core", "testArtifacts"))
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

