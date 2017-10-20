# Clean-Architecture-for-Android


Para utilizar el core, tu gradle del proyecto debe verse así:

```
// Top-level build file where you can add configuration options common to all sub-projects/modules.
project.ext {
    compileSdkVersion = 26
    buildToolsVersion = "26.0.1"
    targetSdkVersion = 26
    support_version = "26.0.0-alpha1"
    retrofit_version = "2.3.0"
    rxjava_version = "2.0.1"
    butterknife_version = "8.8.1"
    dagger_version = "2.11"

    dagger_package = "com.google.dagger"
    support_package = "com.android.support"
    butterknife_package = "com.jakewharton"
    retrofit_package = "com.squareup.retrofit2"
    rxjava_package = "io.reactivex.rxjava2"
}

buildscript {
    ext.kotlin_version = '1.1.4-3'
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:2.3.3'
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
    }
}

allprojects {
    repositories {
        jcenter()
        maven { url "https://www.jitpack.io" }
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}

```
