package com.vferreirati.noteskotlinmvvm.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vferreirati.noteskotlinmvvm.repository.NotesRepository
import com.vferreirati.noteskotlinmvvm.ui.EditorActivity.EditorViewModel
import com.vferreirati.noteskotlinmvvm.ui.NotesActivity.NotesListViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ViewModelFactory @Inject constructor(private val notesRepository: NotesRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(NotesListViewModel::class.java) ->
                    NotesListViewModel(notesRepository) as T

            modelClass.isAssignableFrom(EditorViewModel::class.java) ->
                    EditorViewModel(notesRepository) as T

            else -> throw IllegalArgumentException("ViewModel not found")
        }
}