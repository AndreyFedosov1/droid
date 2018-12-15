package com.vferreirati.noteskotlinmvvm.di.modules

import android.content.Context
import com.vferreirati.noteskotlinmvvm.NotesApplication
import com.vferreirati.noteskotlinmvvm.di.qualifiers.ApplicationContext
import com.vferreirati.noteskotlinmvvm.di.qualifiers.BasicContext
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    @ApplicationContext
    fun provideApplicationContext(app: NotesApplication): Context {
        return app.applicationContext
    }

    @Provides
    @BasicContext
    fun provideContext(app: NotesApplication): Context {
        return app
    }
}