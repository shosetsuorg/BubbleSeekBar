plugins {
	id("com.android.library")
	maven
}


android {
	compileSdkVersion(30)
	buildToolsVersion("30.0.3")

	defaultConfig {
		minSdkVersion(16)
		targetSdkVersion(30)
		versionCode = 37
		versionName = "4.0.0"
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

	implementation("androidx.appcompat:appcompat:1.3.0")
	implementation("androidx.core:core-ktx:1.5.0")
	implementation(kotlin("stdlib-jdk7", "1.5.0"))
}