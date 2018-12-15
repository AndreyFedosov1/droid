package bsu.by.myapplication

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class Frag1 : Fragment() {

    var rootView : View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.frag1, container, false)
        return rootView
    }

    companion object {
        fun newInstance() = Frag1()
    }
}