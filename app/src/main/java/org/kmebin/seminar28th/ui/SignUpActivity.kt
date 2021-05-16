package org.kmebin.seminar28th.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.kmebin.seminar28th.api.ServiceCreator
import org.kmebin.seminar28th.data.request.RequestSignUpData
import org.kmebin.seminar28th.data.response.ResponseSignUpData
import org.kmebin.seminar28th.databinding.ActivitySignUpBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureNavigation()
    }

    private fun configureNavigation() {
        binding.signUp.setOnClickListener {
            if (binding.name.text.isEmpty() || binding.id.text.isEmpty() || binding.password.text.isEmpty()) {
                Toast.makeText(this, "빈칸이 있는지 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
                signUp()
            }
        }
    }

    private fun signUp() {
        val requestSignUpData = RequestSignUpData(
            id = binding.id.text.toString(), password = binding.password.text.toString(),
            sex = " ", nickname = binding.name.text.toString(), phone = " ", birth = " "
        )
        val call: Call<ResponseSignUpData> =
            ServiceCreator.soptService.postSignUp(requestSignUpData)
        call.enqueue(object : Callback<ResponseSignUpData> {
            override fun onResponse(
                call: Call<ResponseSignUpData>,
                response: Response<ResponseSignUpData>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.data
                    Toast.makeText(
                        this@SignUpActivity,
                        "${data?.nickname}님, 환영합니다.",
                        Toast.LENGTH_SHORT
                    ).show()
                    navigateLogin()
                } else {

                }
            }

            override fun onFailure(call: Call<ResponseSignUpData>, t: Throwable) {
                Log.d("NetworkTest", "error:$t")
            }
        })
    }

    private fun navigateLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}