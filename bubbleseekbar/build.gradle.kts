plugins {
	id("com.android.library")
	kotlin("android")
	`maven-publish`
}

val Version = "4.0.0"

group = "app.shosetsu.libs"
version = Version
description = "An old library that makes seek bars easy"

android {
	compileSdkVersion(30)
	buildToolsVersion("30.0.3")

	defaultConfig {
		minSdkVersion(16)
		targetSdkVersion(30)
		versionCode = 37
		versionName = Version
	}

	buildTypes {
		named("release") {
			minifyEnabled(true)
			proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
		}
	}
}

dependencies {
	implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

	implementation("androidx.appcompat:appcompat:1.3.0")
	implementation("androidx.core:core-ktx:1.6.0")
	implementation(kotlin("stdlib-jdk8", "1.5.0"))
}

afterEvaluate {
	publishing {
		publications {
			// Creates a Maven publication called "release".

			create<MavenPublication>("release") {
				// Applies the component for the release build variant.
				from(components.getByName("release"))
			}
		}

	}
}