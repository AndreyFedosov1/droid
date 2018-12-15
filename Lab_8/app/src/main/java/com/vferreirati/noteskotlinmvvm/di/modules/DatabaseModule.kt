package com.vferreirati.noteskotlinmvvm.di.modules

import android.content.Context
import androidx.room.Room
import com.vferreirati.noteskotlinmvvm.data.NoteDatabase
import com.vferreirati.noteskotlinmvvm.di.qualifiers.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [AppModule::class])
class DatabaseModule {

    @Singleton
    @Provides
    fun provideNoteDao(database: NoteDatabase) = database.noteDao()

    @Singleton
    @Provides
    fun provideNoteDatabase(@ApplicationContext context: Context): NoteDatabase {
        return Room.databaseBuilder(
                context,
                NoteDatabase::class.java,
                "notes.db")
                .build()
    }
}