package mehmat.bsu.animation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fade_in.setOnClickListener {
            textView.visibility = View.VISIBLE
            val animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
            textView.startAnimation(animation)
        }
        fade_out.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.fade_out)
            textView.startAnimation(animation)
            Handler().postDelayed({ textView.visibility = View.GONE }, 1000)
        }

    }
}
