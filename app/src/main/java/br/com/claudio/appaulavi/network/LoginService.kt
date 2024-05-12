package br.com.claudio.appaulavi.network

import br.com.claudio.appaulavi.data.login.LoginResponseData
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginService {
    @FormUrlEncoded
    @POST("auth")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<LoginResponseData>
}