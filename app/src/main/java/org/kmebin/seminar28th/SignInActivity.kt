package org.kmebin.seminar28th

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.kmebin.seminar28th.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

	private lateinit var binding:ActivitySignInBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		binding = ActivitySignInBinding.inflate(layoutInflater)
		setContentView(binding.root)
	}
}