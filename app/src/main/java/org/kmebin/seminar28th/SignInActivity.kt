package org.kmebin.seminar28th

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import org.kmebin.seminar28th.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

	private lateinit var binding:ActivitySignInBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		Log.d("lifeCycle", "SignIn-onCreate")

		binding = ActivitySignInBinding.inflate(layoutInflater)
		setContentView(binding.root)

        configureNavigation()
	}

	private fun configureNavigation() {
		binding.login.setOnClickListener {
			if (binding.id.text.isNotBlank() && binding.password.text.isNotBlank()) {
				val intent = Intent(this, HomeActivity::class.java)
				startActivity(intent)

				Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
			} else {
				Toast.makeText(this, "아이디/비밀번호를 확인해주세요!", Toast.LENGTH_SHORT).show()
			}
		}

		binding.signUp.setOnClickListener {
			val intent = Intent(this, SignUpActivity::class.java)
			startActivityForResult(intent, 111)
		}
	}

	override fun onStart() {
		super.onStart()
		Log.d("lifeCycle", "SignIn-onStart")
	}

	override fun onResume() {
		super.onResume()
		Log.d("lifeCycle", "SignIn-onResume")
	}

	override fun onPause() {
		super.onPause()
		Log.d("lifeCycle", "SignIn-onPause")
	}

	override fun onRestart() {
		super.onRestart()
		Log.d("lifeCycle", "SignIn-onRestart")
	}

	override fun onStop() {
		super.onStop()
		Log.d("lifeCycle", "SignIn-onStop")
	}

	override fun onDestroy() {
		super.onDestroy()
		Log.d("lifeCycle", "SignIn-onDestroy")
	}
}