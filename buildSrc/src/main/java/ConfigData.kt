object ConfigData {
    const val flavorDimensions = "default"
    const val applicationId = "com.parstasmim.mylibrary"
    const val compileSdkVersion = 34
    const val buildToolsVersion = "30.0.3"
    const val minSdkVersion = 21
    const val targetSdkVersion = 34
    val versionCode = ApkVersionHandler.generateVersionCode()
    val versionName = ApkVersionHandler.generateVersionName()
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}