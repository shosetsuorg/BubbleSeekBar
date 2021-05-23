// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    var kotlinVersion: String by extra
    kotlinVersion = "1.5.0"
    repositories {
        mavenCentral()
        google()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:4.2.1")
        classpath(kotlin("gradle-plugin", kotlinVersion))
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        mavenCentral()
        google()
    }

    //tasks.withType(Javadoc) {
    //    options.addStringOption("Xdoclint:none", "-quiet")
    //    options.addStringOption("encoding", "UTF-8")
    //}
}

