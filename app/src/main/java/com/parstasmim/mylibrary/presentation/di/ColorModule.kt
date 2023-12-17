package com.parstasmim.mylibrary.presentation.di

import com.parstasmim.mylibrary.utils.IRandomColorGenerator
import com.parstasmim.mylibrary.utils.RandomColorGenerator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ColorModule {
    @Binds
    abstract fun bindRandomColorGenerator(randomColorGenerator: RandomColorGenerator): IRandomColorGenerator
}


