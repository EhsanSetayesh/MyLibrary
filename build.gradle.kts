buildscript {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
        jcenter()
    }
    dependencies {
        classpath (BuildPlugins.androidBuildGradle)
        classpath (BuildPlugins.kotlinGradlePlugin)
        classpath (BuildPlugins.navigationSafeArgs)
        classpath (BuildPlugins.hiltGradlePlugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://plugins.gradle.org/m2/") }
        maven { url = uri("https://jitpack.io") }
        jcenter()
    }
}

tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}