package com.vferreirati.noteskotlinmvvm.di.components

import com.vferreirati.noteskotlinmvvm.NotesApplication
import com.vferreirati.noteskotlinmvvm.di.modules.AppModule
import com.vferreirati.noteskotlinmvvm.di.modules.BindingModule
import com.vferreirati.noteskotlinmvvm.di.modules.DatabaseModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    BindingModule::class,
    DatabaseModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: NotesApplication): Builder

        fun build(): AppComponent
    }

    fun inject(notesApplication: NotesApplication)
}