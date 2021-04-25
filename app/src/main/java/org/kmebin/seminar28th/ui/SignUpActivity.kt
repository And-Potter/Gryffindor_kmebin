package org.kmebin.seminar28th.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import org.kmebin.seminar28th.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("lifeCycle", "SignUp-onCreate")

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureNavigation()
    }

    private fun configureNavigation() {
        binding.signUp.setOnClickListener {
            if (binding.name.text.isEmpty() || binding.id.text.isEmpty() || binding.password.text.isEmpty()) {
                Toast.makeText(this, "빈칸이 있는지 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent()
                intent.putExtra("name", binding.name.text.toString())
                intent.putExtra("id", binding.id.text.toString())
                intent.putExtra("password", binding.password.text.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
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