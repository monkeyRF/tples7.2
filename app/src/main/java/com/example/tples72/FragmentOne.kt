package com.example.tples72

import android.os.Bundle
import android.transition.*
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class FragmentOne : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_one, container, false).also {
        it.findViewById<Button>(R.id.click_me_button).setOnClickListener {
            expand()
        }
    }

    private fun expand() {
        var scene = Scene.getSceneForLayout(requireView() as ViewGroup, R.layout.scene_2,requireContext())
        TransitionManager.go(scene, TransitionSet().apply {
            duration = 400L
            addTransition(ChangeBounds())
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentOne()
    }
}