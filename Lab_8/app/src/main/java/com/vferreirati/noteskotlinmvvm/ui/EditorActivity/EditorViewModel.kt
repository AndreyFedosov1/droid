package com.vferreirati.noteskotlinmvvm.ui.EditorActivity

import androidx.lifecycle.ViewModel
import com.vferreirati.noteskotlinmvvm.data.Note
import com.vferreirati.noteskotlinmvvm.repository.NotesRepository

class EditorViewModel(private val notesRepository: NotesRepository) : ViewModel() {

    fun insert(note: Note) {
        notesRepository.insert(note)
    }
}