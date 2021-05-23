plugins {
	id("com.android.application")
	kotlin("android")
}

android {
	compileSdkVersion(30)
	buildToolsVersion("30.0.3")
	defaultConfig {
		applicationId = "com.xw.samlpe.bubbleseekbar"
		minSdkVersion(16)
		targetSdkVersion(30)
		versionCode = 13
		versionName = "1.12"
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}
	buildFeatures {
		viewBinding = true
	}

	buildTypes {
		named("release") {
			minifyEnabled(false)
			proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
		}
	}
}

dependencies {
	implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
	androidTestImplementation("androidx.test.espresso:espresso-core:3.1.0") {
		exclude("com.android.support", "support-annotations")
	}
	implementation("androidx.appcompat:appcompat:1.3.0")
	implementation("com.google.android.material:material:1.3.0")
	testImplementation("junit:junit:4.13.2")
	implementation(project(":bubbleseekbar"))
}
