package org.kmebin.seminar28th

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.kmebin.seminar28th.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        Log.d("lifeCycle", "SignUp-onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("lifeCycle", "SignUp-onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("lifeCycle", "SignUp-onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("lifeCycle", "SignUp-onRestart")
    }

    override fun onStop() {
        super.onStop()
        Log.d("lifeCycle", "SignUp-onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifeCycle", "SignUp-onDestroy")
    }
}