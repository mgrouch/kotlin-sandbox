import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpack
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
	val kotlinVersion: String by System.getProperties()
	kotlin("plugin.serialization") version kotlinVersion
	kotlin("js") version kotlinVersion
	val kvisionVersion: String by System.getProperties()
	id("io.kvision") version kvisionVersion
}

version = "1.0.0-SNAPSHOT"
group = "com.example"

repositories {
	mavenCentral()
	jcenter()
	mavenLocal()
}

// Versions
val kotlinVersion: String by System.getProperties()
val kvisionVersion: String by System.getProperties()

// Custom Properties
val webDir = file("src/main/web")

kotlin {
	js(LEGACY) {
		browser {
			runTask {
				outputFileName = "main.bundle.js"
				sourceMaps = false
				devServer = KotlinWebpackConfig.DevServer(
					open = false,
					port = 3001,
					proxy = mutableMapOf(
						"/kv/*" to "http://localhost:8080",
						"/kvws/*" to mapOf("target" to "ws://localhost:8080", "ws" to true)
					),
					static = mutableListOf("$buildDir/processedResources/js/main")
				)
			}
			webpackTask {
				outputFileName = "main.bundle.js"
			}
			testTask {
				useKarma {
					useChromeHeadless()
				}
			}
		}
		binaries.executable()
	}
	sourceSets["main"].dependencies {
		implementation("io.kvision:kvision:$kvisionVersion")
		implementation("io.kvision:kvision-bootstrap:$kvisionVersion")
		implementation("io.kvision:kvision-bootstrap-css:$kvisionVersion")
		implementation("io.kvision:kvision-fontawesome:$kvisionVersion")
	}
	sourceSets["test"].dependencies {
		implementation(kotlin("test-js"))
		implementation("io.kvision:kvision-testutils:$kvisionVersion")
	}
	sourceSets["main"].resources.srcDir(webDir)
}


rootProject.plugins.withType<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin> {
	rootProject.the<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension>().versions.webpackDevServer.version = "4.8.1"
	rootProject.the<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension>().versions.webpackCli.version = "4.9.2"
	rootProject.the<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension>().versions.webpack.version = "5.72.0"
}