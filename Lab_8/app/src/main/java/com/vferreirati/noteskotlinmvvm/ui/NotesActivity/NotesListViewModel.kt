package com.vferreirati.noteskotlinmvvm.ui.NotesActivity

import androidx.lifecycle.ViewModel
import com.vferreirati.noteskotlinmvvm.repository.NotesRepository

class NotesListViewModel(private val notesRepository: NotesRepository) : ViewModel() {

    val allNotes = notesRepository.allNotes

    fun deleteAll() {
        notesRepository.deleteAll()
    }

    fun deleteNoteOnPosition(position: Int) {
        val note = allNotes.value?.get(position)
        if(note != null) {
            notesRepository.delete(note)
        }
    }
}
