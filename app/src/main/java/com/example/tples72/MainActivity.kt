package com.example.tples72

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.TranslateAnimation
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var runButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runButton = findViewById(R.id.run_button)

        runButton.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .setCustomAnimations(R.anim.right_in, R.anim.right_out, R.anim.right_in, R.anim.right_out)
                .replace(R.id.frame_layout, FragmentOne.newInstance())
                .commit()
        }

    }
}