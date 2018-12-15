package com.vferreirati.noteskotlinmvvm.di.modules

import com.vferreirati.noteskotlinmvvm.di.scopes.PerActivity
import com.vferreirati.noteskotlinmvvm.ui.EditorActivity.EditorActivity
import com.vferreirati.noteskotlinmvvm.ui.NotesActivity.NotesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BindingModule {

    @PerActivity
    @ContributesAndroidInjector
    abstract fun bindNotesActivity(): NotesActivity

    @PerActivity
    @ContributesAndroidInjector
    abstract fun bindEditorActivity(): EditorActivity
}