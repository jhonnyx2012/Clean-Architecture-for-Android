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

Y ademas, el archivo gradle de modulos donde implementes el core debe verse así:

```
apply plugin: 'com.android.application'

android {
    compileSdkVersion rootProject.ext.compileSdkVersion
    buildToolsVersion rootProject.ext.buildToolsVersion
    defaultConfig {
        applicationId "aqui y tu application id"
        minSdkVersion 16
        targetSdkVersion rootProject.ext.targetSdkVersion
        versionCode 1
        versionName "1.0"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    compile project(':core')
    annotationProcessor "$dagger_package:dagger-compiler:$dagger_version"
    annotationProcessor "$butterknife_package:butterknife-compiler:$butterknife_version"
}
