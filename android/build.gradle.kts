import com.lightningkite.khrysalis.gradle.configureGradle
import com.lightningkite.khrysalis.layout.LayoutConverter
import com.lightningkite.khrysalis.layout.mapViews
import com.lightningkite.khrysalis.layout.normal

buildscript {
    repositories {
        mavenLocal()
    }
    dependencies {
        classpath("com.lightningkite.khrysalis:plugin:0.1.0")
    }
}

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
}
apply {
    plugin("kotlin-android")
    plugin("kotlin-android-extensions")
//    plugin("com.google.gms.google-services")
}

val packageName = "com.tresit.khrysalis"

android {
    //    buildToolsVersion = "28.0.3"
    compileSdkVersion(29)
    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(29)
        applicationId = packageName
        versionCode = 3
        versionName = "0.3.1"
        multiDexEnabled = true
    }
    compileOptions {
        this.setSourceCompatibility(1.8)
        this.setTargetCompatibility(1.8)
    }
    testOptions {
        unitTests.isReturnDefaultValues = true
    }
    packagingOptions {
        pickFirst("META-INF/proguard/coroutines.pro")
        pickFirst("META-INF/android_release.kotlin_module")
        pickFirst("META-INF/android_debug.kotlin_module")
        pickFirst("META-INF/android-maps_release.kotlin_module")
        pickFirst("META-INF/android-maps_debug.kotlin_module")
        pickFirst("META-INF/android-fcm_release.kotlin_module")
        pickFirst("META-INF/android-fcm_debug.kotlin_module")
        pickFirst("META-INF/khrysalis-interfaces.json")
    }
    dexOptions {
        setJavaMaxHeapSize("4g")
    }
//    signingConfigs {
//        this.create("release"){
//            val props = project.rootProject.file("local.properties").takeIf { it.exists() }?.inputStream()?.use { stream ->
//                Properties().apply { load(stream) }
//            }
//            if(props != null && props.size > 0){
//                storeFile = project.rootProject.file(props.getProperty("signingKeystore"))
//                storePassword = props.getProperty("signingPassword")
//                keyAlias = props.getProperty("signingAlias")
//                keyPassword = props.getProperty("signingAliasPassword")
//            }
//        }
//    }
//    buildTypes {
//        this.getByName("release"){
//            this.isMinifyEnabled = false
//            this.proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
//            this.signingConfig = signingConfigs.getByName("release")
//        }
//    }
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://jitpack.io")
    jcenter()
}

val kotlin_version = "1.3.61"
dependencies {
    implementation("com.android.support:multidex:1.0.3")
    implementation("com.lightningkite.khrysalis:android:0.1.1")
    implementation("com.lightningkite.khrysalis:android-maps:0.1.1")
    implementation("com.lightningkite.khrysalis:android-fcm:0.1.1")
    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test:runner:1.2.0")
    androidTestImplementation("com.android.support.test.espresso:espresso-core:3.0.2")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version")
    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlin_version")
    implementation("com.google.firebase:firebase-analytics:17.2.2")
}

project.configureGradle(
    packageName = packageName,
    iosRelativeBase = "../ios/DIR-S",
    setupCodeConversion = {
        imports += listOf("KhrysalisMaps", "KhrysalisFCM")
    },
    setupLayoutConversion = LayoutConverter.normal + LayoutConverter.mapViews
)

tasks.create("wrapper") {
}
