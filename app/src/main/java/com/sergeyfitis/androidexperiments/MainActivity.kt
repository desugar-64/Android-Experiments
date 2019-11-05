package com.sergeyfitis.androidexperiments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sergeyfitis.androidexperiments.raycasting.RaycastingFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            val raycastingFragment = RaycastingFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.mainContainer, raycastingFragment)
                .commitNow()
        }
    }
}
