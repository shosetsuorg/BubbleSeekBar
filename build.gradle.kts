// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins{
    maven
}

buildscript {
    repositories {
        mavenCentral()
        google()
        maven( "https://maven.google.com")
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:4.2.2")
        classpath(kotlin("gradle-plugin", "1.5.0"))
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        mavenCentral()
        google()
        maven("https://jitpack.io")
    }

    //tasks.withType(Javadoc) {
    //    options.addStringOption("Xdoclint:none", "-quiet")
    //    options.addStringOption("encoding", "UTF-8")
    //}
}

task("clean", Delete::class) {
    delete(rootProject.buildDir)
}