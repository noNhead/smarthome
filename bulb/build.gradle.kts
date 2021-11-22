import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot")
	id("io.spring.dependency-management")
	kotlin("jvm")
	kotlin("plugin.spring")
	id("com.bmuschko.docker-java-application") version "7.1.0"
}

group = "com.dosee.smarthome"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

buildscript {
	repositories {
		gradlePluginPortal()
	}
	dependencies {
		classpath("com.bmuschko:gradle-docker-plugin:7.1.0")
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

apply(plugin = "com.bmuschko.docker-remote-api")

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.create("createDockerfile", com.bmuschko.gradle.docker.tasks.image.Dockerfile::class) {
	from("openjdk:jre-alpine")
	copyFile("my-app-1.0.jar", "/app/my-app-1.0.jar")
	entryPoint("java")
	defaultCommand("-jar", "/app/my-app-1.0.jar")
	exposePort(8080)
}
