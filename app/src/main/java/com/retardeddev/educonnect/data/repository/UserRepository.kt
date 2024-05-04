import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserRepository {
    private val userApi: UserApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        userApi = retrofit.create(UserApi::class.java)
    }

    suspend fun login(email: String, code:String) : UserApi.LoginResponse? {
        val request = UserApi.LoginRequest(email, code)
        val response = userApi.login(request)
        return if (response.isSuccessful) response.body() else null
    }

    suspend fun sendCode(email: String) : Boolean {
        val request = UserApi.SendCodeRequest(email)
        val response = userApi.sendCode(request)
        return response.isSuccessful
    }

    suspend fun getUserData(token: String): UserApi.UserDataResponse? {
        val response = userApi.getUserData("Bearer $token")
        return if (response.isSuccessful) response.body() else null
    }
}