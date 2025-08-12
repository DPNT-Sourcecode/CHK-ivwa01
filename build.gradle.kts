plugins {
    kotlin("jvm") version "2.0.21"
    application
    jacoco
}

version = project.version.toString()

kotlin {
    jvmToolchain(21)
}

application {
    mainClass.set("SendCommandToServerKt")
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("io.accelerate:tdl-client-java:0.30.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.17.3")

    testImplementation(kotlin("test"))

    // JUnit 5 BOM keeps versions aligned
    testImplementation(platform("org.junit:junit-bom:5.10.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // JUnit Platform Suite annotations (@Suite, @IncludeEngines, etc.)
    testImplementation("org.junit.platform:junit-platform-suite-api:1.10.3")
    testRuntimeOnly("org.junit.platform:junit-platform-suite-engine:1.10.3")

    // Cucumber engine for JUnit Platform
    testImplementation("io.cucumber:cucumber-java:7.18.1")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.18.1")
    testImplementation("io.cucumber:cucumber-picocontainer:7.18.1")
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
    val action = System.getProperty("action") // String?
    if (action != null && action.trim().isNotEmpty()) {
        args(action) // pass single arg if present
    }
}

tasks.test {
    useJUnitPlatform()
    systemProperty("cucumber.junit-platform.naming-strategy", "long")
    testLogging {
        events("passed", "skipped", "failed")
    }

    ignoreFailures = true
    finalizedBy(tasks.jacocoTestReport)
}


jacoco {
    reportsDirectory.set(layout.buildDirectory.dir("jacoco"))
}

tasks.jacocoTestReport {
    dependsOn(tasks.test) // tests are required to run before generating the report
    reports {
        xml.required.set(true)
        csv.required.set(false)
        html.required.set(false)
    }
}

