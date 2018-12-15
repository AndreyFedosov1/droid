package com.vferreirati.noteskotlinmvvm.ui.NotesActivity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vferreirati.noteskotlinmvvm.R
import com.vferreirati.noteskotlinmvvm.adapter.NoteAdapter
import com.vferreirati.noteskotlinmvvm.ui.EditorActivity.EditorActivity
import com.vferreirati.noteskotlinmvvm.ui.ViewModelFactory
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class NotesActivity : AppCompatActivity() {

    private lateinit var listViewModel: NotesListViewModel

    @Inject
    lateinit var noteAdapter: NoteAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)

        initViewModel()
        initViews()
    }

    private fun initViewModel() {
        listViewModel = ViewModelProviders.of(this, viewModelFactory).get(NotesListViewModel::class.java)
        listViewModel.allNotes.observe(this, Observer {
            noteAdapter.setNotes(it)
        })
    }

    private fun initViews() {
        rv_note.layoutManager = LinearLayoutManager(this)
        rv_note.adapter = noteAdapter
        fab_new_note.setOnClickListener {
            val intent = Intent(this, EditorActivity::class.java)
            startActivity(intent)
        }

        val swipeHandler = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                listViewModel.deleteNoteOnPosition(position)
            }
        }

        ItemTouchHelper(swipeHandler).attachToRecyclerView(rv_note)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.list_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_delete_all) {
            listViewModel.deleteAll()
        }
        return super.onOptionsItemSelected(item)
    }
}
