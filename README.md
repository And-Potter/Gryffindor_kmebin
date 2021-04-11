# SOPT-28th-Android
</br>

* [Week1](#memo-Week1)

</br>
## :memo: Week1
:computer: ​**Level1**
> SignInActivity.kt
```Kotlin
binding.signUp.setOnClickListener {
	val intent = Intent(this, SignUpActivity::class.java)
	startActivityForResult(intent, 111)
}
```
</br>
> SignUpActivity.kt
```Kotlin
binding.signUp.setOnClickListener {
	...
    else {
    	val intent = Intent()
    	intent.putExtra("name", binding.name.text.toString())
    	intent.putExtra("id", binding.id.text.toString())
        intent.putExtra("password",binding.password.text.toString())
    	setResult(Activity.RESULT_OK, intent)
    	finish()
	}
}
```
</br>

> Life Cycle

<img width="500" alt="lifeCycle" src="https://user-images.githubusercontent.com/72112845/114297173-16c58400-9aea-11eb-8334-225a56c9722f.JPG">

</br>

> Review

시험 끝나고 얼른 코드 수정해야겠다.