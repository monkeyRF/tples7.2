package com.example.tples72

import android.animation.AnimatorSet
import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FragmentOne : Fragment() {

    private lateinit var rectangleOne: View
    private lateinit var rectangleTwo: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_one, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rectangleOne = view.findViewById(R.id.rect_1)
        rectangleTwo = view.findViewById(R.id.rect_2)

        view.findViewById<Button>(R.id.click_me_button).setOnClickListener {
            animation()
        }
    }

    private fun animation() {

        val colorAnimator = ValueAnimator
            .ofInt(Color.parseColor("#FF6200EE"), Color.parseColor("#FFFF2903"))
            .setDuration(400)
        colorAnimator.addUpdateListener { valueAnimator ->
            rectangleOne.setBackgroundColor((valueAnimator.animatedValue as Int))
        }
        colorAnimator.setEvaluator(ArgbEvaluator())

        val rectOneSizeAnimator = ValueAnimator.ofInt(rectangleOne.height, 60).setDuration(400)
        rectOneSizeAnimator.addUpdateListener { valueAnimator ->
            val size = valueAnimator.animatedValue as Int
            rectangleOne.layoutParams.width = size
            rectangleOne.layoutParams.height = size
            rectangleOne.requestLayout()
        }

        val rectTwoSizeAnimator = ValueAnimator.ofInt(rectangleOne.height, 120).setDuration(400)
        rectTwoSizeAnimator.addUpdateListener { valueAnimator ->
            val size = valueAnimator.animatedValue as Int
            rectangleTwo.layoutParams.height = size
            rectangleTwo.requestLayout()
        }

        AnimatorSet().apply{
            play(colorAnimator).with(rectOneSizeAnimator).with(rectTwoSizeAnimator)
            start()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentOne()
    }
}