package bsu.by.lab2

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val INPUT = 6
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startInputActivity(view: View){
        val intent = Intent(this, InputActivity::class.java)
        startActivityForResult(intent, INPUT)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == 6 && resultCode== Activity.RESULT_OK){
            var inform = data?.getStringExtra("text");
            var text =findViewById<View>(R.id.textOutput) as TextView
            text.text = inform
        }
        super.onActivityResult(requestCode, resultCode, data)

    }
}

