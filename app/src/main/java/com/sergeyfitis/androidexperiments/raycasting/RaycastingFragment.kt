package com.sergeyfitis.androidexperiments.raycasting

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import com.sergeyfitis.androidexperiments.R

/**
 * A simple [Fragment] subclass.
 */
class RaycastingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_raycasting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.doOnPreDraw {
            val viewBounds = Rect()
            it.getDrawingRect(viewBounds)
            val bg = RaycastingDrawable()
            bg.bounds = viewBounds
            it.background = bg
        }
        view.setOnTouchListener { v, event -> v.background.setHotspot(event.x, event.y); true }
    }

}
