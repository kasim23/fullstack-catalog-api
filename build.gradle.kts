plugins {
    id("java")
}

group = "com.mallon"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // The PostgreSQL Driver
    implementation("org.postgresql:postgresql:42.7.2")

    // Testing tools
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}