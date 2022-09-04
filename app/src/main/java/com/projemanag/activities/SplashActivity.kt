package com.projemanag.activities

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import com.projemanag.R
import kotlinx.android.synthetic.main.activity_splash.*

// TODO (Step 1: Add new activity named as splash activity.)
// START
const val delayToMain : Long = 1000
class SplashActivity : AppCompatActivity() {

    /**
     * This function is auto created by Android when the Activity Class is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        //This call the parent constructor
        super.onCreate(savedInstanceState)
        // This is used to align the xml view to this class
        setContentView(R.layout.activity_splash)

        // TODO (Step 6: Add the full screen flags here.)
        // This is used to hide the status bar and make the splash screen as a full screen activity.
        // START
        // END
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        // END

        val typeface: Typeface =
            Typeface.createFromAsset(assets, "Cookie-Regular.ttf")
        tv_app_name.typeface = typeface

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashActivity, IntroActivity::class.java))
        }, delayToMain)
    }
}
// END