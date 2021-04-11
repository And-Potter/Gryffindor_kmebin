package org.kmebin.seminar28th

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.kmebin.seminar28th.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("lifeCycle", "Home-onCreate")

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        Log.d("lifeCycle", "Home-onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("lifeCycle", "Home-onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("lifeCycle", "Home-onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("lifeCycle", "Home-onRestart")
    }

    override fun onStop() {
        super.onStop()
        Log.d("lifeCycle", "Home-onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifeCycle", "Home-onDestroy")
    }
}