# SOPT-28th-Android
</br>

* [Week1](#memo-Week1)
* [Week2](#memo-Week2)
* [Week4](#memo-Week4)

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

시험 끝나고 제대로 수정하기..

</br>

## :memo: Week2
:computer: ​**Level1**
> data class
```Kotlin
data class RepositoryInfo(
    val name: String,
    val description: String,
    val language: String
)
```

</br>

> ViewHolder
```kotlin
class RepositoryViewHolder(
        private val binding: ItemRepositoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(repositoryInfo: RepositoryInfo) {
            binding.repositoryName.text = repositoryInfo.name
            binding.repositoryDescription.text = repositoryInfo.description
            binding.language.text = repositoryInfo.language
        }
    }
```

</br>

> Adapter
```kotlin
class RepositoryListAdapter : RecyclerView.Adapter<RepositoryListAdapter.RepositoryViewHolder>() {

    var repositoryList = mutableListOf<RepositoryInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val binding =
            ItemRepositoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepositoryViewHolder(binding)
    }

    override fun getItemCount(): Int = repositoryList.size

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.onBind(repositoryList[position])
    }
}
```

</br>

## :memo: Week4
:computer: ​**Level1**
> Retrofit Interface
```Kotlin
interface SoptService {
    @POST("/login/signin")
    fun postLogin(
        @Body body: RequestLoginData
    ): Call<ResponseLoginData>

    @POST("/login/signup")
    fun postSignUp(
        @Body body: RequestSignUpData
    ): Call<ResponseSignUpData>
}
```

</br>

> Retrofit Interface Implementation
```kotlin
object ServiceCreator {
    private const val BASE_URL = "http://cherishserver.com"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val soptService: SoptService = retrofit.create(SoptService::class.java)
}
```

</br>

> Login
```kotlin
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
                this@LoginActivity,
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
```

</br>

> SignUp
```kotlin
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
```

</br>

> gif

<img width="300" alt="gif" src="https://user-images.githubusercontent.com/72112845/118386835-36a21780-b655-11eb-9320-c2c21d8cb7f3.gif">

</br>

> PostMan Test

<img width="600" alt="postman_signup" src="https://user-images.githubusercontent.com/72112845/118386751-a4017880-b654-11eb-9a1e-93d99bbc88b2.PNG">

<img width="600" alt="postman_login" src="https://user-images.githubusercontent.com/72112845/118386757-bbd8fc80-b654-11eb-960a-54aadfc6fa8b.PNG">

</br>

> Review

interface 구현체 네이밍을 단순히 'impl'과 같이 하는 것보다 해당 구현체가 어떤 역할을 하는지 바로 알 수 있게 네이밍하는 것이 더 좋은 것 같다.
