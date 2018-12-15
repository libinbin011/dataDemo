plugins {
    kotlin("jvm") version "1.2.71"
}

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib"))

    compile(project(":useCase"))
}