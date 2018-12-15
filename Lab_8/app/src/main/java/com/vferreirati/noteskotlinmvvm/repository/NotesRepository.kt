package com.vferreirati.noteskotlinmvvm.repository

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.vferreirati.noteskotlinmvvm.data.Note
import com.vferreirati.noteskotlinmvvm.data.NoteDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotesRepository @Inject constructor(private val noteDao: NoteDao) {

    val allNotes: LiveData<List<Note>> = noteDao.getAll()

    fun insert(note: Note) {
        InsertTask(noteDao).execute(note)
    }

    fun deleteAll() {
        DeleteAllTask(noteDao).execute()
    }

    fun delete(note: Note) {
        DeleteOneTask(noteDao).execute(note)
    }

    class InsertTask(private val noteDao: NoteDao) : AsyncTask<Note, Unit, Unit>() {

        override fun doInBackground(vararg params: Note) {
            noteDao.insert(params[0])
        }
    }

    class DeleteAllTask(private val noteDao: NoteDao) : AsyncTask<Unit, Unit, Unit>() {
        override fun doInBackground(vararg params: Unit?) {
            noteDao.deleteAll()
        }
    }

    class DeleteOneTask(private val noteDao: NoteDao) : AsyncTask<Note, Unit, Unit>() {

        override fun doInBackground(vararg params: Note) {
                noteDao.delete(params[0])
        }
    }
}