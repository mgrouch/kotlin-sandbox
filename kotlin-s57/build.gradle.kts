import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("js") version "1.6.21"
	kotlin("plugin.serialization") version "1.6.21"
}

group = "kotlin.s57"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-stdlib")
	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
