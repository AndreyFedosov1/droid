package bsu.by.myapplication

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Button

class MainActivity : AppCompatActivity(), Frag3.OnFragmentInteractionListener {

    override fun onFragmentInteraction(uri: Uri) {
    }

    var frag1: Button? = null
    var frag2: Button? = null
    var frag3: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()
        onclick()
    }

    private fun onclick() {
        frag1?.setOnClickListener {
            replaceFragment(Frag1.newInstance())
        }
        frag2?.setOnClickListener {
            val fragment = Frag2()
            replaceFragment(fragment)
        }
        frag3?.setOnClickListener {
            val fragment = Frag3()
            replaceFragment(fragment)
        }
    }

    private fun initialize() {
        frag1 = findViewById(R.id.frag1)
        frag2 = findViewById(R.id.frag2)
        frag3 = findViewById(R.id.frag3)
    }


    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragments, fragment)
        fragmentTransaction.commit()
    }
}
