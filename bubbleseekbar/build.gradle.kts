plugins {
	id("com.android.library")
	kotlin("android")
	`maven-publish`
}

group = "app.shosetsu.libs"
version = "5.0.0"


android {
	compileSdkVersion(30)
	buildToolsVersion = "30.0.3"

	defaultConfig {
		minSdkVersion(16)
		targetSdkVersion(30)
		versionCode = 37
		versionName = "5.0.0"
	}

	buildTypes {
		named("release") {
			minifyEnabled(false)
			proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
		}
	}
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

dependencies {
	implementation("androidx.appcompat:appcompat:1.3.0")
	implementation("androidx.core:core-ktx:1.6.0")
	implementation(kotlin("stdlib-jdk8", "1.5.0"))
}

