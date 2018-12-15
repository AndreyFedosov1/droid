package com.vferreirati.noteskotlinmvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vferreirati.noteskotlinmvvm.R
import com.vferreirati.noteskotlinmvvm.data.Note
import com.vferreirati.noteskotlinmvvm.di.qualifiers.BasicContext
import com.vferreirati.noteskotlinmvvm.di.scopes.PerActivity
import com.vferreirati.noteskotlinmvvm.ui.NotesActivity.NotesActivity
import javax.inject.Inject

@PerActivity
class NoteAdapter @Inject constructor(@BasicContext private val context: Context)
    : RecyclerView.Adapter<NoteAdapter.NoteHolder>() {

    private var notesList: List<Note>? = null

    class NoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val noteTitleTextView: TextView = itemView.findViewById(R.id.tv_note_title)
        val noteDescriptionTextView: TextView = itemView.findViewById(R.id.tv_note_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NoteHolder(LayoutInflater.from(context).inflate(R.layout.note_item, parent, false))

    override fun getItemCount() = notesList?.size ?: 0

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        val note = notesList?.get(position)
        holder.noteTitleTextView.text = note?.title
        holder.noteDescriptionTextView.text = note?.description
    }

    fun setNotes(notes: List<Note>) {
        notesList = notes
        notifyDataSetChanged()
    }
}