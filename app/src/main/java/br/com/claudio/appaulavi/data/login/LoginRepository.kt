package br.com.claudio.appaulavi.data.login

import br.com.claudio.appaulavi.network.LoginService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository(private val loginService: LoginService) {
    fun login(username: String, password: String, callback: LoginCallback) {
        loginService.login(username, password).enqueue(object : Callback<LoginResponseData> {
            override fun onResponse(
                call: Call<LoginResponseData>,
                response: Response<LoginResponseData>
            ) {
                println(">>>>>>>> ${response}")
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    if(loginResponse != null) {
                        callback.onSuccess(loginResponse.data, loginResponse.success, loginResponse.message)
                    }
                } else {
                    callback.onError(false, "Erro ao realizar login ${response.message()}")
                }
            }

            override fun onFailure(call: Call<LoginResponseData>, t: Throwable) {
                callback.onError(false, "Erro de conexão: ${t.cause.toString()}")
            }

        })
    }


    interface LoginCallback {
        fun onSuccess(data: Data, success: Boolean, message: String)
        fun onError(success: Boolean, message: String)
    }
}