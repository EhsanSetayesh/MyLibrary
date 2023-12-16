plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = ConfigData.compileSdkVersion
    buildToolsVersion = ConfigData.buildToolsVersion
    flavorDimensions.add(ConfigData.flavorDimensions)
    namespace = ConfigData.applicationId
//__________________________________________________________________________________________________
    defaultConfig {
        applicationId = ConfigData.applicationId
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName
        testInstrumentationRunner = ConfigData.testInstrumentationRunner
        multiDexEnabled = true
    }
//__________________________________________________________________________________________________
//    signingConfigs {
//        create("release") {
//            storeFile = file("release.jks")
//            keyAlias = ""
//            keyPassword = ""
//            storePassword = ""
//        }
//    }
//__________________________________________________________________________________________________
    buildTypes {
//        getByName("release") {
//            applicationIdSuffix = ".release"
//            isMinifyEnabled = true
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
////            signingConfig signingConfigs.release
//            isShrinkResources = true
//            isPseudoLocalesEnabled = true
//            isDebuggable = false
//            isJniDebuggable = false
//            isRenderscriptDebuggable = false
//        }
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
        }
    }
//__________________________________________________________________________________________________
    productFlavors {
        //this is for test apk in company
        create("Stage") {
            dimension = ConfigData.flavorDimensions
            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://postman-library-api.glitch.me/books/\""
            )
            applicationIdSuffix = ".stage"
        }
        //this is for production apk for publish in store
//        create("Prod") {
//            dimension = ConfigData.flavorDimensions
//        }
    }

    applicationVariants.all {
        //__________________________________________________________________________________________
        outputs.all {
            (this as com.android.build.gradle.internal.api.BaseVariantOutputImpl).outputFileName =
                "MyLibray-${productFlavors[0].name}-${buildType.name}-${defaultConfig.versionName}.apk"
        }
    }


//__________________________________________________________________________________________________
    buildFeatures {
        dataBinding = true
        buildConfig = true
    }
//__________________________________________________________________________________________________
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
//__________________________________________________________________________________________________
    kotlinOptions {
        jvmTarget = "1.8"
    }
//__________________________________________________________________________________________________
    // Hilt-Allow references to generated code
    kapt {
        correctErrorTypes = true
    }

}

dependencies {

    implementation(Deps.kotlinReflect)
    implementation(Deps.kotlinReflectt)

    //Support
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Deps.appCompat)
    implementation(Deps.androidxCore)
    implementation(Deps.androidxLegacySupport)
    implementation(Deps.constraintLayout)
    implementation(Deps.materialDesign)
    implementation(Deps.fragment)
    implementation(Deps.swipeRefreshLayout)
    implementation(Deps.multidex)

    //Navigation
    implementation(Deps.navigationFragment)
    implementation(Deps.navigationUi)
    implementation(Deps.navigationRuntime)

    //Lifecycles-ViewModel-LiveData
    implementation(Deps.lifecycleViewModel)
    implementation(Deps.lifecycleLiveData)

    //Retrofit
    implementation(Deps.retrofitCore)
    implementation(Deps.retrofitGsonConverter)
    implementation(Deps.loggingInterceptor)

    //Coroutines
    implementation(Deps.coroutinesCore)
    implementation(Deps.coroutinesAndroid)

    //Timber-Log
    implementation(Deps.timber)

    //Hilt
    implementation(Deps.hilt)
    kapt(Deps.hiltCompiler)

    //Room
    implementation(Deps.room)
    implementation(Deps.roomKtx)
    kapt(Deps.roomCompiler)

    //LeakCanary
    debugImplementation(Deps.leakCanary)

    //DataStore
    implementation(Deps.datastore)

    //Loading
    implementation(Deps.loading)

    //WorkManager
    implementation(Deps.work_manager)

    //Tests
    testImplementation(Deps.junit)
    androidTestImplementation(Deps.testRunner)
    androidTestImplementation(Deps.espresso)
    implementation(kotlin("reflect"))

}

