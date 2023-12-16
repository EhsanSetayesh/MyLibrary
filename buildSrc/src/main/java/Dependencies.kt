/**
 * To define plugins
 */
object BuildPlugins {
    val androidBuildGradle by lazy { "com.android.tools.build:gradle:${Versions.gradlePlugin}" }
    val kotlinGradlePlugin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
    val navigationSafeArgs by lazy { "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}" }
    val hiltGradlePlugin by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}" }
}

/**
 * To define dependencies
 */
object Deps {

    //Kotlin
    val kotlinReflect by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}" }
    val kotlinReflectt by lazy { "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}" }

    //Support
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val androidxCore by lazy { "androidx.core:core-ktx:${Versions.androidxCore}" }
    val androidxLegacySupport by lazy { "androidx.legacy:legacy-support-v4:${Versions.androidxLegacySupport}" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }
    val materialDesign by lazy { "com.google.android.material:material:${Versions.material}" }
    val fragment by lazy { "androidx.fragment:fragment-ktx:${Versions.fragment}" }
    val swipeRefreshLayout by lazy { "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayout}" }
    val multidex by lazy { "androidx.multidex:multidex:${Versions.multidex}" }

    //Navigation
    val navigationFragment by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}" }
    val navigationUi by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navigation}" }
    val navigationRuntime by lazy { "androidx.navigation:navigation-runtime:${Versions.navigation}" }

    //Lifecycles-ViewModel-LiveData
    val lifecycleViewModel by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleViewModel}" }
    val lifecycleLiveData by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleLivedata}" }

    //Retrofit
    val retrofitCore by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val retrofitGsonConverter by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofit}" }
    val loggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}" }

    //Coroutines
    val coroutinesCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}" }
    val coroutinesAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}" }

    //Timber-Log
    val timber by lazy { "com.jakewharton.timber:timber:${Versions.timber}" }

    //Hilt
    val hilt by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
    val hiltCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hilt}" }

    //Room
    val room by lazy { "androidx.room:room-runtime:${Versions.room}" }
    val roomCompiler by lazy { "androidx.room:room-compiler:${Versions.room}" }
    val roomKtx by lazy { "androidx.room:room-ktx:${Versions.room}" }

    //LeakCanary
    val leakCanary by lazy { "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}" }

    //LeakCanary
    val datastore by lazy { "androidx.datastore:datastore-preferences:${Versions.datastore}" }

    //loading
    val loading by lazy { "com.hmomeni.progresscircula:progresscircula:${Versions.loading}" }

    //Test
    val junit by lazy { "junit:junit:${Versions.jUnit}" }
    val testRunner by lazy { "androidx.test:runner:${Versions.testRunner}" }
    val espresso by lazy { "androidx.test.espresso:espresso-core:${Versions.espresso}" }

    val work_manager by lazy { "androidx.work:work-runtime-ktx:${Versions.workVersion}" }

}