package com.vferreirati.noteskotlinmvvm.ui.EditorActivity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.vferreirati.noteskotlinmvvm.R
import com.vferreirati.noteskotlinmvvm.data.Note
import com.vferreirati.noteskotlinmvvm.ui.ViewModelFactory
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_editor.*
import javax.inject.Inject

class EditorActivity : AppCompatActivity() {

    private lateinit var editorViewModel: EditorViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)
        AndroidInjection.inject(this)

        initViewModel()
    }

    private fun initViewModel() {
        editorViewModel = ViewModelProviders.of(this, viewModelFactory).get(EditorViewModel::class.java)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.editor_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.action_save) {
            val noteTitle: String = et_note_title.text.toString()
            val noteDescription: String = et_note_description.text.toString()

            if(noteTitle.isNotEmpty()) {
                val note = Note(null, noteTitle, noteDescription)
                editorViewModel.insert(note)
                finish()
            } else {
                Toast.makeText(this, "Please insert a title", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}