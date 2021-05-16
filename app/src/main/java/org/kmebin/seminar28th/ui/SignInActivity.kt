package org.kmebin.seminar28th.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.kmebin.seminar28th.api.ServiceCreator
import org.kmebin.seminar28th.data.request.RequestLoginData
import org.kmebin.seminar28th.data.response.ResponseLoginData
import org.kmebin.seminar28th.databinding.ActivitySignInBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureNavigation()
        logIn()
    }

    private fun configureNavigation() {
        binding.login.setOnClickListener {
            if (binding.id.text.isNotBlank() && binding.password.text.isNotBlank()) {
                navigateHome()
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

    private fun navigateHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    private fun logIn() {
        val requestLoginData = RequestLoginData(
            id = binding.id.text.toString(), password = binding.password.text.toString()
        )
        val call: Call<ResponseLoginData> = ServiceCreator.soptService.postLogin(requestLoginData)
        call.enqueue(object : Callback<ResponseLoginData> {
            override fun onResponse(
                call: Call<ResponseLoginData>,
                response: Response<ResponseLoginData>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.data
                    Toast.makeText(
                        this@SignInActivity,
                        "${data?.nickname}님, 반갑습니다.",
                        Toast.LENGTH_SHORT
                    ).show()
                    navigateHome()
                } else {

                }
            }

            override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
                Log.d("NetworkTest", "error:$t")
            }
        })
    }
}