package bsu.by.lab2

import android.app.Activity
import android.content.Intent
import android.icu.text.IDNA
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText

class InputActivity : AppCompatActivity {
    constructor() : super()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.input_layout)
    }
    fun goBack(view: View){
        val returnIntent = Intent(this, InputActivity::class.java)
        if(findViewById<EditText>(R.id.Input).text.toString()!=""){
            returnIntent.putExtra("text",findViewById<EditText>(R.id.Input).text.toString())
        }
        else
        {
            returnIntent.putExtra("text","Ничего не было введено")
        }
        setResult(Activity.RESULT_OK,returnIntent)
        finish()
    }

}