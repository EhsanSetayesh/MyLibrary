package com.parstasmim.mylibrary.presentation.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.parstasmim.mylibrary.BuildConfig
import com.parstasmim.mylibrary.MyLibraryApplication
import com.parstasmim.mylibrary.datasource.db.AppDatabase
import com.parstasmim.mylibrary.datasource.db.AppDatabase.Companion.DATABASE_NAME
import com.parstasmim.mylibrary.datasource.network.BookApiService
import com.parstasmim.mylibrary.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    internal fun providesApplicationInstance(@ApplicationContext context: Context): MyLibraryApplication {
        return context as MyLibraryApplication
    }

    @Singleton
    @Provides
    internal fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .create()
    }

    @Singleton
    @Provides
    internal fun provideRetrofit(client: OkHttpClient, gsonBuilder: Gson): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
            .build()
    }

    @Singleton
    @Provides
    internal fun provideLoggingInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return interceptor
    }

    @Singleton
    @Provides
    internal fun provideOkHttpClient(
        loggingInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(Constants.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(Constants.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(Constants.TIMEOUT_INTERNET, TimeUnit.MICROSECONDS)
            .addInterceptor(loggingInterceptor)
            //.certificatePinner(certificatePinner)
            .retryOnConnectionFailure(false)
            .build()
    }

//    @Singleton
//    @Provides
//    internal fun provideCertificatePinner(app: MyLibraryApplication): CertificatePinner {
//        return CertificatePinner.Builder()
//            .add("*.parstasmim.com", BuildConfig.certpin1.decryptNew(app.random()))
//            .add("*.parstasmim.com", BuildConfig.certpin2.decryptNew(app.random()))
//            .add("*.parstasmim.com", BuildConfig.certpin3.decryptNew(app.random()))
//            .build()
//    }


    @Singleton
    @Provides
    internal fun provideAppDb(app: Application): AppDatabase {
        return Room
            .databaseBuilder(app, AppDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    internal fun provideBookApiService(retrofit: Retrofit): BookApiService {
        return retrofit
            .create(BookApiService::class.java)
    }

//    @Singleton
//    @Provides
//    internal fun provideValidationManager(): ValidationManager {
//        return ValidationManager()
//    }
}