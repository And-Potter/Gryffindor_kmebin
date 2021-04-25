# SOPT-28th-Android
</br>

* [Week1](#memo-Week1)
* [Week2](#memo-Week2)

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
